package com.sixthc.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtil {
	private Document payloadDoc;
	private NSResolver unr;
	private static org.apache.log4j.Logger log = Logger
			.getLogger(XMLUtil.class);

	public XMLUtil(String xmlString) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		builderFactory.setNamespaceAware(false);
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		InputSource inputSource = new InputSource(new StringReader(xmlString));
		payloadDoc = builder.parse(inputSource);
		unr = new NSResolver(payloadDoc, false);

	}

	public static XMLGregorianCalendar XMLGregorianNow() {
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(
					(GregorianCalendar) GregorianCalendar.getInstance());
		} catch (DatatypeConfigurationException e) {
			log.error(e);
			return null;
		}

	}

	public String GetSOAPBodyPayload() throws ParserConfigurationException,
			IOException, SAXException {
		return this.getTagValue("http://schemas.xmlsoap.org/soap/envelope/",
				"Body");
	}

	public String getTagValue(String namespace, String... tags)
			throws ParserConfigurationException, IOException, SAXException {


		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(unr);

		try {
			String xpathString = "//";
			String searchString = "";


			for (String tag : tags) {
				searchString += tag + "/";
			}
			searchString = StringUtils.chop(searchString);

			
			xpathString = "//*[local-name()='" + searchString + "']/text()";

					
			log.debug("xpath : " + xpathString);
			NodeList nodes = (NodeList) xpath.evaluate(xpathString, payloadDoc,
					XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				org.w3c.dom.Node n = nodes.item(0);
				return n.getNodeValue();
			}
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return "";
	}

	/**
	 * Given an xsd file, it validates it against the node
	 * passed
	 * 
	 * @param xsdFile
	 * @param payload
	 * @return
	 */
	public boolean isXMLValid(String xsdFile, Node payload) {
		log.debug("validating xsd file : " + xsdFile);
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL schemaFile = classLoader.getResource(xsdFile);

		if (schemaFile == null) {
			log.error("schema file not found : " + xsdFile);
			return false;
		}

		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		DOMSource source = new DOMSource(payload);
		Schema schema;
		try {
			schema = schemaFactory.newSchema(schemaFile);
			Validator validator = schema.newValidator();
			validator.validate(source);
			return true;
		} catch (Exception e) {
			log.error(e);
		}

		return false;
	}

	/**
	 * Searches the DOM for a particular node
	 * 
	 * @param namespace
	 * @param element
	 * @param validate
	 * @return
	 * @throws Exception
	 */
	public Node getNode(String namespace, String element) throws Exception {
		log.debug("getNode on namespace " + namespace + ", for element "
				+ element);

		NodeList body = payloadDoc.getElementsByTagNameNS(namespace, element);
		if (body.getLength() > 0) {
			Node node = body.item(0);
			StreamResult xmlOutput = new StreamResult(new StringWriter());
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			transformer.transform(new DOMSource(node), xmlOutput);
			String nodeAsAString = xmlOutput.getWriter().toString();
			System.out.println("parsed node for " + element + " : "
					+ nodeAsAString);
			return node;
		}

		return null;
	}

	/**
	 * Transforms a DOM node to a string
	 * 
	 * @param node
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 */
	public String nodeToString(Node node)
			throws TransformerFactoryConfigurationError, TransformerException {

		StreamResult xmlOutput = new StreamResult(new StringWriter());
		Transformer transformer = TransformerFactory.newInstance()
				.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(new DOMSource(node), xmlOutput);
		String nodeAsAString = xmlOutput.getWriter().toString();

		return nodeAsAString;
	}

	public String getHeaderValueWC(String... tags)
			throws ParserConfigurationException, IOException, SAXException {
		StringBuffer b = new StringBuffer();

		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(unr);

		b.append("//*[local-name()='Header']");
		for (String tag : tags) {
			b.append("/*[local-name()='" + tag + "']");
		}
		b.append("/text()");
		log.debug(b.toString());

		try {
			NodeList nodes = (NodeList) xpath.evaluate(b.toString(),
					payloadDoc, XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				org.w3c.dom.Node n = nodes.item(0);
				return n.getNodeValue();
			}
		} catch (XPathExpressionException e) {
			log.error(e);
		}
		return "";
	}

	/**
	 * throws an exception if the SOAP message does not properly validate
	 * against the xsd
	 * 
	 * @param xsdFile
	 * @param msg
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void validateXML(String xsdFile, String msg) throws Exception {

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL schemaFile = classLoader.getResource(xsdFile);

		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		XMLUtil xmlParser = new XMLUtil(msg);
		String payload = xmlParser.GetSOAPBodyPayload();
		Source src = new StreamSource(new java.io.StringReader(payload));

		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		validator.validate(src);
	}

	public static void validateXML(String xsdFile, Node payload)
			throws Exception {
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		URL schemaFile = classLoader.getResource(xsdFile);

		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		DOMSource source = new DOMSource(payload);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		validator.validate(source);
	}

	private static class NSResolver implements NamespaceContext {
		private static final String DEFAULT_NS = "DEFAULT";
		private Map<String, String> prefix2Uri = new HashMap<String, String>();
		private Map<String, String> uri2Prefix = new HashMap<String, String>();

		/**
		 * This constructor parses the document and stores all namespaces it can
		 * find. If toplevelOnly is true, only namespaces in the root are used.
		 * 
		 * @param document
		 *            source document
		 * @param toplevelOnly
		 *            restriction of the search to enhance performance
		 */
		public NSResolver(Document document, boolean toplevelOnly) {
			examineNode(document.getFirstChild(), toplevelOnly);
			log.debug("The list of the cached namespaces:");
			for (String key : prefix2Uri.keySet()) {
				log.debug("prefix " + key + ": uri " + prefix2Uri.get(key));
			}
		}

		/**
		 * A single node is read, the namespace attributes are extracted and
		 * stored.
		 * 
		 * @param node
		 *            to examine
		 * @param attributesOnly
		 *            ,
		 *            if true no recursion happens
		 */
		private void examineNode(Node node, boolean attributesOnly) {
			NamedNodeMap attributes = node.getAttributes();
			if (attributes == null) {
				log.error("examineNode returned null NS attributes");
				return;
			}

			for (int i = 0; i < attributes.getLength(); i++) {
				Node attribute = attributes.item(i);
				storeAttribute((Attr) attribute);
			}

			if (!attributesOnly) {
				NodeList chields = node.getChildNodes();
				for (int i = 0; i < chields.getLength(); i++) {
					Node chield = chields.item(i);
					if (chield.getNodeType() == Node.ELEMENT_NODE)
						examineNode(chield, false);
				}
			}
		}

		/**
		 * This method looks at an attribute and stores it, if it is a namespace
		 * attribute.
		 * 
		 * @param attribute
		 *            to examine
		 */
		private void storeAttribute(Attr attribute) {
			// examine the attributes in namespace xmlns
			if (attribute.getNamespaceURI() != null
					&& attribute.getNamespaceURI().equals(
							XMLConstants.XMLNS_ATTRIBUTE_NS_URI)) {
				// Default namespace xmlns="uri goes here"
				if (attribute.getNodeName()
						.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
					putInCache(DEFAULT_NS, attribute.getNodeValue());
				} else {
					log.debug("localName : " + attribute.getLocalName() + ", value : " + attribute.getNodeValue());
					// The defined prefixes are stored here
					putInCache(attribute.getLocalName(),
							attribute.getNodeValue());
				}
			}

		}

		private void putInCache(String prefix, String uri) {
			prefix2Uri.put(prefix, uri);
			uri2Prefix.put(uri, prefix);
		}

		/**
		 * This method is called by XPath. It returns the default namespace, if
		 * the
		 * prefix is null or "".
		 * 
		 * @param prefix
		 *            to search for
		 * @return uri
		 */
		public String getNamespaceURI(String prefix) {
			if (prefix == null || prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
				return prefix2Uri.get(DEFAULT_NS);
			} else {
				return prefix2Uri.get(prefix);
			}
		}

		/**
		 * This method is not needed in this context, but can be implemented in
		 * a
		 * similar way.
		 */
		public String getPrefix(String namespaceURI) {
			return uri2Prefix.get(namespaceURI);
		}

		@SuppressWarnings("rawtypes")
		public Iterator getPrefixes(String namespaceURI) {
			// Not implemented
			return null;
		}
	}

}

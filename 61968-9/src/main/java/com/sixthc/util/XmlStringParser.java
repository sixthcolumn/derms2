package com.sixthc.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlStringParser {
	private Document payloadDoc;
	private UniversalNamespaceResolver2 unr;
	private static org.apache.log4j.Logger log = Logger
			.getLogger(XmlStringParser.class);

	public XmlStringParser(String xmlString)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory
				.newInstance();
		builderFactory.setNamespaceAware(true);
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		InputSource inputSource = new InputSource(new StringReader(xmlString));
		payloadDoc = builder.parse(inputSource);
		unr = new UniversalNamespaceResolver2(payloadDoc, false);

	}

	//	public String getTagValue(String tag, String namespace)
	//			throws ParserConfigurationException, IOException, SAXException {
	//		String prefix = unr.getPrefix(namespace);
	//
	//		XPath xpath = XPathFactory.newInstance().newXPath();
	//		xpath.setNamespaceContext(unr);
	//
	//		try {
	//			String xpathString = "//" + prefix + ":" + tag + "/text()";
	//			System.out.println("xpath : " + xpathString);
	//			NodeList nodes = (NodeList) xpath.evaluate(xpathString, payloadDoc,
	//					XPathConstants.NODESET);
	//			if (nodes.getLength() > 0) {
	//				org.w3c.dom.Node n = nodes.item(0);
	//				return n.getNodeValue();
	//			}
	//		} catch (XPathExpressionException e) {
	//			// TODO Auto-generated catch block
	//			log.error(e);
	//		}
	//		return "";
	//	}

	public String getTagValue(String namespace, String... tags)
			throws ParserConfigurationException, IOException, SAXException {

		String prefix = unr.getPrefix(namespace);

		XPath xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext(unr);

		try {
			String xpathString = "//";
			for (String tag : tags) {
				xpathString += prefix + ":" + tag + "/";
			}
			xpathString += "text()";

			log.debug("xpath : " + xpathString);
			NodeList nodes = (NodeList) xpath.evaluate(xpathString, payloadDoc,
					XPathConstants.NODESET);
			if (nodes.getLength() > 0) {
				org.w3c.dom.Node n = nodes.item(0);
				return n.getNodeValue();
			}
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			log.error(e);
		}
		return "";
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
			// TODO Auto-generated catch block
			log.error(e);
		}
		return "";
	}

	private static class UniversalNamespaceResolver implements NamespaceContext {
		// the delegate
		private Document sourceDocument;

		/**
		 * This constructor stores the source document to search the namespaces
		 * in
		 * it.
		 * 
		 * @param document
		 *            source document
		 */
		public UniversalNamespaceResolver(Document document) {
			sourceDocument = document;
		}

		/**
		 * The lookup for the namespace uris is delegated to the stored
		 * document.
		 * 
		 * @param prefix
		 *            to search for
		 * @return uri
		 */
		public String getNamespaceURI(String prefix) {
			if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
				return sourceDocument.lookupNamespaceURI(null);
			} else {
				return sourceDocument.lookupNamespaceURI(prefix);
			}
		}

		/**
		 * This method is not needed in this context, but can be implemented in
		 * a
		 * similar way.
		 */
		public String getPrefix(String namespaceURI) {
			return sourceDocument.lookupPrefix(namespaceURI);
		}

		public Iterator getPrefixes(String namespaceURI) {
			// not implemented yet
			return null;
		}

	}

	private static class UniversalNamespaceResolver2 implements
			NamespaceContext {
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
		public UniversalNamespaceResolver2(Document document,
				boolean toplevelOnly) {
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

		public Iterator getPrefixes(String namespaceURI) {
			// Not implemented
			return null;
		}
	}

}

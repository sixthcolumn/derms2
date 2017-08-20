package com.sixthc.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * Executes functions on Multispeak Headers
 * 
 * @author BenGoodwin
 *
 */
public class MSHeader {
	private Document fromDoc;
	private Document toDoc; 
	private Boolean isValid = false;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(MSHeader.class);

	/**
	 * Copies tag values from one header to another
	 * 
	 * @param fromXML
	 * @param toXML
	 * @return
	 * @throws TransformerException
	 * @throws MSHeaderException
	 */
	public static String CopyPaste(String fromXML, String toXML, String tagName[])
			throws TransformerException, MSHeaderException {

		// parse xml strings
		MSHeader header = new MSHeader(fromXML, toXML);

		// throw exception if parsing failed, bad XML
		if (header.isValid == false)
			throw new MSHeaderException(
					"cannot get soap test, initial xml was invalid");
		
		// copy paste
		for( String key : tagName )
			header.replaceKey(key);

		// build transformer to re-translate DOM to string, and return modified XML
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(header.toDoc), new StreamResult(
				writer));

		return writer.getBuffer().toString();
	}

	/**
	 * given two XML strings, loads them into DOM objects for
	 * processing.
	 * 
	 * @param fromXML
	 *            injecter
	 * @param toXML
	 *            injectee
	 */
	private MSHeader(String fromXML, String toXML) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();

			// parse the from XML
			StringReader sr1 = new StringReader(fromXML);
			InputSource is1 = new InputSource(sr1);
			fromDoc = dBuilder.parse(is1);

			// parse the to XML
			StringReader sr2 = new StringReader(toXML);
			InputSource is2 = new InputSource(sr2);
			toDoc = dBuilder.parse(is2);

			isValid = true;
		} catch (Exception e) {
			log.error(e);
			isValid = false;
		}
	}

	/**
	 * gets the header element from the SOAP document
	 * 
	 * @param doc
	 * @return header Element
	 * @throws MSHeaderException
	 *             if REQUIRED header not found
	 */
	private Element getHeaderElement(Document doc)
			throws MSHeaderException {
		final String headerKey = "Header";
		if (doc.getElementsByTagNameNS("*", headerKey).getLength() > 0) {
			Element header = (Element) doc.getElementsByTagNameNS("*",
					headerKey).item(0);
			return header;
		} else
			throw new MSHeaderException("Header not found in doc : "
					+ doc.toString());

	}

	/**
	 * Gets node of MS header by tag name, throws exception if can't find tag
	 * 
	 * @param e
	 *            parent element
	 * @param tagName
	 *            tag name
	 * @return
	 * @throws MSHeaderException
	 *             thrown if node not found
	 */
	private Node getNode(Element e, String tagName)
			throws MSHeaderException {
		if (e.getElementsByTagNameNS("*", tagName).getLength() > 0)
			return e.getElementsByTagName(tagName).item(0);
		else
			throw new MSHeaderException("Key " + tagName
					+ " not found in element : " + e.toString());

	}

	/**
	 * copies pastes element value fromXML to toXML
	 * 
	 * @param tagName
	 * @throws MSHeaderException
	 */
	private void replaceKey(String tagName) throws MSHeaderException {

		try {
			Element fromElement = getHeaderElement(fromDoc);
			Element toElement = getHeaderElement(toDoc);

			// get the node value form the 'from' item
			String value = getNode(fromElement, tagName).getTextContent();
			log.debug("get value ("
					+ value
					+ ") for tag ("
					+ tagName
					+ ") in original SOAP message, injecting into replacement SOAP message");

			// set the node value of the 'to' item
			getNode(toElement, tagName).setTextContent(value);

		} catch (Exception e) {
			log.error(e);
		}
	}
}

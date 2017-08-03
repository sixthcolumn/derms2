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
 * Given two XML strings, this turns them into DOMs so that values
 * from the 'to' can be injected into the 'from'
 * 
 * @author BenGoodwin
 *
 */
public class DOMParser {
	Document fromDoc; // old doc (from)
	Document toDoc; // replacement doc (to)
	Boolean isValid = false; // when false, initalization failed

	private static org.apache.log4j.Logger log = Logger
			.getLogger(DOMParser.class);

	/**
	 * given two XML strings, loads them into DOM objects for
	 * processing.
	 * 
	 * @param fromXML	injecter
	 * @param toXML		injectee
	 */
	public DOMParser(String fromXML, String toXML) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();

			StringReader sr1 = new StringReader(fromXML);
			InputSource is1 = new InputSource(sr1);
			fromDoc = dBuilder.parse(is1);

			StringReader sr2 = new StringReader(toXML);
			InputSource is2 = new InputSource(sr2);
			toDoc = dBuilder.parse(is2);

			replaceKey("MessageID");
			replaceKey("CorrelationID");
			replaceKey("Timestamp");

			isValid = true;
		} catch (Exception e) {
			log.error(e);
			isValid = false;
		}
	}

	/**
	 * get the toDoc, return as a string
	 * 
	 * @return
	 * @throws TransformerException
	 * @throws DOMParserException
	 */
	public String getSOAPModifiedText() throws TransformerException,
			DOMParserException {
		if (isValid == false)
			throw new DOMParserException(
					"cannot get soap test, initial xml was invalid");

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		StringWriter writer = new StringWriter();
		transformer.transform(new DOMSource(toDoc), new StreamResult(writer));
		return writer.getBuffer().toString();
	}

	/**
	 * gets the header element from the SOAP document
	 * 
	 * @param doc
	 * @return header Element
	 * @throws DOMParserException
	 *             if REQUIRED header not found
	 */
	private Element getHeaderElement(Document doc) throws DOMParserException {
		final String headerKey = "Header";
		if (doc.getElementsByTagNameNS("*", headerKey).getLength() > 0) {
			Element header = (Element) doc.getElementsByTagNameNS("*",
					headerKey).item(0);
			return header;
		} else
			throw new DOMParserException("Header not found in doc : "
					+ doc.toString());

	}

	/**
	 * Gets node (so we can inject into it) based on tag name
	 * 
	 * @param e
	 *            parent element
	 * @param key
	 *            tag name
	 * @return
	 * @throws DOMParserException
	 *             thrown if node not found
	 */
	private Node getNode(Element e, String key) throws DOMParserException {
		if (e.getElementsByTagNameNS("*", key).getLength() > 0)
			return e.getElementsByTagName(key).item(0);
		else
			throw new DOMParserException("Key " + key
					+ " not found in element : " + e.toString());

	}

	/**
	 * replace element of toDoc with element of fromDoc
	 * 
	 * @param key
	 * @throws DOMParserException
	 */
	private void replaceKey(String key) throws DOMParserException {

		try {
			Element fromElement = getHeaderElement(fromDoc);
			Element toElement = getHeaderElement(toDoc);

			// get the node value form the 'from' item
			String value = getNode(fromElement, key).getTextContent();
			log.debug("get value ("
					+ value
					+ ") for tag ("
					+ key
					+ ") in original SOAP message, injecting into replacement SOAP message");

			// set the node value of the 'to' item
			getNode(toElement, key).setTextContent(value);

		} catch (Exception e) {
			log.error(e);
		}
	}

	public Boolean isValid() {
		return isValid;
	}

}

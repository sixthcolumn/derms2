package com.sixthc.util;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;

import com.sixthc.server.ws.ExecuteMaintOrderCreate;

public class DateUtil {
	static Logger log = Logger.getLogger(DateUtil.class);

	public static Timestamp parseDate(XMLGregorianCalendar from) {
		if (from != null) {
			Timestamp timestamp = new Timestamp(from.toGregorianCalendar()
					.getTimeInMillis());
			return timestamp;
		}
		return null;
	}
	
	public static XMLGregorianCalendar getXMLDate(java.util.Date dt) {
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dt);
		XMLGregorianCalendar d2;
		try {
			d2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			return d2;
		} catch (DatatypeConfigurationException e) {
			log.error(e);
			return null;
		}

	}
}

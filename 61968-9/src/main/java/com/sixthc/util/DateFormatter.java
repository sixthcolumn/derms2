package com.sixthc.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateFormatter {

	Date date;
	
	DateFormatter() {
		date = new Date();
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public XMLGregorianCalendar getXMLGregorianDate() throws DatatypeConfigurationException {
		GregorianCalendar gcal = (GregorianCalendar) new GregorianCalendar();
		gcal.setTime(date);
		
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
	}

	@Override
	public String toString() {
		return "Customer [date=" + date + "]";
	}
}

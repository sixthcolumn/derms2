package com.sixthc.util;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;

public class XMLGregorianCalendarFactoryBean implements
		FactoryBean<XMLGregorianCalendar> {

	private int year;
	private int month;
	private int dayOfMonth;
	// we'll default hour, minute, second if not set
	private int hourOfDay = 0;
	private int minute = 0;
	private int second = 0;
	private Boolean now;
	private boolean isYearSet = false;
	private boolean isMonthSet = false;
	private boolean isDayOfMonthSet = false;

	private static org.apache.log4j.Logger log = Logger
			.getLogger(XMLGregorianCalendarFactoryBean.class);

	public void setNow(Boolean now) {
		this.now = now;
	}

	public void setYear(int year) {
		this.year = year;
		this.isYearSet = true;
	}

	public void setMonth(int month) {
		this.month = month;
		this.isMonthSet = true;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.isDayOfMonthSet = true;
		this.dayOfMonth = dayOfMonth;
	}

	public void setHourOfDay(int hourOfDay) {
		this.hourOfDay = hourOfDay;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public Class<XMLGregorianCalendar> getObjectType() {
		return XMLGregorianCalendar.class;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 * 
	 * return xmlgregorian calendar object
	 */
	@Override
	public XMLGregorianCalendar getObject() throws Exception {
		GregorianCalendar gcal;

		if (now == true) {
			gcal = (GregorianCalendar) GregorianCalendar.getInstance();
		} else if (isYearSet == true || isMonthSet == true
				|| isDayOfMonthSet == true ) {
			gcal = (GregorianCalendar) new GregorianCalendar(year, month,
					dayOfMonth, hourOfDay, minute, second);
		} else {
			log.warn("XMLGregorianCalendar Bean Factory, args not set, default to NOW");
			gcal = (GregorianCalendar) GregorianCalendar.getInstance();
		}

		log.debug("returning XMLGregorianCalender value : " + gcal);

		return DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

	}

	@Override
	public boolean isSingleton() {
		return false;
	}
}


package com.sixthc.cim.getServiceOrders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Meeting time and location.
 * 
 * <p>Java class for Appointment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Appointment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callAhead" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="meetingInterval" type="{http://iec.ch/TC57/2015/ServiceOrders#}DateTimeInterval" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Appointment", propOrder = {
    "callAhead",
    "meetingInterval"
})
public class Appointment {

    protected Boolean callAhead;
    protected DateTimeInterval meetingInterval;

    /**
     * Gets the value of the callAhead property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCallAhead() {
        return callAhead;
    }

    /**
     * Sets the value of the callAhead property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCallAhead(Boolean value) {
        this.callAhead = value;
    }

    /**
     * Gets the value of the meetingInterval property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeInterval }
     *     
     */
    public DateTimeInterval getMeetingInterval() {
        return meetingInterval;
    }

    /**
     * Sets the value of the meetingInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeInterval }
     *     
     */
    public void setMeetingInterval(DateTimeInterval value) {
        this.meetingInterval = value;
    }

}

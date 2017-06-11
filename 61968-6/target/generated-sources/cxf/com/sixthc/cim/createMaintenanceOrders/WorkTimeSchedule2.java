
package com.sixthc.cim.createMaintenanceOrders;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Time schedule specific to work.
 * 
 * <p>Java class for WorkTimeSchedule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkTimeSchedule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kind" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}WorkTimeScheduleKind"/>
 *         &lt;element name="scheduleInterval">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkTimeSchedule", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", propOrder = {
    "kind",
    "scheduleInterval"
})
public class WorkTimeSchedule2 {

    @XmlElement(required = true)
    protected WorkTimeScheduleKind2 kind;
    @XmlElement(required = true)
    protected WorkTimeSchedule2 .ScheduleInterval scheduleInterval;

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link WorkTimeScheduleKind2 }
     *     
     */
    public WorkTimeScheduleKind2 getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkTimeScheduleKind2 }
     *     
     */
    public void setKind(WorkTimeScheduleKind2 value) {
        this.kind = value;
    }

    /**
     * Gets the value of the scheduleInterval property.
     * 
     * @return
     *     possible object is
     *     {@link WorkTimeSchedule2 .ScheduleInterval }
     *     
     */
    public WorkTimeSchedule2 .ScheduleInterval getScheduleInterval() {
        return scheduleInterval;
    }

    /**
     * Sets the value of the scheduleInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkTimeSchedule2 .ScheduleInterval }
     *     
     */
    public void setScheduleInterval(WorkTimeSchedule2 .ScheduleInterval value) {
        this.scheduleInterval = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="end" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="start" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "end",
        "start"
    })
    public static class ScheduleInterval {

        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar end;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar start;

        /**
         * Gets the value of the end property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getEnd() {
            return end;
        }

        /**
         * Sets the value of the end property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setEnd(XMLGregorianCalendar value) {
            this.end = value;
        }

        /**
         * Gets the value of the start property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStart() {
            return start;
        }

        /**
         * Sets the value of the start property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStart(XMLGregorianCalendar value) {
            this.start = value;
        }

    }

}

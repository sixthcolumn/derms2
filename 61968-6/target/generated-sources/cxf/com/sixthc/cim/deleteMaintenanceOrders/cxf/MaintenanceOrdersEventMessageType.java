
package com.sixthc.cim.deleteMaintenanceOrders.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sixthc.cim.deleteMaintenanceOrders.HeaderType;


/**
 * <p>Java class for MaintenanceOrdersEventMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaintenanceOrdersEventMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://iec.ch/TC57/2011/schema/message}HeaderType"/>
 *         &lt;element name="Payload" type="{http://iec.ch/TC57/2015/MaintenanceOrdersMessage}MaintenanceOrdersPayloadType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaintenanceOrdersEventMessageType", propOrder = {
    "header",
    "payload"
})
public class MaintenanceOrdersEventMessageType {

    @XmlElement(name = "Header", required = true)
    protected HeaderType header;
    @XmlElement(name = "Payload")
    protected MaintenanceOrdersPayloadType payload;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public HeaderType getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setHeader(HeaderType value) {
        this.header = value;
    }

    /**
     * Gets the value of the payload property.
     * 
     * @return
     *     possible object is
     *     {@link MaintenanceOrdersPayloadType }
     *     
     */
    public MaintenanceOrdersPayloadType getPayload() {
        return payload;
    }

    /**
     * Sets the value of the payload property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaintenanceOrdersPayloadType }
     *     
     */
    public void setPayload(MaintenanceOrdersPayloadType value) {
        this.payload = value;
    }

}

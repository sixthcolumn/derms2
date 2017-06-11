
package com.sixthc.cim.getMaintenanceOrders.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.sixthc.cim.getMaintenanceOrders.HeaderType;


/**
 * <p>Java class for GetMaintenanceOrdersRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMaintenanceOrdersRequestMessageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header" type="{http://iec.ch/TC57/2011/schema/message}HeaderType"/>
 *         &lt;element name="Request" type="{http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage}GetMaintenanceOrdersRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMaintenanceOrdersRequestMessageType", namespace = "http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", propOrder = {
    "header",
    "request"
})
public class GetMaintenanceOrdersRequestMessageType {

    @XmlElement(name = "Header", required = true)
    protected HeaderType header;
    @XmlElement(name = "Request")
    protected GetMaintenanceOrdersRequestType request;

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
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link GetMaintenanceOrdersRequestType }
     *     
     */
    public GetMaintenanceOrdersRequestType getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMaintenanceOrdersRequestType }
     *     
     */
    public void setRequest(GetMaintenanceOrdersRequestType value) {
        this.request = value;
    }

}

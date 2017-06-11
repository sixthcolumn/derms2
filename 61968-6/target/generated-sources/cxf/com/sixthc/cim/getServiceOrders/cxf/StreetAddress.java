
package com.sixthc.cim.getServiceOrders.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * General purpose street address information.
 * 
 * <p>Java class for StreetAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StreetAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="streetDetail" type="{http://iec.ch/TC57/2015/GetServiceOrders#}StreetDetail" minOccurs="0"/>
 *         &lt;element name="townDetail" type="{http://iec.ch/TC57/2015/GetServiceOrders#}TownDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreetAddress", propOrder = {
    "streetDetail",
    "townDetail"
})
public class StreetAddress {

    protected StreetDetail streetDetail;
    protected TownDetail townDetail;

    /**
     * Gets the value of the streetDetail property.
     * 
     * @return
     *     possible object is
     *     {@link StreetDetail }
     *     
     */
    public StreetDetail getStreetDetail() {
        return streetDetail;
    }

    /**
     * Sets the value of the streetDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreetDetail }
     *     
     */
    public void setStreetDetail(StreetDetail value) {
        this.streetDetail = value;
    }

    /**
     * Gets the value of the townDetail property.
     * 
     * @return
     *     possible object is
     *     {@link TownDetail }
     *     
     */
    public TownDetail getTownDetail() {
        return townDetail;
    }

    /**
     * Sets the value of the townDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link TownDetail }
     *     
     */
    public void setTownDetail(TownDetail value) {
        this.townDetail = value;
    }

}

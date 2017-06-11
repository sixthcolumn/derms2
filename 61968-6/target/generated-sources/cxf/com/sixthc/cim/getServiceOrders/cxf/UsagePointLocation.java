
package com.sixthc.cim.getServiceOrders.cxf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Location of this usage point.
 * 
 * <p>Java class for UsagePointLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsagePointLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/GetServiceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="accessMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InternalLocation" type="{http://iec.ch/TC57/2015/GetServiceOrders#}InternalLocation" minOccurs="0"/>
 *         &lt;element name="mainAddress" type="{http://iec.ch/TC57/2015/GetServiceOrders#}StreetAddress" minOccurs="0"/>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePointLocation", propOrder = {
    "mrid",
    "accessMethod",
    "internalLocation",
    "mainAddress",
    "names"
})
public class UsagePointLocation {

    @XmlElement(name = "mRID")
    protected String mrid;
    protected String accessMethod;
    @XmlElement(name = "InternalLocation")
    protected InternalLocation internalLocation;
    protected StreetAddress mainAddress;
    @XmlElement(name = "Names")
    protected List<Name> names;

    /**
     * Gets the value of the mrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMRID() {
        return mrid;
    }

    /**
     * Sets the value of the mrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMRID(String value) {
        this.mrid = value;
    }

    /**
     * Gets the value of the accessMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessMethod() {
        return accessMethod;
    }

    /**
     * Sets the value of the accessMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessMethod(String value) {
        this.accessMethod = value;
    }

    /**
     * Gets the value of the internalLocation property.
     * 
     * @return
     *     possible object is
     *     {@link InternalLocation }
     *     
     */
    public InternalLocation getInternalLocation() {
        return internalLocation;
    }

    /**
     * Sets the value of the internalLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalLocation }
     *     
     */
    public void setInternalLocation(InternalLocation value) {
        this.internalLocation = value;
    }

    /**
     * Gets the value of the mainAddress property.
     * 
     * @return
     *     possible object is
     *     {@link StreetAddress }
     *     
     */
    public StreetAddress getMainAddress() {
        return mainAddress;
    }

    /**
     * Sets the value of the mainAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreetAddress }
     *     
     */
    public void setMainAddress(StreetAddress value) {
        this.mainAddress = value;
    }

    /**
     * Gets the value of the names property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the names property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     */
    public List<Name> getNames() {
        if (names == null) {
            names = new ArrayList<Name>();
        }
        return this.names;
    }

}

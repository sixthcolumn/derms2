
package com.sixthc.cim.getServiceOrders;

import java.math.BigInteger;
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
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="accessMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="geoInfoReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siteAccessProblem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CoordinateSystem" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="crsUrn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Hazards" type="{http://iec.ch/TC57/2015/ServiceOrders#}AssetLocationHazard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InternalLocation" type="{http://iec.ch/TC57/2015/ServiceOrders#}InternalLocation" minOccurs="0"/>
 *         &lt;element name="mainAddress" type="{http://iec.ch/TC57/2015/ServiceOrders#}StreetAddress"/>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PositionPoints" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="xPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="yPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="zPosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "UsagePointLocation", propOrder = {
    "mrid",
    "accessMethod",
    "direction",
    "geoInfoReference",
    "remark",
    "siteAccessProblem",
    "type",
    "coordinateSystem",
    "hazards",
    "internalLocation",
    "mainAddress",
    "names",
    "positionPoints"
})
public class UsagePointLocation {

    @XmlElement(name = "mRID")
    protected String mrid;
    protected String accessMethod;
    protected String direction;
    protected String geoInfoReference;
    protected String remark;
    protected String siteAccessProblem;
    protected String type;
    @XmlElement(name = "CoordinateSystem")
    protected UsagePointLocation.CoordinateSystem coordinateSystem;
    @XmlElement(name = "Hazards")
    protected List<AssetLocationHazard2> hazards;
    @XmlElement(name = "InternalLocation")
    protected InternalLocation2 internalLocation;
    @XmlElement(required = true)
    protected StreetAddress mainAddress;
    @XmlElement(name = "Names")
    protected List<Name2> names;
    @XmlElement(name = "PositionPoints")
    protected List<UsagePointLocation.PositionPoints> positionPoints;

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
     * Gets the value of the direction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    /**
     * Gets the value of the geoInfoReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeoInfoReference() {
        return geoInfoReference;
    }

    /**
     * Sets the value of the geoInfoReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeoInfoReference(String value) {
        this.geoInfoReference = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the siteAccessProblem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiteAccessProblem() {
        return siteAccessProblem;
    }

    /**
     * Sets the value of the siteAccessProblem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiteAccessProblem(String value) {
        this.siteAccessProblem = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the coordinateSystem property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePointLocation.CoordinateSystem }
     *     
     */
    public UsagePointLocation.CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * Sets the value of the coordinateSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePointLocation.CoordinateSystem }
     *     
     */
    public void setCoordinateSystem(UsagePointLocation.CoordinateSystem value) {
        this.coordinateSystem = value;
    }

    /**
     * Gets the value of the hazards property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hazards property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHazards().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AssetLocationHazard2 }
     * 
     * 
     */
    public List<AssetLocationHazard2> getHazards() {
        if (hazards == null) {
            hazards = new ArrayList<AssetLocationHazard2>();
        }
        return this.hazards;
    }

    /**
     * Gets the value of the internalLocation property.
     * 
     * @return
     *     possible object is
     *     {@link InternalLocation2 }
     *     
     */
    public InternalLocation2 getInternalLocation() {
        return internalLocation;
    }

    /**
     * Sets the value of the internalLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalLocation2 }
     *     
     */
    public void setInternalLocation(InternalLocation2 value) {
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
     * {@link Name2 }
     * 
     * 
     */
    public List<Name2> getNames() {
        if (names == null) {
            names = new ArrayList<Name2>();
        }
        return this.names;
    }

    /**
     * Gets the value of the positionPoints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the positionPoints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPositionPoints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsagePointLocation.PositionPoints }
     * 
     * 
     */
    public List<UsagePointLocation.PositionPoints> getPositionPoints() {
        if (positionPoints == null) {
            positionPoints = new ArrayList<UsagePointLocation.PositionPoints>();
        }
        return this.positionPoints;
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
     *         &lt;element name="crsUrn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "crsUrn"
    })
    public static class CoordinateSystem {

        @XmlElement(required = true)
        protected String crsUrn;

        /**
         * Gets the value of the crsUrn property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCrsUrn() {
            return crsUrn;
        }

        /**
         * Sets the value of the crsUrn property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCrsUrn(String value) {
            this.crsUrn = value;
        }

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
     *         &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="xPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="yPosition" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="zPosition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "sequenceNumber",
        "xPosition",
        "yPosition",
        "zPosition"
    })
    public static class PositionPoints {

        protected BigInteger sequenceNumber;
        @XmlElement(required = true)
        protected String xPosition;
        @XmlElement(required = true)
        protected String yPosition;
        protected String zPosition;

        /**
         * Gets the value of the sequenceNumber property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSequenceNumber() {
            return sequenceNumber;
        }

        /**
         * Sets the value of the sequenceNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSequenceNumber(BigInteger value) {
            this.sequenceNumber = value;
        }

        /**
         * Gets the value of the xPosition property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getXPosition() {
            return xPosition;
        }

        /**
         * Sets the value of the xPosition property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setXPosition(String value) {
            this.xPosition = value;
        }

        /**
         * Gets the value of the yPosition property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getYPosition() {
            return yPosition;
        }

        /**
         * Sets the value of the yPosition property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setYPosition(String value) {
            this.yPosition = value;
        }

        /**
         * Gets the value of the zPosition property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getZPosition() {
            return zPosition;
        }

        /**
         * Sets the value of the zPosition property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setZPosition(String value) {
            this.zPosition = value;
        }

    }

}

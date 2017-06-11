
package com.sixthc.cim.getMaintenanceOrders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Information about a particular location for various
 * 				forms
 * 				of work.
 * 			
 * 
 * <p>Java class for WorkLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkLocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="direction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="Hazards" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}AssetLocationHazard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InternalLocation" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}InternalLocation" minOccurs="0"/>
 *         &lt;element name="mainAddress" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="streetDetail">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="addressGeneral" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="addressGeneral2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="addressGeneral3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="buildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="suiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="withinTownLimits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="townDetail">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="phone1" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}TelephoneNumber" minOccurs="0"/>
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
@XmlType(name = "WorkLocation", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", propOrder = {
    "mrid",
    "direction",
    "coordinateSystem",
    "hazards",
    "internalLocation",
    "mainAddress",
    "names",
    "phone1",
    "positionPoints"
})
public class WorkLocation2 {

    @XmlElement(name = "mRID")
    protected String mrid;
    protected String direction;
    @XmlElement(name = "CoordinateSystem")
    protected WorkLocation2 .CoordinateSystem coordinateSystem;
    @XmlElement(name = "Hazards")
    protected List<AssetLocationHazard2> hazards;
    @XmlElement(name = "InternalLocation")
    protected InternalLocation2 internalLocation;
    protected WorkLocation2 .MainAddress mainAddress;
    @XmlElement(name = "Names")
    protected List<Name2> names;
    protected TelephoneNumber phone1;
    @XmlElement(name = "PositionPoints")
    protected List<WorkLocation2 .PositionPoints> positionPoints;

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
     * Gets the value of the coordinateSystem property.
     * 
     * @return
     *     possible object is
     *     {@link WorkLocation2 .CoordinateSystem }
     *     
     */
    public WorkLocation2 .CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * Sets the value of the coordinateSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkLocation2 .CoordinateSystem }
     *     
     */
    public void setCoordinateSystem(WorkLocation2 .CoordinateSystem value) {
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
     *     {@link WorkLocation2 .MainAddress }
     *     
     */
    public WorkLocation2 .MainAddress getMainAddress() {
        return mainAddress;
    }

    /**
     * Sets the value of the mainAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkLocation2 .MainAddress }
     *     
     */
    public void setMainAddress(WorkLocation2 .MainAddress value) {
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
     * Gets the value of the phone1 property.
     * 
     * @return
     *     possible object is
     *     {@link TelephoneNumber }
     *     
     */
    public TelephoneNumber getPhone1() {
        return phone1;
    }

    /**
     * Sets the value of the phone1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link TelephoneNumber }
     *     
     */
    public void setPhone1(TelephoneNumber value) {
        this.phone1 = value;
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
     * {@link WorkLocation2 .PositionPoints }
     * 
     * 
     */
    public List<WorkLocation2 .PositionPoints> getPositionPoints() {
        if (positionPoints == null) {
            positionPoints = new ArrayList<WorkLocation2 .PositionPoints>();
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

        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
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
     *         &lt;element name="streetDetail">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="addressGeneral" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="addressGeneral2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="addressGeneral3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="buildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="suiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="withinTownLimits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="townDetail">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "streetDetail",
        "townDetail"
    })
    public static class MainAddress {

        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
        protected WorkLocation2 .MainAddress.StreetDetail streetDetail;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
        protected WorkLocation2 .MainAddress.TownDetail townDetail;

        /**
         * Gets the value of the streetDetail property.
         * 
         * @return
         *     possible object is
         *     {@link WorkLocation2 .MainAddress.StreetDetail }
         *     
         */
        public WorkLocation2 .MainAddress.StreetDetail getStreetDetail() {
            return streetDetail;
        }

        /**
         * Sets the value of the streetDetail property.
         * 
         * @param value
         *     allowed object is
         *     {@link WorkLocation2 .MainAddress.StreetDetail }
         *     
         */
        public void setStreetDetail(WorkLocation2 .MainAddress.StreetDetail value) {
            this.streetDetail = value;
        }

        /**
         * Gets the value of the townDetail property.
         * 
         * @return
         *     possible object is
         *     {@link WorkLocation2 .MainAddress.TownDetail }
         *     
         */
        public WorkLocation2 .MainAddress.TownDetail getTownDetail() {
            return townDetail;
        }

        /**
         * Sets the value of the townDetail property.
         * 
         * @param value
         *     allowed object is
         *     {@link WorkLocation2 .MainAddress.TownDetail }
         *     
         */
        public void setTownDetail(WorkLocation2 .MainAddress.TownDetail value) {
            this.townDetail = value;
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
         *         &lt;element name="addressGeneral" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="addressGeneral2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="addressGeneral3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="buildingName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="prefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="suiteNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="withinTownLimits" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
            "addressGeneral",
            "addressGeneral2",
            "addressGeneral3",
            "buildingName",
            "code",
            "name",
            "number",
            "prefix",
            "suffix",
            "suiteNumber",
            "type",
            "withinTownLimits"
        })
        public static class StreetDetail {

            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
            protected String addressGeneral;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String addressGeneral2;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String addressGeneral3;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String buildingName;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String code;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String name;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String number;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String prefix;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String suffix;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String suiteNumber;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String type;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected Boolean withinTownLimits;

            /**
             * Gets the value of the addressGeneral property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressGeneral() {
                return addressGeneral;
            }

            /**
             * Sets the value of the addressGeneral property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressGeneral(String value) {
                this.addressGeneral = value;
            }

            /**
             * Gets the value of the addressGeneral2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressGeneral2() {
                return addressGeneral2;
            }

            /**
             * Sets the value of the addressGeneral2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressGeneral2(String value) {
                this.addressGeneral2 = value;
            }

            /**
             * Gets the value of the addressGeneral3 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressGeneral3() {
                return addressGeneral3;
            }

            /**
             * Sets the value of the addressGeneral3 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressGeneral3(String value) {
                this.addressGeneral3 = value;
            }

            /**
             * Gets the value of the buildingName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuildingName() {
                return buildingName;
            }

            /**
             * Sets the value of the buildingName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuildingName(String value) {
                this.buildingName = value;
            }

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the number property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumber() {
                return number;
            }

            /**
             * Sets the value of the number property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumber(String value) {
                this.number = value;
            }

            /**
             * Gets the value of the prefix property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrefix() {
                return prefix;
            }

            /**
             * Sets the value of the prefix property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrefix(String value) {
                this.prefix = value;
            }

            /**
             * Gets the value of the suffix property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSuffix() {
                return suffix;
            }

            /**
             * Sets the value of the suffix property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSuffix(String value) {
                this.suffix = value;
            }

            /**
             * Gets the value of the suiteNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSuiteNumber() {
                return suiteNumber;
            }

            /**
             * Sets the value of the suiteNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSuiteNumber(String value) {
                this.suiteNumber = value;
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
             * Gets the value of the withinTownLimits property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isWithinTownLimits() {
                return withinTownLimits;
            }

            /**
             * Sets the value of the withinTownLimits property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setWithinTownLimits(Boolean value) {
                this.withinTownLimits = value;
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
         *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="section" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="stateOrProvince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "code",
            "country",
            "name",
            "section",
            "stateOrProvince"
        })
        public static class TownDetail {

            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String code;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String country;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
            protected String name;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String section;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String stateOrProvince;

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            /**
             * Gets the value of the country property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the section property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSection() {
                return section;
            }

            /**
             * Sets the value of the section property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSection(String value) {
                this.section = value;
            }

            /**
             * Gets the value of the stateOrProvince property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStateOrProvince() {
                return stateOrProvince;
            }

            /**
             * Sets the value of the stateOrProvince property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStateOrProvince(String value) {
                this.stateOrProvince = value;
            }

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

        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        protected BigInteger sequenceNumber;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
        protected String xPosition;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
        protected String yPosition;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
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

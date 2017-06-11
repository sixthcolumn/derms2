
package com.sixthc.cim.createServiceOrders;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Logical or physical point in the network to which
 * 				readings or events may be attributed. Used at the place where a
 * 				physical or virtual meter may be located; however, it is not
 * 				required that a meter be present.
 * 
 * <p>Java class for UsagePoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsagePoint">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="checkBilling" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="connectionState" type="{http://iec.ch/TC57/2015/ServiceOrders#}UsagePointConnectedKind" minOccurs="0"/>
 *         &lt;element name="grounded" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isSdp" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="isVirtual" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="nominalServiceVoltage" type="{http://iec.ch/TC57/2015/ServiceOrders#}Voltage" minOccurs="0"/>
 *         &lt;element name="phaseCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="AB"/>
 *               &lt;enumeration value="ABC"/>
 *               &lt;enumeration value="ABCN"/>
 *               &lt;enumeration value="ABN"/>
 *               &lt;enumeration value="AC"/>
 *               &lt;enumeration value="ACN"/>
 *               &lt;enumeration value="AN"/>
 *               &lt;enumeration value="B"/>
 *               &lt;enumeration value="BC"/>
 *               &lt;enumeration value="BCN"/>
 *               &lt;enumeration value="BN"/>
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="CN"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="s1"/>
 *               &lt;enumeration value="s12"/>
 *               &lt;enumeration value="s12N"/>
 *               &lt;enumeration value="s1N"/>
 *               &lt;enumeration value="s2"/>
 *               &lt;enumeration value="s2N"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ratedCurrent" type="{http://iec.ch/TC57/2015/ServiceOrders#}CurrentFlow"/>
 *         &lt;element name="serviceDeliveryRemark" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicePriority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MetrologyRequirements" type="{http://iec.ch/TC57/2015/ServiceOrders#}MetrologyRequirement" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ServiceCategory" type="{http://iec.ch/TC57/2015/ServiceOrders#}ServiceCategory" minOccurs="0"/>
 *         &lt;element name="ServiceMultipliers" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
 *                   &lt;element name="kind">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="ctRatio"/>
 *                         &lt;enumeration value="ptRatio"/>
 *                         &lt;enumeration value="transformerRatio"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServiceSupplier" type="{http://iec.ch/TC57/2015/ServiceOrders#}ServiceSupplier" minOccurs="0"/>
 *         &lt;element name="UsagePointLocation" type="{http://iec.ch/TC57/2015/ServiceOrders#}UsagePointLocation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePoint", propOrder = {
    "mrid",
    "checkBilling",
    "connectionState",
    "grounded",
    "isSdp",
    "isVirtual",
    "nominalServiceVoltage",
    "phaseCode",
    "ratedCurrent",
    "serviceDeliveryRemark",
    "servicePriority",
    "metrologyRequirements",
    "names",
    "serviceCategory",
    "serviceMultipliers",
    "serviceSupplier",
    "usagePointLocation"
})
public class UsagePoint {

    @XmlElement(name = "mRID")
    protected String mrid;
    protected Boolean checkBilling;
    protected UsagePointConnectedKind connectionState;
    protected Boolean grounded;
    protected Boolean isSdp;
    protected Boolean isVirtual;
    protected Float nominalServiceVoltage;
    protected String phaseCode;
    protected float ratedCurrent;
    protected String serviceDeliveryRemark;
    protected String servicePriority;
    @XmlElement(name = "MetrologyRequirements")
    protected List<MetrologyRequirement> metrologyRequirements;
    @XmlElement(name = "Names")
    protected List<Name2> names;
    @XmlElement(name = "ServiceCategory")
    protected ServiceCategory serviceCategory;
    @XmlElement(name = "ServiceMultipliers")
    protected List<UsagePoint.ServiceMultipliers> serviceMultipliers;
    @XmlElement(name = "ServiceSupplier")
    protected ServiceSupplier serviceSupplier;
    @XmlElement(name = "UsagePointLocation")
    protected UsagePointLocation usagePointLocation;

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
     * Gets the value of the checkBilling property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCheckBilling() {
        return checkBilling;
    }

    /**
     * Sets the value of the checkBilling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckBilling(Boolean value) {
        this.checkBilling = value;
    }

    /**
     * Gets the value of the connectionState property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePointConnectedKind }
     *     
     */
    public UsagePointConnectedKind getConnectionState() {
        return connectionState;
    }

    /**
     * Sets the value of the connectionState property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePointConnectedKind }
     *     
     */
    public void setConnectionState(UsagePointConnectedKind value) {
        this.connectionState = value;
    }

    /**
     * Gets the value of the grounded property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGrounded() {
        return grounded;
    }

    /**
     * Sets the value of the grounded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGrounded(Boolean value) {
        this.grounded = value;
    }

    /**
     * Gets the value of the isSdp property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSdp() {
        return isSdp;
    }

    /**
     * Sets the value of the isSdp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSdp(Boolean value) {
        this.isSdp = value;
    }

    /**
     * Gets the value of the isVirtual property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsVirtual() {
        return isVirtual;
    }

    /**
     * Sets the value of the isVirtual property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsVirtual(Boolean value) {
        this.isVirtual = value;
    }

    /**
     * Gets the value of the nominalServiceVoltage property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNominalServiceVoltage() {
        return nominalServiceVoltage;
    }

    /**
     * Sets the value of the nominalServiceVoltage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setNominalServiceVoltage(Float value) {
        this.nominalServiceVoltage = value;
    }

    /**
     * Gets the value of the phaseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhaseCode() {
        return phaseCode;
    }

    /**
     * Sets the value of the phaseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhaseCode(String value) {
        this.phaseCode = value;
    }

    /**
     * Gets the value of the ratedCurrent property.
     * 
     */
    public float getRatedCurrent() {
        return ratedCurrent;
    }

    /**
     * Sets the value of the ratedCurrent property.
     * 
     */
    public void setRatedCurrent(float value) {
        this.ratedCurrent = value;
    }

    /**
     * Gets the value of the serviceDeliveryRemark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceDeliveryRemark() {
        return serviceDeliveryRemark;
    }

    /**
     * Sets the value of the serviceDeliveryRemark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceDeliveryRemark(String value) {
        this.serviceDeliveryRemark = value;
    }

    /**
     * Gets the value of the servicePriority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePriority() {
        return servicePriority;
    }

    /**
     * Sets the value of the servicePriority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePriority(String value) {
        this.servicePriority = value;
    }

    /**
     * Gets the value of the metrologyRequirements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metrologyRequirements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetrologyRequirements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MetrologyRequirement }
     * 
     * 
     */
    public List<MetrologyRequirement> getMetrologyRequirements() {
        if (metrologyRequirements == null) {
            metrologyRequirements = new ArrayList<MetrologyRequirement>();
        }
        return this.metrologyRequirements;
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
     * Gets the value of the serviceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCategory }
     *     
     */
    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    /**
     * Sets the value of the serviceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCategory }
     *     
     */
    public void setServiceCategory(ServiceCategory value) {
        this.serviceCategory = value;
    }

    /**
     * Gets the value of the serviceMultipliers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceMultipliers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceMultipliers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsagePoint.ServiceMultipliers }
     * 
     * 
     */
    public List<UsagePoint.ServiceMultipliers> getServiceMultipliers() {
        if (serviceMultipliers == null) {
            serviceMultipliers = new ArrayList<UsagePoint.ServiceMultipliers>();
        }
        return this.serviceMultipliers;
    }

    /**
     * Gets the value of the serviceSupplier property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSupplier }
     *     
     */
    public ServiceSupplier getServiceSupplier() {
        return serviceSupplier;
    }

    /**
     * Sets the value of the serviceSupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSupplier }
     *     
     */
    public void setServiceSupplier(ServiceSupplier value) {
        this.serviceSupplier = value;
    }

    /**
     * Gets the value of the usagePointLocation property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePointLocation }
     *     
     */
    public UsagePointLocation getUsagePointLocation() {
        return usagePointLocation;
    }

    /**
     * Sets the value of the usagePointLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePointLocation }
     *     
     */
    public void setUsagePointLocation(UsagePointLocation value) {
        this.usagePointLocation = value;
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
     *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
     *         &lt;element name="kind">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="ctRatio"/>
     *               &lt;enumeration value="ptRatio"/>
     *               &lt;enumeration value="transformerRatio"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
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
        "mrid",
        "kind",
        "value",
        "names"
    })
    public static class ServiceMultipliers {

        @XmlElement(name = "mRID")
        protected String mrid;
        @XmlElement(required = true)
        protected String kind;
        protected float value;
        @XmlElement(name = "Names")
        protected List<Name2> names;

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
         * Gets the value of the kind property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKind() {
            return kind;
        }

        /**
         * Sets the value of the kind property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKind(String value) {
            this.kind = value;
        }

        /**
         * Gets the value of the value property.
         * 
         */
        public float getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(float value) {
            this.value = value;
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

    }

}

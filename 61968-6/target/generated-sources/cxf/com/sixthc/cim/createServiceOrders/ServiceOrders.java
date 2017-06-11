
package com.sixthc.cim.createServiceOrders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * One or more instances of a Service Order.
 * 			
 * 
 * <p>Java class for ServiceOrders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceOrders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReadingQualityType" type="{http://iec.ch/TC57/2015/ServiceOrders#}ReadingQualityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReadingType" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://iec.ch/TC57/2015/ServiceOrders#}ReadingType">
 *                 &lt;sequence>
 *                   &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
 *                   &lt;element name="accumulation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="aggregate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="commodity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="consumptionTier" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="cpp" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="flowDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="macroPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="measurementKind" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="measuringPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="multiplier" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="phases" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="tou" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="argument" type="{http://iec.ch/TC57/2015/ServiceOrders#}RationalNumber"/>
 *                   &lt;element name="interharmonic" type="{http://iec.ch/TC57/2015/ServiceOrders#}ReadingInterharmonic"/>
 *                   &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServiceOrder" type="{http://iec.ch/TC57/2015/ServiceOrders#}ServiceOrder" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceOrders", propOrder = {
    "readingQualityType",
    "readingType",
    "serviceOrder"
})
public class ServiceOrders {

    @XmlElement(name = "ReadingQualityType")
    protected List<ReadingQualityType> readingQualityType;
    @XmlElement(name = "ReadingType")
    protected List<ServiceOrders.ReadingType> readingType;
    @XmlElement(name = "ServiceOrder", required = true)
    protected List<ServiceOrder> serviceOrder;

    /**
     * Gets the value of the readingQualityType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readingQualityType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadingQualityType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReadingQualityType }
     * 
     * 
     */
    public List<ReadingQualityType> getReadingQualityType() {
        if (readingQualityType == null) {
            readingQualityType = new ArrayList<ReadingQualityType>();
        }
        return this.readingQualityType;
    }

    /**
     * Gets the value of the readingType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readingType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadingType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceOrders.ReadingType }
     * 
     * 
     */
    public List<ServiceOrders.ReadingType> getReadingType() {
        if (readingType == null) {
            readingType = new ArrayList<ServiceOrders.ReadingType>();
        }
        return this.readingType;
    }

    /**
     * Gets the value of the serviceOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceOrder }
     * 
     * 
     */
    public List<ServiceOrder> getServiceOrder() {
        if (serviceOrder == null) {
            serviceOrder = new ArrayList<ServiceOrder>();
        }
        return this.serviceOrder;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;extension base="{http://iec.ch/TC57/2015/ServiceOrders#}ReadingType">
     *       &lt;sequence>
     *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
     *         &lt;element name="accumulation" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="aggregate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="commodity" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="consumptionTier" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="cpp" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="flowDirection" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="macroPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="measurementKind" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="measuringPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="multiplier" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="phases" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="tou" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="unit" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="argument" type="{http://iec.ch/TC57/2015/ServiceOrders#}RationalNumber"/>
     *         &lt;element name="interharmonic" type="{http://iec.ch/TC57/2015/ServiceOrders#}ReadingInterharmonic"/>
     *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mrid",
        "accumulation",
        "aggregate",
        "commodity",
        "consumptionTier",
        "cpp",
        "currency",
        "flowDirection",
        "macroPeriod",
        "measurementKind",
        "measuringPeriod",
        "multiplier",
        "phases",
        "tou",
        "unit",
        "argument",
        "interharmonic",
        "names"
    })
    public static class ReadingType
        extends com.sixthc.cim.createServiceOrders.ReadingType
    {

        @XmlElement(name = "mRID")
        protected String mrid;
        @XmlElement(required = true)
        protected String accumulation;
        @XmlElement(required = true)
        protected String aggregate;
        @XmlElement(required = true)
        protected String commodity;
        @XmlElement(required = true)
        protected BigInteger consumptionTier;
        @XmlElement(required = true)
        protected BigInteger cpp;
        @XmlElement(required = true)
        protected String currency;
        @XmlElement(required = true)
        protected String flowDirection;
        @XmlElement(required = true)
        protected String macroPeriod;
        @XmlElement(required = true)
        protected String measurementKind;
        @XmlElement(required = true)
        protected String measuringPeriod;
        @XmlElement(required = true)
        protected String multiplier;
        @XmlElement(required = true)
        protected String phases;
        @XmlElement(required = true)
        protected BigInteger tou;
        @XmlElement(required = true)
        protected String unit;
        @XmlElement(required = true)
        protected RationalNumber argument;
        @XmlElement(required = true)
        protected ReadingInterharmonic interharmonic;
        @XmlElement(name = "Names", required = true)
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
         * Gets the value of the accumulation property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAccumulation() {
            return accumulation;
        }

        /**
         * Sets the value of the accumulation property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAccumulation(String value) {
            this.accumulation = value;
        }

        /**
         * Gets the value of the aggregate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAggregate() {
            return aggregate;
        }

        /**
         * Sets the value of the aggregate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAggregate(String value) {
            this.aggregate = value;
        }

        /**
         * Gets the value of the commodity property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCommodity() {
            return commodity;
        }

        /**
         * Sets the value of the commodity property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCommodity(String value) {
            this.commodity = value;
        }

        /**
         * Gets the value of the consumptionTier property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getConsumptionTier() {
            return consumptionTier;
        }

        /**
         * Sets the value of the consumptionTier property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setConsumptionTier(BigInteger value) {
            this.consumptionTier = value;
        }

        /**
         * Gets the value of the cpp property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getCpp() {
            return cpp;
        }

        /**
         * Sets the value of the cpp property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setCpp(BigInteger value) {
            this.cpp = value;
        }

        /**
         * Gets the value of the currency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * Sets the value of the currency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrency(String value) {
            this.currency = value;
        }

        /**
         * Gets the value of the flowDirection property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlowDirection() {
            return flowDirection;
        }

        /**
         * Sets the value of the flowDirection property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlowDirection(String value) {
            this.flowDirection = value;
        }

        /**
         * Gets the value of the macroPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMacroPeriod() {
            return macroPeriod;
        }

        /**
         * Sets the value of the macroPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMacroPeriod(String value) {
            this.macroPeriod = value;
        }

        /**
         * Gets the value of the measurementKind property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeasurementKind() {
            return measurementKind;
        }

        /**
         * Sets the value of the measurementKind property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeasurementKind(String value) {
            this.measurementKind = value;
        }

        /**
         * Gets the value of the measuringPeriod property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMeasuringPeriod() {
            return measuringPeriod;
        }

        /**
         * Sets the value of the measuringPeriod property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMeasuringPeriod(String value) {
            this.measuringPeriod = value;
        }

        /**
         * Gets the value of the multiplier property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMultiplier() {
            return multiplier;
        }

        /**
         * Sets the value of the multiplier property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMultiplier(String value) {
            this.multiplier = value;
        }

        /**
         * Gets the value of the phases property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPhases() {
            return phases;
        }

        /**
         * Sets the value of the phases property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPhases(String value) {
            this.phases = value;
        }

        /**
         * Gets the value of the tou property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTou() {
            return tou;
        }

        /**
         * Sets the value of the tou property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTou(BigInteger value) {
            this.tou = value;
        }

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            return unit;
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
            this.unit = value;
        }

        /**
         * Gets the value of the argument property.
         * 
         * @return
         *     possible object is
         *     {@link RationalNumber }
         *     
         */
        public RationalNumber getArgument() {
            return argument;
        }

        /**
         * Sets the value of the argument property.
         * 
         * @param value
         *     allowed object is
         *     {@link RationalNumber }
         *     
         */
        public void setArgument(RationalNumber value) {
            this.argument = value;
        }

        /**
         * Gets the value of the interharmonic property.
         * 
         * @return
         *     possible object is
         *     {@link ReadingInterharmonic }
         *     
         */
        public ReadingInterharmonic getInterharmonic() {
            return interharmonic;
        }

        /**
         * Sets the value of the interharmonic property.
         * 
         * @param value
         *     allowed object is
         *     {@link ReadingInterharmonic }
         *     
         */
        public void setInterharmonic(ReadingInterharmonic value) {
            this.interharmonic = value;
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


package com.sixthc.cim.createMaintenanceOrders;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Asset used to perform work
 * 
 * <p>Java class for WorkAsset complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkAsset">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="critical" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastCalibrationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="odometerReadDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="odometerReading" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}Length" minOccurs="0"/>
 *         &lt;element name="usageKind" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}VehicleUsageKind" minOccurs="0"/>
 *         &lt;element name="utcNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Location" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}WorkLocation" minOccurs="0"/>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Procedures" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="instruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="kind" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}ProcedureKind" minOccurs="0"/>
 *                   &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Measurements" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="measurementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="phases" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}PhaseCode" minOccurs="0"/>
 *                             &lt;element name="unitMultiplier" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitMultiplier" minOccurs="0"/>
 *                             &lt;element name="unitSymbol" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitSymbol" minOccurs="0"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkAsset", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", propOrder = {
    "mrid",
    "critical",
    "lastCalibrationDate",
    "odometerReadDateTime",
    "odometerReading",
    "usageKind",
    "utcNumber",
    "location",
    "names",
    "procedures"
})
public class WorkAsset {

    @XmlElement(name = "mRID")
    protected String mrid;
    protected boolean critical;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastCalibrationDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar odometerReadDateTime;
    protected Float odometerReading;
    protected VehicleUsageKind usageKind;
    @XmlElement(required = true)
    protected String utcNumber;
    @XmlElement(name = "Location")
    protected WorkLocation2 location;
    @XmlElement(name = "Names")
    protected List<Name2> names;
    @XmlElement(name = "Procedures")
    protected List<WorkAsset.Procedures> procedures;

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
     * Gets the value of the critical property.
     * 
     */
    public boolean isCritical() {
        return critical;
    }

    /**
     * Sets the value of the critical property.
     * 
     */
    public void setCritical(boolean value) {
        this.critical = value;
    }

    /**
     * Gets the value of the lastCalibrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastCalibrationDate() {
        return lastCalibrationDate;
    }

    /**
     * Sets the value of the lastCalibrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastCalibrationDate(XMLGregorianCalendar value) {
        this.lastCalibrationDate = value;
    }

    /**
     * Gets the value of the odometerReadDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOdometerReadDateTime() {
        return odometerReadDateTime;
    }

    /**
     * Sets the value of the odometerReadDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOdometerReadDateTime(XMLGregorianCalendar value) {
        this.odometerReadDateTime = value;
    }

    /**
     * Gets the value of the odometerReading property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getOdometerReading() {
        return odometerReading;
    }

    /**
     * Sets the value of the odometerReading property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setOdometerReading(Float value) {
        this.odometerReading = value;
    }

    /**
     * Gets the value of the usageKind property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleUsageKind }
     *     
     */
    public VehicleUsageKind getUsageKind() {
        return usageKind;
    }

    /**
     * Sets the value of the usageKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleUsageKind }
     *     
     */
    public void setUsageKind(VehicleUsageKind value) {
        this.usageKind = value;
    }

    /**
     * Gets the value of the utcNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtcNumber() {
        return utcNumber;
    }

    /**
     * Sets the value of the utcNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtcNumber(String value) {
        this.utcNumber = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link WorkLocation2 }
     *     
     */
    public WorkLocation2 getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkLocation2 }
     *     
     */
    public void setLocation(WorkLocation2 value) {
        this.location = value;
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
     * Gets the value of the procedures property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procedures property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcedures().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkAsset.Procedures }
     * 
     * 
     */
    public List<WorkAsset.Procedures> getProcedures() {
        if (procedures == null) {
            procedures = new ArrayList<WorkAsset.Procedures>();
        }
        return this.procedures;
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
     *         &lt;element name="instruction" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="kind" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}ProcedureKind" minOccurs="0"/>
     *         &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Measurements" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="measurementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="phases" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}PhaseCode" minOccurs="0"/>
     *                   &lt;element name="unitMultiplier" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitMultiplier" minOccurs="0"/>
     *                   &lt;element name="unitSymbol" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitSymbol" minOccurs="0"/>
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
        "instruction",
        "kind",
        "sequenceNumber",
        "measurements"
    })
    public static class Procedures {

        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", required = true)
        protected String instruction;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        protected ProcedureKind kind;
        @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        protected String sequenceNumber;
        @XmlElement(name = "Measurements", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
        protected List<WorkAsset.Procedures.Measurements> measurements;

        /**
         * Gets the value of the instruction property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getInstruction() {
            return instruction;
        }

        /**
         * Sets the value of the instruction property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setInstruction(String value) {
            this.instruction = value;
        }

        /**
         * Gets the value of the kind property.
         * 
         * @return
         *     possible object is
         *     {@link ProcedureKind }
         *     
         */
        public ProcedureKind getKind() {
            return kind;
        }

        /**
         * Sets the value of the kind property.
         * 
         * @param value
         *     allowed object is
         *     {@link ProcedureKind }
         *     
         */
        public void setKind(ProcedureKind value) {
            this.kind = value;
        }

        /**
         * Gets the value of the sequenceNumber property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSequenceNumber() {
            return sequenceNumber;
        }

        /**
         * Sets the value of the sequenceNumber property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSequenceNumber(String value) {
            this.sequenceNumber = value;
        }

        /**
         * Gets the value of the measurements property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the measurements property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMeasurements().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link WorkAsset.Procedures.Measurements }
         * 
         * 
         */
        public List<WorkAsset.Procedures.Measurements> getMeasurements() {
            if (measurements == null) {
                measurements = new ArrayList<WorkAsset.Procedures.Measurements>();
            }
            return this.measurements;
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
         *         &lt;element name="measurementType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="phases" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}PhaseCode" minOccurs="0"/>
         *         &lt;element name="unitMultiplier" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitMultiplier" minOccurs="0"/>
         *         &lt;element name="unitSymbol" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}UnitSymbol" minOccurs="0"/>
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
            "measurementType",
            "phases",
            "unitMultiplier",
            "unitSymbol"
        })
        public static class Measurements {

            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String measurementType;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected PhaseCode phases;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String unitMultiplier;
            @XmlElement(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
            protected String unitSymbol;

            /**
             * Gets the value of the measurementType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMeasurementType() {
                return measurementType;
            }

            /**
             * Sets the value of the measurementType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMeasurementType(String value) {
                this.measurementType = value;
            }

            /**
             * Gets the value of the phases property.
             * 
             * @return
             *     possible object is
             *     {@link PhaseCode }
             *     
             */
            public PhaseCode getPhases() {
                return phases;
            }

            /**
             * Sets the value of the phases property.
             * 
             * @param value
             *     allowed object is
             *     {@link PhaseCode }
             *     
             */
            public void setPhases(PhaseCode value) {
                this.phases = value;
            }

            /**
             * Gets the value of the unitMultiplier property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnitMultiplier() {
                return unitMultiplier;
            }

            /**
             * Sets the value of the unitMultiplier property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnitMultiplier(String value) {
                this.unitMultiplier = value;
            }

            /**
             * Gets the value of the unitSymbol property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUnitSymbol() {
                return unitSymbol;
            }

            /**
             * Sets the value of the unitSymbol property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUnitSymbol(String value) {
                this.unitSymbol = value;
            }

        }

    }

}

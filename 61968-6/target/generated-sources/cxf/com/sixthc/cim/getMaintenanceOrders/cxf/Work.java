
package com.sixthc.cim.getMaintenanceOrders.cxf;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Document used to request, initiate, track and record work.
 * 
 * <p>Java class for Work complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Work">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kind" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}WorkKind" minOccurs="0"/>
 *         &lt;element name="statusKind" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}WorkStatusKind" minOccurs="0"/>
 *         &lt;element name="priority" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="justification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Work", propOrder = {
    "kind",
    "statusKind",
    "priority"
})
public class Work {

    protected WorkKind kind;
    protected WorkStatusKind statusKind;
    protected Work.Priority priority;

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link WorkKind }
     *     
     */
    public WorkKind getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkKind }
     *     
     */
    public void setKind(WorkKind value) {
        this.kind = value;
    }

    /**
     * Gets the value of the statusKind property.
     * 
     * @return
     *     possible object is
     *     {@link WorkStatusKind }
     *     
     */
    public WorkStatusKind getStatusKind() {
        return statusKind;
    }

    /**
     * Sets the value of the statusKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkStatusKind }
     *     
     */
    public void setStatusKind(WorkStatusKind value) {
        this.statusKind = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link Work.Priority }
     *     
     */
    public Work.Priority getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link Work.Priority }
     *     
     */
    public void setPriority(Work.Priority value) {
        this.priority = value;
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
     *         &lt;element name="justification" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="rank" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "justification",
        "rank",
        "type"
    })
    public static class Priority {

        protected String justification;
        protected BigInteger rank;
        protected String type;

        /**
         * Gets the value of the justification property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getJustification() {
            return justification;
        }

        /**
         * Sets the value of the justification property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setJustification(String value) {
            this.justification = value;
        }

        /**
         * Gets the value of the rank property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getRank() {
            return rank;
        }

        /**
         * Sets the value of the rank property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setRank(BigInteger value) {
            this.rank = value;
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

    }

}

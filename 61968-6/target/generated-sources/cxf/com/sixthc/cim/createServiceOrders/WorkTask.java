
package com.sixthc.cim.createServiceOrders;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WorkTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://iec.ch/TC57/2015/ServiceOrders#}mRID" minOccurs="0"/>
 *         &lt;element name="crewETA" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="instruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusKind" type="{http://iec.ch/TC57/2015/ServiceOrders#}WorkStatusKind"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="taskKind" type="{http://iec.ch/TC57/2015/ServiceOrders#}WorkTaskKind"/>
 *         &lt;element name="Assets" type="{http://iec.ch/TC57/2015/ServiceOrders#}Asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Crews" type="{http://iec.ch/TC57/2015/ServiceOrders#}Crew" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Names" type="{http://iec.ch/TC57/2015/ServiceOrders#}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OldAsset" type="{http://iec.ch/TC57/2015/ServiceOrders#}Asset" minOccurs="0"/>
 *         &lt;element name="TimeSchedules" type="{http://iec.ch/TC57/2015/ServiceOrders#}WorkTimeSchedule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UsagePoint" type="{http://iec.ch/TC57/2015/ServiceOrders#}UsagePoint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkTask", propOrder = {
    "mrid",
    "crewETA",
    "instruction",
    "statusKind",
    "subject",
    "taskKind",
    "assets",
    "crews",
    "names",
    "oldAsset",
    "timeSchedules",
    "usagePoint"
})
public class WorkTask {

    @XmlElement(name = "mRID")
    protected String mrid;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar crewETA;
    protected String instruction;
    @XmlElement(required = true)
    protected WorkStatusKind2 statusKind;
    @XmlElement(required = true)
    protected String subject;
    @XmlElement(required = true)
    protected WorkTaskKind taskKind;
    @XmlElement(name = "Assets")
    protected List<Asset2> assets;
    @XmlElement(name = "Crews")
    protected List<Crew2> crews;
    @XmlElement(name = "Names")
    protected List<Name2> names;
    @XmlElement(name = "OldAsset")
    protected Asset2 oldAsset;
    @XmlElement(name = "TimeSchedules")
    protected List<WorkTimeSchedule2> timeSchedules;
    @XmlElement(name = "UsagePoint")
    protected UsagePoint usagePoint;

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
     * Gets the value of the crewETA property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCrewETA() {
        return crewETA;
    }

    /**
     * Sets the value of the crewETA property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCrewETA(XMLGregorianCalendar value) {
        this.crewETA = value;
    }

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
     * Gets the value of the statusKind property.
     * 
     * @return
     *     possible object is
     *     {@link WorkStatusKind2 }
     *     
     */
    public WorkStatusKind2 getStatusKind() {
        return statusKind;
    }

    /**
     * Sets the value of the statusKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkStatusKind2 }
     *     
     */
    public void setStatusKind(WorkStatusKind2 value) {
        this.statusKind = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the taskKind property.
     * 
     * @return
     *     possible object is
     *     {@link WorkTaskKind }
     *     
     */
    public WorkTaskKind getTaskKind() {
        return taskKind;
    }

    /**
     * Sets the value of the taskKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkTaskKind }
     *     
     */
    public void setTaskKind(WorkTaskKind value) {
        this.taskKind = value;
    }

    /**
     * Gets the value of the assets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Asset2 }
     * 
     * 
     */
    public List<Asset2> getAssets() {
        if (assets == null) {
            assets = new ArrayList<Asset2>();
        }
        return this.assets;
    }

    /**
     * Gets the value of the crews property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crews property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrews().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Crew2 }
     * 
     * 
     */
    public List<Crew2> getCrews() {
        if (crews == null) {
            crews = new ArrayList<Crew2>();
        }
        return this.crews;
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
     * Gets the value of the oldAsset property.
     * 
     * @return
     *     possible object is
     *     {@link Asset2 }
     *     
     */
    public Asset2 getOldAsset() {
        return oldAsset;
    }

    /**
     * Sets the value of the oldAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link Asset2 }
     *     
     */
    public void setOldAsset(Asset2 value) {
        this.oldAsset = value;
    }

    /**
     * Gets the value of the timeSchedules property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeSchedules property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeSchedules().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkTimeSchedule2 }
     * 
     * 
     */
    public List<WorkTimeSchedule2> getTimeSchedules() {
        if (timeSchedules == null) {
            timeSchedules = new ArrayList<WorkTimeSchedule2>();
        }
        return this.timeSchedules;
    }

    /**
     * Gets the value of the usagePoint property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePoint }
     *     
     */
    public UsagePoint getUsagePoint() {
        return usagePoint;
    }

    /**
     * Sets the value of the usagePoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePoint }
     *     
     */
    public void setUsagePoint(UsagePoint value) {
        this.usagePoint = value;
    }

}

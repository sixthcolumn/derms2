
package com.sixthc.cim.getMaintenanceOrders.cxf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetMaintenanceOrders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetMaintenanceOrders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Asset" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}Asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Crew" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}Crew" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="MaintenanceOrder" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}MaintenanceOrder" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OldAsset" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}Asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Organization" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}Organisation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TimeSchedule" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}WorkTimeSchedule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Work" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}Work" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WorkLocation" type="{http://iec.ch/TC57/2015/GetMaintenanceOrders#}WorkLocation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetMaintenanceOrders", propOrder = {
    "asset",
    "crew",
    "maintenanceOrder",
    "oldAsset",
    "organization",
    "timeSchedule",
    "work",
    "workLocation"
})
public class GetMaintenanceOrders {

    @XmlElement(name = "Asset")
    protected List<Asset> asset;
    @XmlElement(name = "Crew")
    protected List<Crew> crew;
    @XmlElement(name = "MaintenanceOrder")
    protected List<MaintenanceOrder> maintenanceOrder;
    @XmlElement(name = "OldAsset")
    protected List<Asset> oldAsset;
    @XmlElement(name = "Organization")
    protected List<Organisation> organization;
    @XmlElement(name = "TimeSchedule")
    protected List<WorkTimeSchedule> timeSchedule;
    @XmlElement(name = "Work")
    protected List<Work> work;
    @XmlElement(name = "WorkLocation")
    protected List<WorkLocation> workLocation;

    /**
     * Gets the value of the asset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Asset }
     * 
     * 
     */
    public List<Asset> getAsset() {
        if (asset == null) {
            asset = new ArrayList<Asset>();
        }
        return this.asset;
    }

    /**
     * Gets the value of the crew property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crew property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrew().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Crew }
     * 
     * 
     */
    public List<Crew> getCrew() {
        if (crew == null) {
            crew = new ArrayList<Crew>();
        }
        return this.crew;
    }

    /**
     * Gets the value of the maintenanceOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the maintenanceOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMaintenanceOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MaintenanceOrder }
     * 
     * 
     */
    public List<MaintenanceOrder> getMaintenanceOrder() {
        if (maintenanceOrder == null) {
            maintenanceOrder = new ArrayList<MaintenanceOrder>();
        }
        return this.maintenanceOrder;
    }

    /**
     * Gets the value of the oldAsset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oldAsset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOldAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Asset }
     * 
     * 
     */
    public List<Asset> getOldAsset() {
        if (oldAsset == null) {
            oldAsset = new ArrayList<Asset>();
        }
        return this.oldAsset;
    }

    /**
     * Gets the value of the organization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Organisation }
     * 
     * 
     */
    public List<Organisation> getOrganization() {
        if (organization == null) {
            organization = new ArrayList<Organisation>();
        }
        return this.organization;
    }

    /**
     * Gets the value of the timeSchedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeSchedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkTimeSchedule }
     * 
     * 
     */
    public List<WorkTimeSchedule> getTimeSchedule() {
        if (timeSchedule == null) {
            timeSchedule = new ArrayList<WorkTimeSchedule>();
        }
        return this.timeSchedule;
    }

    /**
     * Gets the value of the work property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the work property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Work }
     * 
     * 
     */
    public List<Work> getWork() {
        if (work == null) {
            work = new ArrayList<Work>();
        }
        return this.work;
    }

    /**
     * Gets the value of the workLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkLocation }
     * 
     * 
     */
    public List<WorkLocation> getWorkLocation() {
        if (workLocation == null) {
            workLocation = new ArrayList<WorkLocation>();
        }
        return this.workLocation;
    }

}


package com.sixthc.cim.getServiceOrders.cxf;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetServiceOrders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceOrders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Asset" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Crew" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Crew" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Customer" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Customer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OldAsset" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Asset" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ServiceCategory" type="{http://iec.ch/TC57/2015/GetServiceOrders#}ServiceCategory" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ServiceOrder" type="{http://iec.ch/TC57/2015/GetServiceOrders#}ServiceOrder" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TimeSchedule" type="{http://iec.ch/TC57/2015/GetServiceOrders#}WorkTimeSchedule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UsagePoint" type="{http://iec.ch/TC57/2015/GetServiceOrders#}UsagePoint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="UsagePointLocation" type="{http://iec.ch/TC57/2015/GetServiceOrders#}UsagePointLocation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Work" type="{http://iec.ch/TC57/2015/GetServiceOrders#}Work" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WorkLocation" type="{http://iec.ch/TC57/2015/GetServiceOrders#}WorkLocation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceOrders", propOrder = {
    "asset",
    "crew",
    "customer",
    "oldAsset",
    "serviceCategory",
    "serviceOrder",
    "timeSchedule",
    "usagePoint",
    "usagePointLocation",
    "work",
    "workLocation"
})
public class GetServiceOrders {

    @XmlElement(name = "Asset")
    protected List<Asset> asset;
    @XmlElement(name = "Crew")
    protected List<Crew> crew;
    @XmlElement(name = "Customer")
    protected List<Customer> customer;
    @XmlElement(name = "OldAsset")
    protected List<Asset> oldAsset;
    @XmlElement(name = "ServiceCategory")
    protected List<ServiceCategory> serviceCategory;
    @XmlElement(name = "ServiceOrder")
    protected List<ServiceOrder> serviceOrder;
    @XmlElement(name = "TimeSchedule")
    protected List<WorkTimeSchedule> timeSchedule;
    @XmlElement(name = "UsagePoint")
    protected List<UsagePoint> usagePoint;
    @XmlElement(name = "UsagePointLocation")
    protected List<UsagePointLocation> usagePointLocation;
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
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customer }
     * 
     * 
     */
    public List<Customer> getCustomer() {
        if (customer == null) {
            customer = new ArrayList<Customer>();
        }
        return this.customer;
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
     * Gets the value of the serviceCategory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceCategory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceCategory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceCategory }
     * 
     * 
     */
    public List<ServiceCategory> getServiceCategory() {
        if (serviceCategory == null) {
            serviceCategory = new ArrayList<ServiceCategory>();
        }
        return this.serviceCategory;
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
     * Gets the value of the usagePoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usagePoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsagePoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsagePoint }
     * 
     * 
     */
    public List<UsagePoint> getUsagePoint() {
        if (usagePoint == null) {
            usagePoint = new ArrayList<UsagePoint>();
        }
        return this.usagePoint;
    }

    /**
     * Gets the value of the usagePointLocation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usagePointLocation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsagePointLocation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsagePointLocation }
     * 
     * 
     */
    public List<UsagePointLocation> getUsagePointLocation() {
        if (usagePointLocation == null) {
            usagePointLocation = new ArrayList<UsagePointLocation>();
        }
        return this.usagePointLocation;
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


package com.sixthc.cim.deleteMaintenanceOrders;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * One or more instances of a Maintenance Order.
 * 			
 * 
 * <p>Java class for MaintenanceOrders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MaintenanceOrders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaintenanceOrder" type="{http://iec.ch/TC57/2015/MaintenanceOrders#}MaintenanceOrder" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaintenanceOrders", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", propOrder = {
    "maintenanceOrder"
})
public class MaintenanceOrders2 {

    @XmlElement(name = "MaintenanceOrder", required = true)
    protected List<MaintenanceOrder2> maintenanceOrder;

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
     * {@link MaintenanceOrder2 }
     * 
     * 
     */
    public List<MaintenanceOrder2> getMaintenanceOrder() {
        if (maintenanceOrder == null) {
            maintenanceOrder = new ArrayList<MaintenanceOrder2>();
        }
        return this.maintenanceOrder;
    }

}

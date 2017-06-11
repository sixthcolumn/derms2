
package com.sixthc.cim.deleteMaintenanceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkTaskKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkTaskKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="exchange"/>
 *     &lt;enumeration value="install"/>
 *     &lt;enumeration value="investigate"/>
 *     &lt;enumeration value="remove"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkTaskKind", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
@XmlEnum
public enum WorkTaskKind {


    /**
     * Work task deals with exchange of assets.
     * 					
     * 
     */
    @XmlEnumValue("exchange")
    EXCHANGE("exchange"),

    /**
     * Work task deals with installation of assets.
     * 					
     * 
     */
    @XmlEnumValue("install")
    INSTALL("install"),

    /**
     * Work task deals with investigation about assets.
     * 					
     * 
     */
    @XmlEnumValue("investigate")
    INVESTIGATE("investigate"),

    /**
     * Work task deals with removal of assets.
     * 					
     * 
     */
    @XmlEnumValue("remove")
    REMOVE("remove");
    private final String value;

    WorkTaskKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkTaskKind fromValue(String v) {
        for (WorkTaskKind c: WorkTaskKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

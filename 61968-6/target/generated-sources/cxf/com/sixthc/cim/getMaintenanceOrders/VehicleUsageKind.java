
package com.sixthc.cim.getMaintenanceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleUsageKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VehicleUsageKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="contractor"/>
 *     &lt;enumeration value="crew"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="user"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VehicleUsageKind", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
@XmlEnum
public enum VehicleUsageKind {

    @XmlEnumValue("contractor")
    CONTRACTOR("contractor"),
    @XmlEnumValue("crew")
    CREW("crew"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("user")
    USER("user");
    private final String value;

    VehicleUsageKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VehicleUsageKind fromValue(String v) {
        for (VehicleUsageKind c: VehicleUsageKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

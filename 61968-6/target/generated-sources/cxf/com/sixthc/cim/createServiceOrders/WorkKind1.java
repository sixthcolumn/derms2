
package com.sixthc.cim.createServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="connect"/>
 *     &lt;enumeration value="construction"/>
 *     &lt;enumeration value="disconnect"/>
 *     &lt;enumeration value="inspection"/>
 *     &lt;enumeration value="maintenance"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="reconnect"/>
 *     &lt;enumeration value="repair"/>
 *     &lt;enumeration value="service"/>
 *     &lt;enumeration value="test"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkKind")
@XmlEnum
public enum WorkKind1 {


    /**
     * Connect work.
     * 
     */
    @XmlEnumValue("connect")
    CONNECT("connect"),

    /**
     * Construction work.
     * 
     */
    @XmlEnumValue("construction")
    CONSTRUCTION("construction"),

    /**
     * Disconnect work.
     * 
     */
    @XmlEnumValue("disconnect")
    DISCONNECT("disconnect"),

    /**
     * Inspection work.
     * 
     */
    @XmlEnumValue("inspection")
    INSPECTION("inspection"),

    /**
     * Maintenance work.
     * 
     */
    @XmlEnumValue("maintenance")
    MAINTENANCE("maintenance"),

    /**
     * Other kind of work.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * (use 'connect' instead) Reconnect
     * 						work.
     * 					
     * 
     */
    @XmlEnumValue("reconnect")
    RECONNECT("reconnect"),

    /**
     * Repair work.
     * 
     */
    @XmlEnumValue("repair")
    REPAIR("repair"),

    /**
     * Service work.
     * 
     */
    @XmlEnumValue("service")
    SERVICE("service"),

    /**
     * Test work.
     * 
     */
    @XmlEnumValue("test")
    TEST("test");
    private final String value;

    WorkKind1(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkKind1 fromValue(String v) {
        for (WorkKind1 c: WorkKind1 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

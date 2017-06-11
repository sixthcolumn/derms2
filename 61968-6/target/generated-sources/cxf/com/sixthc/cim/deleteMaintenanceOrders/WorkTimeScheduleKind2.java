
package com.sixthc.cim.deleteMaintenanceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkTimeScheduleKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkTimeScheduleKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="actual"/>
 *     &lt;enumeration value="earliest"/>
 *     &lt;enumeration value="estimate"/>
 *     &lt;enumeration value="latest"/>
 *     &lt;enumeration value="request"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkTimeScheduleKind", namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#")
@XmlEnum
public enum WorkTimeScheduleKind2 {


    /**
     * Actual work time schedule.
     * 
     */
    @XmlEnumValue("actual")
    ACTUAL("actual"),

    /**
     * Earliest work time schedule.
     * 
     */
    @XmlEnumValue("earliest")
    EARLIEST("earliest"),

    /**
     * Estimate work time schedule.
     * 
     */
    @XmlEnumValue("estimate")
    ESTIMATE("estimate"),

    /**
     * Latest work time schedule.
     * 
     */
    @XmlEnumValue("latest")
    LATEST("latest"),

    /**
     * Request work time schedule.
     * 
     */
    @XmlEnumValue("request")
    REQUEST("request");
    private final String value;

    WorkTimeScheduleKind2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkTimeScheduleKind2 fromValue(String v) {
        for (WorkTimeScheduleKind2 c: WorkTimeScheduleKind2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

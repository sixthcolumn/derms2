
package com.sixthc.cim.getServiceOrders.cxf;

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
@XmlType(name = "WorkTimeScheduleKind")
@XmlEnum
public enum WorkTimeScheduleKind {


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

    WorkTimeScheduleKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkTimeScheduleKind fromValue(String v) {
        for (WorkTimeScheduleKind c: WorkTimeScheduleKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

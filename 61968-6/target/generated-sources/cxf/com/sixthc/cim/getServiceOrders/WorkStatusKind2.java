
package com.sixthc.cim.getServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkStatusKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WorkStatusKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="approved"/>
 *     &lt;enumeration value="cancelled"/>
 *     &lt;enumeration value="closed"/>
 *     &lt;enumeration value="completed"/>
 *     &lt;enumeration value="dispatched"/>
 *     &lt;enumeration value="enroute"/>
 *     &lt;enumeration value="inProgress"/>
 *     &lt;enumeration value="onSite"/>
 *     &lt;enumeration value="scheduled"/>
 *     &lt;enumeration value="waitingOnApproval"/>
 *     &lt;enumeration value="waitingOnMaterial"/>
 *     &lt;enumeration value="waitingToBeScheduled"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WorkStatusKind")
@XmlEnum
public enum WorkStatusKind2 {


    /**
     * Work has been approved.
     * 
     */
    @XmlEnumValue("approved")
    APPROVED("approved"),

    /**
     * Work has been canceled.
     * 
     */
    @XmlEnumValue("cancelled")
    CANCELLED("cancelled"),

    /**
     * Work has been closed (typically by a person
     * 						responsible for work management) and is ready for billing.
     * 					
     * 
     */
    @XmlEnumValue("closed")
    CLOSED("closed"),

    /**
     * Work has been completed, i.e., crew can leave the
     * 						work location and is available for another work.
     * 					
     * 
     */
    @XmlEnumValue("completed")
    COMPLETED("completed"),

    /**
     * Crew has been dispatched.
     * 
     */
    @XmlEnumValue("dispatched")
    DISPATCHED("dispatched"),

    /**
     * Crew is 'en route'.
     * 
     */
    @XmlEnumValue("enroute")
    ENROUTE("enroute"),

    /**
     * Work is in progress.
     * 
     */
    @XmlEnumValue("inProgress")
    IN_PROGRESS("inProgress"),

    /**
     * Crew is on the site.
     * 
     */
    @XmlEnumValue("onSite")
    ON_SITE("onSite"),

    /**
     * Work has been scheduled.
     * 
     */
    @XmlEnumValue("scheduled")
    SCHEDULED("scheduled"),

    /**
     * Work approval is pending.
     * 
     */
    @XmlEnumValue("waitingOnApproval")
    WAITING_ON_APPROVAL("waitingOnApproval"),

    /**
     * Work has been waiting on material.
     * 					
     * 
     */
    @XmlEnumValue("waitingOnMaterial")
    WAITING_ON_MATERIAL("waitingOnMaterial"),

    /**
     * Work needs to be scheduled.
     * 
     */
    @XmlEnumValue("waitingToBeScheduled")
    WAITING_TO_BE_SCHEDULED("waitingToBeScheduled");
    private final String value;

    WorkStatusKind2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WorkStatusKind2 fromValue(String v) {
        for (WorkStatusKind2 c: WorkStatusKind2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}


package com.sixthc.cim.createServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReadingReasonKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReadingReasonKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="billing"/>
 *     &lt;enumeration value="demandReset"/>
 *     &lt;enumeration value="inquiry"/>
 *     &lt;enumeration value="installation"/>
 *     &lt;enumeration value="loadManagement"/>
 *     &lt;enumeration value="loadResearch"/>
 *     &lt;enumeration value="moveIn"/>
 *     &lt;enumeration value="moveOut"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="removal"/>
 *     &lt;enumeration value="serviceConnect"/>
 *     &lt;enumeration value="serviceDisconnect"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReadingReasonKind")
@XmlEnum
public enum ReadingReasonKind {


    /**
     * Reading(s) taken or to be taken in response to a
     * 						billing-related inquiry by a customer or other party. A variant of
     * 						'inquiry'.
     * 
     */
    @XmlEnumValue("billing")
    BILLING("billing"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with the resetting of one or more demand registers in a meter.
     * 					
     * 
     */
    @XmlEnumValue("demandReset")
    DEMAND_RESET("demandReset"),

    /**
     * Reading(s) taken or to be taken in response to an
     * 						inquiry by a customer or other party.
     * 
     */
    @XmlEnumValue("inquiry")
    INQUIRY("inquiry"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with installation of a meter.
     * 
     */
    @XmlEnumValue("installation")
    INSTALLATION("installation"),

    /**
     * Reading(s) taken or to be taken to support
     * 						management of loads on distribution networks or devices.
     * 					
     * 
     */
    @XmlEnumValue("loadManagement")
    LOAD_MANAGEMENT("loadManagement"),

    /**
     * Reading(s) taken or to be taken to support
     * 						research and analysis of loads on distribution networks or
     * 						devices.
     * 
     */
    @XmlEnumValue("loadResearch")
    LOAD_RESEARCH("loadResearch"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with a customer move-in event.
     * 
     */
    @XmlEnumValue("moveIn")
    MOVE_IN("moveIn"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with a customer move-out event.
     * 
     */
    @XmlEnumValue("moveOut")
    MOVE_OUT("moveOut"),

    /**
     * Reading(s) taken or to be taken for some other
     * 						reason or purpose.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with removal of a meter.
     * 
     */
    @XmlEnumValue("removal")
    REMOVAL("removal"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with a connection or re-connection of service.
     * 
     */
    @XmlEnumValue("serviceConnect")
    SERVICE_CONNECT("serviceConnect"),

    /**
     * Reading(s) taken or to be taken in conjunction
     * 						with a disconnection of service.
     * 
     */
    @XmlEnumValue("serviceDisconnect")
    SERVICE_DISCONNECT("serviceDisconnect");
    private final String value;

    ReadingReasonKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReadingReasonKind fromValue(String v) {
        for (ReadingReasonKind c: ReadingReasonKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

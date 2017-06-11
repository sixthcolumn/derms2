
package com.sixthc.cim.getServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="electricity"/>
 *     &lt;enumeration value="gas"/>
 *     &lt;enumeration value="heat"/>
 *     &lt;enumeration value="internet"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="rates"/>
 *     &lt;enumeration value="refuse"/>
 *     &lt;enumeration value="sewerage"/>
 *     &lt;enumeration value="time"/>
 *     &lt;enumeration value="tvLicence"/>
 *     &lt;enumeration value="water"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceKind")
@XmlEnum
public enum ServiceKind {


    /**
     * Electricity service.
     * 
     */
    @XmlEnumValue("electricity")
    ELECTRICITY("electricity"),

    /**
     * Gas service.
     * 
     */
    @XmlEnumValue("gas")
    GAS("gas"),

    /**
     * Heat service.
     * 
     */
    @XmlEnumValue("heat")
    HEAT("heat"),

    /**
     * Internet service.
     * 
     */
    @XmlEnumValue("internet")
    INTERNET("internet"),

    /**
     * Other kind of service.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Rates (e.g. tax, charge, toll, duty, tariff,
     * 						etc.) service.
     * 
     */
    @XmlEnumValue("rates")
    RATES("rates"),

    /**
     * Refuse (waster) service.
     * 
     */
    @XmlEnumValue("refuse")
    REFUSE("refuse"),

    /**
     * Sewerage service.
     * 
     */
    @XmlEnumValue("sewerage")
    SEWERAGE("sewerage"),

    /**
     * Time service.
     * 
     */
    @XmlEnumValue("time")
    TIME("time"),

    /**
     * TV license service.
     * 
     */
    @XmlEnumValue("tvLicence")
    TV_LICENCE("tvLicence"),

    /**
     * Water service.
     * 
     */
    @XmlEnumValue("water")
    WATER("water");
    private final String value;

    ServiceKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceKind fromValue(String v) {
        for (ServiceKind c: ServiceKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

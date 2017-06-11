
package com.sixthc.cim.createServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeterMultiplierKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MeterMultiplierKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ctRatio"/>
 *     &lt;enumeration value="kE"/>
 *     &lt;enumeration value="kH"/>
 *     &lt;enumeration value="kR"/>
 *     &lt;enumeration value="ptRatio"/>
 *     &lt;enumeration value="transformerRatio"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MeterMultiplierKind")
@XmlEnum
public enum MeterMultiplierKind {


    /**
     * Current transformer ratio used to convert
     * 						associated quantities to real measurements.
     * 
     */
    @XmlEnumValue("ctRatio")
    CT_RATIO("ctRatio"),

    /**
     * Test constant.
     * 
     */
    @XmlEnumValue("kE")
    K_E("kE"),

    /**
     * Meter kh (watthour) constant. The number of
     * 						watthours that must be applied to the meter to cause one disk
     * 						revolution for an electromechanical meter or the number of
     * 						watthours represented by one increment pulse for an electronic
     * 						meter.
     * 
     */
    @XmlEnumValue("kH")
    K_H("kH"),

    /**
     * Register multiplier. The number to multiply the
     * 						register reading by in order to get kWh.
     * 
     */
    @XmlEnumValue("kR")
    K_R("kR"),

    /**
     * Potential transformer ratio used to convert
     * 						associated quantities to real measurements.
     * 
     */
    @XmlEnumValue("ptRatio")
    PT_RATIO("ptRatio"),

    /**
     * Product of the CT ratio and PT ratio.
     * 					
     * 
     */
    @XmlEnumValue("transformerRatio")
    TRANSFORMER_RATIO("transformerRatio");
    private final String value;

    MeterMultiplierKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MeterMultiplierKind fromValue(String v) {
        for (MeterMultiplierKind c: MeterMultiplierKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

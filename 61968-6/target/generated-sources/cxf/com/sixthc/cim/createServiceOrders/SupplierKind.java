
package com.sixthc.cim.createServiceOrders;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SupplierKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SupplierKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="retailer"/>
 *     &lt;enumeration value="utility"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SupplierKind")
@XmlEnum
public enum SupplierKind {


    /**
     * Other kind of supplier.
     * 
     */
    @XmlEnumValue("other")
    OTHER("other"),

    /**
     * Entity that sells the service, but does not
     * 						deliver to the customer; applies to the deregulated markets.
     * 					
     * 
     */
    @XmlEnumValue("retailer")
    RETAILER("retailer"),

    /**
     * Entity that delivers the service to the customer.
     * 					
     * 
     */
    @XmlEnumValue("utility")
    UTILITY("utility");
    private final String value;

    SupplierKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SupplierKind fromValue(String v) {
        for (SupplierKind c: SupplierKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

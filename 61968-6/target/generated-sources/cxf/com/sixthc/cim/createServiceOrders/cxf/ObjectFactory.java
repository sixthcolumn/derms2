
package com.sixthc.cim.createServiceOrders.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sixthc.cim.createServiceOrders.cxf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "DeleteServiceOrders");
    private final static QName _ChangeServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "ChangeServiceOrders");
    private final static QName _CanceledServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "CanceledServiceOrders");
    private final static QName _ClosedServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "ClosedServiceOrders");
    private final static QName _CloseServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "CloseServiceOrders");
    private final static QName _DeletedServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "DeletedServiceOrders");
    private final static QName _ServiceOrdersFaultMessage_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "ServiceOrdersFaultMessage");
    private final static QName _CreateServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "CreateServiceOrders");
    private final static QName _ServiceOrdersResponseMessage_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "ServiceOrdersResponseMessage");
    private final static QName _ChangedServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "ChangedServiceOrders");
    private final static QName _CreatedServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "CreatedServiceOrders");
    private final static QName _CancelServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/ServiceOrdersMessage", "CancelServiceOrders");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sixthc.cim.createServiceOrders.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceOrdersResponseMessageType }
     * 
     */
    public ServiceOrdersResponseMessageType createServiceOrdersResponseMessageType() {
        return new ServiceOrdersResponseMessageType();
    }

    /**
     * Create an instance of {@link ServiceOrdersFaultMessageType }
     * 
     */
    public ServiceOrdersFaultMessageType createServiceOrdersFaultMessageType() {
        return new ServiceOrdersFaultMessageType();
    }

    /**
     * Create an instance of {@link ServiceOrdersPayloadType }
     * 
     */
    public ServiceOrdersPayloadType createServiceOrdersPayloadType() {
        return new ServiceOrdersPayloadType();
    }

    /**
     * Create an instance of {@link ServiceOrdersRequestMessageType }
     * 
     */
    public ServiceOrdersRequestMessageType createServiceOrdersRequestMessageType() {
        return new ServiceOrdersRequestMessageType();
    }

    /**
     * Create an instance of {@link ServiceOrdersEventMessageType }
     * 
     */
    public ServiceOrdersEventMessageType createServiceOrdersEventMessageType() {
        return new ServiceOrdersEventMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "DeleteServiceOrders")
    public JAXBElement<ServiceOrdersRequestMessageType> createDeleteServiceOrders(ServiceOrdersRequestMessageType value) {
        return new JAXBElement<ServiceOrdersRequestMessageType>(_DeleteServiceOrders_QNAME, ServiceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "ChangeServiceOrders")
    public JAXBElement<ServiceOrdersRequestMessageType> createChangeServiceOrders(ServiceOrdersRequestMessageType value) {
        return new JAXBElement<ServiceOrdersRequestMessageType>(_ChangeServiceOrders_QNAME, ServiceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "CanceledServiceOrders")
    public JAXBElement<ServiceOrdersEventMessageType> createCanceledServiceOrders(ServiceOrdersEventMessageType value) {
        return new JAXBElement<ServiceOrdersEventMessageType>(_CanceledServiceOrders_QNAME, ServiceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "ClosedServiceOrders")
    public JAXBElement<ServiceOrdersEventMessageType> createClosedServiceOrders(ServiceOrdersEventMessageType value) {
        return new JAXBElement<ServiceOrdersEventMessageType>(_ClosedServiceOrders_QNAME, ServiceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "CloseServiceOrders")
    public JAXBElement<ServiceOrdersRequestMessageType> createCloseServiceOrders(ServiceOrdersRequestMessageType value) {
        return new JAXBElement<ServiceOrdersRequestMessageType>(_CloseServiceOrders_QNAME, ServiceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "DeletedServiceOrders")
    public JAXBElement<ServiceOrdersEventMessageType> createDeletedServiceOrders(ServiceOrdersEventMessageType value) {
        return new JAXBElement<ServiceOrdersEventMessageType>(_DeletedServiceOrders_QNAME, ServiceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersFaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "ServiceOrdersFaultMessage")
    public JAXBElement<ServiceOrdersFaultMessageType> createServiceOrdersFaultMessage(ServiceOrdersFaultMessageType value) {
        return new JAXBElement<ServiceOrdersFaultMessageType>(_ServiceOrdersFaultMessage_QNAME, ServiceOrdersFaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "CreateServiceOrders")
    public JAXBElement<ServiceOrdersRequestMessageType> createCreateServiceOrders(ServiceOrdersRequestMessageType value) {
        return new JAXBElement<ServiceOrdersRequestMessageType>(_CreateServiceOrders_QNAME, ServiceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "ServiceOrdersResponseMessage")
    public JAXBElement<ServiceOrdersResponseMessageType> createServiceOrdersResponseMessage(ServiceOrdersResponseMessageType value) {
        return new JAXBElement<ServiceOrdersResponseMessageType>(_ServiceOrdersResponseMessage_QNAME, ServiceOrdersResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "ChangedServiceOrders")
    public JAXBElement<ServiceOrdersEventMessageType> createChangedServiceOrders(ServiceOrdersEventMessageType value) {
        return new JAXBElement<ServiceOrdersEventMessageType>(_ChangedServiceOrders_QNAME, ServiceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "CreatedServiceOrders")
    public JAXBElement<ServiceOrdersEventMessageType> createCreatedServiceOrders(ServiceOrdersEventMessageType value) {
        return new JAXBElement<ServiceOrdersEventMessageType>(_CreatedServiceOrders_QNAME, ServiceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/ServiceOrdersMessage", name = "CancelServiceOrders")
    public JAXBElement<ServiceOrdersRequestMessageType> createCancelServiceOrders(ServiceOrdersRequestMessageType value) {
        return new JAXBElement<ServiceOrdersRequestMessageType>(_CancelServiceOrders_QNAME, ServiceOrdersRequestMessageType.class, null, value);
    }

}


package com.sixthc.cim.createMaintenanceOrders.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sixthc.cim.createMaintenanceOrders.cxf package. 
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

    private final static QName _CloseMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "CloseMaintenanceOrders");
    private final static QName _CanceledMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "CanceledMaintenanceOrders");
    private final static QName _DeletedMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "DeletedMaintenanceOrders");
    private final static QName _MaintenanceOrdersResponseMessage_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "MaintenanceOrdersResponseMessage");
    private final static QName _CreatedMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "CreatedMaintenanceOrders");
    private final static QName _CancelMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "CancelMaintenanceOrders");
    private final static QName _ChangeMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "ChangeMaintenanceOrders");
    private final static QName _MaintenanceOrdersFaultMessage_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "MaintenanceOrdersFaultMessage");
    private final static QName _CreateMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "CreateMaintenanceOrders");
    private final static QName _DeleteMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "DeleteMaintenanceOrders");
    private final static QName _ChangedMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "ChangedMaintenanceOrders");
    private final static QName _ClosedMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrdersMessage", "ClosedMaintenanceOrders");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sixthc.cim.createMaintenanceOrders.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MaintenanceOrdersFaultMessageType }
     * 
     */
    public MaintenanceOrdersFaultMessageType createMaintenanceOrdersFaultMessageType() {
        return new MaintenanceOrdersFaultMessageType();
    }

    /**
     * Create an instance of {@link MaintenanceOrdersEventMessageType }
     * 
     */
    public MaintenanceOrdersEventMessageType createMaintenanceOrdersEventMessageType() {
        return new MaintenanceOrdersEventMessageType();
    }

    /**
     * Create an instance of {@link MaintenanceOrdersRequestMessageType }
     * 
     */
    public MaintenanceOrdersRequestMessageType createMaintenanceOrdersRequestMessageType() {
        return new MaintenanceOrdersRequestMessageType();
    }

    /**
     * Create an instance of {@link MaintenanceOrdersResponseMessageType }
     * 
     */
    public MaintenanceOrdersResponseMessageType createMaintenanceOrdersResponseMessageType() {
        return new MaintenanceOrdersResponseMessageType();
    }

    /**
     * Create an instance of {@link MaintenanceOrdersPayloadType }
     * 
     */
    public MaintenanceOrdersPayloadType createMaintenanceOrdersPayloadType() {
        return new MaintenanceOrdersPayloadType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "CloseMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersRequestMessageType> createCloseMaintenanceOrders(MaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<MaintenanceOrdersRequestMessageType>(_CloseMaintenanceOrders_QNAME, MaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "CanceledMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersEventMessageType> createCanceledMaintenanceOrders(MaintenanceOrdersEventMessageType value) {
        return new JAXBElement<MaintenanceOrdersEventMessageType>(_CanceledMaintenanceOrders_QNAME, MaintenanceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "DeletedMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersEventMessageType> createDeletedMaintenanceOrders(MaintenanceOrdersEventMessageType value) {
        return new JAXBElement<MaintenanceOrdersEventMessageType>(_DeletedMaintenanceOrders_QNAME, MaintenanceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "MaintenanceOrdersResponseMessage")
    public JAXBElement<MaintenanceOrdersResponseMessageType> createMaintenanceOrdersResponseMessage(MaintenanceOrdersResponseMessageType value) {
        return new JAXBElement<MaintenanceOrdersResponseMessageType>(_MaintenanceOrdersResponseMessage_QNAME, MaintenanceOrdersResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "CreatedMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersEventMessageType> createCreatedMaintenanceOrders(MaintenanceOrdersEventMessageType value) {
        return new JAXBElement<MaintenanceOrdersEventMessageType>(_CreatedMaintenanceOrders_QNAME, MaintenanceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "CancelMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersRequestMessageType> createCancelMaintenanceOrders(MaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<MaintenanceOrdersRequestMessageType>(_CancelMaintenanceOrders_QNAME, MaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "ChangeMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersRequestMessageType> createChangeMaintenanceOrders(MaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<MaintenanceOrdersRequestMessageType>(_ChangeMaintenanceOrders_QNAME, MaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersFaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "MaintenanceOrdersFaultMessage")
    public JAXBElement<MaintenanceOrdersFaultMessageType> createMaintenanceOrdersFaultMessage(MaintenanceOrdersFaultMessageType value) {
        return new JAXBElement<MaintenanceOrdersFaultMessageType>(_MaintenanceOrdersFaultMessage_QNAME, MaintenanceOrdersFaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "CreateMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersRequestMessageType> createCreateMaintenanceOrders(MaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<MaintenanceOrdersRequestMessageType>(_CreateMaintenanceOrders_QNAME, MaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "DeleteMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersRequestMessageType> createDeleteMaintenanceOrders(MaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<MaintenanceOrdersRequestMessageType>(_DeleteMaintenanceOrders_QNAME, MaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "ChangedMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersEventMessageType> createChangedMaintenanceOrders(MaintenanceOrdersEventMessageType value) {
        return new JAXBElement<MaintenanceOrdersEventMessageType>(_ChangedMaintenanceOrders_QNAME, MaintenanceOrdersEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrdersEventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrdersMessage", name = "ClosedMaintenanceOrders")
    public JAXBElement<MaintenanceOrdersEventMessageType> createClosedMaintenanceOrders(MaintenanceOrdersEventMessageType value) {
        return new JAXBElement<MaintenanceOrdersEventMessageType>(_ClosedMaintenanceOrders_QNAME, MaintenanceOrdersEventMessageType.class, null, value);
    }

}

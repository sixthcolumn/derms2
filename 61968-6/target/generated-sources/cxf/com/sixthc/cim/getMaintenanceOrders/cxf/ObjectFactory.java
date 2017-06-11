
package com.sixthc.cim.getMaintenanceOrders.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sixthc.cim.getMaintenanceOrders.cxf package. 
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

    private final static QName _GetMaintenanceOrdersRequestMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", "GetMaintenanceOrdersRequestMessage");
    private final static QName _GetMaintenanceOrdersFaultMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", "GetMaintenanceOrdersFaultMessage");
    private final static QName _GetMaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/GetMaintenanceOrders#", "GetMaintenanceOrders");
    private final static QName _GetMaintenanceOrdersResponseMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", "GetMaintenanceOrdersResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sixthc.cim.getMaintenanceOrders.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkTimeSchedule }
     * 
     */
    public WorkTimeSchedule createWorkTimeSchedule() {
        return new WorkTimeSchedule();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress.TownDetail }
     * 
     */
    public WorkLocation.MainAddress.TownDetail createWorkLocationMainAddressTownDetail() {
        return new WorkLocation.MainAddress.TownDetail();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrdersResponseMessageType }
     * 
     */
    public GetMaintenanceOrdersResponseMessageType createGetMaintenanceOrdersResponseMessageType() {
        return new GetMaintenanceOrdersResponseMessageType();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrders }
     * 
     */
    public GetMaintenanceOrders createGetMaintenanceOrders() {
        return new GetMaintenanceOrders();
    }

    /**
     * Create an instance of {@link InternalLocation }
     * 
     */
    public InternalLocation createInternalLocation() {
        return new InternalLocation();
    }

    /**
     * Create an instance of {@link MaintenanceOrdersPayloadType }
     * 
     */
    public MaintenanceOrdersPayloadType createMaintenanceOrdersPayloadType() {
        return new MaintenanceOrdersPayloadType();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress.StreetDetail }
     * 
     */
    public WorkLocation.MainAddress.StreetDetail createWorkLocationMainAddressStreetDetail() {
        return new WorkLocation.MainAddress.StreetDetail();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrdersResponseType }
     * 
     */
    public GetMaintenanceOrdersResponseType createGetMaintenanceOrdersResponseType() {
        return new GetMaintenanceOrdersResponseType();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrdersRequestMessageType }
     * 
     */
    public GetMaintenanceOrdersRequestMessageType createGetMaintenanceOrdersRequestMessageType() {
        return new GetMaintenanceOrdersRequestMessageType();
    }

    /**
     * Create an instance of {@link WorkLocation }
     * 
     */
    public WorkLocation createWorkLocation() {
        return new WorkLocation();
    }

    /**
     * Create an instance of {@link ActivityRecord }
     * 
     */
    public ActivityRecord createActivityRecord() {
        return new ActivityRecord();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrdersFaultMessageType }
     * 
     */
    public GetMaintenanceOrdersFaultMessageType createGetMaintenanceOrdersFaultMessageType() {
        return new GetMaintenanceOrdersFaultMessageType();
    }

    /**
     * Create an instance of {@link Asset }
     * 
     */
    public Asset createAsset() {
        return new Asset();
    }

    /**
     * Create an instance of {@link NameType }
     * 
     */
    public NameType createNameType() {
        return new NameType();
    }

    /**
     * Create an instance of {@link AssetLocationHazard }
     * 
     */
    public AssetLocationHazard createAssetLocationHazard() {
        return new AssetLocationHazard();
    }

    /**
     * Create an instance of {@link GetMaintenanceOrdersRequestType }
     * 
     */
    public GetMaintenanceOrdersRequestType createGetMaintenanceOrdersRequestType() {
        return new GetMaintenanceOrdersRequestType();
    }

    /**
     * Create an instance of {@link Work }
     * 
     */
    public Work createWork() {
        return new Work();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link MaintenanceOrder }
     * 
     */
    public MaintenanceOrder createMaintenanceOrder() {
        return new MaintenanceOrder();
    }

    /**
     * Create an instance of {@link WorkTimeSchedule.ScheduleInterval }
     * 
     */
    public WorkTimeSchedule.ScheduleInterval createWorkTimeScheduleScheduleInterval() {
        return new WorkTimeSchedule.ScheduleInterval();
    }

    /**
     * Create an instance of {@link Organisation }
     * 
     */
    public Organisation createOrganisation() {
        return new Organisation();
    }

    /**
     * Create an instance of {@link NameTypeAuthority }
     * 
     */
    public NameTypeAuthority createNameTypeAuthority() {
        return new NameTypeAuthority();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress }
     * 
     */
    public WorkLocation.MainAddress createWorkLocationMainAddress() {
        return new WorkLocation.MainAddress();
    }

    /**
     * Create an instance of {@link Crew }
     * 
     */
    public Crew createCrew() {
        return new Crew();
    }

    /**
     * Create an instance of {@link Work.Priority }
     * 
     */
    public Work.Priority createWorkPriority() {
        return new Work.Priority();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaintenanceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", name = "GetMaintenanceOrdersRequestMessage")
    public JAXBElement<GetMaintenanceOrdersRequestMessageType> createGetMaintenanceOrdersRequestMessage(GetMaintenanceOrdersRequestMessageType value) {
        return new JAXBElement<GetMaintenanceOrdersRequestMessageType>(_GetMaintenanceOrdersRequestMessage_QNAME, GetMaintenanceOrdersRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaintenanceOrdersFaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", name = "GetMaintenanceOrdersFaultMessage")
    public JAXBElement<GetMaintenanceOrdersFaultMessageType> createGetMaintenanceOrdersFaultMessage(GetMaintenanceOrdersFaultMessageType value) {
        return new JAXBElement<GetMaintenanceOrdersFaultMessageType>(_GetMaintenanceOrdersFaultMessage_QNAME, GetMaintenanceOrdersFaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaintenanceOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetMaintenanceOrders#", name = "GetMaintenanceOrders")
    public JAXBElement<GetMaintenanceOrders> createGetMaintenanceOrders(GetMaintenanceOrders value) {
        return new JAXBElement<GetMaintenanceOrders>(_GetMaintenanceOrders_QNAME, GetMaintenanceOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMaintenanceOrdersResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetMaintenanceOrdersMessage", name = "GetMaintenanceOrdersResponseMessage")
    public JAXBElement<GetMaintenanceOrdersResponseMessageType> createGetMaintenanceOrdersResponseMessage(GetMaintenanceOrdersResponseMessageType value) {
        return new JAXBElement<GetMaintenanceOrdersResponseMessageType>(_GetMaintenanceOrdersResponseMessage_QNAME, GetMaintenanceOrdersResponseMessageType.class, null, value);
    }

}

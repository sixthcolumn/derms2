
package com.sixthc.cim.getServiceOrders.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sixthc.cim.getServiceOrders.cxf package. 
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

    private final static QName _GetServiceOrders_QNAME = new QName("http://iec.ch/TC57/2015/GetServiceOrders#", "GetServiceOrders");
    private final static QName _GetServiceOrdersResponseMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetServiceOrdersMessage", "GetServiceOrdersResponseMessage");
    private final static QName _GetServiceOrdersFaultMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetServiceOrdersMessage", "GetServiceOrdersFaultMessage");
    private final static QName _GetServiceOrdersRequestMessage_QNAME = new QName("http://iec.ch/TC57/2015/GetServiceOrdersMessage", "GetServiceOrdersRequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sixthc.cim.getServiceOrders.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WorkLocation }
     * 
     */
    public WorkLocation createWorkLocation() {
        return new WorkLocation();
    }

    /**
     * Create an instance of {@link com.sixthc.cim.getServiceOrders.cxf.StreetDetail }
     * 
     */
    public com.sixthc.cim.getServiceOrders.cxf.StreetDetail createStreetDetail() {
        return new com.sixthc.cim.getServiceOrders.cxf.StreetDetail();
    }

    /**
     * Create an instance of {@link NameType }
     * 
     */
    public NameType createNameType() {
        return new NameType();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress.TownDetail }
     * 
     */
    public WorkLocation.MainAddress.TownDetail createWorkLocationMainAddressTownDetail() {
        return new WorkLocation.MainAddress.TownDetail();
    }

    /**
     * Create an instance of {@link Work.Priority }
     * 
     */
    public Work.Priority createWorkPriority() {
        return new Work.Priority();
    }

    /**
     * Create an instance of {@link Crew }
     * 
     */
    public Crew createCrew() {
        return new Crew();
    }

    /**
     * Create an instance of {@link GetServiceOrdersResponseType }
     * 
     */
    public GetServiceOrdersResponseType createGetServiceOrdersResponseType() {
        return new GetServiceOrdersResponseType();
    }

    /**
     * Create an instance of {@link StreetAddress }
     * 
     */
    public StreetAddress createStreetAddress() {
        return new StreetAddress();
    }

    /**
     * Create an instance of {@link ServiceCategory }
     * 
     */
    public ServiceCategory createServiceCategory() {
        return new ServiceCategory();
    }

    /**
     * Create an instance of {@link Work }
     * 
     */
    public Work createWork() {
        return new Work();
    }

    /**
     * Create an instance of {@link InternalLocation }
     * 
     */
    public InternalLocation createInternalLocation() {
        return new InternalLocation();
    }

    /**
     * Create an instance of {@link GetServiceOrdersRequestMessageType }
     * 
     */
    public GetServiceOrdersRequestMessageType createGetServiceOrdersRequestMessageType() {
        return new GetServiceOrdersRequestMessageType();
    }

    /**
     * Create an instance of {@link AssetLocationHazard }
     * 
     */
    public AssetLocationHazard createAssetLocationHazard() {
        return new AssetLocationHazard();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress.StreetDetail }
     * 
     */
    public WorkLocation.MainAddress.StreetDetail createWorkLocationMainAddressStreetDetail() {
        return new WorkLocation.MainAddress.StreetDetail();
    }

    /**
     * Create an instance of {@link ServiceOrdersPayloadType }
     * 
     */
    public ServiceOrdersPayloadType createServiceOrdersPayloadType() {
        return new ServiceOrdersPayloadType();
    }

    /**
     * Create an instance of {@link GetServiceOrders }
     * 
     */
    public GetServiceOrders createGetServiceOrders() {
        return new GetServiceOrders();
    }

    /**
     * Create an instance of {@link GetServiceOrdersResponseMessageType }
     * 
     */
    public GetServiceOrdersResponseMessageType createGetServiceOrdersResponseMessageType() {
        return new GetServiceOrdersResponseMessageType();
    }

    /**
     * Create an instance of {@link WorkLocation.MainAddress }
     * 
     */
    public WorkLocation.MainAddress createWorkLocationMainAddress() {
        return new WorkLocation.MainAddress();
    }

    /**
     * Create an instance of {@link ActivityRecord }
     * 
     */
    public ActivityRecord createActivityRecord() {
        return new ActivityRecord();
    }

    /**
     * Create an instance of {@link Asset }
     * 
     */
    public Asset createAsset() {
        return new Asset();
    }

    /**
     * Create an instance of {@link NameTypeAuthority }
     * 
     */
    public NameTypeAuthority createNameTypeAuthority() {
        return new NameTypeAuthority();
    }

    /**
     * Create an instance of {@link WorkTimeSchedule }
     * 
     */
    public WorkTimeSchedule createWorkTimeSchedule() {
        return new WorkTimeSchedule();
    }

    /**
     * Create an instance of {@link Organisation }
     * 
     */
    public Organisation createOrganisation() {
        return new Organisation();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link ServiceOrder }
     * 
     */
    public ServiceOrder createServiceOrder() {
        return new ServiceOrder();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link UsagePointLocation }
     * 
     */
    public UsagePointLocation createUsagePointLocation() {
        return new UsagePointLocation();
    }

    /**
     * Create an instance of {@link GetServiceOrdersRequestType }
     * 
     */
    public GetServiceOrdersRequestType createGetServiceOrdersRequestType() {
        return new GetServiceOrdersRequestType();
    }

    /**
     * Create an instance of {@link UsagePoint }
     * 
     */
    public UsagePoint createUsagePoint() {
        return new UsagePoint();
    }

    /**
     * Create an instance of {@link WorkTimeSchedule.ScheduleInterval }
     * 
     */
    public WorkTimeSchedule.ScheduleInterval createWorkTimeScheduleScheduleInterval() {
        return new WorkTimeSchedule.ScheduleInterval();
    }

    /**
     * Create an instance of {@link GetServiceOrdersFaultMessageType }
     * 
     */
    public GetServiceOrdersFaultMessageType createGetServiceOrdersFaultMessageType() {
        return new GetServiceOrdersFaultMessageType();
    }

    /**
     * Create an instance of {@link com.sixthc.cim.getServiceOrders.cxf.TownDetail }
     * 
     */
    public com.sixthc.cim.getServiceOrders.cxf.TownDetail createTownDetail() {
        return new com.sixthc.cim.getServiceOrders.cxf.TownDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetServiceOrders#", name = "GetServiceOrders")
    public JAXBElement<GetServiceOrders> createGetServiceOrders(GetServiceOrders value) {
        return new JAXBElement<GetServiceOrders>(_GetServiceOrders_QNAME, GetServiceOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceOrdersResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetServiceOrdersMessage", name = "GetServiceOrdersResponseMessage")
    public JAXBElement<GetServiceOrdersResponseMessageType> createGetServiceOrdersResponseMessage(GetServiceOrdersResponseMessageType value) {
        return new JAXBElement<GetServiceOrdersResponseMessageType>(_GetServiceOrdersResponseMessage_QNAME, GetServiceOrdersResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceOrdersFaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetServiceOrdersMessage", name = "GetServiceOrdersFaultMessage")
    public JAXBElement<GetServiceOrdersFaultMessageType> createGetServiceOrdersFaultMessage(GetServiceOrdersFaultMessageType value) {
        return new JAXBElement<GetServiceOrdersFaultMessageType>(_GetServiceOrdersFaultMessage_QNAME, GetServiceOrdersFaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceOrdersRequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/GetServiceOrdersMessage", name = "GetServiceOrdersRequestMessage")
    public JAXBElement<GetServiceOrdersRequestMessageType> createGetServiceOrdersRequestMessage(GetServiceOrdersRequestMessageType value) {
        return new JAXBElement<GetServiceOrdersRequestMessageType>(_GetServiceOrdersRequestMessage_QNAME, GetServiceOrdersRequestMessageType.class, null, value);
    }

}

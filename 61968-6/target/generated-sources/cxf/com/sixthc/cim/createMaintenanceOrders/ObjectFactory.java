
package com.sixthc.cim.createMaintenanceOrders;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sixthc.cim.createMaintenanceOrders package. 
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

    private final static QName _EventMessage_QNAME = new QName("http://iec.ch/TC57/2011/schema/message", "EventMessage");
    private final static QName _Message_QNAME = new QName("http://iec.ch/TC57/2011/schema/message", "Message");
    private final static QName _MaintenanceOrders_QNAME = new QName("http://iec.ch/TC57/2015/MaintenanceOrders#", "MaintenanceOrders");
    private final static QName _FaultMessage_QNAME = new QName("http://iec.ch/TC57/2011/schema/message", "FaultMessage");
    private final static QName _ResponseMessage_QNAME = new QName("http://iec.ch/TC57/2011/schema/message", "ResponseMessage");
    private final static QName _RequestMessage_QNAME = new QName("http://iec.ch/TC57/2011/schema/message", "RequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sixthc.cim.createMaintenanceOrders
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ErrorType.ID }
     * 
     */
    public ErrorType.ID createErrorTypeID() {
        return new ErrorType.ID();
    }

    /**
     * Create an instance of {@link Work2 .Priority }
     * 
     */
    public Work2 .Priority createWork2Priority() {
        return new Work2 .Priority();
    }

    /**
     * Create an instance of {@link Organisation2 .Phone1 }
     * 
     */
    public Organisation2 .Phone1 createOrganisation2Phone1() {
        return new Organisation2 .Phone1();
    }

    /**
     * Create an instance of {@link WorkTask.MaterialItems.Quantity }
     * 
     */
    public WorkTask.MaterialItems.Quantity createWorkTaskMaterialItemsQuantity() {
        return new WorkTask.MaterialItems.Quantity();
    }

    /**
     * Create an instance of {@link Asset2 }
     * 
     */
    public Asset2 createAsset2() {
        return new Asset2();
    }

    /**
     * Create an instance of {@link MaintenanceOrders2 }
     * 
     */
    public MaintenanceOrders2 createMaintenanceOrders2() {
        return new MaintenanceOrders2();
    }

    /**
     * Create an instance of {@link WorkAsset.Procedures.Measurements }
     * 
     */
    public WorkAsset.Procedures.Measurements createWorkAssetProceduresMeasurements() {
        return new WorkAsset.Procedures.Measurements();
    }

    /**
     * Create an instance of {@link Organisation2 .StreetAddress.StreetDetail }
     * 
     */
    public Organisation2 .StreetAddress.StreetDetail createOrganisation2StreetAddressStreetDetail() {
        return new Organisation2 .StreetAddress.StreetDetail();
    }

    /**
     * Create an instance of {@link TelephoneNumber }
     * 
     */
    public TelephoneNumber createTelephoneNumber() {
        return new TelephoneNumber();
    }

    /**
     * Create an instance of {@link RequestType }
     * 
     */
    public RequestType createRequestType() {
        return new RequestType();
    }

    /**
     * Create an instance of {@link WorkLocation2 .PositionPoints }
     * 
     */
    public WorkLocation2 .PositionPoints createWorkLocation2PositionPoints() {
        return new WorkLocation2 .PositionPoints();
    }

    /**
     * Create an instance of {@link MessageProperty }
     * 
     */
    public MessageProperty createMessageProperty() {
        return new MessageProperty();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link WorkTask }
     * 
     */
    public WorkTask createWorkTask() {
        return new WorkTask();
    }

    /**
     * Create an instance of {@link WorkTimeSchedule2 }
     * 
     */
    public WorkTimeSchedule2 createWorkTimeSchedule2() {
        return new WorkTimeSchedule2();
    }

    /**
     * Create an instance of {@link ObjectType }
     * 
     */
    public ObjectType createObjectType() {
        return new ObjectType();
    }

    /**
     * Create an instance of {@link Crew2 }
     * 
     */
    public Crew2 createCrew2() {
        return new Crew2();
    }

    /**
     * Create an instance of {@link CrewMember.Person }
     * 
     */
    public CrewMember.Person createCrewMemberPerson() {
        return new CrewMember.Person();
    }

    /**
     * Create an instance of {@link RequestType.ID }
     * 
     */
    public RequestType.ID createRequestTypeID() {
        return new RequestType.ID();
    }

    /**
     * Create an instance of {@link MaintenanceOrder2 }
     * 
     */
    public MaintenanceOrder2 createMaintenanceOrder2() {
        return new MaintenanceOrder2();
    }

    /**
     * Create an instance of {@link Attachment }
     * 
     */
    public Attachment createAttachment() {
        return new Attachment();
    }

    /**
     * Create an instance of {@link WorkLocation2 .MainAddress }
     * 
     */
    public WorkLocation2 .MainAddress createWorkLocation2MainAddress() {
        return new WorkLocation2 .MainAddress();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link WorkTimeSchedule2 .ScheduleInterval }
     * 
     */
    public WorkTimeSchedule2 .ScheduleInterval createWorkTimeSchedule2ScheduleInterval() {
        return new WorkTimeSchedule2 .ScheduleInterval();
    }

    /**
     * Create an instance of {@link WorkLocation2 }
     * 
     */
    public WorkLocation2 createWorkLocation2() {
        return new WorkLocation2();
    }

    /**
     * Create an instance of {@link EventMessageType }
     * 
     */
    public EventMessageType createEventMessageType() {
        return new EventMessageType();
    }

    /**
     * Create an instance of {@link ReplayDetectionType }
     * 
     */
    public ReplayDetectionType createReplayDetectionType() {
        return new ReplayDetectionType();
    }

    /**
     * Create an instance of {@link NameType2 }
     * 
     */
    public NameType2 createNameType2() {
        return new NameType2();
    }

    /**
     * Create an instance of {@link PayloadType.ID }
     * 
     */
    public PayloadType.ID createPayloadTypeID() {
        return new PayloadType.ID();
    }

    /**
     * Create an instance of {@link CrewMember }
     * 
     */
    public CrewMember createCrewMember() {
        return new CrewMember();
    }

    /**
     * Create an instance of {@link Name3 }
     * 
     */
    public Name3 createName3() {
        return new Name3();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link WorkLocation2 .MainAddress.TownDetail }
     * 
     */
    public WorkLocation2 .MainAddress.TownDetail createWorkLocation2MainAddressTownDetail() {
        return new WorkLocation2 .MainAddress.TownDetail();
    }

    /**
     * Create an instance of {@link Organisation2 .StreetAddress }
     * 
     */
    public Organisation2 .StreetAddress createOrganisation2StreetAddress() {
        return new Organisation2 .StreetAddress();
    }

    /**
     * Create an instance of {@link ResponseMessageType }
     * 
     */
    public ResponseMessageType createResponseMessageType() {
        return new ResponseMessageType();
    }

    /**
     * Create an instance of {@link PayloadType }
     * 
     */
    public PayloadType createPayloadType() {
        return new PayloadType();
    }

    /**
     * Create an instance of {@link Organisation2 .StreetAddress.TownDetail }
     * 
     */
    public Organisation2 .StreetAddress.TownDetail createOrganisation2StreetAddressTownDetail() {
        return new Organisation2 .StreetAddress.TownDetail();
    }

    /**
     * Create an instance of {@link Work2 .Attachments }
     * 
     */
    public Work2 .Attachments createWork2Attachments() {
        return new Work2 .Attachments();
    }

    /**
     * Create an instance of {@link ReplyType }
     * 
     */
    public ReplyType createReplyType() {
        return new ReplyType();
    }

    /**
     * Create an instance of {@link Asset2 .Procedures.Measurements }
     * 
     */
    public Asset2 .Procedures.Measurements createAsset2ProceduresMeasurements() {
        return new Asset2 .Procedures.Measurements();
    }

    /**
     * Create an instance of {@link WorkLocation2 .CoordinateSystem }
     * 
     */
    public WorkLocation2 .CoordinateSystem createWorkLocation2CoordinateSystem() {
        return new WorkLocation2 .CoordinateSystem();
    }

    /**
     * Create an instance of {@link Work2 }
     * 
     */
    public Work2 createWork2() {
        return new Work2();
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link WorkAsset.Procedures }
     * 
     */
    public WorkAsset.Procedures createWorkAssetProcedures() {
        return new WorkAsset.Procedures();
    }

    /**
     * Create an instance of {@link ErrorType.RelatedID }
     * 
     */
    public ErrorType.RelatedID createErrorTypeRelatedID() {
        return new ErrorType.RelatedID();
    }

    /**
     * Create an instance of {@link ReplyType.ID }
     * 
     */
    public ReplyType.ID createReplyTypeID() {
        return new ReplyType.ID();
    }

    /**
     * Create an instance of {@link WorkAsset }
     * 
     */
    public WorkAsset createWorkAsset() {
        return new WorkAsset();
    }

    /**
     * Create an instance of {@link NameType3 }
     * 
     */
    public NameType3 createNameType3() {
        return new NameType3();
    }

    /**
     * Create an instance of {@link NameTypeAuthority3 }
     * 
     */
    public NameTypeAuthority3 createNameTypeAuthority3() {
        return new NameTypeAuthority3();
    }

    /**
     * Create an instance of {@link AssetLocationHazard2 }
     * 
     */
    public AssetLocationHazard2 createAssetLocationHazard2() {
        return new AssetLocationHazard2();
    }

    /**
     * Create an instance of {@link NameTypeAuthority2 }
     * 
     */
    public NameTypeAuthority2 createNameTypeAuthority2() {
        return new NameTypeAuthority2();
    }

    /**
     * Create an instance of {@link OperationType }
     * 
     */
    public OperationType createOperationType() {
        return new OperationType();
    }

    /**
     * Create an instance of {@link FaultMessageType }
     * 
     */
    public FaultMessageType createFaultMessageType() {
        return new FaultMessageType();
    }

    /**
     * Create an instance of {@link WorkTask.MaterialItems }
     * 
     */
    public WorkTask.MaterialItems createWorkTaskMaterialItems() {
        return new WorkTask.MaterialItems();
    }

    /**
     * Create an instance of {@link OptionType }
     * 
     */
    public OptionType createOptionType() {
        return new OptionType();
    }

    /**
     * Create an instance of {@link WorkLocation2 .MainAddress.StreetDetail }
     * 
     */
    public WorkLocation2 .MainAddress.StreetDetail createWorkLocation2MainAddressStreetDetail() {
        return new WorkLocation2 .MainAddress.StreetDetail();
    }

    /**
     * Create an instance of {@link InternalLocation2 }
     * 
     */
    public InternalLocation2 createInternalLocation2() {
        return new InternalLocation2();
    }

    /**
     * Create an instance of {@link RequestMessageType }
     * 
     */
    public RequestMessageType createRequestMessageType() {
        return new RequestMessageType();
    }

    /**
     * Create an instance of {@link Organisation2 }
     * 
     */
    public Organisation2 createOrganisation2() {
        return new Organisation2();
    }

    /**
     * Create an instance of {@link Name2 }
     * 
     */
    public Name2 createName2() {
        return new Name2();
    }

    /**
     * Create an instance of {@link Asset2 .Procedures }
     * 
     */
    public Asset2 .Procedures createAsset2Procedures() {
        return new Asset2 .Procedures();
    }

    /**
     * Create an instance of {@link ActivityRecord2 }
     * 
     */
    public ActivityRecord2 createActivityRecord2() {
        return new ActivityRecord2();
    }

    /**
     * Create an instance of {@link OperationSet }
     * 
     */
    public OperationSet createOperationSet() {
        return new OperationSet();
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2011/schema/message", name = "EventMessage")
    public JAXBElement<EventMessageType> createEventMessage(EventMessageType value) {
        return new JAXBElement<EventMessageType>(_EventMessage_QNAME, EventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2011/schema/message", name = "Message")
    public JAXBElement<MessageType> createMessage(MessageType value) {
        return new JAXBElement<MessageType>(_Message_QNAME, MessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaintenanceOrders2 }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2015/MaintenanceOrders#", name = "MaintenanceOrders")
    public JAXBElement<MaintenanceOrders2> createMaintenanceOrders(MaintenanceOrders2 value) {
        return new JAXBElement<MaintenanceOrders2>(_MaintenanceOrders_QNAME, MaintenanceOrders2 .class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2011/schema/message", name = "FaultMessage")
    public JAXBElement<FaultMessageType> createFaultMessage(FaultMessageType value) {
        return new JAXBElement<FaultMessageType>(_FaultMessage_QNAME, FaultMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2011/schema/message", name = "ResponseMessage")
    public JAXBElement<ResponseMessageType> createResponseMessage(ResponseMessageType value) {
        return new JAXBElement<ResponseMessageType>(_ResponseMessage_QNAME, ResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestMessageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2011/schema/message", name = "RequestMessage")
    public JAXBElement<RequestMessageType> createRequestMessage(RequestMessageType value) {
        return new JAXBElement<RequestMessageType>(_RequestMessage_QNAME, RequestMessageType.class, null, value);
    }

}

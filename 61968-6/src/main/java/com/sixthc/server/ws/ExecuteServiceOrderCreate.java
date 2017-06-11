package com.sixthc.server.ws;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.cim.createServiceOrders.ActivityRecord2;
import com.sixthc.cim.createServiceOrders.Asset2;
import com.sixthc.cim.createServiceOrders.AssetLocationHazard2;
import com.sixthc.cim.createServiceOrders.Crew2;
import com.sixthc.cim.createServiceOrders.CrewMember;
import com.sixthc.cim.createServiceOrders.CrewMember.Person;
import com.sixthc.cim.createServiceOrders.ErrorType;
import com.sixthc.cim.createServiceOrders.ErrorType.ID;
import com.sixthc.cim.createServiceOrders.HeaderType;
import com.sixthc.cim.createServiceOrders.IDKindType;
import com.sixthc.cim.createServiceOrders.InternalLocation2;
import com.sixthc.cim.createServiceOrders.MeterReading;
import com.sixthc.cim.createServiceOrders.MeterReading.Readings;
import com.sixthc.cim.createServiceOrders.MeterReading.Readings.TimePeriod;
import com.sixthc.cim.createServiceOrders.MeterReading.ValuesInterval;
import com.sixthc.cim.createServiceOrders.Name2;
import com.sixthc.cim.createServiceOrders.NameType2;
import com.sixthc.cim.createServiceOrders.NameTypeAuthority2;
import com.sixthc.cim.createServiceOrders.ReadingQuality;
import com.sixthc.cim.createServiceOrders.ReadingQualityType;
import com.sixthc.cim.createServiceOrders.ReplyType;
import com.sixthc.cim.createServiceOrders.RequestType;
import com.sixthc.cim.createServiceOrders.ServiceOrder;
import com.sixthc.cim.createServiceOrders.ServiceOrders;
import com.sixthc.cim.createServiceOrders.TelephoneNumber;
import com.sixthc.cim.createServiceOrders.Work2;
import com.sixthc.cim.createServiceOrders.Work2.Priority;
import com.sixthc.cim.createServiceOrders.WorkAsset;
import com.sixthc.cim.createServiceOrders.WorkLocation2;
import com.sixthc.cim.createServiceOrders.WorkLocation2.CoordinateSystem;
import com.sixthc.cim.createServiceOrders.WorkLocation2.MainAddress;
import com.sixthc.cim.createServiceOrders.WorkLocation2.MainAddress.StreetDetail;
import com.sixthc.cim.createServiceOrders.WorkLocation2.MainAddress.TownDetail;
import com.sixthc.cim.createServiceOrders.WorkLocation2.PositionPoints;
import com.sixthc.cim.createServiceOrders.WorkTask;
import com.sixthc.cim.createServiceOrders.WorkTimeSchedule2;
import com.sixthc.cim.createServiceOrders.WorkTimeSchedule2.ScheduleInterval;
import com.sixthc.cim.createServiceOrders.cxf.FaultMessage;
import com.sixthc.cim.createServiceOrders.cxf.ServiceOrdersPayloadType;
import com.sixthc.cim.createServiceOrders.cxf.ServiceOrdersPort;
import com.sixthc.dao.MaintOrderDao;
import com.sixthc.dao.WorkOrderDao;
import com.sixthc.hbm.Address;
import com.sixthc.hbm.AssetNames;
import com.sixthc.hbm.Attachment;
import com.sixthc.hbm.ConstraintException;
import com.sixthc.hbm.Contactperson;
import com.sixthc.hbm.CrewContactpersons;
import com.sixthc.hbm.CrewNames;
import com.sixthc.hbm.Hazards;
import com.sixthc.hbm.Maintorder;
import com.sixthc.hbm.MaintorderNames;
import com.sixthc.hbm.MeterReadingSeq;
import com.sixthc.hbm.ReadingQualityTypeNames;
import com.sixthc.hbm.WorkOrder;
import com.sixthc.hbm.WorkOrderAttachments;
import com.sixthc.hbm.WorkOrderHazards;
import com.sixthc.hbm.WorkOrderNames;
import com.sixthc.hbm.WorkOrderSchedule;
import com.sixthc.hbm.WorkOrderWorkTasks;
import com.sixthc.hbm.WorkPositionPoints;
import com.sixthc.hbm.WorkTaskAssets;
import com.sixthc.hbm.WorkTaskCrews;
import com.sixthc.hbm.WorkTaskNames;
import com.sixthc.hbm.WorkTaskOldAssets;
import com.sixthc.hbm.WorkTaskTimeSchedules;
import com.sixthc.util.DateUtil;
import com.sixthc.util.ImageLoadFileException;
import com.sixthc.util.ImageLoader;

public class ExecuteServiceOrderCreate implements ServiceOrdersPort {
	static Logger log = Logger.getLogger(ExecuteServiceOrderCreate.class);

	@Autowired
	private WorkOrderDao workOrderDao;

	@Autowired
	private MaintOrderDao maintOrderDao;

	private List<com.sixthc.hbm.ReadingQualityTypeNames> parseReadingQualityTypeNames(
			List<Name2> list) {
		Vector<com.sixthc.hbm.ReadingQualityTypeNames> namesList = new Vector<com.sixthc.hbm.ReadingQualityTypeNames>();
		for (Name2 reqName : list) {
			com.sixthc.hbm.ReadingQualityTypeNames names = new com.sixthc.hbm.ReadingQualityTypeNames();
			namesList.add(names);
			names.setName(reqName.getName());

			// TODO : need to fix this, gets a transient save error
			//			NameType2 reqNameType = reqName.getNameType();
			//			if (reqNameType != null) {
			//				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
			//				nameType.setName(reqNameType.getName());
			//				nameType.setDescription(reqNameType.getDescription());
			//				names.setNametype(nameType);
			//
			//				nameType.getReadingQualityTypeNameses().add(names);
			//
			//				NameTypeAuthority2 reqNameTypeAuthority = reqNameType
			//						.getNameTypeAuthority();
			//				if (reqNameTypeAuthority != null) {
			//					com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
			//					nameTypeAuthority.setName(reqNameTypeAuthority.getName());
			//					nameTypeAuthority.setDescription(reqNameTypeAuthority
			//							.getDescription());
			//					nameType.setNameTypeAuthority(nameTypeAuthority);
			//				}
			//			}
		}
		return namesList;
	}

	private List<com.sixthc.hbm.MaintorderNames> parseMaintorderNames(
			List<Name2> list) {
		Vector<com.sixthc.hbm.MaintorderNames> namesList = new Vector<com.sixthc.hbm.MaintorderNames>();
		for (Name2 reqName : list) {
			com.sixthc.hbm.MaintorderNames names = new com.sixthc.hbm.MaintorderNames();
			namesList.add(names);
			names.setName(reqName.getName());

			NameType2 reqNameType = reqName.getNameType();
			if (reqNameType != null) {
				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
				nameType.setName(reqNameType.getName());
				nameType.setDescription(reqNameType.getDescription());
				names.setNametype(nameType);

				nameType.getMaintOrderNameses().add(names);

				NameTypeAuthority2 reqNameTypeAuthority = reqNameType
						.getNameTypeAuthority();
				if (reqNameTypeAuthority != null) {
					com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
					nameTypeAuthority.setName(reqNameTypeAuthority.getName());
					nameTypeAuthority.setDescription(reqNameTypeAuthority
							.getDescription());
					nameType.setNameTypeAuthority(nameTypeAuthority);
				}
			}
		}
		return namesList;
	}

	private com.sixthc.hbm.Nametype parseNameType(NameType2 from) {
		if (from != null) {
			com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
			nameType.setName(from.getName());
			nameType.setDescription(from.getDescription());

			NameTypeAuthority2 reqNameTypeAuthority = from
					.getNameTypeAuthority();
			if (reqNameTypeAuthority != null) {
				com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
				nameTypeAuthority.setName(reqNameTypeAuthority.getName());
				nameTypeAuthority.setDescription(reqNameTypeAuthority
						.getDescription());
				nameType.setNameTypeAuthority(nameTypeAuthority);
			}
			return nameType;
		}
		return null;
	}

	private List<com.sixthc.hbm.AssetNames> parseAssetNames(List<Name2> reqNames) {
		Vector<com.sixthc.hbm.AssetNames> namesList = new Vector<com.sixthc.hbm.AssetNames>();
		for (Name2 reqName : reqNames) {
			com.sixthc.hbm.AssetNames names = new com.sixthc.hbm.AssetNames();
			namesList.add(names);
			names.setName(reqName.getName());

			NameType2 reqNameType = reqName.getNameType();
			if (reqNameType != null) {
				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
				nameType.setName(reqNameType.getName());
				nameType.setDescription(reqNameType.getDescription());
				names.setNametype(nameType);
				nameType.getAssetNameses().add(names);

				NameTypeAuthority2 reqNameTypeAuthority = reqNameType
						.getNameTypeAuthority();
				if (reqNameTypeAuthority != null) {
					com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
					nameTypeAuthority.setName(reqNameTypeAuthority.getName());
					nameTypeAuthority.setDescription(reqNameTypeAuthority
							.getDescription());
					nameType.setNameTypeAuthority(nameTypeAuthority);
				}
			}
		}
		return namesList;
	}

	private com.sixthc.hbm.Asset parseAsset(WorkAsset reqCrewAsset) {
		com.sixthc.hbm.Asset workAsset = new com.sixthc.hbm.Asset();
		workAsset.setMrid(reqCrewAsset.getMRID());
		workAsset.setCriticalFlag(reqCrewAsset.isCritical() == true ? 1 : 0);
		workAsset.setUtcNumber(reqCrewAsset.getUtcNumber());

		List<com.sixthc.hbm.AssetNames> namesList = parseAssetNames(reqCrewAsset
				.getNames());
		for (AssetNames assetNames : namesList) {
			workAsset.getAssetNameses().add(assetNames);
			assetNames.setAsset(workAsset);
		}

		return workAsset;
	}

	private com.sixthc.hbm.Asset parseAsset(Asset2 reqAsset) {
		com.sixthc.hbm.Asset workAsset = new com.sixthc.hbm.Asset();
		workAsset.setMrid(reqAsset.getMRID());
		if (reqAsset.isCritical() != null)
			workAsset.setCriticalFlag(reqAsset.isCritical() == true ? 1 : 0);
		workAsset.setUtcNumber(reqAsset.getUtcNumber());
		workAsset.setAmrSystem(reqAsset.getAmrSystem());
		workAsset.setFormNumber(reqAsset.getFormNumber());
		workAsset.setSerialNumber(reqAsset.getSerialNumber());

		List<com.sixthc.hbm.AssetNames> namesList = parseAssetNames(reqAsset
				.getNames());
		for (AssetNames assetNames : namesList) {
			workAsset.getAssetNameses().add(assetNames);
			assetNames.setAsset(workAsset);
		}

		List<com.sixthc.cim.createServiceOrders.MeterMultiplier> meterMultipliers = reqAsset
				.getMeterMultipliers();
		for (com.sixthc.cim.createServiceOrders.MeterMultiplier m : meterMultipliers) {
			com.sixthc.hbm.MeterMultiplier workMeter = new com.sixthc.hbm.MeterMultiplier();
			workMeter.setKind(m.getKind().value());
			workMeter.setMrid(m.getMRID());
			workMeter.setValue((double) m.getValue());
			workMeter.setAsset(workAsset);
			workAsset.getMeterMultipliers().add(workMeter);
		}

		List<MeterReading> seqs = reqAsset.getMeterReadings();
		for (MeterReading s : seqs) {
			MeterReadingSeq workSeq = new MeterReadingSeq();
			ValuesInterval valuesInterval = s.getValuesInterval();
			if (valuesInterval != null) {
				if (valuesInterval.getEnd() != null)
					workSeq.setValueIntervalEnd(valuesInterval.getEnd()
							.toGregorianCalendar().getTime());
				if (valuesInterval.getStart() != null)
					workSeq.setValueIntervalStart(valuesInterval.getStart()
							.toGregorianCalendar().getTime());
			}

			for (Readings r : s.getReadings()) {
				com.sixthc.hbm.MeterReading r2 = new com.sixthc.hbm.MeterReading();
				r2.setReason(r.getReason());
				if (r.getReportedDateTime() != null)
					r2.setReportDate(r.getReportedDateTime()
							.toGregorianCalendar().getTime());
				r2.setSource(r.getSource());
				if (r.getTimeStamp() != null)
					r2.setTimestamp(r.getTimeStamp().toGregorianCalendar()
							.getTime());
				r2.setValue(r.getValue());
				TimePeriod tp = r.getTimePeriod();
				if (tp != null) {
					if (tp.getEnd() != null)
						r2.setTimePeriodEnd(tp.getEnd().toGregorianCalendar()
								.getTime());
					if (tp.getStart() != null)
						r2.setTimePeriodStart(tp.getStart()
								.toGregorianCalendar().getTime());
				}

				for (ReadingQuality reqRqt : r.getReadingQualities()) {
					com.sixthc.hbm.MeterReadingQuality rqt2 = new com.sixthc.hbm.MeterReadingQuality();
					rqt2.setComment(reqRqt.getComment());
					if (reqRqt.getReadingQualityType() != null)
						rqt2.setQualityType(reqRqt.getReadingQualityType()
								.getRef());
					rqt2.setSource(reqRqt.getSource());
					rqt2.setTimestamp(reqRqt.getTimeStamp()
							.toGregorianCalendar().getTime());
					r2.getMeterReadingQualities().add(rqt2);
				}

				workSeq.getMeterReadings().add(r2);
				r2.setMeterReadingSeq(workSeq);

			}
			workAsset.getMeterReadingSeqs().add(workSeq);
			workSeq.setAsset(workAsset);
		}

		return workAsset;
	}

	private void parseStreetDetail2(Address woAddress, MainAddress addr) {
		StreetDetail streetDetail = addr.getStreetDetail();

		if (streetDetail != null) {
			woAddress.setSdBuildingName(streetDetail.getBuildingName());
			woAddress.setSdCode(streetDetail.getCode());
			woAddress.setSdNumber(streetDetail.getNumber());
			woAddress.setSdSuffix(streetDetail.getSuffix());
			woAddress.setSdPrefix(streetDetail.getPrefix());
			woAddress.setSdSuiteNumber(streetDetail.getSuiteNumber());
			woAddress.setSdBuildingName(streetDetail.getBuildingName());

			woAddress.setSdAddress1(streetDetail.getAddressGeneral());
			woAddress.setSdAddress2(streetDetail.getName());
			woAddress.setSdWithinTownLimitsFlag(streetDetail
					.isWithinTownLimits() != null
					&& streetDetail.isWithinTownLimits() == true ? 1 : 0);
			woAddress.setSdType(streetDetail.getType());

		}

		TownDetail townDetail = addr.getTownDetail();
		if (townDetail != null) {
			woAddress.setTdCode(townDetail.getCode());
			woAddress.setTdCountry(townDetail.getCountry());
			woAddress.setTdName(townDetail.getName());
			woAddress.setTdSection(townDetail.getSection());
			woAddress.setTdStateProvince(townDetail.getStateOrProvince());
		}

	}

	private List<com.sixthc.hbm.CrewNames> parseCrewNames(List<Name2> reqNames) {
		Vector<com.sixthc.hbm.CrewNames> namesList = new Vector<com.sixthc.hbm.CrewNames>();
		for (Name2 reqName : reqNames) {
			com.sixthc.hbm.CrewNames names = new com.sixthc.hbm.CrewNames();
			namesList.add(names);
			names.setName(reqName.getName());

			NameType2 reqNameType = reqName.getNameType();
			if (reqNameType != null) {
				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
				nameType.setName(reqNameType.getName());
				nameType.setDescription(reqNameType.getDescription());
				names.setNametype(nameType);
				nameType.getCrewNameses().add(names);

				NameTypeAuthority2 reqNameTypeAuthority = reqNameType
						.getNameTypeAuthority();
				if (reqNameTypeAuthority != null) {
					com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
					nameTypeAuthority.setName(reqNameTypeAuthority.getName());
					nameTypeAuthority.setDescription(reqNameTypeAuthority
							.getDescription());
					nameType.setNameTypeAuthority(nameTypeAuthority);
				}
			}
		}
		return namesList;
	}

	private List<com.sixthc.hbm.WorkTaskNames> parseWorkTaskNames(
			List<Name2> reqNames) {
		Vector<com.sixthc.hbm.WorkTaskNames> namesList = new Vector<com.sixthc.hbm.WorkTaskNames>();
		for (Name2 reqName : reqNames) {
			com.sixthc.hbm.WorkTaskNames names = new com.sixthc.hbm.WorkTaskNames();
			namesList.add(names);
			names.setName(reqName.getName());

			NameType2 reqNameType = reqName.getNameType();
			if (reqNameType != null) {
				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
				nameType.setName(reqNameType.getName());
				nameType.setDescription(reqNameType.getDescription());
				names.setNametype(nameType);
				nameType.getWorkTaskNameses().add(names);

				NameTypeAuthority2 reqNameTypeAuthority = reqNameType
						.getNameTypeAuthority();
				if (reqNameTypeAuthority != null) {
					com.sixthc.hbm.NameTypeAuthority nameTypeAuthority = new com.sixthc.hbm.NameTypeAuthority();
					nameTypeAuthority.setName(reqNameTypeAuthority.getName());
					nameTypeAuthority.setDescription(reqNameTypeAuthority
							.getDescription());
					nameType.setNameTypeAuthority(nameTypeAuthority);
				}
			}
		}
		return namesList;
	}

	@Override
	public void createServiceOrders(Holder<HeaderType> header,
			RequestType request, Holder<ServiceOrdersPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {
		// TODO Auto-generated method stub
		boolean imageFileProcessingError = false;
		int numErrors = 0;
		int numOrders = 0;
		reply.value = new ReplyType();
		boolean workOrderError = false;

		HeaderType returnHeader = new HeaderType();
		returnHeader.setVerb("reply");
		returnHeader.setNoun("ServiceOrders");
		returnHeader.setTimestamp(DateUtil.getXMLDate(new Date(System
				.currentTimeMillis())));
		returnHeader.setCorrelationID(header.value.getCorrelationID());
		returnHeader.setMessageID(UUID.randomUUID().toString());
		header.value = returnHeader;

		ServiceOrders orders = payload.value.getServiceOrders();

		for (ServiceOrder req : orders.getServiceOrder()) {
			Maintorder so = new Maintorder();

			so.setMrid(req.getMRID());
			so.setCreatedBy("wms");
			so.setCreatedAt(new Date(System.currentTimeMillis()));
			so.setOrderType("Service");

			UUID uuid = UUID.randomUUID();
			so.setMrid(uuid.toString());

			List<ReadingQualityType> rqtList = orders.getReadingQualityType();
			for (ReadingQualityType reqRqt : rqtList) {
				com.sixthc.hbm.ReadingQualityType rqt = new com.sixthc.hbm.ReadingQualityType();
				rqt.setCategory(reqRqt.getCategory());
				rqt.setMrid(reqRqt.getMRID());
				rqt.setSubCategory(reqRqt.getSubCategory());
				rqt.setSubCategory(reqRqt.getSystemId());
				rqt.setSystemId(reqRqt.getSystemId());
				rqt.setMaintorder(so);
				List<ReadingQualityTypeNames> rqtNames = parseReadingQualityTypeNames(reqRqt
						.getNames());
				for (ReadingQualityTypeNames n : rqtNames) {
					n.setReadingQualityType(rqt);
					rqt.getReadingQualityTypeNameses().add(n);
				}
				so.getReadingQualityTypes().add(rqt);
			}

			List<com.sixthc.cim.createServiceOrders.ServiceOrders.ReadingType> readList = orders
					.getReadingType();
			for (com.sixthc.cim.createServiceOrders.ServiceOrders.ReadingType reqRead : readList) {
				com.sixthc.hbm.ReadingType rt = new com.sixthc.hbm.ReadingType();
				rt.setMrid(reqRead.getMRID());
				rt.setAccumulation(reqRead.getAccumulation());
				rt.setAggregate(reqRead.getAggregate());
				rt.setArgumentDenom(reqRead.getArgument().getDenominator()
						.doubleValue());
				rt.setArgumentNumer(reqRead.getArgument().getNumerator()
						.doubleValue());
				rt.setCommodity(reqRead.getCommodity());
				rt.setConsumptionTier(reqRead.getConsumptionTier()
						.doubleValue());
				rt.setCpp(reqRead.getCpp().doubleValue());
				rt.setCurrency(reqRead.getCurrency());
				rt.setFlowDirection(reqRead.getFlowDirection());
				rt.setInterHDenom(reqRead.getInterharmonic().getDenominator()
						.doubleValue());
				rt.setInterHNumer(reqRead.getInterharmonic().getNumerator()
						.doubleValue());
				rt.setMacroPeriod(reqRead.getMacroPeriod());
				rt.setMeasurementKind(reqRead.getMeasurementKind());
				rt.setMultiplier(reqRead.getMultiplier());
				rt.setPhases(reqRead.getPhases());
				rt.setTou(reqRead.getTou().doubleValue());
				rt.setUnit(reqRead.getUnit());
				so.getReadingTypes().add(rt);

			}

			List<MaintorderNames> nlist = parseMaintorderNames(req.getNames());
			for (MaintorderNames names : nlist) {
				names.setMaintorder(so);
				so.getMaintorderNameses().add(names);
			}

			System.out.println("Service Order mRID: " + so.getMrid());
			if (req.getMRID() != null) {
				numErrors++;
				System.out
						.println("Error - createOrder, but Work.MRID specified: "
								+ req.getMRID());
				ErrorType et = new ErrorType();
				et.setCode("6.1");
				et.setLevel("FATAL");
				et.setDetails("Request cancelled per business rule. MRID cannot be specified when creating service order");
				ID id = new ID();
				id.setIdType("Service Order Number");
				id.setIdAuthority("Utility XYZ");
				id.setKind(IDKindType.NAME);
				id.setObjectType("ServiceOrder");
				et.setID(id);
				if (so.getMaintorderNameses().size() > 0) {
					for (MaintorderNames n : so.getMaintorderNameses()) {
						id.setValue(n.getName());
						break;
					}
				} else {
					id.setValue("NOT SET");
				}
				reply.value.getError().add(et);
				continue; // stop processing THIS order
			}

			// will return the mrid in the payload back to caller
			req.setMRID(uuid.toString());

			// no organization in this type

			for (Work2 reqWork : req.getWork()) {
				numOrders++;
				System.out.println("numOrders: " + numOrders + " mRID: "
						+ reqWork.getMRID());

				WorkOrder workOrder = new WorkOrder();
				so.getWorkOrders().add(workOrder);
				workOrder.setMaintorder(so);

				if (reqWork.getActivityRecords() != null
						&& reqWork.getActivityRecords().size() > 0) {
					ActivityRecord2 rec = reqWork.getActivityRecords().get(0);
					if (rec.getReason() != null)
						workOrder.setReason(rec.getReason());
					if (rec.getSeverity() != null)
						workOrder.setSeverity(rec.getSeverity());
					if (rec.getType() != null)
						workOrder.setOrderType(rec.getType());
				}

				UUID workOrderUUID = UUID.randomUUID();
				workOrder.setMrid(workOrderUUID.toString());
				reqWork.setMRID(uuid.toString()); // overwrite MRID
				workOrder.setCreatedBy("WMS");
				workOrder.setKind(reqWork.getKind() != null ? reqWork.getKind()
						.value() : "Not Set");

				Timestamp workUpdatedDateTime = DateUtil.parseDate(reqWork
						.getLastModifiedDateTime());
				if (workUpdatedDateTime != null)
					workOrder.setUpdatedAt(workUpdatedDateTime);

				reqWork.getLastModifiedDateTime();
				//workOrder.setWorkOrderName("NOT SET"); // leave null
				workOrder.setStatus("ACTIVE");

				for (WorkTimeSchedule2 reqWorkSchedules : reqWork
						.getTimeSchedules()) {
					WorkOrderSchedule workOrderSchedule = new WorkOrderSchedule();
					workOrder.getWorkOrderSchedules().add(workOrderSchedule);
					workOrderSchedule.setWorkOrder(workOrder);
					com.sixthc.hbm.TimeSchedule ts = new com.sixthc.hbm.TimeSchedule();
					workOrderSchedule.setTimeSchedule(ts);
					ts.getWorkOrderSchedules().add(workOrderSchedule);
					ScheduleInterval reqTimeInterval = reqWorkSchedules
							.getScheduleInterval();

					Timestamp start = DateUtil.parseDate(reqTimeInterval
							.getStart());
					if (start != null)
						ts.setStartTstamp(start);
					Timestamp end = DateUtil
							.parseDate(reqTimeInterval.getEnd());
					if (end != null)
						ts.setEndTstamp(end);
					workOrderSchedule.setTimeSchedule(ts);
					if (reqWorkSchedules.getKind() != null)
						ts.setType(reqWorkSchedules.getKind().value());
				}

				for (Name2 reqName : reqWork.getNames()) {
					WorkOrderNames workOrderNames = new WorkOrderNames();
					workOrderNames.setName(reqName.getName());
					workOrder.getWorkOrderNameses().add(workOrderNames);
					workOrderNames.setWorkOrder(workOrder);

					com.sixthc.hbm.Nametype workOrderNameType = parseNameType(reqName
							.getNameType());
					if (workOrderNameType != null) {
						workOrderNames.setNametype(workOrderNameType);
						workOrderNameType.getWorkOrderNameses().add(
								workOrderNames);
					}
				}

				Priority priority = reqWork.getPriority();
				if (priority != null) {
					if (priority.getRank() != null)
						workOrder
								.setPriorityRank(priority.getRank().intValue());
					workOrder.setPriorityJustification(priority
							.getJustification());
					workOrder.setPriorityType(priority.getType());
				}

				Timestamp reqDateTime = DateUtil.parseDate(reqWork
						.getRequestDateTime());
				if (reqDateTime != null)
					workOrder.setRequestDatetime(reqDateTime);

				workOrder.setStatusKind(reqWork.getStatusKind().value());
				workOrder.setStatus(workOrder.getStatus());

				WorkLocation2 reqLoc = reqWork.getWorkLocation();
				if (reqLoc != null) {
					// reqLoc.getMRID(); //  bb: ignore

					TelephoneNumber phone1 = reqLoc.getPhone1();
					if (phone1 != null) {
						workOrder.setPhone1AreaCode(phone1.getAreaCode());
						workOrder.setPhone1CityCode(phone1.getCityCode());
						workOrder.setPhone1CountryCode(phone1.getCountryCode());
						workOrder.setPhone1Extension(phone1.getExtension());
						workOrder.setPhone1LocalNumber(phone1.getLocalNumber());
					}

					for (AssetLocationHazard2 reqHazard : reqLoc.getHazards()) {
						Hazards hazards = new Hazards();
						hazards.setHazardName(reqHazard.getType());
						WorkOrderHazards workOrderHazards = new WorkOrderHazards();

						workOrderHazards.setHazards(hazards);
						workOrderHazards.setWorkOrder(workOrder);
						workOrder.getWorkOrderHazardses().add(workOrderHazards);
					}

					InternalLocation2 iloc = reqLoc.getInternalLocation();
					if (iloc != null) {
						workOrder.setInternalBuildingName(iloc
								.getBuildingName());
						workOrder.setInternalBuildingNum(iloc
								.getBuildingNumber());
						workOrder.setInternalFloor(iloc.getFloor());
						workOrder.setInternalRoomNum(iloc.getRoomNumber());
					}

					com.sixthc.cim.createServiceOrders.WorkLocation2.MainAddress reqMaddr = reqLoc
							.getMainAddress();
					if (reqMaddr != null) {
						Address address = new Address();

						address.getAddressWorkorders().add(workOrder);
						workOrder.setAddress(address);

						address.setDirections(reqLoc.getDirection());
						CoordinateSystem coordSystem = reqLoc
								.getCoordinateSystem();
						if (coordSystem != null) {
							address.setCoordSystem(coordSystem.getCrsUrn());
						}
						parseStreetDetail2(address, reqMaddr);

						// Status mstatus = reqMaddr.getStatus(); // ignore

					}

					for (PositionPoints p : reqLoc.getPositionPoints()) {
						WorkPositionPoints workPoints = new WorkPositionPoints();
						try {
							workPoints.setZposition(Integer.valueOf(p
									.getZPosition()));
							workPoints.setXposition(Integer.valueOf(p
									.getXPosition()));
							workPoints.setYposition(Integer.valueOf(p
									.getYPosition()));
							workPoints.setSequenceNum(p.getSequenceNumber()
									.intValue());
						} catch (NumberFormatException nfe) {
							log.error("position value ignored, not number");
							throw new ConstraintException(
									"address position points : non integer value passed");
						}
						workOrder.getWorkPositionPointses().add(workPoints);
						workPoints.setWorkOrder(workOrder);
					}
				}

				for (WorkTask reqTask : reqWork.getWorkTasks()) {
					com.sixthc.hbm.WorkTask workTask = new com.sixthc.hbm.WorkTask();
					WorkOrderWorkTasks workOrderWorkTasks = new WorkOrderWorkTasks();
					workOrderWorkTasks.setWorkTask(workTask);
					workOrderWorkTasks.setWorkOrder(workOrder);
					workTask.getWorkOrderWorkTaskses().add(workOrderWorkTasks);
					workOrder.getWorkOrderWorkTaskses().add(workOrderWorkTasks);

					for (Asset2 reqAsset : reqTask.getAssets()) {
						WorkTaskAssets workTaskAssets = new WorkTaskAssets();
						com.sixthc.hbm.Asset workAsset = parseAsset(reqAsset);
						workTaskAssets.setAsset(workAsset);
						workTask.getWorkTaskAssetses().add(workTaskAssets);
						workTaskAssets.setWorkTask(workTask);
						workAsset.setMrid(reqAsset.getMRID());
						workTaskAssets.setCreatedAt(new Date(System
								.currentTimeMillis())); // use current time

					}

					Timestamp reqCrewEta = DateUtil.parseDate(reqTask
							.getCrewETA());
					if (reqCrewEta != null)
						if (reqDateTime != null)
							workTask.setCrewEta(reqCrewEta);

					for (Crew2 reqCrew : reqTask.getCrews()) {
						WorkTaskCrews workCrews = new WorkTaskCrews();
						workTask.getWorkTaskCrewses().add(workCrews);
						workCrews.setWorkTask(workTask);
						com.sixthc.hbm.Crew workCrew = new com.sixthc.hbm.Crew();
						workCrews.setCrew(workCrew);
						workCrew.setMrid(reqCrew.getMRID());

						parseCrewNames(reqCrew.getNames());

						List<com.sixthc.hbm.CrewNames> namesList = parseCrewNames(reqCrew
								.getNames());
						for (CrewNames crewNames : namesList) {
							workCrew.getCrewNameses().add(crewNames);
							crewNames.setCrew(workCrew);
						}

						for (CrewMember reqCrewMember : reqCrew
								.getCrewMembers()) {
							Person reqPerson = reqCrewMember.getPerson();

							CrewContactpersons persons = new CrewContactpersons();
							persons.setCrew(workCrew);
							workCrew.getContactPersons().add(persons);

							Contactperson person = new Contactperson();
							person.setFirstname(reqPerson.getFirstName());
							person.setLastname(reqPerson.getLastName());

							persons.setContactperson(person);
							person.getCrewContactpersons().add(persons);
						}
					}

					workTask.setInstructions(reqTask.getInstruction());

					workTask.setMrid(reqTask.getMRID());
					workTask.setStatusKind(reqTask.getStatusKind().value());

					for (WorkTaskNames workTaskNames : parseWorkTaskNames(reqTask
							.getNames())) {
						workTaskNames.setWorkTask(workTask);
						workTask.getWorkTaskNameses().add(workTaskNames);
					}

					if (reqTask.getOldAsset() != null) {
						com.sixthc.hbm.Asset oldAsset = parseAsset(reqTask
								.getOldAsset());
						com.sixthc.hbm.WorkTaskOldAssets workTaskOldAssets = new WorkTaskOldAssets();

						workTaskOldAssets.setAsset(oldAsset);
						oldAsset.getWorkTaskOldAssetses()
								.add(workTaskOldAssets);

						workTaskOldAssets.setWorkTask(workTask);
						workTask.getWorkTaskOldAssetses()
								.add(workTaskOldAssets);

						workTaskOldAssets.setCreatedAt(new Date(System
								.currentTimeMillis()));
					}

					// reqTask.getStatusKind(); // ignore
					if (reqTask.getTaskKind() != null)
						workTask.setTaskType(reqTask.getTaskKind().value());

					workTask.setSubject(reqTask.getSubject());

					for (WorkTimeSchedule2 reqTaskSchedule : reqTask
							.getTimeSchedules()) {
						WorkTaskTimeSchedules workTaskSchedule = new WorkTaskTimeSchedules();
						workTask.getWorkTaskTimeScheduleses().add(
								workTaskSchedule);
						workTaskSchedule.setWorkTask(workTask);
						com.sixthc.hbm.TimeSchedule ts = new com.sixthc.hbm.TimeSchedule();
						workTaskSchedule.setTimeSchedule(ts);
						ts.getWorkTaskTimeScheduleses().add(workTaskSchedule);
						ScheduleInterval reqTimeInterval = reqTaskSchedule
								.getScheduleInterval();

						Timestamp start = DateUtil.parseDate(reqTimeInterval
								.getStart());
						if (start != null)
							ts.setStartTstamp(start);
						Timestamp end = DateUtil.parseDate(reqTimeInterval
								.getEnd());
						if (end != null)
							ts.setEndTstamp(end);
						workTaskSchedule.setTimeSchedule(ts);
						if (reqTaskSchedule.getKind() != null)
							ts.setType(reqTaskSchedule.getKind().value());

					}
				}

				if (reqWork.getAttachments() != null) {
					for (com.sixthc.cim.createServiceOrders.Attachment reqAtt : reqWork
							.getAttachments().getAttachment()) {

						try {
							log.debug("attachment : "
									+ reqAtt.getUrl().toString());
							String file = UUID.randomUUID().toString();
							String uri = reqAtt.getUrl();

							Attachment attachment = new Attachment();
							attachment.setComment(reqAtt.getComment());
							attachment.setDescription(reqAtt.getDescription());
							String fileExt = ImageLoader
									.DetermineFileExtension(uri);
							attachment.setFilename(file + "." + fileExt);
							attachment.setType(ImageLoader
									.DetermineAttachmentType(uri));

							ImageLoader.getImage(uri, attachment.getFilename());

							WorkOrderAttachments woa = new WorkOrderAttachments();
							woa.setAttachment(attachment);
							attachment.setWorkOrderAttachmentses(workOrder
									.getWorkOrderAttachmentses());
							woa.setWorkOrder(workOrder);
							workOrder.getWorkOrderAttachmentses().add(woa);
						} catch (ImageLoadFileException e) {
							log.debug("attachment : failed to download image");
							log.error(e);

							ErrorType et = new ErrorType();
							et.setCode("8.1");
							et.setCode("WARNING");
							et.setDetails("failed to load image from url : "
									+ reqAtt);
							ID id = new ID();
							id.setIdType("Work Attachment Image");
							id.setIdAuthority("Utility XYZ");
							id.setKind(IDKindType.NAME);
							id.setObjectType("Work");
							et.setID(id);
							if (so.getMaintorderNameses().size() > 0) {
								for (MaintorderNames n : so
										.getMaintorderNameses()) {
									id.setValue(n.getName());
									break;
								}
							} else {
								id.setValue("NOT SET");
							}
							reply.value.getError().add(et);
						}

					}
				}
				workOrderDao.save(workOrder);
			}
		}
		if (numErrors > 0) {
			if (numErrors == numOrders) {
				reply.value.setResult("Failed");
			} else {
				reply.value.setResult("Partial");
			}

		} else if (imageFileProcessingError == true) {
			reply.value.setResult("Partial");
		} else {
			reply.value.setResult("OK");
		}

	}

}

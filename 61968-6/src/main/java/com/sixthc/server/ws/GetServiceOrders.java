package com.sixthc.server.ws;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.cim.getMaintenanceOrders.Asset2.Procedures;
import com.sixthc.cim.getMaintenanceOrders.Asset2.Procedures.Measurements;
import com.sixthc.cim.getMaintenanceOrders.Organisation2;
import com.sixthc.cim.getMaintenanceOrders.Organisation2.Phone1;
import com.sixthc.cim.getMaintenanceOrders.PhaseCode;
import com.sixthc.cim.getMaintenanceOrders.ProcedureKind;
import com.sixthc.cim.getServiceOrders.ActivityRecord2;
import com.sixthc.cim.getServiceOrders.Asset2;
import com.sixthc.cim.getServiceOrders.AssetLocationHazard2;
import com.sixthc.cim.getServiceOrders.Attachment;
import com.sixthc.cim.getServiceOrders.Crew2;
import com.sixthc.cim.getServiceOrders.CrewMember;
import com.sixthc.cim.getServiceOrders.CrewMember.Person;
import com.sixthc.cim.getServiceOrders.InternalLocation2;
import com.sixthc.cim.getServiceOrders.Name2;
import com.sixthc.cim.getServiceOrders.NameType2;
import com.sixthc.cim.getServiceOrders.NameTypeAuthority2;
import com.sixthc.cim.getServiceOrders.ReplyType;
import com.sixthc.cim.getServiceOrders.ServiceOrders;
import com.sixthc.cim.getServiceOrders.StreetAddress;
import com.sixthc.cim.getServiceOrders.TownDetail;
import com.sixthc.cim.getServiceOrders.Work2;
import com.sixthc.cim.getServiceOrders.Work2.Attachments;
import com.sixthc.cim.getServiceOrders.Work2.Priority;
import com.sixthc.cim.getServiceOrders.WorkAsset;
import com.sixthc.cim.getServiceOrders.WorkKind1;
import com.sixthc.cim.getServiceOrders.WorkLocation2;
import com.sixthc.cim.getServiceOrders.WorkLocation2.MainAddress;
import com.sixthc.cim.getServiceOrders.WorkLocation2.PositionPoints;
import com.sixthc.cim.getServiceOrders.WorkStatusKind2;
import com.sixthc.cim.getServiceOrders.WorkTask;
import com.sixthc.cim.getServiceOrders.WorkTaskKind;
import com.sixthc.cim.getServiceOrders.WorkTimeSchedule2;
import com.sixthc.cim.getServiceOrders.WorkTimeSchedule2.ScheduleInterval;
import com.sixthc.cim.getServiceOrders.WorkTimeScheduleKind2;
import com.sixthc.cim.getServiceOrders.cxf.GetServiceOrdersFaultMessage;
import com.sixthc.cim.getServiceOrders.cxf.GetServiceOrdersPort;
import com.sixthc.cim.getServiceOrders.cxf.GetServiceOrdersRequestMessageType;
import com.sixthc.cim.getServiceOrders.cxf.GetServiceOrdersResponseMessageType;
import com.sixthc.cim.getServiceOrders.cxf.ServiceOrder;
import com.sixthc.cim.getServiceOrders.cxf.ServiceOrdersPayloadType;
import com.sixthc.dao.MaintOrderDao;
import com.sixthc.hbm.Address;
import com.sixthc.hbm.AddressPositionPoints;
import com.sixthc.hbm.AssetNames;
import com.sixthc.hbm.AssetProcedures;
import com.sixthc.hbm.Contactperson;
import com.sixthc.hbm.CrewAssets;
import com.sixthc.hbm.CrewContactpersons;
import com.sixthc.hbm.CrewNames;
import com.sixthc.hbm.Hazards;
import com.sixthc.hbm.Maintorder;
import com.sixthc.hbm.MaintorderNames;
import com.sixthc.hbm.Measurement;
import com.sixthc.hbm.Nametype;
import com.sixthc.hbm.Organization;
import com.sixthc.hbm.OrganizationNames;
import com.sixthc.hbm.Phone;
import com.sixthc.hbm.Procedure;
import com.sixthc.hbm.ProcedureMeasurements;
import com.sixthc.hbm.TimeSchedule;
import com.sixthc.hbm.WorkOrder;
import com.sixthc.hbm.WorkOrderAttachments;
import com.sixthc.hbm.WorkOrderHazards;
import com.sixthc.hbm.WorkOrderNames;
import com.sixthc.hbm.WorkOrderOrganizations;
import com.sixthc.hbm.WorkOrderSchedule;
import com.sixthc.hbm.WorkOrderWorkTasks;
import com.sixthc.hbm.WorkPositionPoints;
import com.sixthc.hbm.WorkTaskAssets;
import com.sixthc.hbm.WorkTaskCrews;
import com.sixthc.hbm.WorkTaskTimeSchedules;
import com.sixthc.util.DateUtil;

public class GetServiceOrders implements GetServiceOrdersPort{
	static Logger log = Logger.getLogger(GetServiceOrders.class);
	
	@Autowired
	private MaintOrderDao maintOrderDao;

	public void setPhone1(Phone from, Organisation2.Phone1 to) {
		if (from == null)
			return;
		to.setAreaCode(from.getAreacode());
		to.setCityCode(from.getCitycode());
		to.setCountryCode(from.getCountrycode());
		to.setExtension(from.getExtension());
		to.setLocalNumber(from.getLocalnumber());
	}

	private void setAddress1(Address from, StreetAddress to) {
		if (from == null)
			return;
		com.sixthc.cim.getServiceOrders.StreetDetail sd = new com.sixthc.cim.getServiceOrders.StreetDetail();
		to.setStreetDetail(sd);
		sd.setAddressGeneral(from.getSdAddress1());
		sd.setBuildingName(from.getSdBuildingName());
		sd.setCode(from.getSdCode());
		sd.setName(from.getSdAddress2());
		sd.setNumber(from.getSdNumber());
		sd.setPrefix(from.getSdPrefix());
		sd.setSuffix(from.getSdSuffix());
		sd.setSuiteNumber(from.getSdSuiteNumber());
		sd.setType(from.getSdType());
		sd.setWithinTownLimits(from.getSdWithinTownLimitsFlag() == 1 ? true
				: false);

		TownDetail td = new TownDetail();
		to.setTownDetail(td);
		td.setCode(from.getTdCode());
		td.setCountry(from.getTdCountry());
		td.setName(from.getTdName());
		td.setSection(from.getTdSection());
		td.setStateOrProvince(from.getTdStateProvince());
	}

	private void setMainAddress(Address from, MainAddress to) {
		com.sixthc.cim.getServiceOrders.WorkLocation2.MainAddress.StreetDetail sd = new com.sixthc.cim.getServiceOrders.WorkLocation2.MainAddress.StreetDetail();
		to.setStreetDetail(sd);
		sd.setAddressGeneral(from.getSdAddress1());
		sd.setBuildingName(from.getSdBuildingName());
		sd.setCode(from.getSdCode());
		sd.setName(from.getSdAddress2());
		sd.setNumber(from.getSdNumber());
		sd.setPrefix(from.getSdPrefix());
		sd.setSuffix(from.getSdSuffix());
		sd.setSuiteNumber(from.getSdSuiteNumber());
		sd.setType(from.getSdType());
		sd.setWithinTownLimits(from.getSdWithinTownLimitsFlag() == 1 ? true
				: false);

		com.sixthc.cim.getServiceOrders.WorkLocation2.MainAddress.TownDetail td = new com.sixthc.cim.getServiceOrders.WorkLocation2.MainAddress.TownDetail();
		to.setTownDetail(td);
		to.setTownDetail(td);
		td.setCode(from.getTdCode());
		td.setCountry(from.getTdCountry());
		td.setName(from.getTdName());
		td.setSection(from.getTdSection());
		td.setStateOrProvince(from.getTdStateProvince());

	}

	private void setMaintOrderNames(MaintorderNames from, Name2 to) {
		to.setName(from.getName());

		if (from.getNametype() != null) {
			Nametype moNameType = from.getNametype();
			NameType2 respNameType = new NameType2();
			respNameType.setDescription(moNameType.getDescription());
			respNameType.setName(moNameType.getName());
			to.setNameType(respNameType);
			if (moNameType.getNameTypeAuthority() != null) {

				com.sixthc.hbm.NameTypeAuthority moNameTypeAuthority = moNameType
						.getNameTypeAuthority();
				NameTypeAuthority2 respNTA = new NameTypeAuthority2();
				respNameType.setNameTypeAuthority(respNTA);
				respNTA.setDescription(moNameTypeAuthority.getDescription());
				respNTA.setName(moNameTypeAuthority.getName());
			}
		}
	}

	private void setMaintOrderOrgNames(OrganizationNames moNames, com.sixthc.cim.getMaintenanceOrders.Name2 to) {
		to.setName(moNames.getName());

		if (moNames.getNametype() != null) {
			Nametype moNameType = moNames.getNametype();
			com.sixthc.cim.getMaintenanceOrders.NameType2 respNameType = new com.sixthc.cim.getMaintenanceOrders.NameType2();
			respNameType.setDescription(moNameType.getDescription());
			respNameType.setName(moNameType.getName());
			to.setNameType(respNameType);
			if (moNameType.getNameTypeAuthority() != null) {
				com.sixthc.hbm.NameTypeAuthority moNameTypeAuthority = moNameType
						.getNameTypeAuthority();
				com.sixthc.cim.getMaintenanceOrders.NameTypeAuthority2 respNTA = new com.sixthc.cim.getMaintenanceOrders.NameTypeAuthority2();
				respNameType.setNameTypeAuthority(respNTA);
				respNTA.setDescription(moNameTypeAuthority.getDescription());
				respNTA.setName(moNameTypeAuthority.getName());
			}
		}
	}

	private void setWorkOrderNames(WorkOrderNames moWorkOrderNames, Name2 to) {
		to.setName(moWorkOrderNames.getName());

		if (moWorkOrderNames.getNametype() != null) {
			Nametype moNameType = moWorkOrderNames.getNametype();
			NameType2 respNameType = new NameType2();
			respNameType.setDescription(moNameType.getDescription());
			respNameType.setName(moNameType.getName());
			to.setNameType(respNameType);
			if (moNameType.getNameTypeAuthority() != null) {
				com.sixthc.hbm.NameTypeAuthority moNameTypeAuthority = moNameType
						.getNameTypeAuthority();
				NameTypeAuthority2 respNTA = new NameTypeAuthority2();
				respNameType.setNameTypeAuthority(respNTA);
				respNTA.setDescription(moNameTypeAuthority.getDescription());
				respNTA.setName(moNameTypeAuthority.getName());
			}
		}
	}

	private void setAssetNames(AssetNames assetNames, Name2 to) {
		to.setName(assetNames.getName());

		if (assetNames.getNametype() != null) {
			Nametype moNameType = assetNames.getNametype();
			NameType2 respNameType = new NameType2();
			respNameType.setDescription(moNameType.getDescription());
			respNameType.setName(moNameType.getName());
			to.setNameType(respNameType);
			if (moNameType.getNameTypeAuthority() != null) {
				com.sixthc.hbm.NameTypeAuthority moNameTypeAuthority = moNameType
						.getNameTypeAuthority();
				NameTypeAuthority2 respNTA = new NameTypeAuthority2();
				respNameType.setNameTypeAuthority(respNTA);
				respNTA.setDescription(moNameTypeAuthority.getDescription());
				respNTA.setName(moNameTypeAuthority.getName());
			}
		}
	}

	private void setCrewNames(CrewNames assetNames, Name2 to) {
		to.setName(assetNames.getName());

		if (assetNames.getNametype() != null) {
			Nametype moNameType = assetNames.getNametype();
			NameType2 respNameType = new NameType2();
			respNameType.setDescription(moNameType.getDescription());
			respNameType.setName(moNameType.getName());
			to.setNameType(respNameType);
			if (moNameType.getNameTypeAuthority() != null) {
				com.sixthc.hbm.NameTypeAuthority moNameTypeAuthority = moNameType
						.getNameTypeAuthority();
				NameTypeAuthority2 respNTA = new NameTypeAuthority2();
				respNameType.setNameTypeAuthority(respNTA);
				respNTA.setDescription(moNameTypeAuthority.getDescription());
				respNTA.setName(moNameTypeAuthority.getName());
			}
		}
	}

	private void setAsset(com.sixthc.hbm.Asset from, Asset2 to) {
		to.setMRID(from.getMrid());
		to.setCritical(from.getCriticalFlag() == 1 ? true : false);
		to.setUtcNumber(from.getUtcNumber());

		WorkLocation2 toWorkloc = new WorkLocation2();

		for (AssetNames assetNames : from.getAssetNameses()) {
			Name2 toAsset = new Name2();
			setAssetNames(assetNames, toAsset);
			toWorkloc.getNames().add(toAsset);
		}

		if (from.getInternalBuildingNumber() != null
				&& from.getInternalFloor() != null
				&& from.getInternalRoomNumber() != null) {
			InternalLocation2 toInternalLoc = new InternalLocation2();
			toWorkloc.setInternalLocation(toInternalLoc);
			toInternalLoc.setBuildingName(from.getInternalBuildingName());
			toInternalLoc.setBuildingNumber(from.getInternalBuildingNumber());
			toInternalLoc.setFloor(from.getInternalFloor());
			toInternalLoc.setRoomNumber(from.getInternalRoomNumber());
		}
	}

	private boolean isSet(String s) {
		return (s != null && s.length() > 0);
	}

	private void setWorkAsset(com.sixthc.hbm.Asset from, WorkAsset to) {
		to.setMRID(from.getMrid());
		to.setCritical(from.getCriticalFlag() == 1 ? true : false);
		to.setUtcNumber(from.getUtcNumber());

		WorkLocation2 toWorkloc = new WorkLocation2();

		for (AssetNames assetNames : from.getAssetNameses()) {
			Name2 toAsset = new Name2();
			setAssetNames(assetNames, toAsset);
			toWorkloc.getNames().add(toAsset);
		}

		if (from.getInternalBuildingNumber() != null
				&& from.getInternalFloor() != null
				&& from.getInternalRoomNumber() != null) {
			InternalLocation2 toInternalLoc = new InternalLocation2();
			toWorkloc.setInternalLocation(toInternalLoc);
			toInternalLoc.setBuildingName(from.getInternalBuildingName());
			toInternalLoc.setBuildingNumber(from.getInternalBuildingNumber());
			toInternalLoc.setFloor(from.getInternalFloor());
			toInternalLoc.setRoomNumber(from.getInternalRoomNumber());
		}
	}

	@Override
	public GetServiceOrdersResponseMessageType getServiceOrders(
			GetServiceOrdersRequestMessageType getServiceOrdersRequestMessage)
			throws GetServiceOrdersFaultMessage {

		GetServiceOrdersResponseMessageType resp = new GetServiceOrdersResponseMessageType();
		ServiceOrdersPayloadType payload = new ServiceOrdersPayloadType();
		resp.setPayload(payload);
		ServiceOrders respServiceOrders = new ServiceOrders();
		resp.setHeader(getServiceOrdersRequestMessage.getHeader());
		ReplyType reply = new ReplyType();
		resp.setReply(reply);

		for (ServiceOrder reqMaint : getServiceOrdersRequestMessage
				.getRequest().getGetServiceOrders().getServiceOrder()) {

			String lookupString = reqMaint.getMRID();
			List<Maintorder> maintOrders;
			if (lookupString == null || lookupString.length() == 0)
				maintOrders = maintOrderDao.findAll();
			else {
				maintOrders = new Vector<Maintorder>();
				maintOrders.add(maintOrderDao.find(lookupString));
			}

			/*
			 * because we can get an empty search string, we might return
			 * multiple maint orders
			 */
			for (Maintorder mo : maintOrders) {

				if (mo == null) {
					// error;
					continue;
				}

				// set maint order names
				com.sixthc.cim.getServiceOrders.ServiceOrder respSo = new com.sixthc.cim.getServiceOrders.ServiceOrder();
				respServiceOrders.getServiceOrder().add(respSo);
				respSo.setMRID(mo.getMrid());
				System.out.println("mo count : "
						+ mo.getMaintorderNameses().size());
				for (MaintorderNames moName : mo.getMaintorderNameses()) {
					Name2 respName = new Name2();
					respSo.getNames().add(respName);
					setMaintOrderNames(moName, respName);
				}

				/*
				 * currently we store the single ORG with each work order,
				 * design
				 * flaw. So we
				 * are going to get it from the first work order and place in
				 * maintOrder.org
				 */
				if (!mo.getWorkOrders().isEmpty()) {
					WorkOrder moOrgWorkOrder = mo.getWorkOrders().toArray(
							new WorkOrder[1])[0];
					for (WorkOrderOrganizations moOrg : moOrgWorkOrder
							.getWorkOrderOrganizations()) {
						Organization moOrg2 = moOrg.getOrganization();
						Organisation2 respOrg = new Organisation2();
						if (moOrg2.getAddress() != null
								|| moOrg2.getPhone() != null) {

							if (moOrg2.getPhone() != null) {
								Phone1 phone = new Phone1();
								respOrg.setPhone1(phone);
								setPhone1(moOrg2.getPhone(), phone);
							}
							respOrg.setMRID(moOrg2.getMrid());
							// set maint order org names
							for (OrganizationNames moNames : moOrg2
									.getOrganizationNameses()) {
								com.sixthc.cim.getMaintenanceOrders.Name2 respName = new com.sixthc.cim.getMaintenanceOrders.Name2();
								respOrg.getNames().add(respName);
								setMaintOrderOrgNames(moNames, respName);
							}
						}
					}
				}

				for (WorkOrder moWorkOrder : mo.getWorkOrders()) {
					Work2 respWorkOrder = new Work2();
					respSo.getWork().add(respWorkOrder);
					

					if( moWorkOrder.getWorkOrderAttachmentses().size() > 0 ) {
						respWorkOrder.setAttachments(new Attachments());
						for( WorkOrderAttachments att : moWorkOrder.getWorkOrderAttachmentses()) {
							Attachment a = new Attachment();
							a.setComment(att.getAttachment().getComment());
							a.setDescription(att.getAttachment().getDescription());
							a.setUrl(att.getAttachment().getFilename());
							respWorkOrder.getAttachments().getAttachment().add(a);
						}
					}


					respWorkOrder.setMRID(moWorkOrder.getMrid());

					// TODO : Missing activityRecords

					// work order names
					for (WorkOrderNames moWorkOrderNames : moWorkOrder
							.getWorkOrderNameses()) {
						Name2 respName2 = new Name2();
						respWorkOrder.getNames().add(respName2);
						setWorkOrderNames(moWorkOrderNames, respName2);
					}
					respWorkOrder.setKind(WorkKind1.fromValue(moWorkOrder
							.getKind()));
					respWorkOrder.setLastModifiedDateTime(DateUtil
							.getXMLDate(moWorkOrder.getUpdatedAt()));

					Priority respPriority = new Priority();
					respPriority.setJustification(moWorkOrder
							.getPriorityJustification());
					if (moWorkOrder.getPriorityRank() != null) {
						respPriority.setRank(BigInteger.valueOf(moWorkOrder
								.getPriorityRank()));
						respPriority.setType(moWorkOrder.getPriorityType());
						respWorkOrder.setPriority(respPriority);
					}

					respWorkOrder.setRequestDateTime(DateUtil
							.getXMLDate(new Date(System.currentTimeMillis())));
					respWorkOrder.setStatusKind(WorkStatusKind2
							.fromValue(moWorkOrder.getStatusKind()));

					WorkLocation2 respLoc = new WorkLocation2();
					respWorkOrder.setWorkLocation(respLoc);

					if (moWorkOrder.getCreatedAt() != null
							&& isSet(moWorkOrder.getReason())
							|| isSet(moWorkOrder.getSeverity())
							|| isSet(moWorkOrder.getOrderType())) {
						ActivityRecord2 ar = new ActivityRecord2();
						respWorkOrder.getActivityRecords().add(ar);
						if (isSet(moWorkOrder.getReason()))
							ar.setReason(moWorkOrder.getReason());
						if (isSet(moWorkOrder.getSeverity()))
							ar.setSeverity(moWorkOrder.getSeverity());
						if (isSet(moWorkOrder.getOrderType()))
							ar.setType(moWorkOrder.getOrderType());
						ar.setCreatedDateTime(DateUtil.getXMLDate(moWorkOrder
								.getCreatedAt()));
					}

					//respWorkOrder.setWorkLocation(respLoc);
					for (WorkOrderHazards moHaz : moWorkOrder
							.getWorkOrderHazardses()) {
						AssetLocationHazard2 respHaz = new AssetLocationHazard2();
						Hazards moHaz2 = moHaz.getHazards();
						moHaz2.getHazardName();
						respHaz.setType(moHaz2.getHazardName());

						respLoc.getHazards().add(respHaz);

					}

					for (WorkOrderSchedule moSched : moWorkOrder
							.getWorkOrderSchedules()) {
						WorkTimeSchedule2 respSched = new WorkTimeSchedule2();
						respWorkOrder.getTimeSchedules().add(respSched);
						respSched
								.setKind(WorkTimeScheduleKind2
										.fromValue(moSched.getTimeSchedule()
												.getType()));
						ScheduleInterval respSI = new ScheduleInterval();
						respSched.setScheduleInterval(respSI);
						TimeSchedule moS = moSched.getTimeSchedule();
						respSI.setStart(DateUtil.getXMLDate(moS
								.getStartTstamp()));
						respSI.setEnd(DateUtil.getXMLDate(moS.getEndTstamp()));
					}

					if (moWorkOrder.getInternalBuildingNum() != null
							&& moWorkOrder.getInternalFloor() != null
							&& moWorkOrder.getInternalRoomNum() != null) {
						InternalLocation2 respIloc = new InternalLocation2();
						respLoc.setInternalLocation(respIloc);
						respIloc.setBuildingName(moWorkOrder
								.getInternalBuildingName());
						respIloc.setBuildingNumber(moWorkOrder
								.getInternalBuildingNum());
						respIloc.setFloor(moWorkOrder.getInternalFloor());
						respIloc.setRoomNumber(moWorkOrder.getInternalRoomNum());
					}

					Address moWorkOrderAddress = moWorkOrder.getAddress();
					if (moWorkOrderAddress != null) {
						MainAddress respMainAddr = new MainAddress();
						respLoc.setMainAddress(respMainAddr);
						respLoc.setDirection(moWorkOrderAddress.getDirections());
						//					CoordinateSystem cs = new CoordinateSystem();
						//					cs.setCrsUrn(moWorkOrderAddress.getCoordSystem());
						//					respLoc.setCoordinateSystem(cs);
						MainAddress ma = new MainAddress();
						setMainAddress(moWorkOrderAddress, ma);
						respLoc.setDirection(moWorkOrderAddress.getDirections());
						//respLoc.setMRID(null); // TODO : No mrid for work location
						respLoc.setMainAddress(ma);
					}

					for (WorkPositionPoints moPoints : moWorkOrder
							.getWorkPositionPointses()) {
						PositionPoints reqPos = new PositionPoints();
						reqPos.setSequenceNumber(BigInteger.valueOf(moPoints
								.getSequenceNum()));
						reqPos.setXPosition(moPoints.getXposition().toString());
						reqPos.setYPosition(moPoints.getYposition().toString());
						reqPos.setZPosition(moPoints.getZposition().toString());
						respLoc.getPositionPoints().add(reqPos);
					}

					for (WorkOrderWorkTasks moTasks : moWorkOrder
							.getWorkOrderWorkTaskses()) {
						WorkTask respWorkTask = new WorkTask();
						respWorkOrder.getWorkTasks().add(respWorkTask);
						com.sixthc.hbm.WorkTask moWorkTask = moTasks
								.getWorkTask();

						if (moWorkTask.getCrewEta() != null)
							respWorkTask.setCrewETA(DateUtil
									.getXMLDate(moWorkTask.getCrewEta()));
						respWorkTask.setInstruction(moWorkTask
								.getInstructions());
						respWorkTask.setMRID(moWorkTask.getMrid());
						respWorkTask.setStatusKind(WorkStatusKind2
								.fromValue(moWorkTask.getStatusKind()));
						respWorkTask.setSubject(moWorkTask.getSubject());
						if (moWorkTask.getTaskType() != null) {
							respWorkTask.setTaskKind(WorkTaskKind
									.fromValue(moWorkTask.getTaskType()));
						}

						for (WorkTaskCrews moCrews : moWorkTask
								.getWorkTaskCrewses()) {
							com.sixthc.hbm.Crew moCrew = moCrews.getCrew();
							Crew2 respCrew = new Crew2();
							respWorkTask.getCrews().add(respCrew);

							respCrew.setMRID(moCrew.getMrid());
							for (CrewNames moCrewNames : moCrew
									.getCrewNameses()) {
								Name2 name = new Name2();
								respCrew.getNames().add(name);
								setCrewNames(moCrewNames, name);
							}


							for (CrewContactpersons moContact : moCrew
									.getContactPersons()) {
								Contactperson moContactPerson = moContact
										.getContactperson();
								CrewMember respMember = new CrewMember();
								respCrew.getCrewMembers().add(respMember);
								Person respPerson = new Person();
								respMember.setPerson(respPerson);
								respPerson.setFirstName(moContactPerson
										.getFirstname());
								respPerson.setLastName(moContactPerson
										.getLastname());
							}

						}

						moWorkTask.getWorkTaskNameses();
						moWorkTask.getWorkTaskIdentifiedObjectses();
						moWorkTask.getWorkTaskOldAssetses();

						for (WorkTaskTimeSchedules moSchedule : moWorkTask
								.getWorkTaskTimeScheduleses()) {
							WorkTimeSchedule2 respSched = new WorkTimeSchedule2();
							respWorkTask.getTimeSchedules().add(respSched);
							respSched.setKind(WorkTimeScheduleKind2
									.fromValue(moSchedule.getTimeSchedule()
											.getType()));
							ScheduleInterval respSI = new ScheduleInterval();
							respSched.setScheduleInterval(respSI);
							TimeSchedule moS = moSchedule.getTimeSchedule();
							respSI.setStart(DateUtil.getXMLDate(moS
									.getStartTstamp()));
							respSI.setEnd(DateUtil.getXMLDate(moS
									.getEndTstamp()));
						}

						for (WorkTaskAssets moAsset : moWorkTask
								.getWorkTaskAssetses()) {

							Asset2 respAsset = new Asset2();
							respWorkTask.getAssets().add(respAsset);
							com.sixthc.hbm.Asset a2 = moAsset.getAsset();
							setAsset(a2, respAsset);
						}
					}
				}
			}

		}
		// if nothing found, then return an empty payload
		if (respServiceOrders.getServiceOrder().size() > 0) {
			log.debug(respServiceOrders.getServiceOrder().size()
					+ " maint orders are being returned");
			payload.setServiceOrders(respServiceOrders);
		} else
			log.debug("no maint orders found, returning empty payload");

		reply.setResult("OK");
		return resp;
	}

}

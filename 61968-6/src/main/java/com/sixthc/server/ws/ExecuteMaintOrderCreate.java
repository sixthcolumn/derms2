package com.sixthc.server.ws;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

import javax.xml.ws.Holder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sixthc.cim.createMaintenanceOrders.cxf.FaultMessage;
import com.sixthc.cim.createMaintenanceOrders.cxf.MaintenanceOrdersPayloadType;
import com.sixthc.cim.createMaintenanceOrders.cxf.MaintenanceOrdersPort;
import com.sixthc.cim.createMaintenanceOrders.ActivityRecord2;
import com.sixthc.cim.createMaintenanceOrders.Asset2;
import com.sixthc.cim.createMaintenanceOrders.Asset2.Procedures;
import com.sixthc.cim.createMaintenanceOrders.AssetLocationHazard2;
import com.sixthc.cim.createMaintenanceOrders.Crew2;
import com.sixthc.cim.createMaintenanceOrders.CrewMember;
import com.sixthc.cim.createMaintenanceOrders.CrewMember.Person;
import com.sixthc.cim.createMaintenanceOrders.ErrorType;
import com.sixthc.cim.createMaintenanceOrders.ErrorType.ID;
import com.sixthc.cim.createMaintenanceOrders.HeaderType;
import com.sixthc.cim.createMaintenanceOrders.IDKindType;
import com.sixthc.cim.createMaintenanceOrders.InternalLocation2;
import com.sixthc.cim.createMaintenanceOrders.MaintenanceOrder2;
import com.sixthc.cim.createMaintenanceOrders.MaintenanceOrders2;
import com.sixthc.cim.createMaintenanceOrders.Name2;
import com.sixthc.cim.createMaintenanceOrders.NameType2;
import com.sixthc.cim.createMaintenanceOrders.NameTypeAuthority2;
import com.sixthc.cim.createMaintenanceOrders.Organisation2;
import com.sixthc.cim.createMaintenanceOrders.Organisation2.Phone1;
import com.sixthc.cim.createMaintenanceOrders.Organisation2.StreetAddress;
import com.sixthc.cim.createMaintenanceOrders.ReplyType;
import com.sixthc.cim.createMaintenanceOrders.RequestType;
import com.sixthc.cim.createMaintenanceOrders.Work2;
import com.sixthc.cim.createMaintenanceOrders.Work2.Priority;
import com.sixthc.cim.createMaintenanceOrders.WorkAsset;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2.CoordinateSystem;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2.MainAddress;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2.MainAddress.StreetDetail;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2.MainAddress.TownDetail;
import com.sixthc.cim.createMaintenanceOrders.WorkLocation2.PositionPoints;
import com.sixthc.cim.createMaintenanceOrders.WorkTask;
import com.sixthc.cim.createMaintenanceOrders.WorkTask.MaterialItems;
import com.sixthc.cim.createMaintenanceOrders.WorkTask.MaterialItems.Quantity;
import com.sixthc.cim.createMaintenanceOrders.WorkTimeSchedule2;
import com.sixthc.cim.createMaintenanceOrders.WorkTimeSchedule2.ScheduleInterval;
import com.sixthc.dao.MaintOrderDao;
import com.sixthc.dao.WorkOrderDao;
import com.sixthc.hbm.Address;
import com.sixthc.hbm.AddressHazards;
import com.sixthc.hbm.AddressPositionPoints;
import com.sixthc.hbm.AssetNames;
import com.sixthc.hbm.AssetProcedures;
import com.sixthc.hbm.Attachment;
import com.sixthc.hbm.ConstraintException;
import com.sixthc.hbm.Contactperson;
import com.sixthc.hbm.CrewAssets;
import com.sixthc.hbm.CrewContactpersons;
import com.sixthc.hbm.CrewNames;
import com.sixthc.hbm.Hazards;
import com.sixthc.hbm.Maintorder;
import com.sixthc.hbm.MaintorderNames;
import com.sixthc.hbm.MaterialItem;
import com.sixthc.hbm.MaterialItemNames;
import com.sixthc.hbm.Measurement;
import com.sixthc.hbm.Nametype;
import com.sixthc.hbm.Organization;
import com.sixthc.hbm.Procedure;
import com.sixthc.hbm.ProcedureMeasurements;
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
import com.sixthc.hbm.WorkTaskMaterialItems;
import com.sixthc.hbm.WorkTaskNames;
import com.sixthc.hbm.WorkTaskOldAssets;
import com.sixthc.hbm.WorkTaskTimeSchedules;
import com.sixthc.util.DateUtil;
import com.sixthc.util.ImageLoadFileException;
import com.sixthc.util.ImageLoader;

public class ExecuteMaintOrderCreate implements MaintenanceOrdersPort {
	static Logger log = Logger.getLogger(ExecuteMaintOrderCreate.class);

	@Autowired
	private WorkOrderDao workOrderDao;

	@Autowired
	private MaintOrderDao maintOrderDao;

	private List<com.sixthc.hbm.OrganizationNames> parseNames(
			List<Name2> reqNames) {
		Vector<com.sixthc.hbm.OrganizationNames> namesList = new Vector<com.sixthc.hbm.OrganizationNames>();
		for (Name2 reqName : reqNames) {
			com.sixthc.hbm.OrganizationNames names = new com.sixthc.hbm.OrganizationNames();
			namesList.add(names);
			names.setName(reqName.getName());

			NameType2 reqNameType = reqName.getNameType();
			if (reqNameType != null) {
				com.sixthc.hbm.Nametype nameType = new com.sixthc.hbm.Nametype();
				nameType.setName(reqNameType.getName());
				nameType.setDescription(reqNameType.getDescription());
				names.setNametype(nameType);
				nameType.getOrganizationNameses().add(names);

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

	private void parseStreetDetail(com.sixthc.hbm.Address woAddress,
			StreetAddress addr) {
		com.sixthc.cim.createMaintenanceOrders.Organisation2.StreetAddress.StreetDetail streetDetail = addr
				.getStreetDetail();

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
					.isWithinTownLimits() == true ? 1 : 0);
			woAddress.setSdType(streetDetail.getType());

		}

		com.sixthc.cim.createMaintenanceOrders.Organisation2.StreetAddress.TownDetail townDetail = addr
				.getTownDetail();
		if (townDetail != null) {
			woAddress.setTdCode(townDetail.getCode());
			woAddress.setTdCountry(townDetail.getCountry());
			woAddress.setTdName(townDetail.getName());
			woAddress.setTdSection(townDetail.getSection());
			woAddress.setTdStateProvince(townDetail.getStateOrProvince());
		}
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

	private com.sixthc.hbm.Asset parseAsset(WorkAsset reqCrewAsset) {
		com.sixthc.hbm.Asset workAsset = new com.sixthc.hbm.Asset();
		workAsset.setMrid(reqCrewAsset.getMRID());
		WorkLocation2 reqAssetLoc = reqCrewAsset.getLocation();
		workAsset.setCriticalFlag(reqCrewAsset.isCritical() == true ? 1 : 0);
		workAsset.setUtcNumber(reqCrewAsset.getUtcNumber());
		if (reqAssetLoc != null) {
			WorkLocation2.MainAddress reqMainAddress = reqAssetLoc
					.getMainAddress();

			Address workAssetAddress = new Address();
			workAsset.setAddress(workAssetAddress);
			reqAssetLoc.getMRID(); // ignore

			InternalLocation2 reqInternalLoc = reqAssetLoc
					.getInternalLocation();
			if (reqInternalLoc != null) {
				workAsset.setInternalBuildingName(reqInternalLoc
						.getBuildingName());
				workAsset.setInternalBuildingNumber(reqInternalLoc
						.getBuildingNumber());
				workAsset.setInternalFloor(reqInternalLoc.getFloor());
				workAsset.setInternalRoomNumber(reqInternalLoc.getRoomNumber());
			}

			if (reqMainAddress != null) {
				parseStreetDetail2(workAssetAddress, reqMainAddress);
				workAsset.setAddress(workAssetAddress);
			}

			if (reqAssetLoc.getCoordinateSystem() != null) {
				workAssetAddress.setCoordSystem(reqAssetLoc
						.getCoordinateSystem().getCrsUrn());

				workAssetAddress.setDirections(reqAssetLoc.getDirection());
			}

			for (AssetLocationHazard2 reqHaz : reqAssetLoc.getHazards()) {

				Hazards workhaz = new Hazards();
				AddressHazards addrHazards = new AddressHazards();
				workAssetAddress.getAddressHazardses().add(addrHazards);
				addrHazards.setAddress(workAssetAddress);
				addrHazards.setHazards(workhaz);
				workhaz.setHazardName(reqHaz.getType());
			}

			InternalLocation2 reqIloc = reqAssetLoc.getInternalLocation();
			if (reqIloc != null) {
				workAsset.setInternalBuildingName(reqIloc.getBuildingName());
				workAsset
						.setInternalBuildingNumber(reqIloc.getBuildingNumber());
				workAsset.setInternalFloor(reqIloc.getFloor());
				workAsset.setInternalRoomNumber(reqIloc.getRoomNumber());
			}

			reqAssetLoc.getMRID(); // ignore

			List<PositionPoints> reqPoints = reqAssetLoc.getPositionPoints();
			for (PositionPoints p : reqPoints) {
				AddressPositionPoints workPoints = new AddressPositionPoints();
				try {
					workPoints.setZposition(Integer.valueOf(p.getZPosition()));
					workPoints.setXposition(Integer.valueOf(p.getXPosition()));
					workPoints.setYposition(Integer.valueOf(p.getYPosition()));
					workPoints.setSequence(p.getSequenceNumber().intValue());
				} catch (NumberFormatException nfe) {
					log.error("position value ignored, not number");
					throw new ConstraintException(
							"address position points : non integer value passed");
				}
				workAssetAddress.getAddressPositionPointses().add(workPoints);
				workPoints.setAddress(workAssetAddress);

			}

		}

		for (com.sixthc.cim.createMaintenanceOrders.WorkAsset.Procedures reqProc : reqCrewAsset
				.getProcedures()) {
			AssetProcedures workProcs = new AssetProcedures();
			Procedure workProc = new Procedure();

			workAsset.getAssetProcedureses().add(workProcs);
			workProcs.setProcedure(workProc);
			workProcs.setAsset(workAsset);
			workProc.getAssetProcedureses().add(workProcs);

			workProc.setInstruction(reqProc.getInstruction());
			if (reqProc.getKind() != null)
				workProc.setKind(reqProc.getKind().value());
			try {
				workProc.setSequence(Integer.valueOf(reqProc
						.getSequenceNumber()));
			} catch (NumberFormatException nfe) {
				log.error("position value ignored, not number");
				throw new ConstraintException(
						"asset sequence : non integer value passed");
			}

			for (com.sixthc.cim.createMaintenanceOrders.WorkAsset.Procedures.Measurements reqMeasure : reqProc
					.getMeasurements()) {
				ProcedureMeasurements workMeasures = new ProcedureMeasurements();
				workMeasures.setProcedure(workProc);
				workProc.getProcedureMeasurementses().add(workMeasures);

				Measurement workMeasure = new Measurement();
				workMeasures.setMeasurement(workMeasure);
				workMeasure.getProcedureMeasurementses().add(workMeasures);

				workMeasure.setType(reqMeasure.getMeasurementType());
				if (reqMeasure.getPhases() != null)
					workMeasure.setPhases(reqMeasure.getPhases().value());
				try {
					workMeasure.setUnitMultiplier(Float.valueOf(reqMeasure
							.getUnitMultiplier()));
				} catch (NumberFormatException nfe) {
					log.error("position value ignored, not number");
					throw new ConstraintException(
							"asset procedure measure unit multiplier : non float value passed");
				}
				workMeasure.setUnitSymbol(reqMeasure.getUnitSymbol());
			}
		}

		List<com.sixthc.hbm.AssetNames> namesList = parseAssetNames(reqCrewAsset
				.getNames());
		for (AssetNames assetNames : namesList) {
			workAsset.getAssetNameses().add(assetNames);
			assetNames.setAsset(workAsset);
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

	private com.sixthc.hbm.Asset parseAsset(Asset2 reqAsset) {
		com.sixthc.hbm.Asset workAsset = new com.sixthc.hbm.Asset();
		workAsset.setMrid(reqAsset.getMRID());
		WorkLocation2 reqAssetLoc = reqAsset.getLocation();
		workAsset.setCriticalFlag(reqAsset.isCritical() == true ? 1 : 0);
		workAsset.setUtcNumber(reqAsset.getUtcNumber());
		if (reqAssetLoc != null) {
			MainAddress reqMainAddress = reqAssetLoc.getMainAddress();

			Address workAssetAddress = new Address();
			workAsset.setAddress(workAssetAddress);
			reqAssetLoc.getMRID(); // ignore

			InternalLocation2 reqInternalLoc = reqAssetLoc
					.getInternalLocation();
			if (reqInternalLoc != null) {
				workAsset.setInternalBuildingName(reqInternalLoc
						.getBuildingName());
				workAsset.setInternalBuildingNumber(reqInternalLoc
						.getBuildingNumber());
				workAsset.setInternalFloor(reqInternalLoc.getFloor());
				workAsset.setInternalRoomNumber(reqInternalLoc.getRoomNumber());
			}

			if (reqMainAddress != null) {
				parseStreetDetail2(workAssetAddress, reqMainAddress);
				workAsset.setAddress(workAssetAddress);
			}

			if (reqAssetLoc.getCoordinateSystem() != null) {
				workAssetAddress.setCoordSystem(reqAssetLoc
						.getCoordinateSystem().getCrsUrn());

				workAssetAddress.setDirections(reqAssetLoc.getDirection());
			}

			for (AssetLocationHazard2 reqHaz : reqAssetLoc.getHazards()) {

				Hazards workhaz = new Hazards();
				AddressHazards addrHazards = new AddressHazards();
				workAssetAddress.getAddressHazardses().add(addrHazards);
				addrHazards.setAddress(workAssetAddress);
				addrHazards.setHazards(workhaz);
				workhaz.setHazardName(reqHaz.getType());
			}

			InternalLocation2 reqIloc = reqAssetLoc.getInternalLocation();
			if (reqIloc != null) {
				workAsset.setInternalBuildingName(reqIloc.getBuildingName());
				workAsset
						.setInternalBuildingNumber(reqIloc.getBuildingNumber());
				workAsset.setInternalFloor(reqIloc.getFloor());
				workAsset.setInternalRoomNumber(reqIloc.getRoomNumber());
			}

			reqAssetLoc.getMRID(); // ignore

			List<PositionPoints> reqPoints = reqAssetLoc.getPositionPoints();
			for (PositionPoints p : reqPoints) {
				AddressPositionPoints workPoints = new AddressPositionPoints();
				try {
					workPoints.setZposition(Integer.valueOf(p.getZPosition()));
					workPoints.setXposition(Integer.valueOf(p.getXPosition()));
					workPoints.setYposition(Integer.valueOf(p.getYPosition()));
					workPoints.setSequence(p.getSequenceNumber().intValue());
				} catch (NumberFormatException nfe) {
					log.error("position value ignored, not number");
					throw new ConstraintException(
							"address position points : non integer value passed");
				}
				workAssetAddress.getAddressPositionPointses().add(workPoints);
				workPoints.setAddress(workAssetAddress);

			}

		}

		for (Procedures reqProc : reqAsset.getProcedures()) {
			AssetProcedures workProcs = new AssetProcedures();
			Procedure workProc = new Procedure();

			workAsset.getAssetProcedureses().add(workProcs);
			workProcs.setProcedure(workProc);
			workProcs.setAsset(workAsset);
			workProc.getAssetProcedureses().add(workProcs);

			workProc.setInstruction(reqProc.getInstruction());
			if (reqProc.getKind() != null)
				workProc.setKind(reqProc.getKind().value());
			try {
				workProc.setSequence(Integer.valueOf(reqProc
						.getSequenceNumber()));
			} catch (NumberFormatException nfe) {
				log.error("position value ignored, not number");
				throw new ConstraintException(
						"asset sequence : non integer value passed");
			}

			for (Procedures.Measurements reqMeasure : reqProc.getMeasurements()) {
				ProcedureMeasurements workMeasures = new ProcedureMeasurements();
				workMeasures.setProcedure(workProc);
				workProc.getProcedureMeasurementses().add(workMeasures);

				Measurement workMeasure = new Measurement();
				workMeasures.setMeasurement(workMeasure);
				workMeasure.getProcedureMeasurementses().add(workMeasures);

				workMeasure.setType(reqMeasure.getMeasurementType());
				if (reqMeasure.getPhases() != null)
					workMeasure.setPhases(reqMeasure.getPhases().value());
				try {
					workMeasure.setUnitMultiplier(Float.valueOf(reqMeasure
							.getUnitMultiplier()));
				} catch (NumberFormatException nfe) {
					log.error("position value ignored, not number");
					throw new ConstraintException(
							"asset procedure measure unit multiplier : non float value passed");
				}
				workMeasure.setUnitSymbol(reqMeasure.getUnitSymbol());
			}
		}

		List<com.sixthc.hbm.AssetNames> namesList = parseAssetNames(reqAsset
				.getNames());
		for (AssetNames assetNames : namesList) {
			workAsset.getAssetNameses().add(assetNames);
			assetNames.setAsset(workAsset);
		}

		return workAsset;
	}

	@Override
	public void createMaintenanceOrders(Holder<HeaderType> header,
			RequestType request, Holder<MaintenanceOrdersPayloadType> payload,
			Holder<ReplyType> reply) throws FaultMessage {
		// TODO Auto-generated method stub
		boolean imageFileProcessingError = false;
		int numErrors = 0;
		int numOrders = 0;
		reply.value = new ReplyType();
		boolean workOrderError = false;

		HeaderType returnHeader = new HeaderType();
		returnHeader.setVerb("reply");
		returnHeader.setNoun("MaintenanceOrders");
		returnHeader.setTimestamp(DateUtil.getXMLDate(new Date(System
				.currentTimeMillis())));
		returnHeader.setCorrelationID(header.value.getCorrelationID());
		returnHeader.setMessageID(UUID.randomUUID().toString());
		header.value = returnHeader;

		MaintenanceOrders2 orders = payload.value.getMaintenanceOrders();
		//payload.value = null;
		for (MaintenanceOrder2 req : orders.getMaintenanceOrder()) {
			Maintorder mo = new Maintorder();

			mo.setMrid(req.getMRID());
			mo.setCreatedBy("wms");
			mo.setCreatedAt(new Date(System.currentTimeMillis()));
			mo.setOrderType("Maintenance");

			UUID uuid = UUID.randomUUID();
			mo.setMrid(uuid.toString());

			List<MaintorderNames> nlist = parseMaintorderNames(req.getNames());
			for (MaintorderNames names : nlist) {
				names.setMaintorder(mo);
				mo.getMaintorderNameses().add(names);
			}

			System.out.println("Maint Order mRID: " + mo.getMrid());
			if (req.getMRID() != null) {
				numErrors++;
				System.out
						.println("Error - createOrder, but Work.MRID specified: "
								+ req.getMRID());
				ErrorType et = new ErrorType();
				et.setCode("6.1");
				et.setLevel("FATAL");
				et.setDetails("Request cancelled per business rule. MRID cannot be specified when creating maint order");
				ID id = new ID();
				id.setIdType("Maintenance Order Number");
				id.setIdAuthority("Utility XYZ");
				id.setKind(IDKindType.NAME);
				id.setObjectType("MaintenanceOrder");
				et.setID(id);
				if (mo.getMaintorderNameses().size() > 0) {
					for (MaintorderNames n : mo.getMaintorderNameses()) {
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

			List<com.sixthc.hbm.Organization> orgList = new Vector<com.sixthc.hbm.Organization>();
			Organisation2 reqOrg = req.getOrganisation();

			if (reqOrg != null) {
				com.sixthc.hbm.Organization workOrg = new com.sixthc.hbm.Organization();

				workOrg.setMrid(reqOrg.getMRID());
				List<com.sixthc.hbm.OrganizationNames> namesList = parseNames(reqOrg
						.getNames());
				for (com.sixthc.hbm.OrganizationNames names : namesList) {
					names.setOrganization(workOrg);
					workOrg.getOrganizationNameses().add(names);

				}

				Phone1 ph1 = reqOrg.getPhone1();
				if (ph1 != null) {
					com.sixthc.hbm.Phone phone = new com.sixthc.hbm.Phone();
					phone.setAreacode(ph1.getAreaCode());
					phone.setCitycode(ph1.getCityCode());
					phone.setCountrycode(ph1.getCountryCode());
					phone.setExtension(ph1.getExtension());
					phone.setLocalnumber(ph1.getLocalNumber());
					workOrg.setPhone(phone);
					phone.getOrganizations().add(workOrg);
				}

				StreetAddress addr = reqOrg.getStreetAddress();

				if (addr != null) {
					com.sixthc.hbm.Address woAddress = new com.sixthc.hbm.Address();
					parseStreetDetail(woAddress, addr);
					workOrg.setAddress(woAddress);
					woAddress.getOrganizations().add(workOrg);
				}
				//	orgDao.save(workOrg);
				orgList.add(workOrg);
			}

			for (Work2 reqWork : req.getWork()) {

				numOrders++;
				System.out.println("numOrders: " + numOrders + " mRID: "
						+ reqWork.getMRID());

				WorkOrder workOrder = new WorkOrder();
				mo.getWorkOrders().add(workOrder);
				workOrder.setMaintorder(mo);

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

				// add orgs to all work orders
				for (Organization workOrg : orgList) {
					WorkOrderOrganizations workOrgs = new WorkOrderOrganizations();
					workOrgs.setOrganization(workOrg);
					workOrg.getWorkOrderOrganizations().add(workOrgs);
					workOrder.getWorkOrderOrganizations().add(workOrgs);
					workOrgs.setWorkOrder(workOrder);

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

					com.sixthc.cim.createMaintenanceOrders.WorkLocation2.MainAddress reqMaddr = reqLoc
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

						for (WorkAsset reqCrewAsset : reqCrew.getWorkAssets()) {
							com.sixthc.hbm.Asset workCrewAsset = parseAsset(reqCrewAsset);
							CrewAssets crewAssets = new CrewAssets();
							workCrewAsset.getWorkCrewAssets().add(crewAssets);
							crewAssets.setAsset(workCrewAsset);
							workCrew.getCrewAssets().add(crewAssets);
							crewAssets.setCrew(workCrew);
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

					for (MaterialItems reqMat : reqTask.getMaterialItems()) {
						WorkTaskMaterialItems workTaskItems = new WorkTaskMaterialItems();
						MaterialItem workMatItem = new MaterialItem();

						workTaskItems.setWorkTask(workTask);
						workTask.getWorkTaskMaterialItemses()
								.add(workTaskItems);

						workTaskItems.setMaterialItem(workMatItem);
						workMatItem.getWorkTaskMaterialItemses().add(
								workTaskItems);

						Quantity reqMatQuantity = reqMat.getQuantity();
						if (reqMatQuantity != null) {
							BigInteger reqMatQuantityValue = reqMatQuantity
									.getValue();
							if (reqMatQuantityValue != null)
								workMatItem.setQuantity(reqMatQuantityValue
										.floatValue());

							workMatItem.setMultiplier(reqMatQuantity
									.getMultiplier());

							workMatItem.setUnit(reqMatQuantity.getUnit());

						}

						for (Name2 reqMatName : reqMat.getNames()) {
							MaterialItemNames workMatItemName = new MaterialItemNames();
							workMatItem.getMaterialItemNameses().add(
									workMatItemName);
							workMatItemName.setMaterialItem(workMatItem);
							workMatItemName.setName(reqMatName.getName());

							Nametype workNameType = parseNameType(reqMatName
									.getNameType());
							if (workNameType != null) {
								workMatItemName.setNametype(workNameType);
								workNameType.getMaterialItemNameses().add(
										workMatItemName);
							}

							for (MaterialItemNames matItemNames : workMatItem
									.getMaterialItemNameses()) {
								matItemNames.setName(reqMatName.getName());
								matItemNames.setNametype(workNameType);
							}
						}
					}

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
					for (com.sixthc.cim.createMaintenanceOrders.Attachment reqAtt : reqWork
							.getAttachments().getAttachment()) {

						try {
							log.debug("attachment : "
									+ reqAtt.getUrl().toString());
							String file = UUID.randomUUID().toString();
							String uri = reqAtt.getUrl();

							Attachment attachment = new Attachment();
							attachment.setComment(reqAtt.getComment());
							attachment.setDescription(reqAtt.getDescription());
							String fileExt = ImageLoader.DetermineFileExtension(uri);
							attachment.setFilename(file + "." + fileExt);
							attachment.setType(ImageLoader.DetermineAttachmentType(uri));

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
							if (mo.getMaintorderNameses().size() > 0) {
								for (MaintorderNames n : mo
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

## CIM Webservices for Distributed Energy Resources (DER)

Use case scenarios: https://github.com/dupes/epri-webservices-cim-der/wiki/Application-Integration-at-Utilities

### Overview
* Groups and DER devices are identified by mRID which is a guid

#### Dispatch
Dispatch real, reactive, or apparent power for one or more groups.
  * **files**: `ExecuteDERGroupDispatches.wsdl, DERGroupDispatchesMessage.xsd, DERGroupDispatches.xsd, Message.xsd`

#### Group Status
Retrieve current
  * **files**: `GetDERGroupStatuses.wsdl, GetDERGroupStatusesMessage.xsd, GetDERGroupStatuses.xsd, DERGroupStatuses.xsd , Message.xsd`

#### Group Forecasts
The request (createDERGroupForecasts) indicates what the request is for, # of intervals, time units of intervals, and start and creation date, the reply fills in all of the predicted values for the requested capability.
  * **files**:

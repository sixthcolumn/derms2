package com.sixthc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="message_log")
public class MessageLog {

	@Id
	@GeneratedValue
	@Column(name = "message_log_id")
	private int id;
	@Column(name = "address", length = 4000)
	private String address;
	private String contentType;	
	@Column(name = "create_date")
	private java.sql.Timestamp createDate;
	private String data;	
	private String encoding;
	@Column(name = "faultCode", length = 4000)
	private String faultCode;
	@Column(name = "header", length = 4000)
	private String header;	
	@Column(name = "httpMethod", length = 4000)
	private String httpMethod;
	@Column(name = "message")
	private String messageTxt;
	@Column(name = "messageId")
	private String messageId;
	@Column(name = "correlationID")
	private String correlationID;
	private String operation;
	@Column(name = "payload", length = 60000)
	private String payload;
	@Column(name = "responseCode", length = 4000)
	private String responseCode;
	private String resultCode;	
	@ManyToOne
	@JoinColumn(name="message_id", referencedColumnName = "message_id")
	private Message message;
	
	
	@ManyToOne
	@JoinColumn(name="vendor_id", referencedColumnName = "vendor_id")
	private Vendor vendor;

	private String stage;

	@Transient
	private String packageName;
	@Transient
	private String packageGroupName;
	@Transient
	private String messageName;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getMessageTxt() {
		return messageTxt;
	}

	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}

	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}

/*	public String toString() {
		return "Id = " + id + ", Message = " + message + ", Timestamp = "
				+ createDate + ", data = " + data;
	}
*/
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public String getMessageId() {
		return messageId;
	}
	
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getCorrelationID() {
		return correlationID;
	}

	public void setCorrelationID(String correlationID) {
		this.correlationID = correlationID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}
/*
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
*/
	public String getPackageGroupName() {
		return packageGroupName;
	}

	public void setPackageGroupName(String packageGroupName) {
		this.packageGroupName = packageGroupName;
	}

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
	
}

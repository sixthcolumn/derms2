package com.sixthc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue
	@Column(name = "message_id")
	private int id;
	private String name;
	@Column(name="request_flag")
	private int requestFlag;
	@Column(name="default_message_txt")
	private String defaultMessageText;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="package_group_id")
	private PkgGroup pkgGroup;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRequestFlag() {
		return requestFlag;
	}
	public void setRequestFlag(int requestFlag) {
		this.requestFlag = requestFlag;
	}
	public String getDefaultMessageText() {
		return defaultMessageText;
	}
	public void setDefaultMessageText(String defaultMessageText) {
		this.defaultMessageText = defaultMessageText;
	}
	public PkgGroup getPkgGroup() {
		return pkgGroup;
	}
	public void setPkgGroup(PkgGroup pkgGroup) {
		this.pkgGroup = pkgGroup;
	}

}

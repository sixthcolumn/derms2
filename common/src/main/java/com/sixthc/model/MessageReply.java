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
@Table(name="message_reply")
public class MessageReply {

	@Id
	@GeneratedValue
	@Column(name = "message_reply_id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="message_text")
	private String messageText;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="message_id")
	private Message message;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
		
	

}

package com.sixthc.hbm;

// Generated Jun 3, 2015 2:34:41 PM by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * Organization generated by hbm2java
 */
@Entity
@Table(name = "organization")
public class Organization implements java.io.Serializable {
	private static Constraint con = new Constraint(Organization.class);

	private static org.apache.log4j.Logger log = Logger
			.getLogger(Organization.class);

	private Integer id;
	private Phone phone;
	private Address address;
	private String mrid;
	private Set<WorkOrderOrganizations> workOrderOrganizations = new HashSet<WorkOrderOrganizations>(
			0);
	private Set<OrganizationNames> organizationNameses = new HashSet<OrganizationNames>(
			0);

	public Organization() {
	}

	public Organization(String mrid) {
		this.mrid = mrid;
	}

	public Organization(Phone phone, Address address, String mrid,
			Set<OrganizationNames> organizationNameses) {
		this.phone = phone;
		this.address = address;
		this.mrid = mrid;
		this.organizationNameses = organizationNameses;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		log.debug("setID : " + id);
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	public Phone getPhone() {
		return this.phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization")
	public Set<WorkOrderOrganizations> getWorkOrderOrganizations() {
		return workOrderOrganizations;
	}

	public void setWorkOrderOrganizations(
			Set<WorkOrderOrganizations> workOrderOrganizations) {
		this.workOrderOrganizations = workOrderOrganizations;
	}

	@Column(name = "mRid", nullable = false, length = 40)
	public String getMrid() {
		return this.mrid;
	}

	public void setMrid(String mrid) {
		con.check("setMrid", mrid, false, 40);
		this.mrid = mrid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "organization")
	public Set<OrganizationNames> getOrganizationNameses() {
		return this.organizationNameses;
	}

	public void setOrganizationNameses(
			Set<OrganizationNames> organizationNameses) {
		this.organizationNameses = organizationNameses;
	}

}

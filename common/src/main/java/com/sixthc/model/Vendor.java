package com.sixthc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor")
public class Vendor {
	@Id
	@GeneratedValue
	@Column(name = "vendor_id")
	private int id;
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "VENDOR_PACKAGES", joinColumns = { @JoinColumn(name = "VENDOR_ID") }, inverseJoinColumns = { @JoinColumn(name = "PACKAGE_ID") })
	private Set<Pkg> packages = new HashSet<Pkg>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Set<Pkg> getPakcages() {
		return packages;
	}

	public void setPakcages(Set<Pkg> pakcages) {
		this.packages = pakcages;
	}

	public void setName(String name) {
		this.name = name;
	}

}

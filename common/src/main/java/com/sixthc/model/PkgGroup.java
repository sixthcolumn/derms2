package com.sixthc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="package_group")
public class PkgGroup {
	@Id
	@GeneratedValue
	@Column(name = "package_group_id")
	private int id;
	private String name;

	@ManyToOne
	@JoinColumn(name="package_id")
	private Pkg pkg;
	
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
	public Pkg getPkg() {
		return pkg;
	}
	public void setPkg(Pkg pkg) {
		this.pkg = pkg;
	}
	
	
}

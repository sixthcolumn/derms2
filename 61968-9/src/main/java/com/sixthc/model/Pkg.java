package com.sixthc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="package")
public class Pkg {
	@Id
	@GeneratedValue
	@Column(name = "package_id")
	private int id;
	private String name;
	@OneToMany(mappedBy="pkg")
	private Set<PkgGroup> pkgGroups;
	
	public Set<PkgGroup> getPkgGroups() {
		return pkgGroups;
	}
	public void setPkgGroups(Set<PkgGroup> pkgGroups) {
		this.pkgGroups = pkgGroups;
	}
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
}

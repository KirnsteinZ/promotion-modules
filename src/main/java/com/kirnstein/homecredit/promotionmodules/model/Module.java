package com.kirnstein.homecredit.promotionmodules.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="module")
public class Module implements Serializable{

	private static final long serialVersionUID = -6907606867818879190L;

	@JsonIgnore
	@Id
	@GeneratedValue
	@Column(name="module_id")
	private long moduleId;
	
	@Column(name="module_name",nullable=false)
	private String moduleName;
	
	//Other module info

	public long getModuleId() {
		return moduleId;
	}

	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	@Override
	public String toString() {
		return "Module [moduleId=" + moduleId + ", moduleName=" + moduleName + "]";
	}

	//Other module info getter setter
	
}

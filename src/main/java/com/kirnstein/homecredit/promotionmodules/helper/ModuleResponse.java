package com.kirnstein.homecredit.promotionmodules.helper;

import java.io.Serializable;

public class ModuleResponse implements Serializable{

	private static final long serialVersionUID = 8172772110939072876L;
	public ModuleResponse(String moduleName, int moduleOrder) {
		super();
		this.moduleName = moduleName;
		this.moduleOrder = moduleOrder;
	}
	String moduleName;
	int moduleOrder;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getModuleOrder() {
		return moduleOrder;
	}
	public void setModuleOrder(int moduleOrder) {
		this.moduleOrder = moduleOrder;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

package com.mobws.system.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName: Department 
 * @Description: 部门表对应实体 department
 * @author liujn liujn@mobws.com
 * @date 2016年5月17日 下午2:56:34 
 *
 */
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private String departmentId;
	private String departmentname;
	private String departmenttel;
	private String departmentdesc;
	private String mainmanager;
	private int departmenttype;
	private String parentId;
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getDepartmenttel() {
		return departmenttel;
	}
	public void setDepartmenttel(String departmenttel) {
		this.departmenttel = departmenttel;
	}
	public String getDepartmentdesc() {
		return departmentdesc;
	}
	public void setDepartmentdesc(String departmentdesc) {
		this.departmentdesc = departmentdesc;
	}
	public String getMainmanager() {
		return mainmanager;
	}
	public void setMainmanager(String mainmanager) {
		this.mainmanager = mainmanager;
	}
	public int getDepartmenttype() {
		return departmenttype;
	}
	public void setDepartmenttype(int departmenttype) {
		this.departmenttype = departmenttype;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentname="
				+ departmentname + ", departmenttel=" + departmenttel
				+ ", departmentdesc=" + departmentdesc + ", mainmanager="
				+ mainmanager + ", departmenttype=" + departmenttype
				+ ", parentId=" + parentId + "]";
	}
	
}

package com.mobws.system.service;

import java.util.List;

import com.mobws.system.entity.Department;

public interface DepartmentService {

	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Department> queryAllDepartments();
	
	/**
	 * 添加部门信息
	 * @param department 部门信息
	 */
	public void addDepartment(Department department);
	
	/**
	 * 根据 departmentId 查找部门
	 * @param departmentId
	 * @return
	 */
	public Department queryDepartment(String departmentId);
	
	/**
	 * 根据部门主键 编辑部门信息
	 * @param department
	 */
	public void updateDepartment(Department department);
	
	/**
	 * 根据部门主键 删除部门
	 * @param departmentId
	 * @return
	 */
	public String deleteDepartment(String departmentId);
	
	/**
	 * 拖拽修改部门树
	 * @param department
	 */
	public void updateParentDepartment(Department department);
	
}

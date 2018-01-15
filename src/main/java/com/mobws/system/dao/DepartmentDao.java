package com.mobws.system.dao;

import java.util.List;

import com.mobws.system.entity.Department;

public interface DepartmentDao {

	/**
	 * 查询所有部门信息
	 * @return List<Department>
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
	 * 根据部门主键查询该部门下子部门个数
	 * select count(*) from department where parentId=#{departmentId} 
	 * @param departmentId
	 * @return
	 */
	public int countDepartmentByParentId(String departmentId);
	
	/**
	 * 根据部门主键查询部门下人员个数
	 * select count(*) from userdepartment where departmentId=#{departmentId}
	 * @param departmentId
	 * @return
	 */
	public int countUserForDepartment(String departmentId);
	
	/**
	 * 删除部门信息
	 * @param departmentId
	 */
	public void deleteDepartment(String departmentId);
	
	/**
	 * 拖拽修改部门树
	 * @param department
	 */
	public void updateParentDepartment(Department department);
}

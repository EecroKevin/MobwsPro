package com.mobws.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mobws.system.dao.DepartmentDao;
import com.mobws.system.entity.Department;
import com.mobws.system.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public List<Department> queryAllDepartments() {
		List<Department> departmentList = departmentDao.queryAllDepartments();
		return departmentList;
	}

	@Override
	public void addDepartment(Department department) {
		departmentDao.addDepartment(department);
	}

	@Override
	public Department queryDepartment(String departmentId) {
		Department department = departmentDao.queryDepartment(departmentId);
		return department;
	}

	@Override
	public void updateDepartment(Department department) {
		departmentDao.updateDepartment(department);
	}

	@Override
	public String deleteDepartment(String departmentId) {
		//获取子部门数量、部门下人员数量
		int countDepartment = departmentDao.countDepartmentByParentId(departmentId);
		int countUser = departmentDao.countUserForDepartment(departmentId);
		if(countDepartment > 0){
			//子部门不为空
			return "haveDepartment";
		}else if(countUser > 0){
			//部门下人员数量不为空
			return "haveUser";
		}else{
			//删除部门
			departmentDao.deleteDepartment(departmentId);
			return "deleteok";
		}
	}

	@Override
	public void updateParentDepartment(Department department){
		departmentDao.updateParentDepartment(department);
	}
	
}

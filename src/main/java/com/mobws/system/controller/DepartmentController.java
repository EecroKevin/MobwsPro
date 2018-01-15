package com.mobws.system.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobws.system.entity.Department;
import com.mobws.system.service.DepartmentService;
import com.mobws.utils.KeyProvider;

@Controller
public class DepartmentController extends BaseController{

	@Resource(name="departmentServiceImpl")
	private DepartmentService departmentService;
	
	/**
	 * 初始化树节点
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/findDepartmentsTree.do")
	public void findDepartmentsTree(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Department> departmentList = departmentService.queryAllDepartments();
			StringBuffer sb = new StringBuffer("[");
			int i=0;
			for(Department department : departmentList){
				if(department.getParentId().equals("-1")){
					sb.append("{id:'")
					.append(department.getDepartmentId()).append("',parentId:'")
					.append(department.getParentId()).append("',name:'")
					.append(department.getDepartmentname()).append("',menuType:'")
					.append(department.getDepartmenttype()).append("',icon:'../../icons/home.gif', open:true, drag:false }");
				}else{
					sb.append("{id:'")
					.append(department.getDepartmentId()).append("',parentId:'")
					.append(department.getParentId()).append("',name:'")
					.append(department.getDepartmentname()).append("',menuType:'")
					.append(department.getDepartmenttype()).append("',icon:'../../icons/user_group.gif', open:true}");
				}
				if(i < departmentList.size()-1){
					sb.append(",");
				}
				i++;
			}
			sb.append("]");
			writetoPage(response, sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * 添加部门
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/addDepartment.do")
	public void addDepartment(HttpServletRequest request, HttpServletResponse response){
		Department department = new Department();
		department.setDepartmentdesc(request.getParameter("departmentdesc"));
		department.setDepartmentname(request.getParameter("departmentname"));
		department.setDepartmenttel(request.getParameter("departmenttel"));
		department.setDepartmenttype(0);
		department.setParentId(request.getParameter("parentId"));
		department.setDepartmentId(KeyProvider.getPrimaryKey());
		
		departmentService.addDepartment(department);
		writetoPage(response, "addok");
	}
	
	/**
	 * 编辑部门的跳转
	 */
	@RequestMapping(value="/toEditDepartment.do")
	public String toEditDepartment(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String departmentId = request.getParameter("departmentId");
		Department department = departmentService.queryDepartment(departmentId);
		model.put("department", department);
		
		String  index = request.getParameter("index");
		return "system/framework/orgnization/editdepartment";
	}
	
	/**
	 * 编辑部门的方法
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/editDepartment.do")
	public void editDepartment (HttpServletRequest request, HttpServletResponse response){
		Department department = new Department();
		department.setDepartmentId(request.getParameter("departmentId"));
		department.setDepartmentdesc(request.getParameter("departmentdesc"));
		department.setDepartmentname(request.getParameter("departmentname"));
		department.setDepartmenttel(request.getParameter("departmenttel"));
		
		departmentService.updateDepartment(department);
		writetoPage(response, "updateok");
	}
	
	/**
	 * 删除部门
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/deleteDepartment.do")
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response){
		String departmentId = request.getParameter("departmentId");
		String str = departmentService.deleteDepartment(departmentId);
		writetoPage(response, str);
	}

	/**
	 * 查看部门信息 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="/getDepartmentInfo.do")
	public String getDepartmentInfo(ModelMap model, HttpServletRequest request, HttpServletResponse response){
		String departmentId = request.getParameter("departmentId");
		Department department = departmentService.queryDepartment(departmentId);
		model.put("department", department);
		
		return "system/framework/orgnization/departmentinfo";
	}
	
	@RequestMapping(value="/updateParentDepartment.do")
	public void updateParentDepartment(HttpServletRequest request, HttpServletResponse response){
		String departmentId = request.getParameter("departmentId");
		String parentId = request.getParameter("parentId");
		
		Department department = new Department();
		department.setDepartmentId(departmentId);
		department.setParentId(parentId);
		
		departmentService.updateParentDepartment(department);
		writetoPage(response, "updateok");
		
	}
}

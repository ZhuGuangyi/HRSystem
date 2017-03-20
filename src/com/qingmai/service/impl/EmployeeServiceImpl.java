package com.qingmai.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qingmai.dao.IEmployeeDao;
import com.qingmai.dao.impl.EmployeeDaoImpl;
import com.qingmai.entity.Employee;
import com.qingmai.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao dao = new EmployeeDaoImpl();

	@Override
	//添加员工
	public boolean insert(HttpServletRequest request) {
		//解析请求
		Employee e = new Employee();
		try{
		FileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		List<FileItem> lists = upload.parseRequest(request);
		
		//fileitem是上传文件的核心类
		for(FileItem i : lists){
			boolean flag = i.isFormField();//判断是否为普通文本框
			if(flag){
				if("name".equals(i.getFieldName())){
					//获得普通文本框的内容
					String name = i.getString();
					e.setName(name);
				}
				if("age".equals(i.getFieldName())){
					//获得普通文本框的内容
					int age = Integer.parseInt(i.getString());
					e.setAge(age);
				}
				if("sex".equals(i.getFieldName())){
					//获得普通文本框的内容
					String sex = i.getString();
					sex = i.getString("utf-8");
					e.setSex(sex);
				}
				if("degree".equals(i.getFieldName())){
					//获得普通文本框的内容
					String degree = i.getString();
					degree = i.getString("utf-8");
					e.setDegree(degree);
				}
				if("department".equals(i.getFieldName())){
					//获得普通文本框的内容
					String department = i.getString();
					e.setDepartment(department);
				}
				if("duty".equals(i.getFieldName())){
					//获得普通文本框的内容
					String duty = i.getString();
					e.setDuty(duty);
				}
				if("state".equals(i.getFieldName())){
					//获得普通文本框的内容
					
					String state = i.getString();
					state = i.getString("utf-8");
					e.setState(state);
				}
				if("id".equals(i.getFieldName())){
					//获得普通文本框的内容
					int id = Integer.parseInt(i.getString());
					e.setId(id);
				}
				if("introduction".equals(i.getFieldName())){
					//获得普通文本框的内容
					String introduction = i.getString();
					e.setIntroduction(introduction);
				}
				
			}else{
				
				String fieldName = i.getFieldName();//域的名字
				String name = i.getName();//文件的名字
				String type = i.getContentType();//文件的类型
				long size = i.getSize();//文件的大小
				
				//1.将图片上传至服务器webapps中的HrUpload文件夹
				String realPath = request.getRealPath("/");
				int endIndex = realPath.length() -
						"wtpwebapps".length() - 
						request.getContextPath().length() - 1;
				realPath = realPath.substring(0, endIndex);
				String p = realPath+"webapps/HrUpload/";
				File f = new File(p);
				if(!f.exists()){
					f.mkdir();
				}
				String time = System.currentTimeMillis()+"";
				String fileName = name.split("\\.")[0] + time + "." + name.split("\\.")[1];
				File file = new File(p+"/"+fileName);
				i.write(file);
				String path = "HrUpload/"+fileName;
				e.setPath(path);
				
			}
			
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		//将注册信息保存到数据库
		boolean flag = dao.insertEmployee(e);
		return flag;
	}

	@Override
	public boolean deleteEmployee(int id) {
		boolean flag = dao.executeDelete(id);
		return flag;
	}

	@Override
	public List<Object> selectEmployee(Employee e, String currentPage1) {
		// 用map存放查询的键值对
		Map<String, String> maps = new HashMap<String, String>();

		if (e.getName() != "" && e.getName() != null) {
			maps.put("name", e.getName());
		}
		if (e.getDepartment() != "" && e.getDepartment() != null) {
			maps.put("department", e.getDepartment());
		}
		if (e.getDuty() != "" && e.getDuty() != null) {
			maps.put("duty", e.getDuty());
		}
		// 计算分页使用的数据
		int totalCount = dao.executeSelect(maps).size();
		int pageCount = 5;
		int totalPages = (totalCount % pageCount == 0) ? totalCount / pageCount
				: totalCount / pageCount + 1;
		int currentPage = 1;
		// 限制上下页条件
		if (currentPage1 != null) {
			currentPage = Integer.parseInt(currentPage1);
			if (currentPage >= pageCount) {
				currentPage = pageCount;
			}
			if (currentPage <= 1) {
				currentPage = 1;
			}
		}

		int startIndex = (currentPage - 1) * pageCount;
		// 调用数据持久层，即数据库，完成分页功能
		List<Employee> lists = dao.executeSelectByPage(maps, startIndex,pageCount);
		List<Object> obj = new ArrayList<Object>();
		obj.add(lists);
		obj.add(currentPage);
		obj.add(pageCount);
		return obj;

	}

	@Override
	public Employee selectEmployee(int id) {
		Employee e = dao.excuteSelect(id);
		return e;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		
		return false;
	}

	@Override
	public boolean checkID(int id) {
		boolean flag = dao.excuteSelectID(id);
		return flag;
	}

	@Override
	public String path(int id) {
		String path = dao.excutePath(id);
		return path;
	}

	

	
}

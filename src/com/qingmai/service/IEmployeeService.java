package com.qingmai.service;

import java.util.List;




import javax.servlet.http.HttpServletRequest;

import com.qingmai.entity.Employee;

public interface IEmployeeService {
	
public abstract List<Object> selectEmployee(Employee e, String currentPage1);
	
public abstract Employee selectEmployee(int id); 

public abstract boolean updateEmployee(Employee e);

public abstract boolean deleteEmployee(int id);
//添加员工
public abstract boolean insert(HttpServletRequest request);

public abstract boolean checkID(int id);

public abstract String path(int id);


}

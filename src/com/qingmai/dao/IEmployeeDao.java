package com.qingmai.dao;

import java.util.List;
import java.util.Map;

import com.qingmai.entity.Employee;

public interface IEmployeeDao {

	public abstract List<Employee> executeSelect(Map<String,String> maps);
	
	public abstract Employee excuteSelect(int id);
	
	public abstract boolean executeUpdate(Employee e);
	
	public abstract boolean executeDelete(int id);
	
	public abstract List<Employee> executeSelectByPage(Map<String,String> maps , int startIndex , int pageCount);
	//添加员工
	public abstract boolean insertEmployee(Employee e);
	
	public abstract boolean excuteSelectID(int id);
	
	public abstract String excutePath(int id);
}

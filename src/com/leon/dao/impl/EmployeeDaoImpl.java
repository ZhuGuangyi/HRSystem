package com.leon.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.leon.dao.IEmployeeDao;
import com.leon.db.DbUtil;
import com.leon.entity.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public boolean executeUpdate(Employee e) {
		String sql = "update employee set  name=? , age=? , degree=? , department=?,duty=?,path=? where id=?";
		Object[] params = {e.getName(), e.getAge(), e.getDegree(),
				e.getDepartment(), e.getDuty() ,e.getId(),e.getPath()};
		boolean flag = DbUtil.executeUpdate(sql, params);
		return flag;
		
	}

	@Override
	public boolean executeDelete(int id) {
		String sql = "delete from employee where id=?";
		Object[] params = {id};
		boolean flag=DbUtil.executeUpdate(sql, params);
		return flag;
	}

	@Override
	public List<Employee> executeSelectByPage(Map<String, String> maps, int startIndex , int pageCount) {
		
		Object[] params = new Object[maps.size()];
		String sql = "select * from employee where ";
		String condition = "";
		// map遍历转成set
		Set<String> sets = maps.keySet();
		int i = 0;
		if (sets.size() != 0) {
			for (String s : sets) {
				condition += s + " like ? and ";
				String value = maps.get(s);
				params[i] = "%" + value + "%";
				i++;
			}
			condition = condition.substring(0, condition.length() - 4);
		} else {
			sql = "select * from employee";
		}
		// condition的值 name like ? and type like ? and
		sql += condition  + " limit " + startIndex + "," + pageCount;
		System.out.println(sql);

		java.sql.ResultSet rs = DbUtil.executeQuery(sql, params);
		List<Employee> lists = new ArrayList<Employee>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String degree = rs.getString("degree");
				String department = rs.getString("department");
				String duty = rs.getString("duty");
				String path = rs.getString("path");
				Employee e = new Employee( id,name, age, sex, degree, department,duty,path);
				lists.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
		}
		return lists;
	}

	@Override
	public List<Employee> executeSelect(Map<String, String> maps) {
		
		Object[] params = new Object[maps.size()];
		String sql = "select * from employee where ";
		String condition = "";
		// map遍历转成set
		Set<String> sets = maps.keySet();
		int i = 0;
		if (sets.size() != 0) {
			for (String s : sets) {
				condition += s + " like ? and ";
				String value = maps.get(s);
				params[i] = "%" + value + "%";
				i++;
			}
			condition = condition.substring(0, condition.length() - 4);
		} else {
			sql = "select * from employee";
		}
		// condition的值 name like ? and type like ? and
		sql += condition;
		System.out.println(sql);

		java.sql.ResultSet rs = DbUtil.executeQuery(sql, params);
		List<Employee> lists = new ArrayList<Employee>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = Integer.parseInt(rs.getString("age"));
				String sex = rs.getString("sex");
				String degree = rs.getString("degree");
				String department = rs.getString("department");
				String duty = rs.getString("duty");
				String path = rs.getString("path");
				Employee e = new Employee(id,name, age, sex, degree, department ,duty,path);
				lists.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
		}
		return lists;
	}

	@Override
	public Employee excuteSelect(int id) {
		
		Employee e = null;
		String sql = "select * from employee where id=? ";
		System.out.println("sql:"+sql);
		Object[] params = { id };
		java.sql.ResultSet rs = DbUtil.executeQuery(sql, params);

		try {
			while (rs.next()) {
				int id1 = rs.getInt("id");
				System.out.println(id1);
				String name = rs.getString("name");
				int age = Integer.parseInt(rs.getString("age"));
				String degree = rs.getString("degree");
				String department = rs.getString("department");
				String duty = rs.getString("duty");
				e = new Employee(id1, name, age, degree, department, duty);
				System.out.println("属性"+id1+name+age+degree+department+duty);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		} finally {
			DbUtil.close(rs);
		}

		return e;
	}

	@Override
	public boolean insertEmployee(Employee e) {
		boolean flag = false;
		String sql = "insert into employee(id,name,age,sex,degree,department,duty,state,introduction,path) values"
				+ "(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {e.getId(),e.getName(),e.getAge(),e.getSex(),e.getDegree(),e.getDepartment(),e.getDuty(),e.getState(),e.getIntroduction(),e.getPath()};
		flag = DbUtil.executeUpdate(sql, params);
		return flag;
	}

	@Override
	public boolean excuteSelectID(int id) {
		int count = 0;
		String sql = "select count(*) from employee where  id=?" ;
		Object[]params = {id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try{
			while (rs.next()) {
				  count=rs.getInt(1);
				}
			
		}catch(Exception e){
			
		}
		finally{
			DbUtil.close(rs);
		}
		return count == 1? true : false;
	}

	@Override
	public String excutePath(int id) {
		String path = "";
		String sql = "select path from employee where  id=?" ;
		Object[]params = {id};
		ResultSet rs = DbUtil.executeQuery(sql, params);
		try{
			while (rs.next()) {
				path=rs.getString(1);
				}
			
		}catch(Exception e){
			
		}
		finally{
			DbUtil.close(rs);
		}
		return path;
	}
		

	

}

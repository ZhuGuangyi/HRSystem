package com.leon.dao.impl;

import java.sql.SQLException;

import com.leon.dao.IAdminDao;
import com.leon.db.DbUtil;
import com.leon.entity.Admin;
import com.mysql.jdbc.ResultSet;

public class AdminDaoImpl implements IAdminDao {

	@Override
	public boolean excuteSelect(Admin a) {
		int count=0;
		
		String sql="select count(*) from admin where binary name=? and password=?";
		Object[] params={a.getName(),a.getPassword()};
		java.sql.ResultSet rs=DbUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbUtil.close(rs);
		}
		
		return count == 1? true : false;
	

	
	}
}

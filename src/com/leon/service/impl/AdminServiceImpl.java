package com.leon.service.impl;

import com.leon.dao.IAdminDao;
import com.leon.dao.impl.AdminDaoImpl;
import com.leon.entity.Admin;
import com.leon.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	IAdminDao dao=new AdminDaoImpl();
	@Override
	public boolean checkLogin(Admin a) {
		boolean flag=dao.excuteSelect(a);
		return flag;
	}

	@Override
	public boolean insert(Admin a) {
		// TODO Auto-generated method stub
		return false;
	}

}

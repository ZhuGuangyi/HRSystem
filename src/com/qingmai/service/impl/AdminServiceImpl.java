package com.qingmai.service.impl;

import com.qingmai.dao.IAdminDao;
import com.qingmai.dao.impl.AdminDaoImpl;
import com.qingmai.entity.Admin;
import com.qingmai.service.IAdminService;

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

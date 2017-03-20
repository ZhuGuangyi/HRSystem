package com.qingmai.service;

import com.qingmai.entity.Admin;

public interface IAdminService {
	public abstract boolean checkLogin(Admin a) ;
	public abstract boolean insert(Admin a);
}

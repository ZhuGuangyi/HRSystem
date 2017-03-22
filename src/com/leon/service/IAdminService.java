package com.leon.service;

import com.leon.entity.Admin;

public interface IAdminService {
	public abstract boolean checkLogin(Admin a) ;
	public abstract boolean insert(Admin a);
}

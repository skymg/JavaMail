package com.mg.dao;

import com.mg.entity.User;

public interface UserDao  {

	void regist(User user) throws Exception;

	  User findByCode(String code) throws Exception;

	void update(User user)throws Exception;
	}



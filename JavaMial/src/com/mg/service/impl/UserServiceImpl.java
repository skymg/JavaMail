package com.mg.service.impl;

import com.mg.dao.UserDao;
import com.mg.dao.impl.UserDaoImpl;
import com.mg.entity.User;
import com.mg.service.UserService;
import com.mg.utils.MialUtils;

public class UserServiceImpl implements UserService {

	@Override
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		//业务层用户注册的方法
		UserDao userDao = new UserDaoImpl();
		userDao.regist(user);
		//发送一封电子邮件
		MialUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	//根据激活码查询用户的方法
	public User findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao =new UserDaoImpl();
		return userDao.findByCode(code);
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		UserDao userDao =new UserDaoImpl();
		userDao.update(user);
	} 

}

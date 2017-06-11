package com.mg.service;

import com.mg.entity.User;

public interface UserService {

	void regist(User user) throws Exception;

	User findByCode(String code)throws Exception;

	void update(User user)throws Exception;


}

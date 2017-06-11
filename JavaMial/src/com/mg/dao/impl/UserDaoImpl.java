package com.mg.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mg.dao.UserDao;
import com.mg.entity.User;
import com.mg.utils.JDBCUtils;

/**
 * UserDao实现类
 * 
 * @author sky_mg 2017年6月11日上午11:54:11 TODO
 */
public class UserDaoImpl implements UserDao {

	@Override
	// Dao中保存用户的方法
	public void regist(User user) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		Object[] params = { user.getUid(), user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
				user.getState(), user.getCode() };
		queryRunner.update(sql, params);
	}

	@Override
	// Dao中根据激活码查询用户
	public User findByCode(String code) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code = ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
		return user;
	}

	@Override
	// Dao中修改用户的方法
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] params = { user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(),
				user.getState(), user.getCode(), user.getUid() };
		queryRunner.update(sql, params);
	}

}

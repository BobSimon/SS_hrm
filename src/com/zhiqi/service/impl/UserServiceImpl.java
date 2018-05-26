package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.UserDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.User;
import com.zhiqi.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public List<User> userList(PageBean pageBean, User s_user) {
		// TODO Auto-generated method stub
		return userDao.userList(pageBean,s_user);
	}

	@Override
	public int userCount(User s_user) {
		// TODO Auto-generated method stub
		return userDao.userCount(s_user);
	}

	@Override
	public User loadById(int id) {
		// TODO Auto-generated method stub
		return userDao.loadById(id);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.delete(id);
	}

	/**
	 * 选出招聘专员，系统预设角色值为1是招聘专员
	 *@author 稚
	 */
	@Override
	public List<User> userListByRole1() {
		// TODO Auto-generated method stub
		return userDao.userListByRole1();
	}

}

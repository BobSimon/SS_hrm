package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.User;

public interface UserService {

	public User login(User user);
	public List<User> userList(PageBean pageBean,User s_user);
	public int userCount(User s_user);
	public User loadById(int id);
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	
	public List<User> userListByRole1();//选出招聘专员，系统预设角色值为1是招聘专员
}

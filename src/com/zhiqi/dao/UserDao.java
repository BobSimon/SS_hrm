package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.User;

public interface UserDao {

	public User login(User user);
	public List<User> userList(PageBean pageBean, User s_user);
	public int userCount(User s_user);
	public User loadById(int id);
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public List<User> userListByRole1();
}

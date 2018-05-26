package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.Dept;
import com.zhiqi.model.PageBean;

public interface DeptDao {
	
	public List<Dept> deptList(PageBean pageBean,Dept s_dept);
	public int deptCount(Dept s_dept);
	public void add(Dept dept);
	public void update(Dept dept);
	public void delete(int id);
	public Dept loadById(int id);
	
}

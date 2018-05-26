package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.DeptDao;
import com.zhiqi.model.Dept;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DeptService;

@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Resource
	private DeptDao deptDao;

	@Override
	public List<Dept> deptList(PageBean pageBean, Dept s_dept) {
		// TODO Auto-generated method stub
		return deptDao.deptList(pageBean, s_dept);
	}

	@Override
	public int deptCount(Dept s_dept) {
		// TODO Auto-generated method stub
		return deptDao.deptCount(s_dept);
	}

	@Override
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.add(dept);
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update(dept);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		deptDao.delete(id);
	}

	@Override
	public Dept loadById(int id) {
		// TODO Auto-generated method stub
		return deptDao.loadById(id);
	}
	
}

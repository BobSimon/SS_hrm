package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.SalaryDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Salary;
import com.zhiqi.service.SalaryService;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	@Resource
	private SalaryDao salaryDao;
	
	@Override
	public List<Salary> salaryList(PageBean pageBean, Salary s_salary) {
		// TODO Auto-generated method stub
		return salaryDao.salaryList(pageBean, s_salary);
	}

	@Override
	public int salaryCount(Salary s_salary) {
		// TODO Auto-generated method stub
		return salaryDao.salaryCount(s_salary);
	}

	@Override
	public Salary loadById(int id) {
		// TODO Auto-generated method stub
		return salaryDao.loadById(id);
	}

	@Override
	public void add(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.add(salary);
	}

	@Override
	public void update(Salary salary) {
		// TODO Auto-generated method stub
		salaryDao.update(salary);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		salaryDao.delete(id);
	}

}

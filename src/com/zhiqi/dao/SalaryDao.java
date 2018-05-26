package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.Salary;

public interface SalaryDao {
	public List<Salary> salaryList(PageBean pageBean,Salary s_salary);
	public int salaryCount(Salary s_salary);
	public Salary loadById(int id);
	public void add(Salary salary);
	public void update(Salary salary);
	public void delete(int id);
}

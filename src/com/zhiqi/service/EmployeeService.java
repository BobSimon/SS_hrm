package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.Employee;
import com.zhiqi.model.PageBean;

public interface EmployeeService {
	public List<Employee> employeeList(PageBean pageBean,Employee s_employee);
	public int employeeCount(Employee s_employee);
	public void add(Employee employee);
	public void update(Employee employee);
	public void delete(int id);
	public Employee loadById(int id);
	public String findLastEmployeeNo();
}

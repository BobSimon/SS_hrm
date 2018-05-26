package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.EmployeeDao;
import com.zhiqi.model.Employee;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> employeeList(PageBean pageBean, Employee s_employee) {
		// TODO Auto-generated method stub
		return employeeDao.employeeList(pageBean, s_employee);
	}

	@Override
	public int employeeCount(Employee s_employee) {
		// TODO Auto-generated method stub
		return employeeDao.employeeCount(s_employee);
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.add(employee);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDao.delete(id);
	}

	@Override
	public Employee loadById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.loadById(id);
	}

	@Override
	public String findLastEmployeeNo() {
		// TODO Auto-generated method stub
		return employeeDao.findLastEmployeeNo();
	}

}

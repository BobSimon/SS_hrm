package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.SalaryDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Salary;

@Repository
public class SalaryDaoImpl implements SalaryDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Salary> salaryList(PageBean pageBean, Salary s_salary) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select id,hoursOfG1,hoursOfG2,hoursOfG3,"
				+ " hoursOfAnnualLeave,hoursOfSickLeave,hoursOfPersonalLeave,absenteeism,"
				+ " monthlyPay,month,employeeNo,empName"
				+ " from t_salary");
		if(s_salary!=null){
			if(s_salary.getEmployeeNo()!=null){
				sb.append(" and employeeNo like '%"+s_salary.getEmployeeNo()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by id asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<Salary> SalaryList=new ArrayList<Salary>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Salary resultSalary=new Salary();	
				resultSalary.setId(rs.getInt("id"));
				resultSalary.setHoursOfG1(rs.getBigDecimal("hoursOfG1"));
				resultSalary.setHoursOfG2(rs.getBigDecimal("hoursOfG2"));
				resultSalary.setHoursOfG3(rs.getBigDecimal("hoursOfG3"));
				resultSalary.setHoursOfAnnualLeave(rs.getBigDecimal("hoursOfAnnualLeave"));
				resultSalary.setHoursOfSickLeave(rs.getBigDecimal("hoursOfSickLeave"));
				resultSalary.setHoursOfPersonalLeave(rs.getBigDecimal("hoursOfPersonalLeave"));
				resultSalary.setAbsenteeism(rs.getBigDecimal("absenteeism"));
				resultSalary.setMonthlyPay(rs.getBigDecimal("monthlyPay"));
				resultSalary.setMonth(rs.getInt("month"));
				resultSalary.setEmployeeNo(rs.getString("employeeNo"));
				resultSalary.setEmpName(rs.getString("empName"));
				SalaryList.add(resultSalary);
			}
		});
		return SalaryList;
	}

	@Override
	public int salaryCount(Salary s_salary) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total"
				+ " from t_salary");
		if(s_salary!=null){
			if(s_salary.getEmployeeNo()!=null){
				sb.append(" and employeeNo like '%"+s_salary.getEmployeeNo()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public Salary loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select id,hoursOfG1,hoursOfG2,hoursOfG3,"
				+ " hoursOfAnnualLeave,hoursOfSickLeave,hoursOfPersonalLeave,absenteeism,"
				+ " monthlyPay,month,employeeNo,empName"
				+ " from t_salary where id=?";
		final Salary resultSalary=new Salary();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultSalary.setId(rs.getInt("id"));
				resultSalary.setHoursOfG1(rs.getBigDecimal("hoursOfG1"));
				resultSalary.setHoursOfG2(rs.getBigDecimal("hoursOfG2"));
				resultSalary.setHoursOfG3(rs.getBigDecimal("hoursOfG3"));
				resultSalary.setHoursOfAnnualLeave(rs.getBigDecimal("hoursOfAnnualLeave"));
				resultSalary.setHoursOfSickLeave(rs.getBigDecimal("hoursOfSickLeave"));
				resultSalary.setHoursOfPersonalLeave(rs.getBigDecimal("hoursOfPersonalLeave"));
				resultSalary.setAbsenteeism(rs.getBigDecimal("absenteeism"));
				resultSalary.setMonthlyPay(rs.getBigDecimal("monthlyPay"));
				resultSalary.setMonth(rs.getInt("month"));
				resultSalary.setEmployeeNo(rs.getString("employeeNo"));
				resultSalary.setEmpName(rs.getString("empName"));
			}
		});
		return resultSalary;
	}

	@Override
	public void add(Salary salary) {
		// TODO Auto-generated method stub
		String sql="insert into t_salary values(NULL,?,?,?,NULL,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{salary.getHoursOfG1(),salary.getHoursOfG2(),salary.getHoursOfG3(),
				salary.getHoursOfAnnualLeave(),salary.getHoursOfSickLeave(),salary.getHoursOfPersonalLeave(),
				salary.getAbsenteeism(),salary.getMonthlyPay(),salary.getMonth(),
				salary.getEmployeeNo(),salary.getEmpName()});
	}

	@Override
	public void update(Salary salary) {
		// TODO Auto-generated method stub
		String sql="update t_salary set hoursOfG1=?,hoursOfG2=?,hoursOfG3=?,"
				+ " hoursOfAnnualLeave=?,hoursOfSickLeave=?,hoursOfPersonalLeave=?,absenteeism=?,monthlyPay=?,"
				+ " month=?,employeeNo=?,empName=?"
				+ " where id=?";
		jdbcTemplate.update(sql, new Object[]{salary.getHoursOfG1(),salary.getHoursOfG2(),salary.getHoursOfG3(),
				salary.getHoursOfAnnualLeave(),salary.getHoursOfSickLeave(),salary.getHoursOfPersonalLeave(),
				salary.getAbsenteeism(),salary.getMonthlyPay(),salary.getMonth(),
				salary.getEmployeeNo(),salary.getEmpName(),salary.getId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_salary where id=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

}

package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.EmployeeDao;
import com.zhiqi.model.Employee;
import com.zhiqi.model.PageBean;
import com.zhiqi.util.StringUtil;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Employee> employeeList(PageBean pageBean, Employee s_employee) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select employeeId,employeeNo,empName,empSex,empIdcard,"
				+ " empNation,empZzmm,empRecord,empDegree,school,empPic,"
				+ " t1.deptId,t2.deptName,major,empDesc"
				+ "  from t_employee t1,t_dept t2 where t1.deptId=t2.deptId");
		if(s_employee!=null){
			if(StringUtil.isNotEmpty(s_employee.getEmployeeNo())){
				sb.append(" and employeeNo like '%"+s_employee.getEmployeeNo()+"%'");
			}
			if(StringUtil.isNotEmpty(s_employee.getEmpName())){
				sb.append(" and empName like '%"+s_employee.getEmpName()+"%'");
			}
			if(s_employee.getDeptId()!=null){
				sb.append(" and t1.deptId ='"+s_employee.getDeptId()+"'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by employeeId asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<Employee> employeeList=new ArrayList<Employee>();
		jdbcTemplate.query(sb.toString(), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Employee employee=new Employee();
				employee.setEmployeeId(rs.getString("employeeId"));
				employee.setEmployeeNo(rs.getString("employeeNo"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpSex(rs.getString("empSex"));
				employee.setEmpIdcard(rs.getString("empIdcard"));
				employee.setEmpNation(rs.getString("empNation"));
				employee.setEmpZzmm(rs.getString("empZzmm"));
				employee.setEmpRecord(rs.getString("empRecord"));
				employee.setEmpDegree(rs.getString("empDegree"));
				employee.setSchool(rs.getString("school"));
				employee.setEmpPic(rs.getString("empPic"));
				employee.setDeptId(rs.getInt("deptId"));
				employee.setMajor(rs.getString("major"));
				employee.setEmpDesc(rs.getString("empDesc"));
				employee.setDeptName(rs.getString("deptName"));
				employeeList.add(employee);
			}
		});
		return employeeList;
	}

	@Override
	public int employeeCount(Employee s_employee) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total from t_employee t1,t_dept t2 where t1.deptId=t2.deptId");
		if(s_employee!=null){
			if(StringUtil.isNotEmpty(s_employee.getEmployeeNo())){
				sb.append(" and employeeNo like '%"+s_employee.getEmployeeNo()+"%'");
			}
			if(StringUtil.isNotEmpty(s_employee.getEmpName())){
				sb.append(" and empName like '%"+s_employee.getEmpName()+"%'");
			}
			if(s_employee.getDeptId()!=null){
				sb.append(" and t1.deptId ='"+s_employee.getDeptId()+"'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString(), Integer.class);
	}

	@Override
	public void add(Employee employee) {
		// TODO Auto-generated method stub
		String sql="insert into t_employee values(NULL,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{employee.getEmployeeNo(),employee.getEmpName(),
				employee.getEmpSex(),employee.getEmpIdcard(),employee.getEmpNation(),employee.getEmpZzmm(),
				employee.getEmpRecord(),employee.getEmpDegree(),employee.getSchool(),employee.getEmpPic(),employee.getDeptId(),
				employee.getMajor(),employee.getEmpDesc()});
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		String sql="update t_employee set employeeNo=?,empName=?,empSex=?,empIdcard=?,empNation=?,empZzmm=?,"
				+ " empRecord=?,empDegree=?,school=?,empPic=?,deptId=?,major=?,empDesc=? where employeeId=?";
		jdbcTemplate.update(sql, new Object[]{employee.getEmployeeNo(),employee.getEmpName(),
				employee.getEmpSex(),employee.getEmpIdcard(),employee.getEmpNation(),employee.getEmpZzmm(),
				employee.getEmpRecord(),employee.getEmpDegree(),employee.getSchool(),employee.getEmpPic(),employee.getDeptId(),
				employee.getMajor(),employee.getEmpDesc(),employee.getEmployeeId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_employee where employeeId=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public Employee loadById(int id) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select employeeId,employeeNo,empName,empSex,empIdcard,"
				+ " empNation,empZzmm,empRecord,empDegree,school,empPic,"
				+ " t1.deptId,t2.deptName,major,empDesc"
				+ "  from t_employee t1,t_dept t2 where t1.deptId=t2.deptId and employeeId=?");
		final Employee employee=new Employee();
		jdbcTemplate.query(sb.toString(), new Object[]{id}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				employee.setEmployeeId(rs.getString("employeeId"));
				employee.setEmployeeNo(rs.getString("employeeNo"));
				employee.setEmpName(rs.getString("empName"));
				employee.setEmpSex(rs.getString("empSex"));
				employee.setEmpIdcard(rs.getString("empIdcard"));
				employee.setEmpNation(rs.getString("empNation"));
				employee.setEmpZzmm(rs.getString("empZzmm"));
				employee.setEmpRecord(rs.getString("empRecord"));
				employee.setEmpDegree(rs.getString("empDegree"));
				employee.setSchool(rs.getString("school"));
				employee.setEmpPic(rs.getString("empPic"));
				employee.setDeptId(rs.getInt("deptId"));
				employee.setMajor(rs.getString("major"));
				employee.setEmpDesc(rs.getString("empDesc"));
				employee.setDeptName(rs.getString("deptName"));
			}
		});
		return employee;
	}

	@Override
	public String findLastEmployeeNo() {
		// TODO Auto-generated method stub
		String sql="SELECT employeeNo FROM t_employee ORDER BY employeeId DESC LIMIT 0,1";
		return jdbcTemplate.queryForObject(sql, String.class);
	}

}

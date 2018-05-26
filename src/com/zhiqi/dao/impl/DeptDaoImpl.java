package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.DeptDao;
import com.zhiqi.model.Dept;
import com.zhiqi.model.PageBean;
import com.zhiqi.util.StringUtil;

@Repository
public class DeptDaoImpl implements DeptDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Dept> deptList(PageBean pageBean, Dept s_dept) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select deptId,deptName from t_dept");
		if(s_dept!=null){
			if(StringUtil.isNotEmpty(s_dept.getDeptName())){
				sb.append(" and deptName like '%"+s_dept.getDeptName()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by deptId asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<Dept> deptList=new ArrayList<Dept>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Dept dept=new Dept();
				dept.setDeptId(rs.getInt("deptId"));
				dept.setDeptName(rs.getString("deptName"));
				deptList.add(dept);
			}
		});
		return deptList;
	}

	@Override
	public int deptCount(Dept s_dept) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total from t_dept");
		if(s_dept!=null){
			if(StringUtil.isNotEmpty(s_dept.getDeptName())){
				sb.append(" and deptName like '%"+s_dept.getDeptName()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public void add(Dept dept) {
		// TODO Auto-generated method stub
		String sql="insert into t_dept values(NULL,?)";
		jdbcTemplate.update(sql, new Object[]{dept.getDeptName()});
	}

	@Override
	public void update(Dept dept) {
		// TODO Auto-generated method stub
		String sql="update t_dept set deptName=? where deptId=?";
		jdbcTemplate.update(sql, new Object[]{dept.getDeptName(),dept.getDeptId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_dept where deptId=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public Dept loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select deptId,deptName from t_dept where deptId=?";
		final Dept dept=new Dept();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				dept.setDeptId(rs.getInt("deptId"));
				dept.setDeptName(rs.getString("deptName"));
			}
		});
		return dept;
	}
	
}

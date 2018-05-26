package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.UserDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.User;
import com.zhiqi.util.StringUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String sql="select * from t_user where userName=? and password=?";
		final User resultUser=new User();
		jdbcTemplate.query(sql, new Object[]{user.getUserName(),user.getPassword()}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultUser.setUserId(rs.getInt("userId"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setTrueName(rs.getString("trueName"));
				resultUser.setRole(rs.getInt("role"));
			}
		});
		return resultUser;
	}

	@Override
	public List<User> userList(PageBean pageBean, User s_user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select "
				+ " userId,userName,password,trueName,role from t_user");
		if(s_user!=null){
			if(StringUtil.isNotEmpty(s_user.getTrueName())){
				sb.append(" and trueName like '%"+s_user.getTrueName()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by userId asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<User> userList=new ArrayList<User>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				User resultUser=new User();
				resultUser.setUserId(rs.getInt("userId"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setTrueName(rs.getString("trueName"));
				resultUser.setRole(rs.getInt("role"));
				userList.add(resultUser);
			}
		});
		return userList;
	}

	@Override
	public int userCount(User s_user) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select "
				+ " count(*) as total"
				+ " from t_user");
		if(s_user!=null){
			if(StringUtil.isNotEmpty(s_user.getTrueName())){
				sb.append(" and trueName like '%"+s_user.getTrueName()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public User loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select userId,userName,password,trueName,role"
				+ " from t_user where userId=?";
		final User resultUser=new User();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultUser.setUserId(rs.getInt("userId"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setTrueName(rs.getString("trueName"));
				resultUser.setRole(rs.getInt("role"));
			}
		});
		return resultUser;
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		String sql="insert into t_user values(NULL,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getPassword(),
				user.getTrueName(),user.getRole()});
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		String sql="update t_user set userName=?,password=?,trueName=?,role=?"
				+ " where userId=?";
		jdbcTemplate.update(sql, new Object[]{user.getUserName(),user.getPassword(),
				user.getTrueName(),user.getRole(),user.getUserId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_user where userId=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public List<User> userListByRole1() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select "
				+ " userId,userName,password,trueName,role from t_user where role=1");
		final List<User> userList=new ArrayList<User>();
		jdbcTemplate.query(sb.toString(), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				User resultUser=new User();
				resultUser.setUserId(rs.getInt("userId"));
				resultUser.setUserName(rs.getString("userName"));
				resultUser.setPassword(rs.getString("password"));
				resultUser.setTrueName(rs.getString("trueName"));
				resultUser.setRole(rs.getInt("role"));
				userList.add(resultUser);
			}
		});
		return userList;
	}

}

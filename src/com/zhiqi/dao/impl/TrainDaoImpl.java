package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.TrainDao;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Train;
import com.zhiqi.util.DateUtil;

@Repository
public class TrainDaoImpl implements TrainDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Train> trainList(PageBean pageBean, Train s_train) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select id,name,joinTime,content,empName,isOk"
				+ " from t_train");
		if(s_train!=null){
			if(s_train.getName()!=null){
				sb.append(" and name like '%"+s_train.getName()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by id asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<Train> trainList=new ArrayList<Train>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Train resultTrain=new Train();	
				resultTrain.setId(rs.getInt("id"));
				resultTrain.setName(rs.getString("name"));
				resultTrain.setJoinTime(DateUtil.formatString(rs.getString("joinTime"), "yyyy-MM-dd"));
				resultTrain.setContent(rs.getString("content"));
				resultTrain.setEmpName(rs.getString("empName"));
				resultTrain.setIsOk(rs.getInt("isOk"));
				trainList.add(resultTrain);
			}
		});
		return trainList;
	}

	@Override
	public int trainCount(Train s_train) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total"
				+ " from t_train");
		if(s_train!=null){
			if(s_train.getName()!=null){
				sb.append(" and name like '%"+s_train.getName()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public Train loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select id,name,joinTime,content,empName,isOk"
				+ " from t_train where id=?";
		final Train resultTrain=new Train();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultTrain.setId(rs.getInt("id"));
				resultTrain.setName(rs.getString("name"));
				resultTrain.setJoinTime(DateUtil.formatString(rs.getString("joinTime"), "yyyy-MM-dd"));
				resultTrain.setContent(rs.getString("content"));
				resultTrain.setEmpName(rs.getString("empName"));
				resultTrain.setIsOk(rs.getInt("isOk"));
			}
		});
		return resultTrain;
	}

	@Override
	public void add(Train train) {
		// TODO Auto-generated method stub
		String sql="insert into t_train values(NULL,?,now(),?,?,?)";
		jdbcTemplate.update(sql,new Object[]{train.getName(),train.getContent(),
				train.getEmpName(),train.getIsOk()});
	}

	@Override
	public void update(Train train) {
		// TODO Auto-generated method stub
		String sql="update t_train set name=?,content=?,empName=?,isOk=?"
				+ " where id=?";
		jdbcTemplate.update(sql, new Object[]{train.getName(),train.getContent(),
				train.getEmpName(),train.getIsOk(),train.getId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_train where id=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

}

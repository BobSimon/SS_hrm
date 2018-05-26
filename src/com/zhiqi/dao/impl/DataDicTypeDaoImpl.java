package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.DataDicTypeDao;
import com.zhiqi.model.DataDicType;
import com.zhiqi.model.PageBean;
import com.zhiqi.util.StringUtil;

@Repository
public class DataDicTypeDaoImpl implements DataDicTypeDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DataDicType> dataDicTypeList(PageBean pageBean, DataDicType s_dataDicType) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select ddTypeId,ddTypeName,ddTypeDesc from t_datadictype");
		if(s_dataDicType!=null){
			if(StringUtil.isNotEmpty(s_dataDicType.getDdTypeName())){
				sb.append(" and ddTypeName like '%"+s_dataDicType.getDdTypeName()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<DataDicType> dataDicTypeList=new ArrayList<DataDicType>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				DataDicType dataDicType=new DataDicType();
				dataDicType.setDdTypeId(rs.getInt("ddTypeId"));
				dataDicType.setDdTypeName(rs.getString("ddTypeName"));
				dataDicType.setDdTypeDesc(rs.getString("ddTypeDesc"));
				dataDicTypeList.add(dataDicType);
			}
		});
		return dataDicTypeList;
	}

	@Override
	public int dataDicTypeCount(DataDicType s_dataDicType) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total from t_datadictype");
		if(s_dataDicType!=null){
			if(StringUtil.isNotEmpty(s_dataDicType.getDdTypeName())){
				sb.append(" and ddTypeName like '%"+s_dataDicType.getDdTypeName()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public void add(DataDicType dataDicType) {
		// TODO Auto-generated method stub
		String sql="insert into t_datadictype values(NULL,?,?)";
		jdbcTemplate.update(sql, new Object[]{dataDicType.getDdTypeName(),dataDicType.getDdTypeDesc()});
	}

	@Override
	public void update(DataDicType dataDicType) {
		// TODO Auto-generated method stub
		String sql="update t_datadictype set ddTypeName=?,ddTypeDesc=? where ddTypeId=?";
		jdbcTemplate.update(sql, new Object[]{dataDicType.getDdTypeName(),dataDicType.getDdTypeDesc(),dataDicType.getDdTypeId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_datadictype where ddTypeId=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public DataDicType loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select ddTypeId,ddTypeName,ddTypeDesc from t_datadictype where ddTypeId=?";
		final DataDicType dataDicType=new DataDicType();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				dataDicType.setDdTypeId(rs.getInt("ddTypeId"));
				dataDicType.setDdTypeName(rs.getString("ddTypeName"));
				dataDicType.setDdTypeDesc(rs.getString("ddTypeDesc"));
			}
		});
		return dataDicType;
	}

}

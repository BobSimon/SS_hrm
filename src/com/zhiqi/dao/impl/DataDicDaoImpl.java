package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.DataDicDao;
import com.zhiqi.model.DataDic;
import com.zhiqi.model.PageBean;
import com.zhiqi.util.StringUtil;

@Repository
public class DataDicDaoImpl implements DataDicDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DataDic> dataDicList(PageBean pageBean, DataDic s_dataDic) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select "
				+ " t_datadic.ddId,t_datadic.ddTypeId,t_datadic.ddValue,t_datadic.ddDesc,t_datadictype.ddTypeName"
				+ " from t_datadic,t_datadictype"
				+ " where t_datadic.ddTypeId=t_datadictype.ddTypeId");
		if(s_dataDic!=null){
			if(StringUtil.isNotEmpty(s_dataDic.getDdValue())){
				sb.append(" and t_datadic.ddValue like '%"+s_dataDic.getDdValue()+"%'");
			}
			if(StringUtil.isNotEmpty(s_dataDic.getDdTypeName())){
				sb.append(" and t_datadictype.ddTypeName like '%"+s_dataDic.getDdTypeName()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<DataDic> dataDicList=new ArrayList<DataDic>();
		jdbcTemplate.query(sb.toString(), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				DataDic resultDataDic=new DataDic();
				resultDataDic.setDdId(rs.getInt("ddId"));
				resultDataDic.setDdTypeId(rs.getInt("ddTypeId"));
				resultDataDic.setDdValue(rs.getString("ddValue"));
				resultDataDic.setDdDesc(rs.getString("ddDesc"));
				resultDataDic.setDdTypeName(rs.getString("ddTypeName"));
				dataDicList.add(resultDataDic);
			}
		});
		return dataDicList;
	}

	@Override
	public int dataDicCount(DataDic s_dataDic) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select "
				+ " count(*) as total"
				+ " from t_datadic,t_datadictype"
				+ " where t_datadic.ddTypeId=t_datadictype.ddTypeId");
		if(s_dataDic!=null){
			if(StringUtil.isNotEmpty(s_dataDic.getDdValue())){
				sb.append(" and t_datadic.ddValue like '%"+s_dataDic.getDdValue()+"%'");
			}
			if(StringUtil.isNotEmpty(s_dataDic.getDdTypeName())){
				sb.append(" and t_datadictype.ddTypeName like '%"+s_dataDic.getDdTypeName()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString(), Integer.class);
	}

	@Override
	public void add(DataDic dataDic) {
		// TODO Auto-generated method stub
		String sql="insert into t_datadic values(NULL,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{dataDic.getDdTypeId(),dataDic.getDdValue(),
				dataDic.getDdDesc()});
	}

	@Override
	public void update(DataDic dataDic) {
		// TODO Auto-generated method stub
		String sql="update t_datadic set ddTypeId=?,ddValue=?,ddDesc=? "
				+ " where ddId=?";
		jdbcTemplate.update(sql, new Object[]{dataDic.getDdTypeId(),dataDic.getDdValue(),
				dataDic.getDdDesc(),dataDic.getDdId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_datadic where ddId=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

	@Override
	public DataDic loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select t_datadic.ddId,t_datadic.ddTypeId,t_datadic.ddValue,t_datadic.ddDesc,t_datadictype.ddTypeName"
				+ " from t_datadic,t_datadictype where t_datadic.ddTypeId=t_datadictype.ddTypeId and t_datadic.ddId=?";
		final DataDic resultDataDic=new DataDic();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultDataDic.setDdId(rs.getInt("ddId"));
				resultDataDic.setDdTypeId(rs.getInt("ddTypeId"));
				resultDataDic.setDdValue(rs.getString("ddValue"));
				resultDataDic.setDdDesc(rs.getString("ddDesc"));
				resultDataDic.setDdTypeName(rs.getString("ddTypeName"));
			}
		});
		return resultDataDic;
	}

	@Override
	public boolean existDataDicTypeByDataDicId(int id) {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_datadic where ddTypeId=?";
		int result=jdbcTemplate.queryForObject(sql,new Object[]{id},Integer.class);
		if(result>0){
			return true;
		}else{
			return false;			
		}
	}

}

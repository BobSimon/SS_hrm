package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.ContractDao;
import com.zhiqi.model.Contract;
import com.zhiqi.model.PageBean;

@Repository
public class ContractDaoImpl implements ContractDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Contract> contractList(PageBean pageBean, Contract s_contract) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select id,name,sex,idcard,contractLength,interviewer,"
				+ " isOk,missReason"
				+ " from t_contract");
		if(s_contract!=null){
			if(s_contract.getName()!=null){
				sb.append(" and name like '%"+s_contract.getName()+"%'");
			}
			if(s_contract.getIdcard()!=null){
				sb.append(" and idcard like '%"+s_contract.getIdcard()+"%'");
			}
		}
		if(pageBean!=null){
			sb.append("  order by id asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<Contract> contractList=new ArrayList<Contract>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				Contract resultContract=new Contract();	
				resultContract.setId(rs.getInt("id"));
				resultContract.setName(rs.getString("name"));
				resultContract.setSex(rs.getString("sex"));
				resultContract.setIdcard(rs.getString("idcard"));
				resultContract.setContractLength(rs.getInt("contractLength"));
				resultContract.setInterviewer(rs.getString("interviewer"));
				resultContract.setIsOk(rs.getInt("isOk"));
				resultContract.setMissReason(rs.getString("missReason"));
				contractList.add(resultContract);
			}
		});
		return contractList;
	}

	@Override
	public int contractCount(Contract s_contract) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total"
				+ " from t_contract");
		if(s_contract!=null){
			if(s_contract.getName()!=null){
				sb.append(" and name like '%"+s_contract.getName()+"%'");
			}
			if(s_contract.getIdcard()!=null){
				sb.append(" and idcard like '%"+s_contract.getIdcard()+"%'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public Contract loadById(int id) {
		// TODO Auto-generated method stub
		String sql="select id,name,sex,idcard,contractLength,interviewer,isOk,missReason"
				+ " from t_contract where id=?";
		final Contract resultContract=new Contract();
		jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				resultContract.setId(rs.getInt("id"));
				resultContract.setName(rs.getString("name"));
				resultContract.setSex(rs.getString("sex"));
				resultContract.setIdcard(rs.getString("idcard"));
				resultContract.setContractLength(rs.getInt("contractLength"));
				resultContract.setInterviewer(rs.getString("interviewer"));
				resultContract.setIsOk(rs.getInt("isOk"));
				resultContract.setMissReason(rs.getString("missReason"));
			}
		});
		return resultContract;
	}

	@Override
	public void add(Contract contract) {
		// TODO Auto-generated method stub
		String sql="insert into t_contract values(NULL,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{contract.getName(),contract.getSex(),contract.getIdcard(),
				contract.getContractLength(),contract.getInterviewer(),contract.getIsOk(),contract.getMissReason()});
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
		String sql="update t_contract set name=?,sex=?,idcard=?,contractLength=?,interviewer=?,isOk=?,missReason=?"
				+ " where id=?";
		jdbcTemplate.update(sql, new Object[]{contract.getName(),contract.getSex(),contract.getIdcard(),
				contract.getContractLength(),contract.getInterviewer(),contract.getIsOk(),
				contract.getMissReason(),contract.getId()});
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="delete from t_contract where id=?";
		jdbcTemplate.update(sql, new Object[]{id});
	}

}

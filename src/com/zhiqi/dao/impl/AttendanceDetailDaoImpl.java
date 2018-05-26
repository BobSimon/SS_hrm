package com.zhiqi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.zhiqi.dao.AttendanceDetailDao;
import com.zhiqi.model.AttendanceDetail;
import com.zhiqi.model.PageBean;
import com.zhiqi.util.DateUtil;

@Repository
public class AttendanceDetailDaoImpl implements AttendanceDetailDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AttendanceDetail> attendanceDetailList(PageBean pageBean, AttendanceDetail s_attendanceDetail) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select id,day,recordComeTime,recordLeaveTime,"
				+ " reportComeTime,reportLeaveTime,"
				+ " isAnnualLeave,isSickLeave,isAPersonalLeave,empId,adState"
				+ " from t_attendance_detail");
		if(s_attendanceDetail!=null){
			if(s_attendanceDetail.getDay()!=null){
				sb.append(" and day  ='"+s_attendanceDetail.getDay()+"'");
			}
			if(s_attendanceDetail.getEmpId()!=null){
				sb.append(" and empId like '%"+s_attendanceDetail.getEmpId()+"%'");
			}
			if(s_attendanceDetail.getAdState()!=null){
				sb.append(" and adState = '"+s_attendanceDetail.getAdState()+"'");
			}
		}
		if(pageBean!=null){
			sb.append(" order by id asc limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		final List<AttendanceDetail> attendanceDetailList=new ArrayList<AttendanceDetail>();
		jdbcTemplate.query(sb.toString().replaceFirst("and", "where"), new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				AttendanceDetail resultAttendanceDetail=new AttendanceDetail();	
				resultAttendanceDetail.setId(rs.getInt("id"));
				resultAttendanceDetail.setDay(DateUtil.formatString(rs.getString("day"), "yyyy-MM-dd"));
				resultAttendanceDetail.setRecordComeTime(DateUtil.formatString(rs.getString("recordComeTime"), "yyyy-MM-dd HH:mm:ss"));
				resultAttendanceDetail.setRecordLeaveTime(DateUtil.formatString(rs.getString("recordLeaveTime"), "yyyy-MM-dd HH:mm:ss"));
				resultAttendanceDetail.setReportComeTime(DateUtil.formatString(rs.getString("reportComeTime"), "yyyy-MM-dd HH:mm:ss"));
				resultAttendanceDetail.setReportLeaveTime(DateUtil.formatString(rs.getString("reportLeaveTime"), "yyyy-MM-dd HH:mm:ss"));
				resultAttendanceDetail.setIsAnnualLeave(rs.getInt("isAnnualLeave"));
				resultAttendanceDetail.setIsSickLeave(rs.getInt("isSickLeave"));
				resultAttendanceDetail.setIsAPersonalLeave(rs.getInt("isAPersonalLeave"));
				resultAttendanceDetail.setEmpId(rs.getInt("empId"));
				resultAttendanceDetail.setAdState(rs.getInt("adState"));
				attendanceDetailList.add(resultAttendanceDetail);
			}
		});
		return attendanceDetailList;
	}

	@Override
	public int attendanceDetailCount(AttendanceDetail s_attendanceDetail) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("select count(*) as total"
				+ " from t_attendance_detail");
		if(s_attendanceDetail!=null){
			if(s_attendanceDetail.getDay()!=null){
				sb.append(" and day  ='"+s_attendanceDetail.getDay()+"'");
			}
			if(s_attendanceDetail.getEmpId()!=null){
				sb.append(" and empId like '%"+s_attendanceDetail.getEmpId()+"%'");
			}
			if(s_attendanceDetail.getAdState()!=null){
				sb.append(" and adState = '"+s_attendanceDetail.getAdState()+"'");
			}
		}
		return jdbcTemplate.queryForObject(sb.toString().replaceFirst("and", "where"), Integer.class);
	}

	@Override
	public void setState(int id, int state) {
		// TODO Auto-generated method stub
		String sql="update t_attendance_detail set adState=?"
				+ " where id=?";
		jdbcTemplate.update(sql, new Object[]{state,id});
	}

}

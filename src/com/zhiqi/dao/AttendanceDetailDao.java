package com.zhiqi.dao;

import java.util.List;

import com.zhiqi.model.AttendanceDetail;
import com.zhiqi.model.PageBean;

public interface AttendanceDetailDao {

	public List<AttendanceDetail> attendanceDetailList(PageBean pageBean,AttendanceDetail s_attendanceDetail);
	public int attendanceDetailCount(AttendanceDetail s_attendanceDetail);
	public void setState(int id,int state);
}

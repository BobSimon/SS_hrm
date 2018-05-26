package com.zhiqi.service;

import java.util.List;

import com.zhiqi.model.AttendanceDetail;
import com.zhiqi.model.PageBean;

public interface AttendanceDetailService {

	public List<AttendanceDetail> attendanceDetailList(PageBean pageBean,AttendanceDetail s_attendanceDetail);
	public int attendanceDetailCount(AttendanceDetail s_attendanceDetail);
	public void setState(int id,int state);
}

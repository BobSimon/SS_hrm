package com.zhiqi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhiqi.dao.AttendanceDetailDao;
import com.zhiqi.model.AttendanceDetail;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.AttendanceDetailService;

@Service("attendanceDetail")
public class AttendanceDetailServiceImpl implements AttendanceDetailService {

	@Resource
	private AttendanceDetailDao attendanceDetailDao;

	@Override
	public List<AttendanceDetail> attendanceDetailList(PageBean pageBean, AttendanceDetail s_attendanceDetail) {
		// TODO Auto-generated method stub
		return attendanceDetailDao.attendanceDetailList(pageBean, s_attendanceDetail);
	}

	@Override
	public int attendanceDetailCount(AttendanceDetail s_attendanceDetail) {
		// TODO Auto-generated method stub
		return attendanceDetailDao.attendanceDetailCount(s_attendanceDetail);
	}

	@Override
	public void setState(int id, int state) {
		// TODO Auto-generated method stub
		attendanceDetailDao.setState(id,state);
	}

}

package com.zhiqi.model;

import java.util.Date;

/**
 * 考勤提报表，有主管对下属的出勤时间进行提报
 * 默认8点，晚来的进行设置
 * @author asus
 *
 */
public class AttendanceReport {
	private Integer id;
	private Date comeTime;//默认8点，中午休息1小时
	private Date leaveTime;//默认17：00
	private Integer AttendanceId;//外键
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getComeTime() {
		return comeTime;
	}
	public void setComeTime(Date comeTime) {
		this.comeTime = comeTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public Integer getAttendanceId() {
		return AttendanceId;
	}
	public void setAttendanceId(Integer attendanceId) {
		AttendanceId = attendanceId;
	}
	
}

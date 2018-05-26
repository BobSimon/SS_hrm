package com.zhiqi.model;

import java.util.Date;

/**
 * 考勤记录表
 * @author asus
 *
 */
public class AttendanceRecord {
	private Integer id;
	private Date comeTime;
	private Date leaveTime;
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

package com.zhiqi.model;

import java.util.Date;

/**
 * 考勤记录表
 * 考勤提报表，有主管对下属的出勤时间进行提报
 * 默认8点，中午休息1小时,下班默认17：00
 * @author asus
 *
 */
public class AttendanceDetail {
	private Integer id;
	private Date day;//日期（哪一天的考勤）
	private Date recordComeTime;//记录的
	private Date recordLeaveTime;//
	private Date reportComeTime;//提报的
	private Date reportLeaveTime;//
	private Integer isAnnualLeave;//是否年休
	private Integer isSickLeave;//是否病假
	private Integer isAPersonalLeave;//是否事假
	private Integer empId;//雇员外键
	private Integer adState;//状态 0待操作 1已操作或不需要操作
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Date getRecordComeTime() {
		return recordComeTime;
	}
	public void setRecordComeTime(Date recordComeTime) {
		this.recordComeTime = recordComeTime;
	}
	public Date getRecordLeaveTime() {
		return recordLeaveTime;
	}
	public void setRecordLeaveTime(Date recordLeaveTime) {
		this.recordLeaveTime = recordLeaveTime;
	}
	public Date getReportComeTime() {
		return reportComeTime;
	}
	public void setReportComeTime(Date reportComeTime) {
		this.reportComeTime = reportComeTime;
	}
	public Date getReportLeaveTime() {
		return reportLeaveTime;
	}
	public void setReportLeaveTime(Date reportLeaveTime) {
		this.reportLeaveTime = reportLeaveTime;
	}
	public Integer getIsAnnualLeave() {
		return isAnnualLeave;
	}
	public void setIsAnnualLeave(Integer isAnnualLeave) {
		this.isAnnualLeave = isAnnualLeave;
	}
	public Integer getIsSickLeave() {
		return isSickLeave;
	}
	public void setIsSickLeave(Integer isSickLeave) {
		this.isSickLeave = isSickLeave;
	}
	public Integer getIsAPersonalLeave() {
		return isAPersonalLeave;
	}
	public void setIsAPersonalLeave(Integer isAPersonalLeave) {
		this.isAPersonalLeave = isAPersonalLeave;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getAdState() {
		return adState;
	}
	public void setAdState(Integer adState) {
		this.adState = adState;
	}
	
}

package com.zhiqi.model;

import java.util.Date;
/**
 * 培训实体类
 * @author asus
 *
 */
public class Train {
	private Integer id;
	private String name;
	private Date joinTime;//培训时间（开始时间）
	private String content;//培训内容
	private String empName;//员工姓名
	private Integer isOk;//是否合格
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getIsOk() {
		return isOk;
	}
	public void setIsOk(Integer isOk) {
		this.isOk = isOk;
	}
	
}

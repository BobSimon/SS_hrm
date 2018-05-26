package com.zhiqi.model;

public class Contract {

	private Integer id;
	private String name;
	private String sex;
	private String idcard;
	private Integer contractLength;
	private String interviewer;
	private Integer isOk;
	private String missReason;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Integer getContractLength() {
		return contractLength;
	}
	public void setContractLength(Integer contractLength) {
		this.contractLength = contractLength;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public Integer getIsOk() {
		return isOk;
	}
	public void setIsOk(Integer isOk) {
		this.isOk = isOk;
	}
	public String getMissReason() {
		return missReason;
	}
	public void setMissReason(String missReason) {
		this.missReason = missReason;
	}
	
}

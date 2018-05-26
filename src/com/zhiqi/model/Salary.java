package com.zhiqi.model;

import java.math.BigDecimal;

/**
 * 薪资实体类
 * @author asus
 *
 */
public class Salary {
	private Integer id;
	private BigDecimal hoursOfG1;//工作时数(不含有旷工时数，旷工超过规定次数可作出处分)
	private BigDecimal hoursOfG2;//超出8小时后1.5倍
	private BigDecimal hoursOfG3;//周六周日2倍
	//private BigDecimal hoursOfG4;//国家法定假日3倍(去掉本字段，国家法定假日的判断每年由政府规定，需另设表存在查询判断)

	private BigDecimal hoursOfAnnualLeave;//年休给予100&工资，年休最低可以调0.5天 4小时
	private BigDecimal hoursOfSickLeave;//病假给予70%工资，
	private BigDecimal hoursOfPersonalLeave;//事假(无工资)
	//缺勤需 假（病、年、事）来补，不补算旷工
	private BigDecimal absenteeism;//旷工时数
	
	private BigDecimal  monthlyPay;//月薪
	private Integer month;//哪一个月的薪资
	private String employeeNo;//哪个员工的薪资外键
	private String empName;//哪个员工的薪资外键
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getHoursOfG1() {
		return hoursOfG1;
	}
	public void setHoursOfG1(BigDecimal hoursOfG1) {
		this.hoursOfG1 = hoursOfG1;
	}
	public BigDecimal getHoursOfG2() {
		return hoursOfG2;
	}
	public void setHoursOfG2(BigDecimal hoursOfG2) {
		this.hoursOfG2 = hoursOfG2;
	}
	public BigDecimal getHoursOfG3() {
		return hoursOfG3;
	}
	public void setHoursOfG3(BigDecimal hoursOfG3) {
		this.hoursOfG3 = hoursOfG3;
	}
	public BigDecimal getHoursOfAnnualLeave() {
		return hoursOfAnnualLeave;
	}
	public void setHoursOfAnnualLeave(BigDecimal hoursOfAnnualLeave) {
		this.hoursOfAnnualLeave = hoursOfAnnualLeave;
	}
	public BigDecimal getHoursOfSickLeave() {
		return hoursOfSickLeave;
	}
	public void setHoursOfSickLeave(BigDecimal hoursOfSickLeave) {
		this.hoursOfSickLeave = hoursOfSickLeave;
	}
	public BigDecimal getHoursOfPersonalLeave() {
		return hoursOfPersonalLeave;
	}
	public void setHoursOfPersonalLeave(BigDecimal hoursOfPersonalLeave) {
		this.hoursOfPersonalLeave = hoursOfPersonalLeave;
	}
	public BigDecimal getAbsenteeism() {
		return absenteeism;
	}
	public void setAbsenteeism(BigDecimal absenteeism) {
		this.absenteeism = absenteeism;
	}
	public BigDecimal getMonthlyPay() {
		return monthlyPay;
	}
	public void setMonthlyPay(BigDecimal monthlyPay) {
		this.monthlyPay = monthlyPay;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
}

package com.zhiqi.model;

/**
 * 考勤实体类
 * @author asus
 *
 */
public class Attendance {//暂时不使用
	private Integer id;
//	迟到次数
//	早退次数
//	上班忘记打卡(需补)
//	下班忘记打卡(需补)
//	//没打卡(需->旷工，年休，病假，事假->补)
//	旷工次数

	private Integer month;//哪一个月的考勤
	private Integer empId;//外键
}

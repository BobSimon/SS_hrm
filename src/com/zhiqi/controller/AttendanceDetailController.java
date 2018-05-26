package com.zhiqi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiqi.model.AttendanceDetail;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.AttendanceDetailService;
import com.zhiqi.util.DateUtil;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/attendanceDetail")
public class AttendanceDetailController {

	@Autowired
	private AttendanceDetailService attendanceDetailService;
	 
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,AttendanceDetail s_attendanceDetail,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_attendanceDetail", s_attendanceDetail);
		}else{
			s_attendanceDetail=(AttendanceDetail)session.getAttribute("s_attendanceDetail");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		List<AttendanceDetail> attendanceDetailList=attendanceDetailService.attendanceDetailList(pageBean,s_attendanceDetail);
		
		int total=attendanceDetailService.attendanceDetailCount(s_attendanceDetail);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/attendanceDetail/list.do", total, Integer.parseInt(page), 10);
		mav.addObject("attendanceDetailList", attendanceDetailList);
			
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "考勤管理");
		mav.addObject("mainPage", "/attendanceDetail/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/check")
	public void preSave(HttpServletResponse resp) throws Exception{
		List<AttendanceDetail> attendanceDetailList=attendanceDetailService.attendanceDetailList(null,null);
		
		attendanceDetailList=checkDetail(attendanceDetailList);//检查考勤记录，看是否需要补打卡，补假期
		//System.out.println("刷新本月考勤记录表");
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
	
	private List<AttendanceDetail> checkDetail(List<AttendanceDetail> attendanceDetailList){
		List<AttendanceDetail> result=new ArrayList<AttendanceDetail>();
		//遍历考勤记录,查询需要领导提报考勤的记录
		for(AttendanceDetail ad:attendanceDetailList){
			//1,
			if(ad.getRecordComeTime()!=null && ad.getRecordLeaveTime()!=null){
				attendanceDetailService.setState(ad.getId(),1);//上班打卡 并且 下班也打卡 就设为OK
			}
			if(ad.getRecordComeTime()==null || ad.getRecordLeaveTime()==null){
				attendanceDetailService.setState(ad.getId(),0);//ad.setAdState(0);//上班忘记打卡 或 下班忘记打卡 就设代待处理
			}
			if(ad.getRecordComeTime()==null && ad.getReportComeTime()!=null){
				attendanceDetailService.setState(ad.getId(),1);//上班忘记打卡 但是已经被领导提报上班考勤 设为OK
			}
			if(ad.getRecordLeaveTime()==null && ad.getReportLeaveTime()!=null){
				attendanceDetailService.setState(ad.getId(),1);//下班忘记打卡 但是已经被领导提报下班考勤 设为OK
			}
			if(DateUtil.getWeekOfDate(ad.getDay()).equals("星期日") || DateUtil.getWeekOfDate(ad.getDay()).equals("星期六")){
				System.out.println(DateUtil.getWeekOfDate(ad.getDay()));
				attendanceDetailService.setState(ad.getId(),1);//如果是休息日 设为OK
			}
		}
		return result;
	}
}



//Calendar calOfRecordLeaveTime = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
//calOfRecordLeaveTime.setTime(ad.getRecordLeaveTime());
//
//Calendar calOfRecordComeTime = Calendar.getInstance();
//calOfRecordComeTime.setTime(ad.getRecordComeTime());
//
//Calendar calOfReportComeTime = Calendar.getInstance();
//calOfReportComeTime.setTime(ad.getReportComeTime());
//
//Calendar calOfReportLeaveTime = Calendar.getInstance();
//calOfReportLeaveTime.setTime(ad.getReportLeaveTime());
//
//long betweenHours = (calOfRecordComeTime.getTimeInMillis()-calOfRecordLeaveTime.getTimeInMillis()) / (1000 * 60 * 60); //计算间隔多少小时
//System.out.print(betweenHours);
package com.zhiqi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhiqi.model.PageBean;
import com.zhiqi.model.Salary;
import com.zhiqi.service.SalaryService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	private SalaryService salaryService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Salary s_salary,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_salary", s_salary);
		}else{
			s_salary=(Salary)session.getAttribute("s_salary");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Salary> salaryList=salaryService.salaryList(pageBean,s_salary);
		int total=salaryService.salaryCount(s_salary);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/train/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("salaryList", salaryList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "薪资管理");
		mav.addObject("mainPage", "/salary/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "薪资管理");
		mav.addObject("mainPage","/salary/save.jsp");
		mav.setViewName("main");
		
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "薪资信息添加");
		}else{
			mav.addObject("actionName", "薪资信息修改");
			Salary salary=salaryService.loadById(Integer.parseInt(id));
			mav.addObject("salary", salary);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(Salary salary){
		if(salary.getId()==null){
			salaryService.add(salary);
		}else{
			salaryService.update(salary);
		}
		return "redirect:/salary/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		salaryService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

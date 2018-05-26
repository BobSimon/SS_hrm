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
import com.zhiqi.model.Recruit;
import com.zhiqi.service.RecruitService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/recruit")
public class RecruitController {

	@Autowired
	private RecruitService recruitService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Recruit s_recruit,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_recruit", s_recruit);
		}else{
			s_recruit=(Recruit)session.getAttribute("s_recruit");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Recruit> recruitList=recruitService.recruitList(pageBean,s_recruit);
		int total=recruitService.recruitCount(s_recruit);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/recruit/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("recruitList", recruitList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "招聘管理");
		mav.addObject("mainPage", "/recruit/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "招聘管理");
		mav.addObject("mainPage","/recruit/save.jsp");
		List<Recruit> recruitList=recruitService.recruitList(null, null);
		mav.addObject("recruitList", recruitList);
		mav.setViewName("main");
		
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "招聘信息添加");
		}else{
			mav.addObject("actionName", "招聘信息修改");
			Recruit recruit=recruitService.loadById(Integer.parseInt(id));
			mav.addObject("recruit", recruit);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(Recruit recruit){
		if(recruit.getId()==null){
			recruitService.add(recruit);
		}else{
			recruitService.update(recruit);
		}
		return "redirect:/recruit/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		recruitService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
	@RequestMapping("/checkHealth")
	public void setHealth(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		recruitService.setHealth(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
	@RequestMapping("/checkIdcard")
	public void setIdcard(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		recruitService.setIdcard(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

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

import com.zhiqi.model.Dept;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DeptService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Dept s_dept,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_dept", s_dept);
		}else{
			s_dept=(Dept)session.getAttribute("s_dept");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Dept> deptList=deptService.deptList(pageBean,s_dept);
		int total=deptService.deptCount(s_dept);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/dept/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("deptList", deptList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "部门管理");
		mav.addObject("mainPage", "/dept/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "部门管理");
		mav.addObject("mainPage","/dept/save.jsp");
		mav.setViewName("main");
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "部门信息添加");
		}else{
			mav.addObject("actionName", "部门信息修改");
			Dept dept=deptService.loadById(Integer.parseInt(id));
			mav.addObject("dept", dept);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(Dept dept){
		if(dept.getDeptId()==null){
			deptService.add(dept);
		}else{
			deptService.update(dept);
		}
		return "redirect:/dept/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		deptService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

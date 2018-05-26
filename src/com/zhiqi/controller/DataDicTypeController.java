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

import com.zhiqi.model.DataDicType;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DataDicService;
import com.zhiqi.service.DataDicTypeService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dataDicType")
public class DataDicTypeController {

	@Autowired
	private DataDicTypeService dataDicTypeService;
	
	@Autowired
	private DataDicService dataDicService;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,DataDicType s_dataDicType,HttpServletRequest req){
		ModelAndView mav=new ModelAndView();
		HttpSession session=req.getSession();
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_department", s_dataDicType);
		}else{
			s_dataDicType=(DataDicType)session.getAttribute("s_dataDicType");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<DataDicType> dataDicTypeList=dataDicTypeService.dataDicTypeList(pageBean, s_dataDicType);
		int total=dataDicTypeService.dataDicTypeCount(s_dataDicType);
		String pageCode=PageUtil.getPagation(req.getContextPath()+"/dataDicType/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("dataDicTypeList", dataDicTypeList);
		mav.addObject("total", total);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "数据字典类型管理");
		mav.addObject("mainPage", "dataDicType/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "数据字典类型管理");
		mav.addObject("mainPage", "/dataDicType/save.jsp");
		mav.setViewName("main");
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "数据字典类型添加");
		}else{
			mav.addObject("actionName", "数据字典类型修改");
			DataDicType dataDicType=dataDicTypeService.loadById(Integer.parseInt(id));
			mav.addObject("dataDicType",dataDicType);
		}
		
		return mav;
	}
	@RequestMapping("/save")
	public String save(DataDicType dataDicType){
		if(dataDicType.getDdTypeId()==null){
			dataDicTypeService.add(dataDicType);
		}else{
			dataDicTypeService.update(dataDicType);
		}
		return "redirect:/dataDicType/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		JSONObject result=new JSONObject();
		if(dataDicService.existDataDicTypeByDataDicId(Integer.parseInt(id))){
			result.put("errorInfo", "该类型下存在数据字典，不能删除！");
		}else{
			dataDicTypeService.delete(Integer.parseInt(id));
			result.put("success", true);
		}
		ResponseUtil.write(result, resp);
	}
}

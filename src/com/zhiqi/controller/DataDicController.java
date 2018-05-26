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

import com.zhiqi.model.DataDic;
import com.zhiqi.model.DataDicType;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DataDicService;
import com.zhiqi.service.DataDicTypeService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/dataDic")
public class DataDicController {

	@Autowired
	private DataDicService dataDicService;
	
	@Autowired
	private DataDicTypeService dataDicTypeService;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,DataDic s_dataDic,HttpServletRequest req){
		ModelAndView mav=new ModelAndView();
		HttpSession session=req.getSession();
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_dataDic", s_dataDic);
		}else{
			s_dataDic=(DataDic)session.getAttribute("s_dataDic");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<DataDic> dataDicList=dataDicService.dataDicList(pageBean,s_dataDic);
		int total=dataDicService.dataDicCount(s_dataDic);
		String pageCode=PageUtil.getPagation(req.getContextPath()+"/dataDic/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("dataDicList", dataDicList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "数据字典管理");
		mav.addObject("mainPage","/dataDic/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "数据字典管理");
		mav.addObject("mainPage","/dataDic/save.jsp");
		List<DataDic> dataDicList=dataDicService.dataDicList(null, null);
		mav.addObject("dataDicList", dataDicList);
		mav.setViewName("main");
		
		List<DataDicType> dataDicTypeList=dataDicTypeService.dataDicTypeList(null, null);
		mav.addObject("dataDicTypeList", dataDicTypeList);
		
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "数据字典添加");
		}else{
			mav.addObject("actionName", "数据字典修改");
			DataDic dataDic=dataDicService.loadById(Integer.parseInt(id));
			mav.addObject("dataDic", dataDic);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(DataDic dataDic){
		if(dataDic.getDdId()==null){
			dataDicService.add(dataDic);
		}else{
			dataDicService.update(dataDic);
		}
		return "redirect:/dataDic/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		dataDicService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

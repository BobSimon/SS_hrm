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
import com.zhiqi.model.Train;
import com.zhiqi.service.TrainService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Train s_train,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_train", s_train);
		}else{
			s_train=(Train)session.getAttribute("s_train");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Train> trainList=trainService.trainList(pageBean,s_train);
		int total=trainService.trainCount(s_train);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/train/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("trainList", trainList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "培训管理");
		mav.addObject("mainPage", "/train/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "招聘信息管理");
		mav.addObject("mainPage","/train/save.jsp");
		//List<Train> recruitList=trainService.trainList(null, null);
		//mav.addObject("recruitList", recruitList);
		mav.setViewName("main");
		
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "招聘信息添加");
		}else{
			mav.addObject("actionName", "招聘信息修改");
			Train train=trainService.loadById(Integer.parseInt(id));
			mav.addObject("train", train);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(Train train){
		if(train.getId()==null){
			trainService.add(train);
		}else{
			trainService.update(train);
		}
		return "redirect:/train/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		trainService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

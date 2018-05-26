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

import com.zhiqi.model.Contract;
import com.zhiqi.model.PageBean;
import com.zhiqi.model.Recruit;
import com.zhiqi.model.User;
import com.zhiqi.service.ContractService;
import com.zhiqi.service.RecruitService;
import com.zhiqi.service.UserService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/contract")
public class ContractController {

	@Autowired
	private ContractService contractService;
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Contract s_contract,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_contract", s_contract);
		}else{
			s_contract=(Contract)session.getAttribute("s_contract");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Contract> contractList=contractService.contractList(pageBean,s_contract);
		int total=contractService.contractCount(s_contract);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/contract/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("contractList", contractList);
		
		//添加合同信息时 先把应聘合格者选出来打到前台
		List<Recruit> recruitList=recruitService.recruitListByStateOk();
		mav.addObject("recruitList", recruitList);
		
		//添加面试官list（招聘专员）
		List<User> userListRole1=userService.userListByRole1();
		mav.addObject("userListRole1", userListRole1);
				
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "面试管理");
		mav.addObject("mainPage", "/contract/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "面试管理");
		mav.addObject("mainPage","/contract/save.jsp");
//		//添加合同信息时 先把应聘合格者选出来打到前台
//		List<Recruit> recruitList=recruitService.recruitListByStateOk();
//		mav.addObject("recruitList", recruitList);
		mav.setViewName("main");
		
		if(StringUtil.isEmpty(id)){
			mav.addObject("actionName", "面试信息添加");
		}else{
			mav.addObject("actionName", "面试信息修改");
			Contract contract=contractService.loadById(Integer.parseInt(id));
			mav.addObject("contract", contract);
			
		}
		return mav;
	}
	@RequestMapping("/save")
	public String save(Contract recruit){
		if(recruit.getId()==null){
			contractService.add(recruit);
		}else{
			contractService.update(recruit);
		}
		return "redirect:/contract/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		contractService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
	@RequestMapping("/begin")
	public void newContract(@RequestParam(value="recruitId",required=false)String recruitId,
			@RequestParam(value="userId",required=false)String userId,
			HttpServletResponse resp) throws Exception{
		//取应聘者ID和面试官ID，在合同中插入数据,然后删除合格的应聘者数据
		Contract contract=new Contract();
		
		Recruit recruit=recruitService.loadById(Integer.parseInt(recruitId));
		contract.setName(recruit.getName());
		contract.setSex(recruit.getSex());
		contract.setIdcard(recruit.getIdcard());
		contract.setContractLength(0);//此处简化，默认3年期合同
		
		User interviewer=userService.loadById(Integer.parseInt(userId));
		contract.setInterviewer(interviewer.getTrueName());
		contract.setIsOk(0);
		contract.setMissReason("");
		contractService.add(contract);
		
		recruitService.delete(Integer.parseInt(recruitId));
	}
	@RequestMapping("/setPass")
	public void setPass(){}
	@RequestMapping("/setNotPass")
	public void setNotPass(){}
}

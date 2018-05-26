package com.zhiqi.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiqi.model.DataDic;
import com.zhiqi.model.Dept;
import com.zhiqi.model.Employee;
import com.zhiqi.model.PageBean;
import com.zhiqi.service.DataDicService;
import com.zhiqi.service.DeptService;
import com.zhiqi.service.EmployeeService;
import com.zhiqi.util.PageUtil;
import com.zhiqi.util.ResponseUtil;
import com.zhiqi.util.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DataDicService dataDicService;
	@Autowired
	private DeptService deptService;
	
	@RequestMapping("list")
	public ModelAndView list(@RequestParam(value="page",required=false)String page,Employee s_employee,HttpServletRequest request){
		ModelAndView mav=new ModelAndView();
		HttpSession session=request.getSession();
		if(page==null){
			page="1";
			session.setAttribute("s_employee", s_employee);
		}else{
			s_employee=(Employee)session.getAttribute("s_employee");
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page),5);
		List<Employee> employeeList=employeeService.employeeList(pageBean,s_employee);
		int total=employeeService.employeeCount(s_employee);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/employee/list.do", total, Integer.parseInt(page), 5);
		mav.addObject("employeeList", employeeList);
		mav.addObject("pageCode", pageCode);
		mav.addObject("modeName", "雇员管理");
		mav.addObject("mainPage", "/employee/list.jsp");
		mav.setViewName("main");
		return mav;
	}
	@RequestMapping("/preSave")
	public ModelAndView preSave(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "雇员管理");
		mav.addObject("mainPage","/employee/save.jsp");
		mav.setViewName("main");
		
		DataDic s_dataDic=new DataDic();
		s_dataDic.setDdTypeName("性别");
		List<DataDic> sexDataDicList=dataDicService.dataDicList(null, s_dataDic);
		mav.addObject("sexDataDicList",sexDataDicList);
		
		s_dataDic.setDdTypeName("民族");
		List<DataDic> nationDataDicList=dataDicService.dataDicList(null, s_dataDic);
		mav.addObject("nationDataDicList",nationDataDicList);
		
		s_dataDic.setDdTypeName("政治面貌");
		List<DataDic> zzmmDataDicList=dataDicService.dataDicList(null, s_dataDic);
		mav.addObject("zzmmDataDicList",zzmmDataDicList);
		
		s_dataDic.setDdTypeName("学历");
		List<DataDic> recordDataDicList=dataDicService.dataDicList(null, s_dataDic);
		mav.addObject("recordDataDicList",recordDataDicList);
		
		s_dataDic.setDdTypeName("学位");
		List<DataDic> degreeDataDicList=dataDicService.dataDicList(null, s_dataDic);
		mav.addObject("degreeDataDicList",degreeDataDicList);
		
		List<Dept> deptList=deptService.deptList(null, null);
		mav.addObject("deptList",deptList);
		
		if(StringUtil.isEmpty(id)){
			Employee employee=new Employee();
			employee.setEmpPic("nophoto.jpg");
			mav.addObject("employee", employee);
			mav.addObject("actionName", "雇员信息添加");
		}else{
			mav.addObject("actionName", "雇员信息修改");
			Employee employee=employeeService.loadById(Integer.parseInt(id));
			mav.addObject("employee", employee);
			
		}
		return mav;
	}
	@RequestMapping("/view")
	public ModelAndView view(@RequestParam(value="id",required=false)String id){
		ModelAndView mav=new ModelAndView();
		mav.addObject("modeName", "雇员管理");
		mav.addObject("mainPage","/employee/view.jsp");
		mav.setViewName("main");

		mav.addObject("actionName", "雇员信息查看");
		Employee employee=employeeService.loadById(Integer.parseInt(id));
		mav.addObject("employee", employee);
		
		return mav;
	}
	@RequestMapping("/save")
	public String save(@RequestParam("file")MultipartFile file,HttpServletRequest request,Employee employee) throws Exception{

		if(file.getSize()!=0){
			String filePath=request.getServletContext().getRealPath("/");
			System.out.println(filePath);
			file.transferTo(new File(filePath+"userImage/"+file.getOriginalFilename()));
			employee.setEmpPic(file.getOriginalFilename());
		}
		
		if(employee.getEmployeeId().equals("")){//添加
			//构造员工工号为当前最大值+1
			String employeeNo=employeeService.findLastEmployeeNo();
			employeeNo=(Integer.parseInt(employeeNo)+1)+"";
			employee.setEmployeeNo(employeeNo);
			employeeService.add(employee);
		}else{//修改
			employeeService.update(employee);
		}
		return "redirect:/employee/list.do";
	}
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id",required=false)String id,HttpServletResponse resp) throws Exception{
		employeeService.delete(Integer.parseInt(id));
		JSONObject result=new JSONObject();
		result.put("success", true);
		ResponseUtil.write(result, resp);
	}
}

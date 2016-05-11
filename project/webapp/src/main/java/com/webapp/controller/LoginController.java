package com.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.web.vo.Community;
import com.webapp.web.vo.DepartmentEditor;
import com.webapp.web.vo.DepartmentVO;
import com.webapp.web.vo.EmployeeVo;

@Controller
public class LoginController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
	}
	
	 @ModelAttribute("community")
	    public List<Community> populateCommunity(){
		 ArrayList<Community> community = new ArrayList<Community>();
		 community.add(new Community("Spring", "Spring"));
		 community.add(new Community("Hibernate", "Hibernate"));
		 community.add(new Community("Struts", "Struts"));
		 return community;
	 }
	 @ModelAttribute("allDepartments")
	    public List<DepartmentVO> populateDepartments(){
		    System.out.println("allDepartments");
	        ArrayList<DepartmentVO> departments = new ArrayList<DepartmentVO>();
	        departments.add(new DepartmentVO(-1,  "Select Department"));
	        departments.add(new DepartmentVO(1,  "Human Resource"));
	        departments.add(new DepartmentVO(2,  "Finance"));
	        departments.add(new DepartmentVO(3,  "Information Technology"));
	        return departments;
	    }
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		System.out.println("sdfdsfsdf");
		model.addAttribute("message", "Spring 3 MVC Hello World");
		 EmployeeVo employeeVO=new EmployeeVo();
	        model.addAttribute("employee", employeeVO);
//		return "hellotemp";
		return "index1";

	}
	 @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
	    public String submitForm(@ModelAttribute("employee") EmployeeVo employeeVO,
	            BindingResult result, SessionStatus status) {
	 
		 System.out.println("employeeVO sept"+employeeVO.getDepartment().getName());
		 System.out.println("employeeVO "+employeeVO.getCommunityList());
		 System.out.println("employeeVO  Gender "+employeeVO.getGender());
//	        Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);
	         
//	        for (ConstraintViolation<EmployeeVO> violation : violations) 
//	        {
//	            String propertyPath = violation.getPropertyPath().toString();
//	            String message = violation.getMessage();
//	            // Add JSR-303 errors to BindingResult
//	            // This allows Spring to display them in view via a FieldError
//	            result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
//	        }
	 
	        if (result.hasErrors()) {
	            return "addEmployee";
	        }
	        // Store the employee information in database
	        // manager.createNewRecord(employeeVO);
	         
	        System.out.println(employeeVO);
	 
	        // Mark Session Complete
	        status.setComplete();
	        return "redirect:success.htm";
	    }
	@RequestMapping(value = "/success", method = RequestMethod.GET)  
	public ModelAndView welcome() {  
		System.out.println("index");
	  return new ModelAndView("index2");  
	 } 
}

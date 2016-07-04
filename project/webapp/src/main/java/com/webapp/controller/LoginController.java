package com.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.webapp.exception.DAOException;
import com.webapp.service.EmployeeService;
import com.webapp.validator.AddEmployeeFormValidator;
import com.webapp.web.vo.Community;
import com.webapp.web.vo.DepartmentEditor;
import com.webapp.web.vo.DepartmentVO;
import com.webapp.web.vo.EmployeeVo;

@Controller
public class LoginController {
	public LoginController() {
		System.out.println("creating loginController");
	}
	@Autowired
	EmployeeService employeeservice;
	@Autowired
	AddEmployeeFormValidator employeeformValidator;
	@Value(value = "dhiraj")
	String val;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
	    binder.setValidator(employeeformValidator);
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
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String printWelcome(@RequestParam("user")String user,@RequestParam("pwd")String pwd, ModelMap model) {
		model.addAttribute("message", "Add Employee Detail");
		EmployeeVo employeeVO=new EmployeeVo();
	    model.addAttribute("employee", employeeVO);
	    System.out.println(">>>>>>"+user+"password" + pwd);
		return "hellotemp";
//		return "index1";

	}
	 @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
	    public String submitForm(@ModelAttribute("employee") EmployeeVo employeeVO,
	            BindingResult result, SessionStatus status) {
	 
		 employeeformValidator.validate(employeeVO, result);
		 System.out.println("employeeVO sept"+employeeVO.getDepartment().getName());
		 System.out.println("employeeVO "+employeeVO.getCommunityList());
		 System.out.println("employeeVO  Gender  "+employeeVO.getGender()+val);
		 if (result.hasErrors()) {
	            return "hellotemp";
	        }
		 try {
				employeeservice.addEmployee(employeeVO);
			} catch (DAOException e) {
				e.printStackTrace();
			}
//	        Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);
	         
//	        for (ConstraintViolation<EmployeeVO> violation : violations) 
//	        {
//	            String propertyPath = violation.getPropertyPath().toString();
//	            String message = violation.getMessage();
//	            // Add JSR-303 errors to BindingResult
//	            // This allows Spring to display them in view via a FieldError
//	            result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
//	        }
	 
	        
	        // Store the employee information in database
	        // manager.createNewRecord(employeeVO);
	         
	        System.out.println(employeeVO);
	 
	        // Mark Session Complete
	        status.setComplete();
	        return "redirect:success.htm";
	    }
	@RequestMapping(value = "/success", method = RequestMethod.GET)  
	public String welcome() {  
		System.out.println("index");
	  return "index2";  
	 } 
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		EmployeeVo employeeVO=new EmployeeVo();
		ModelAndView model = new ModelAndView("index2");
		model.addObject("errMsg", ex.getMessage());

		return model;

	}
}

package com.webapp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.webapp.web.vo.DepartmentVO;
import com.webapp.web.vo.EmployeeVo;

@Component
public class AddEmployeeFormValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return EmployeeVo.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		EmployeeVo employeeVo=(EmployeeVo)target;
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.firstName", "First name is required.");
		 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.lastName", "Last name is required.");
		 if(employeeVo.getDepartment().getId()==-1){
			 errors.rejectValue("department", "error.lastName", "Department name is required.");
		 }
	}

}

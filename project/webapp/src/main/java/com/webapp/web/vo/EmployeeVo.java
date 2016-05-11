package com.webapp.web.vo;

public class EmployeeVo {
	private static final long serialVersionUID = 1L;
	 
    private Integer id;
     
    private String firstName;
     
    private String lastName;
     
    private String email;
    
    private DepartmentVO department;
    
    
     
	public DepartmentVO getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentVO department) {
		this.department = department;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}








	public String getEmail() {
		return email;
	}








	public void setEmail(String email) {
		this.email = email;
	}








	@Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department= ]";
    }
}

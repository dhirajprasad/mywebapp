package com.webapp.web.vo;

public class DepartmentVO {

	public DepartmentVO(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
 
    private Integer id;
    private String name;
 
    
 
    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
    public String toString() {
        return "DepartmentVO [id=" + id + ", name=" + name + "]";
    }
}

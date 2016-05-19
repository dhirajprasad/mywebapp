package com.webapp.dao.generic;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDAO {
String name="dhiraj>>>>>>>>";
public TestDAO() {
	System.out.println("TestDAO default constructor");
	
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}

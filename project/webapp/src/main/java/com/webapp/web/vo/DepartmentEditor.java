package com.webapp.web.vo;

import java.beans.PropertyEditorSupport;

public class DepartmentEditor extends PropertyEditorSupport{

	 //This will be called when user HTTP Post to server a field bound to DepartmentVO
    @Override
    public void setAsText(String id) 
    {
    	System.out.println("DepartmentEditor" + id);
        DepartmentVO d;
        switch(Integer.parseInt(id))
        {
            case 1: d = new DepartmentVO(1,  "Human Resource"); break;
            case 2: d = new DepartmentVO(2,  "Finance"); break;
            case 3: d = new DepartmentVO(3,  "Information Technology"); break;
            default: d = null;
        }
        this.setValue(d);
    }
}

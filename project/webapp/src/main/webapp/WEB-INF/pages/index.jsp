<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

    <style>
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
${message} 
<a href="add.htm">Reset</a>


 

    <h2><spring:message code="lbl.page" text="Add New Employee" /></h2>
    <br/>
    <form:form method="post" action="addEmployee.htm" modelAttribute="employee">
         <form:errors path="*" cssClass="error" /> 
        <table>
            <tr>
                <td><spring:message code="lbl.firstName" text="First Name" /></td>
                <td><form:input path="firstName" /></td>
                <td><form:errors path="firstName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.lastName" text="Last Name" /></td>
                <td><form:input path="lastName" /></td>
                <td><form:errors path="lastName" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.email" text="Email Id" /></td>
                <td><form:input path="email" /></td>
                <td><form:errors path="email" cssClass="error" /></td>
            </tr>
             
            <!-- DROPDOWN code -->
             
            <tr>
                <td><spring:message code="lbl.department" text="Department" /></td>
                <td><form:select path="department" items="${allDepartments}" itemValue="id" itemLabel="name" /></td>
                <td><form:errors path="department" cssClass="error" /></td>
            </tr>
             <tr>
             <td>Gender :</td>
             <td>
            <form:radiobutton path="gender" value="Male" label="M" /> 
            <form:radiobutton path="gender" value="Female" label="F" />
       		 </td>
       		 </tr>
       		 <tr>
        <td>Community :</td>
        <td><form:checkboxes path="communityList" items="${community}" itemValue="key" itemLabel="value" /></td>
    </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
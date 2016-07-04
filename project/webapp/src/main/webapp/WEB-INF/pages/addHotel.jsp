<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><spring:message code="lbl.page" text="Add Hotels" /></h2>
    <br/>
    <form:form method="post" action="addHotels.htm" modelAttribute="hotel">
        <%-- <form:errors path="*" cssClass="error" /> --%>
        <table>
            <tr>
                <td><spring:message code="lbl.HotelName" text="Hotel Name" /></td>
                <td><form:input path="hotelname" /></td>
                <td><form:errors path="hotelname" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.HotelName" text="City" /></td>
                <td><form:input path="city" /></td>
                <td><form:errors path="city" cssClass="error" /></td>
            </tr>
            <tr>
                <td><spring:message code="lbl.HotelName" text="State" /></td>
                <td><form:input path="state" /></td>
                <td><form:errors path="state" cssClass="error" /></td>
            </tr>
            <tr>
                <td colspan="3"><input type="submit" value="Add Employee"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
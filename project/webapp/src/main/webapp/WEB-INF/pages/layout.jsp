<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ page isELIgnored="false" %>   
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">  
<html style="background-color: bisque;">  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title></title>  
</head>  
<body>  
        <div style="text-align: center;"><tiles:insertAttribute name="header" /></div>  
        <div style="float:left;padding:10px;width:15%;">
        <tiles:insertAttribute name="menu"/>
        </div>  
        <div style="float:left;padding:10px;width:80%;border-left:1px solid pink;">  
        <tiles:insertAttribute name="body" />
        </div>  
        <div style="clear:both;position: fixed;bottom: 0;width: 100%;">
        <tiles:insertAttribute name="footer"/></div>  
  
</body>  
</html>  
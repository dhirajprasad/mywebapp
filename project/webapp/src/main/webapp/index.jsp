<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
 .form {
    background: white;
    width: 40%;
    box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.7);
    font-family: lato;
    position: relative;
    color: #333;
    border-radius: 10px;
    margin-top: 12%;
    margin-left: 31%;
}
.sub{
position: relative;
    margin-top: 30px;
    margin-bottom: 30px;
    left: 50%;
    transform: translate(-50%, 0);
    font-family: inherit;
    color: white;
    background: #FF3838;
    outline: none;
    border: none;
    padding: 5px 15px;
    font-size: 1.3em;
    font-weight: 400;
    border-radius: 3px;
    box-shadow: 0px 0px 10px rgba(51, 51, 51, 0.4);
    cursor: pointer;
    transition: all 0.15s ease-in-out;
}
.form button {
position: relative;
    margin-top: 30px;
    margin-bottom: 30px;
    left: 50%;
    transform: translate(-50%, 0);
    font-family: inherit;
    color: white;
    background: #FF3838;
    outline: none;
    border: none;
    padding: 5px 15px;
    font-size: 1.3em;
    font-weight: 400;
    border-radius: 3px;
    box-shadow: 0px 0px 10px rgba(51, 51, 51, 0.4);
    cursor: pointer;
    transition: all 0.15s ease-in-out;
}
.form header{
background: #FF3838;
    padding: 30px 20px;
    color: white;
    font-size: 1.2em;
    font-weight: 600;
    border-radius: 10px 10px 0 0;
}
.form input{
display: block;
    width: 78%;
    margin-left: 20px;
    padding: 5px 20px;
    font-size: 1em;
    border-radius: 3px;
    outline: none;
    border: 1px solid #ccc;
}
   .form label{
   margin-left: 20px;
    display: inline-block;
    margin-top: 30px;
    margin-bottom: 5px;
    position: relative;
   } 
   
   .form label span{
   	    color: #FF3838;
    font-size: 2em;
    position: absolute;
    left: 2.3em;
    top: -10px;
}
   }
    .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    


.navbar {
float: left;
margin-left: -1%;
max-height: 50px;
color: #F89406;
font-weight: 200;
font-size: 26px;
width: -moz-available;
margin-top: -152px;
text-shadow: 0px 1px 0px #FFF;
height: 250px;
background-color: #000;
display: block;
margin-right: -8px;
}

.navbar .nav.pull-right-menuoption {
    float: right;
    margin-right: 0px;
    padding-top: 5px;
}

</style>
<title>Insert title here</title>
</head>
<body>
<!-- <a href="add.htm">click</a> -->
<div class="navbar">
<div class="navbar-inner">
<div class="nav-container">
<a class="brand" href="http://www.studytonight.com/" title="Take me Home :)"><img style="max-height:45px;" id="brand-icon" src="/css/resource.v2/icons/studytonight/st-icon.png" alt="studytonight.com"></a>
<ul class="nav pull-right-menuoption nav-right-responsive">

<!-- <font color="orange">Study</font>tonight<sup><span id="beta">&#946;eta</span></sup> -->
<li><a href="http://www.studytonight.com/login">LogIn</a></li>

</ul>


</div>
</div>
</div>
<div class="form">

 <form:form method="post" action="add.htm">
  <header>Login</header>
  <label>Username <span>*</span></label>
  <input id="txt" name="user" type="text">
  
  <label>Password <span>*</span></label>
  <input type="password" name="pwd">
 <!--  <input id="loginsubmit"type="submit" value="Login" class="sub"></input> -->
  <button >Login</button>
</form:form>  
</div>
</body>
</html>
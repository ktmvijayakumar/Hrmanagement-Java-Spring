<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<title>HR Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<spring:url value="/resources/css/style.css" var="coreCss" />
 	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
 	<spring:url value="/resources/images/concertCareLogo.png" var="imageLogo" />
 	<spring:url value="/resources/images/banner.jpg" var="imageBanner" />
 	<spring:url value="/resources/images/about.png" var="imageAbout" />
 
 	<link href="${bootstrapCss}" rel="stylesheet" />
 	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>

<div class="container">
	<header>
		<div class="imglogo"><img src="${imageLogo}" id="imagelogo"></div>
		<div class="headinglogo"><p class="heading3logo"><span class="hr">HR</span> Management System</p></div>
	</header>
</div>

<div class="clearfix">&nbsp;</div>

<!-- login Page-->
<div class="container">

	<div class="image">
	<div class="row">
		<div class="col-lg-6">
			<div class="image-row-body">
					     <img alt="slide" src="${imageAbout}" width="350px" height="300px">   
			</div>			
		</div>
		<div class="col-lg-6" >
			<div class="index-center">
				<center>
					 <h1>Login</h1>
					 <p style="color: red;">${errorString}</p>
					 <form method="POST" action="${pageContext.request.contextPath}/log/index"> 
				        	  <input type="text" name="hr_emailid" placeholder="Email id"/> <br>
				     		  <input type="password" name="hr_password" placeholder="Password"/> <br>
				              <input type="submit" class="button" value= "Submit" />
				              <a class="acolor" href="${pageContext.request.contextPath}/log/index">Cancel</a>
				      </form>
				</center>
			</div>

		</div>
	</div>	
	</div>
</div>

<div class="clearfix">&nbsp;</div>
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapminjs" />
<script src="${bootstrapminjs}" type="text/javascript" ></script>
<spring:url value="/resources/js/jquery.min.js" var="jqueryminjs" />
<script src="${jqueryminjs}"></script>
</body>
</html>
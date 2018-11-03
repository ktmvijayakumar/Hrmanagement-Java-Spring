<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>HR Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<spring:url value="/resources/css/style.css" var="coreCss" />
 	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
 	<spring:url value="/resources/images/concertCareLogo.png" var="imageLogo" />
 	<spring:url value="/resources/images/dummy.jpg" var="imageDummy" />
 	<link href="${bootstrapCss}" rel="stylesheet" />
 	<link href="${coreCss}" rel="stylesheet" />
 
</head>
<body>
<%
  response.setHeader("Cache-Control","no-cache");
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragma","no-cache");
  response.setDateHeader ("Expires", 0);
  if(session.getAttribute("loginedUser")==null)
	  response.sendRedirect("index");

  %>
<div class="container">
	<header>
		<div class="imglogo"><img src="${imageLogo}" id="imagelogo"></div>
		<div class="headinglogo"><p class="heading3logo"><span class="hr">HR</span> Management System</p>
		<div class="a"><a href="${pageContext.request.contextPath}/log/logout">Logout</a></div>
		</div>
		
	</header>
</div>


<div class="clearfix">&nbsp;</div>

<div class="container content">
	<jsp:include page="sideMenu.jsp"/>


	<div class="main">
		<div class="profile">
		<div class="content-profile">
			<h2 style="text-align:center">Profile</h2>
		  	<table class="table-hover">
		      	 	<tr>
	   		          	<th class="tabletitle">Name</th>
			            <td class="tablecontent">${userDetail.hr_name}</td>
			        </tr>
			        <tr>
				          <th class="tabletitle">Age</th>
				          <td class="tablecontent">${userDetail.hr_age}</td>
			        </tr>
			        <tr>
				          <th class="tabletitle">Email Id</th>
				          <td class="tablecontent">${userDetail.hr_emailid}</td>
				          
			   	    </tr>
			        <tr>
				          <th class="tabletitle">Phone No</th>
				          <td class="tablecontent">${userDetail.hr_phoneno}</td>
			        </tr>      
	    	        <tr>
				          <th class="tabletitle">Address</th>
				          <td class="tablecontent">${userDetail.hr_address}</td>
			        </tr>      
	    	
	    	</table>
	    	<br>
    	</div>
	</div>
</div>
</div>

<div class="clearfix">&nbsp;</div>


</body>
</html>
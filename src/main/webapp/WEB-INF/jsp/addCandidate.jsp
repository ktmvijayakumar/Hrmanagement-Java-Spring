<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
			<center>
			<h1>Add candidate</h1>
			<p style="color:green; font-size:16px;">${successMessage}</p>
			<hr>
			<p style="color: red;">${errorString}</p>
			<form method="POST" action="${pageContext.request.contextPath}/candidate/addCandidates" enctype="multipart/form-data">
			   		       <input type="text" name="ncandidate_name" placeholder="Name" required/><br>
			               <input type="number" name="ncandidate_age" placeholder="Age" required/><br>
			               <input type="email" name="ncandidate_emailid" placeholder="Emailid" required/><br>
			               <input type="number" name="ncandidate_phoneno" placeholder="PhoneNumber" required/><br> 
			               <input type="text" name="ncandidate_address" placeholder="Address" required/><br>
			               <input type="text" name="ncandidate_qualification" placeholder="Qualification" required/><br>
			           		
			           		<c:forEach var="var" items="${DesignationDetail}">
			           		<label class="checkbox-inline">
			           		<input type="checkbox" name="ncandidate_designation" value="${var.designation_name}" checked><br>${var.designation_name}
			           		</label>
			           		</c:forEach>
			           		<br>
			           		<input type="file" name="resume" placeholder="Resume File" required/><br>
			               <input type="submit" class="button" value= "Submit" />
			              
		     </form>
		     </center>
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
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
			<h2 style="text-align:center"><span class="hr">Certificate</span> Verification</h2>
			<p style="color:green; font-size:16px;">${successMessage}</p>
		  	<table class="table-hover">
		      	 	<tr>
	   		          	<th class="tabletitle">Name</th>
			            <td class="tablecontent">${candidateDetail.candidate_name}</td>
			        </tr>
			        <tr>
				          <th class="tabletitle">Email Id</th>
				          <td class="tablecontent">${candidateDetail.candidate_emailid}</td>
				          
			   	    </tr>
			        <tr>
				          <th class="tabletitle">Phone No</th>
				          <td class="tablecontent">${candidateDetail.candidate_phoneno}</td>
			        </tr>      
	    	        
	    	</table><br>
	    	<center>
	    	<div>
	    	<form method="POST" action="${pageContext.request.contextPath}/res/certificateVerifyStatus">
	    		<input type="hidden" name="candidate_id" value="${candidateDetail.candidate_id}">
	   	       	<select style="width: 420px; font-size: 25px;padding:10px;" id="status_id" name="verification_status">
	   	       		  <option value="Verified" id="status_id">Verified</option>
					  <option value="Not verified" id="status_id">Not verified</option>
				</select><br>
	   	        <input type="date" name="verification_date" id="input-date" required/><br>
	   	        <textarea rows="3" cols="28" name="verification_description" placeholder="Description"></textarea><br>
	   	       	<input type="submit" class="button-call" value="submit">
	    	</form>
	    	</div>
	    	</center>
	    	
    	</div>
	</div>
</div>
</div>

<div class="clearfix">&nbsp;</div>

</body>
</html>
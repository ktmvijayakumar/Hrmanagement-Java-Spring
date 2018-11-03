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
			<h2 style="text-align:center"><span class="hr">Interview</span> Round Info</h2>
			<p style="color:green; font-size:16px;">${successMessage}</p>
		  	<div class="candidatename">
			<center><h2>Candidate Name:   ${candidateDetail[0].candidate_name}</h2> </center>			
	    	</div>	    	
	    	<center>
	    	<div>
	    	<form method="POST" action="${pageContext.request.contextPath}/interview/interviewprocesssave">
	    		<input type="hidden" name="candidate_id" value="${candidateDetail[0].candidate_id}">
	    		<label class="radio-inline">
			      <input type="radio" name="round_id" value="1" checked class="radio-name"><br>Aptitude
			    </label>
			    <label class="radio-inline">
			      <input type="radio" name="round_id" value="4" class="radio-name"><br>GD
			    </label>
			    <label class="radio-inline">
			      <input type="radio" name="round_id" value="2" class="radio-name"><br>Technical
			    </label>
			    <label class="radio-inline">
			      <input type="radio" name="round_id" value="3" class="radio-name"><br>HR
			    </label>
	    		<input type="text" name="interviewer_name" placeholder="Interviewer Name" required/> <br>
	    		<select style="width: 420px; font-size: 25px;padding:10px;" id="statusid" name="round_statusid">
	   	       		  <option value="1" id="round_statusid">Cleared</option>
					  <option value="2" id="round_statusid">Not cleared</option>
				</select>
				<br>
				<textarea rows="3" cols="28" name="comments" placeholder="Comments" required></textarea><br>
				<br>
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
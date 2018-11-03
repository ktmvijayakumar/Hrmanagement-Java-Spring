<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>HR Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
 	<spring:url value="/resources/css/style.css" var="coreCss" />
 	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
 	<spring:url value="/resources/images/concertCareLogo.png" var="imageLogo" />
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


	<div class="main-viewcandidate">
		<div class="content-viewcandidate">
			<center>
           		 <h2><span class="hr">Interview</span> candidates &nbsp &nbsp Date: ${dates} </h2>
            </center>
            <p style="color:green; font-size:16px;">${successMessage}</p>
            <table class="table-hover interviewtable">
                    <tr>
                        <th class="tabletitle-viewcandidate">SNo</th>
                        <th class="tabletitle-viewcandidate">Candidate Name</th>
                        <th class="tabletitle-viewcandidate">View Details</th>
                        <th class="tabletitle-viewcandidate">Reschedule</th>
                    </tr>
                    <c:forEach var="cand" items="${interviewDetail}">
					<tr>
						<td class="tablecontent-viewcandidate"></td>
						<td class="tablecontent-viewcandidate">${cand.candidate_name}</td>
						<td class="tablecontent-viewcandidate"><a href="${pageContext.request.contextPath}/interview/interviewDetail?candidate_id=${cand.candidate_id}">View</a></td>
						<td class="tablecontent-viewcandidate"><a href="${pageContext.request.contextPath}/interview/reAllocateInterview?candidate_id=${cand.candidate_id}">Allocate</a></td>
					</tr>
					</c:forEach>
                       
            </table>
		  	<br>
    	</div>
</div>
</div>
<div class="clearfix">&nbsp;</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<title>HR Management</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
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
            <h2><span class="hr">Selected</span> Candidates &nbsp &nbsp Date: ${dates} </h2>
            <div class="row-date" style="margin_top: 20px;">
                <form method="GET" action="searchSelectedCandidateResult">
                   <input type="date" name="date" id="date" required/>
                   <input type="submit" class="button-search" value="submit">
               </form>
            </div>
            <p style="color:green; font-size:16px;">${successMessage}</p>
            <div class="round-one-result">
            <table class="table-hover selectedCandidatetable">
                    <tr>
                        <th class="tabletitle-viewcandidate">SNo</th>
                        <th class="tabletitle-viewcandidate">Candidate Name</th>
                        <th class="tabletitle-viewcandidate">View Details</th>
                    </tr>
                    <c:forEach var="candidate" items="${selectedCandidatesDetail}">
					<tr>
						<td class="tablecontent-viewcandidate"></td>
						<td class="tablecontent-viewcandidate"><c:out value="${candidate.candidate_name}" /></td>
						<td class="tablecontent-viewcandidate"><a href="${pageContext.request.contextPath}/res/selectedCandidateDetail?candidate_id=${candidate.candidate_id}">View</a></td>
					</tr>
					</c:forEach>
            </table>
            </div>
            <br>
		  	</center>
    	</div>
</div>

<div class="clearfix">&nbsp;</div>

</body>
</html>
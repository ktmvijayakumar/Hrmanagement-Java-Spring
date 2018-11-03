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
 	<spring:url value="/resources/files/${candidateDetail.ncandidate_resume}"  var="files"/>
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
			<h2 style="text-align:center"><span class="hr">Call</span> Info</h2>
			<center><h2 style="color:green;">${successMessage}</h2></center>
		  	<table class="table-hover">
		      	 	<tr>
	   		          	<th class="tabletitle">Name</th>
			            <td class="tablecontent">${candidateDetail.ncandidate_name}</td>
			        </tr>
			        <tr>
				          <th class="tabletitle">Email Id</th>
				          <td class="tablecontent">${candidateDetail.ncandidate_emailid}</td>
				          
			   	    </tr>
			        <tr>
				          <th class="tabletitle">Phone No</th>
				          <td class="tablecontent">${candidateDetail.ncandidate_phoneno}</td>
			        </tr>       
	    	</table>
	    	<table class="table-hover modalCandidatetable">
                    <tr>
                        <th class="tabletitle-viewcandidate">Round Name</th>
                        <th class="tabletitle-viewcandidate">Status</th>
                        <th class="tabletitle-viewcandidate">Comments</th>
                        <th class="tabletitle-viewcandidate">Date</th>
                    </tr>
                    <c:forEach var="candidate" items="${interviewDetail}">
					<tr>
						<td class="tablecontent-viewcandidate"><c:out value="${candidate.round_name}" /></td>
						<td class="tablecontent-viewcandidate"><c:out value="${candidate.round_status_name}" /></td>
						<td class="tablecontent-viewcandidate"><c:out value="${candidate.comments}" /></td>
						<td class="tablecontent-viewcandidate"><c:out value="${candidate.interview_date}" /></td>
					</tr>
					</c:forEach>
                       
            </table><br>
	    	<center>
	    	<h4>Again have to schedule interview on ${callinfoentity.interview_date} ?</h4>
	    	<form method="POST" action="${pageContext.request.contextPath}/interview/modalcallInfoStatus" id="form-submit-model">
	    		<input type="hidden" name="candidate_id" value="${candidateDetail.ncandidate_id}">
	    		<input type="hidden" name="status_id" value="${callinfoentity.status_id}">
	    		<input type="hidden" name="interview_date" value="${callinfoentity.interview_date}">
	    		<input type="hidden" name="interview_description" value="${callinfoentity.interview_description}">
	   	       	<select style="width: 420px; font-size: 25px;padding:10px;" id="status_id" name="status_id">
	   	       		  <option value="1" id="status_id">Willing</option>
					  <option value="2" id="status_id">Not willing</option>
				</select><br>
	   	       	<table class="table-hover">
		      	 	<tr>
				          <th class="tabletitle">Interview Date</th>
				          <td class="tablecontent">${callinfoentity.interview_date}</td>
				          
			   	    </tr>
			        <tr>
				          <th class="tabletitle">Interview Description</th>
				          <td class="tablecontent">${callinfoentity.interview_description}</td>
			        </tr>      
	    	   </table><br>
	   	       <input type="submit" class="button-call" value="Submit">
	   		   <a class="acolor" href="/hrmanage/viewCandidates">Cancel</a>
	    	</form>
	    	</center>
	    	
    	</div>
	</div>
</div>
</div>

<div class="clearfix">&nbsp;</div>  
  

</body>
</html>
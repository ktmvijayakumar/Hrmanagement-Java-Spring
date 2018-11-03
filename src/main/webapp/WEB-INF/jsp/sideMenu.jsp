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
	<div class="sidenav">
	 <h3>
	  <a href="${pageContext.request.contextPath}/candidate/addDesignation">Add Designation</a>
	  <a href="${pageContext.request.contextPath}/candidate/addCandidate">Add Candidates</a>
	  <a href="${pageContext.request.contextPath}/candidate/viewCandidates">View Candidates</a>
	  <a href="${pageContext.request.contextPath}/interview/interview">Interview</a>
	  <a href="${pageContext.request.contextPath}/res/viewResult">Interview Results</a>
	  <a href="${pageContext.request.contextPath}/res/selectedCandidates">Selected Candidates</a>
	  <a href="${pageContext.request.contextPath}/res/callLetterRelease">CallLetter Release</a>
	  <a href="${pageContext.request.contextPath}/res/acceptedCandidates">Accepted Candidates</a>
	  <a href="${pageContext.request.contextPath}/res/employee">Employee Details</a>
	</h3>
	</div>
</body>
</html>
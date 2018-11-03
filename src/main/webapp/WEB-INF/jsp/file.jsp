<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/style.css" var="coreCss" />
 	<spring:url value="/resources/files/${candidateDetail.ncandidate_resume}"  var="files"/>
 	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
 	<link href="${bootstrapCss}" rel="stylesheet" />
 	<link href="${coreCss}" rel="stylesheet" />
</head>
<body>
<iframe src="${files}" height="650px" width="100%"></iframe>
</body>
</html>
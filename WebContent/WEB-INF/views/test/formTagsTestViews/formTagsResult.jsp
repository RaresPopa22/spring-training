<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS" />
	<link href="${testMainCSS}" rel="stylesheet" />
	<title>Form Tags Test Result</title>
</head>
<body>
	<h1>Congratulations! You have registered your organization</h1>
	<h2>Details below...</h2>
	<hr>
	<div align="center">
		<h3>Organization Name: <b>${orgreg.orgName}</b></h3>
		<h3>Country: <b>${orgreg.country}</b></h3>
	</div>
</body>
</html>
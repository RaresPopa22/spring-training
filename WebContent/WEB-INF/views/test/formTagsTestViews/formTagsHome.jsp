<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<spring:url value="/resources/test-main.css" var="testMainCSS" />
	<link href="${testMainCSS}" rel="stylesheet" />
	<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Welcome to the Form Tags Test Bed</h1>
		<hr>
		<h3>Register Your Organization with us!</h3>
		<form:form action="registerOrg" modelAttribute="orgRegistration">
			<table>
				<tr>
					<td><form:label path="orgName">Name of Organization</form:label></td>
					<td><form:input path="orgName" placeholder="Enter Organization name"/></td>
				</tr>
				<tr>
					<td><form:label path="country">Country</form:label></td>
					<td>
						<form:select path="country">
							<form:option value="NONE">----SELECT----</form:option>
							<form:option value="Australia">----Australia----</form:option>
							<form:option value="India">----India----</form:option>
							<form:option value="Sweeden">----Sweeden----</form:option>
							<form:option value="United States">----United States----</form:option>
							<form:option value="Egypt">----Egypt----</form:option>
						</form:select>
					</td>
				</tr>
					<td align="center"><input type="submit" value="Submit"/></td>
			</table>
		</form:form>
	</div>
</body>
</html>
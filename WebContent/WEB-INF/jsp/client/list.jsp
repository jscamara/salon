<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><fmt:message key="client.list"/></title>
	</head>
	<body>
		<div>
			<form action="${linkTo[ClientController].form }">
				<button type="submit"><fmt:message key="add"/></button>
			</form>
		</div>
		<div>
			<c:forEach var="client" items="${clients }">
				${client.name } <br>
			</c:forEach>
		</div>		
	</body>
</html>
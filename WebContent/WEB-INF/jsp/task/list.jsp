<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<form action="${linkTo[TaskController].form }">
				<button type="submit"><fmt:message key="add"/></button>
			</form>
		</div>
		<div>
			<c:choose>
				<c:when test="${not empty tasks}">
					<table>
						<thead>
							<tr>
								<th><fmt:message key="task.name"/></th>
								<th><fmt:message key="task.description"/></th>
								<th><fmt:message key="task.time"/></th>
								<th><fmt:message key="task.active"/></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="task" items="${tasks }">
								<tr>
									<td>${task.name }</td>
									<td>${task.description }</td>
									<td>${task.time }</td>
									<td><input type="checkbox" ${task.active ? "checked='checked'" : '' } disabled="disabled"></td>
								</tr>		
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<fmt:message key="noResults"/>
				</c:otherwise>
			</c:choose>
		</div>
		<script type="text/javascript" src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.8.23.custom.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/beautySalon.js' />"></script>
	</body>
</html>
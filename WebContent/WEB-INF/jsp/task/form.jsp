<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<fmt:message key="task.name"/><input type="text" name="task.name" value="${task.name }"><br>
		<fmt:message key="task.description"/><textarea name="task.description">${task.description }</textarea><br>
		<fmt:message key="task.time"/><input type="text" name="task.time" value="${task.time }"><br>
		<fmt:message key="task.description"/><input type="text" name="task.description" value="${task.description }"><br>
		<fmt:message key="task.specialty"/>
		<select>
			<c:forEach var="specialty" items="${specialties }">
				<option>${specialty.name }</option>
			</c:forEach>
		</select>
		
	</body>
</html>
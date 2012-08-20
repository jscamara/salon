<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
			<form action="${linkTo[ProfessionalController].form }" method="get">
				<button type="submit"><fmt:message key="add"/></button>
			</form>
		</div>
		<div id="professionals">
			<c:forEach items="${professionals }" var="professional">
				<fmt:message key="professional.name" /> ${professional.name} <br />
			</c:forEach>
		</div>
	</body>
</html>
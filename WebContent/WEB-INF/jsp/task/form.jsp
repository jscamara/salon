<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery-ui-1.8.23.custom.css' />" />
		<title><fmt:message key="task.form"/></title>
	</head>
	<body>
		<div>
			<form action="${linkTo[TaskController].add }" method="post">
				<fmt:message key="task.name"/><input type="text" autofocus="autofocus" name="task.name" value="${task.name }"><br>
				<fmt:message key="task.description"/><textarea name="task.description">${task.description }</textarea><br>
				<fmt:message key="task.time"/><input type="number" name="task.time" value="${task.time }" maxlength="3" size="5" ><br>
				<fmt:message key="task.specialty"/>
				<select name="task.specialty">
					<c:forEach var="specialty" items="${specialties }">
						<option value="${specialty }" ${task.specialty == specialty ? 'selected' : '' }>${specialty.name }</option>
					</c:forEach>
				</select><br>
				<fmt:message key="task.active"/><input type="checkbox" name="task.active" ${task.active == true ? "checked='checked'" : '' }>
				<button type="submit"><fmt:message key="send"/></button> 			
			</form>
		</div>
		<div>
			<form action="${linkTo[TaskController].list }">
				<button type="submit"><fmt:message key="back"/></button>
			</form>
		</div>
		<div id="dialog-message"></div>

		<script type="text/javascript" src="<c:url value='/js/jquery-1.7.2.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.8.23.custom.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/beautySalon.js' />"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				errors = "";
				if(${not empty errors}){
					<c:forEach var="error" items="${errors}">
						error = "";
						if(errors.trim().length > 0) {
							error += "<br>${error.message}";
						} else {
							error = "${error.message}";
						}
						
						errors += error;
					</c:forEach>
		
					showValidationMessages("Ops", errors);
				}
			});
		</script>
	</body>
</html>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery-ui-1.8.23.custom.css' />" />
		<title><fmt:message key="professional.form"/></title>
	</head>
	<body>
		<form action="${linkTo[ProfessionalController].add}" method="post" enctype="multipart/form-data">
			<div id="personalInformation">
				<fmt:message key="person.name"/><input type="text" id="name" name="professional.name" value="${professional.name }" required="required"><br/>
				<fmt:message key="person.cpf"/><input type="text" id="cpf" name="professional.cpf" value="${professional.cpf }" required="required"><br/>
				<fmt:message key="person.rg"/><input type="text" id="rg" name="professional.rg" value="${professional.rg }"><br/>
				<fmt:message key="person.photo"/><input type="file" name="photo"><br/>
				<fmt:message key="professional.specialty"/>
				<select name="professional.specialty">
					<c:forEach var="specialty" items="${specialties }">
						<option value="${specialty }">${specialty.name }</option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div id="adressInformation">
				<fmt:message key="adress.street"/><input type="text" id="street" name="professional.adress.street" value="${professional.adress.street }"><br/>
				<fmt:message key="adress.number"/><input type="text" id="number" name="professional.adress.number" value="${professional.adress.number }"><br/>
				<fmt:message key="adress.neighborhood"/><input type="text" id="neighborhood" name="professional.adress.neighborhood" value="${professional.adress.neighborhood }"><br/>
				<fmt:message key="adress.city"/><input type="text" id="city" name="professional.adress.city" value="${professional.adress.city }"><br/>
				<fmt:message key="adress.state"/><input type="text" id="state" name="professional.adress.state" value="${professional.adress.state }"><br/>
				<fmt:message key="adress.complement"/><input type="text" id="complement" name="professional.adress.complement" value="${professional.adress.complement }"><br/>
				<fmt:message key="adress.cep"/><input type="text" id="cep" name="professional.adress.cep" value="${professional.adress.cep }"><br/>
			</div>
			<br>
			<div id="contactInformation">
				<div id="phone">
					<fmt:message key="phone.ddd"/><input type="text" name="professional.phones[0].ddd">
					<fmt:message key="phone.number"/><input type="text" name="professional.phones[0].number">
					<select name="professional.phones[0].type">
						<c:forEach var="phoneType" items="${phoneTypes }">
							<option value="${phoneType }">${phoneType.name }</option>
						</c:forEach>
					</select>
					<br>
					<fmt:message key="phone.ddd"/><input type="text" maxlength="2" name="professional.phones[1].ddd">
					<fmt:message key="phone.number"/><input type="text" maxlength="9" name="professional.phones[1].number">
					<select name="professional.phones[1].type">
						<c:forEach var="phoneType" items="${phoneTypes }">
							<option value="${phoneType }">${phoneType.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit"><fmt:message key="save"/></button>
		</form>
		<form action="${linkTo[ProfessionalController].list }">
			<button type="submit"><fmt:message key="back"/></button>
		</form>
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
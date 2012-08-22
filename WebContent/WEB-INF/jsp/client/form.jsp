<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><fmt:message key="client.form"/></title>
	</head>
	<body>
		<form action="${linkTo[ClientController].add}" method="post" enctype="multipart/form-data">
			<div id="personalInformation">
				<fmt:message key="person.name"/><input type="text" id="name" name="client.name" value="${client.name }" required="required"><br/>
				<fmt:message key="person.cpf"/><input type="text" id="cpf" name="client.cpf" value="${client.cpf }" required="required"><br/>
				<fmt:message key="person.rg"/><input type="text" id="rg" name="client.rg" value="${client.rg }"><br/>
				<fmt:message key="person.photo"/><input type="file" name="photo"><br/>
			</div>
			<br>
			<div id="adressInformation">
				<fmt:message key="adress.street"/><input type="text" id="street" name="client.adress.street" value="${client.adress.street }"><br/>
				<fmt:message key="adress.number"/><input type="text" id="number" name="client.adress.number" value="${client.adress.number }"><br/>
				<fmt:message key="adress.neighborhood"/><input type="text" id="neighborhood" name="client.adress.neighborhood" value="${client.adress.neighborhood }"><br/>
				<fmt:message key="adress.city"/><input type="text" id="city" name="client.adress.city" value="${client.adress.city }"><br/>
				<fmt:message key="adress.state"/><input type="text" id="state" name="client.adress.state" value="${client.adress.state }"><br/>
				<fmt:message key="adress.complement"/><input type="text" id="complement" name="client.adress.complement" value="${client.adress.complement }"><br/>
				<fmt:message key="adress.cep"/><input type="text" id="cep" name="client.adress.cep" value="${client.adress.cep }"><br/>
			</div>
			<br>
			<div id="contactInformation">
				<div id="phone">
					<fmt:message key="phone.ddd"/><input type="text" name="client.phones[0].ddd">
					<fmt:message key="phone.number"/><input type="text" name="client.phones[0].number">
					<select name="client.phones[0].type">
						<c:forEach var="phoneType" items="${phoneTypes }">
							<option value="${phoneType }">${phoneType.name }</option>
						</c:forEach>
					</select>
					<br>
					<fmt:message key="phone.ddd"/><input type="text" maxlength="2" name="client.phones[1].ddd">
					<fmt:message key="phone.number"/><input type="text" maxlength="9" name="client.phones[1].number">
					<select name="client.phones[1].type">
						<c:forEach var="phoneType" items="${phoneTypes }">
							<option value="${phoneType }">${phoneType.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit"><fmt:message key="save"/></button>
		</form>
		<form action="${linkTo[ClientController].list }">
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
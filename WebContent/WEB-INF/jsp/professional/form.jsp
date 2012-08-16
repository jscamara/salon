<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><fmt:message key="professional.form"/></title>
	</head>
	<body>
		<form action="${linkTo[ProfessionalController].add}" method="post" enctype="multipart/form-data">
			<div id="personalInformation">
				<fmt:message key="professional.name"/><input type="text" id="name" name="professional.name" value="${professional.name }" required="required"><br/>
				<fmt:message key="professional.cpf"/><input type="text" id="cpf" name="professional.cpf" value="${professional.cpf }" required="required"><br/>
				<fmt:message key="professional.rg"/><input type="text" id="rg" name="professional.rg" value="${professional.rg }"><br/>
				<fmt:message key="professional.photo"/><input type="file" name="photo"><br/>
			</div>
			<br>
			<div id="adressInformation">
				<fmt:message key="professional.adress.street"/><input type="text" id="street" name="professional.adress.street" value="${professional.adress.street }"><br/>
				<fmt:message key="professional.adress.number"/><input type="text" id="number" name="professional.adress.number" value="${professional.adress.number }"><br/>
				<fmt:message key="professional.adress.neighborhood"/><input type="text" id="neighborhood" name="professional.adress.neighborhood" value="${professional.adress.neighborhood }"><br/>
				<fmt:message key="professional.adress.city"/><input type="text" id="city" name="professional.adress.city" value="${professional.adress.city }"><br/>
				<fmt:message key="professional.adress.state"/><input type="text" id="state" name="professional.adress.state" value="${professional.adress.state }"><br/>
				<fmt:message key="professional.adress.complement"/><input type="text" id="complement" name="professional.adress.complement" value="${professional.adress.complement }"><br/>
				<fmt:message key="professional.adress.cep"/><input type="text" id="cep" name="professional.adress.cep" value="${professional.adress.cep }"><br/>
			</div>
			<br>
			<div id="contactInformation">
				<fmt:message key="professional.phone.number"/><input type="text" id="phone">
				<select>
					<c:forEach var="phoneType" items="${phoneTypes }">
						<option value="${phoneType }">${phoneType.name }</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit"><fmt:message key="send"/></button>
		</form>
	</body>
</html>
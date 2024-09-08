<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aterar Consulta</title>
</head>
<body>
	<form action="/clinicaveterinaria/ConsultaAlterar" method="get">
	<input type="hidden" name="id" value ="${consulta.id}" >
		Data: <input type="date" name="data" value="${consulta.data}" ><br>
		Hora: <input type="time" name="hora" value="${consulta.hora}"><br>
		Valor: <input type="number" name="valor"><br>
		Animal:
		<select name="idanimal">
			<c:forEach var="ani" items="${animais}">
				<option value="${ani.id}"> ${ani.nome} </option>
			</c:forEach>
		</select><br>
		Veterinario:
		<select name="idveterinario">
			<c:forEach var="vet" items="${veterinarios}">
				<option value="${vet.id}"> ${vet.nome} </option>
			</c:forEach>
		</select><br>
		<input type="submit">
	</form>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
	<p>${data}</p>
	<c:if test="${sucesso}">
	    <p>Consulta alterada com sucesso!</p>
	</c:if>
</body>
</html>
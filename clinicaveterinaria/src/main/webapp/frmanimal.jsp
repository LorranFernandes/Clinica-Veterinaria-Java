<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Animal</title>
</head>
<body>
	<form action="/clinicaveterinaria/AnimalAdd" method="get">
		Nome: <input type="text" name="nome"> <br>
		Especie: <input type="text" name="especie"> <br>
		Raca: <input type="text" name="raca"> <br>
		Idade: <input type="number" name="idade"> <br>
		Clientes 
		<select name="idcliente">
			<c:forEach var="cli" items="${clientes}">
				<option value="${cli.id}"> ${cli.nome} </option>
			</c:forEach>
		</select>
		<br>
		<input type="submit" name="valor"> <br>
	</form>
	<br>
	<br>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
	<p>${nomeAnimal}</p>
	<c:if test="${sucesso}">
	    <p>Animal adicionado com sucesso!</p>
	</c:if>
	
	
</body>
</html>
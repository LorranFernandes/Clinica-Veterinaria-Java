<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinario</title>
</head>
<body>
	<form action="/clinicaveterinaria/VeterinarioAdd" method="get">
		Nome: <input type="text" name="nome" ><br>
		Especialidade: <input type="text" name="especialidade"><br>
		<input type="submit">
	</form>

	<br>
	<br>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
	<p>${nomeVeterinario}</p>
	<c:if test="${sucesso}">
	    <p>Veterinario adicionado com sucesso!</p>
	</c:if>
	
	
</body>
</html>
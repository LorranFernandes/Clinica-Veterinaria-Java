<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Veterinario</title>
</head>
<body>
	<form action="/clinicaveterinaria/VeterinarioAlterar" method="get">
	<input type="hidden" name="id" value ="${veterinario.id}" > 
		Nome: <input type="text" name="nome" ><br>
		Especialidade: <input type="text" name="especialidade"><br>
		<input type="submit">
	</form>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
	<p>${nomeVeterinario}</p>
	<c:if test="${sucesso}">
	    <p>Veterinario alterado com sucesso!</p>
	</c:if>
</body>
</html>
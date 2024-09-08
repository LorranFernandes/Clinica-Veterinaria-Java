<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alterar Cliente</title>
</head>
<body>
	<form action="/clinicaveterinaria/ClienteAlterar" method="get">
	<input type="hidden" name="id" value ="${cliente.id}" > 
		Nome: <input type="text" name="nome" ><br>
		Telefone: <input type="text" name="telefone"><br>
		<input type="submit">
	</form>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
		<p>${nomeCliente}</p>
	<c:if test="${sucesso}">
	    <p>Cliente alterado com sucesso!</p>
	</c:if>
	
</body>
</html>
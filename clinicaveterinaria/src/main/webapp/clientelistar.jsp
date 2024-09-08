<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Clientes</title>
</head>
<body>
	<form action="/clinicaveterinaria/ClienteListar" method="get">
			Buscar <input type="text" name="txt"> <br>
			<input type="hidden" name="next" value="/clientelistar.jsp">
			<input type="submit" value="Buscar">
	</form>
	
	<table border="1">
		<tr> <td> Id </td> <td> Nome </td> <td> Excluir </td>  <td> Alterar </td></tr>
	<c:forEach var="cli" items="${clientes}">
		<tr>
			<td> ${cli.id} </td>
			<td> ${cli.nome} </td>
			<td> <a href="/clinicaveterinaria/ClienteExcluir?id=${cli.id}"> Excluir  </a></td>
			<td> <a href="/clinicaveterinaria/ClientePrepara?id=${cli.id}"> Alterar  </a></td>
		</tr>	
	</c:forEach>
	
	</table>

	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
</body>
</html>
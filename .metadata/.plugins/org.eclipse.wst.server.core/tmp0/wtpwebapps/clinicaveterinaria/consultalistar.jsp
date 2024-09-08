<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Consultas</title>
</head>
<body>
	<form action="/clinicaveterinaria/ConsultaListar" method="get">
		Buscar <input type="text" name="txt"> <br>
		<input type="hidden" name="next" value="/consultalistar.jsp">
		<input type="submit" value="Buscar">
	</form>

	<table border="1">
		<tr> <td> Id </td> <td> Data </td> <td> Hora </td> <td> Valor </td> <td> Animal </td> <td> Veterinario </td>
		<td> Excluir </td>  <td> Alterar </td></tr>
	<c:forEach var="con" items="${consultas}">
		<tr>
			<td> ${con.id} </td>
			<td> ${con.data} </td>
			<td> ${con.hora} </td>
			<td> ${con.valor} </td>
			<td> ${con.animal.nome} </td>
			<td> ${con.veterinario.nome} </td>
			<td> <a href="/clinicaveterinaria/ConsultaExcluir?id=${con.id}"> Excluir </a> </td>
			<td> <a href="/clinicaveterinaria/ConsultaPrepara?id=${con.id}"> Alterar </a> </td>			
		</tr>	
	</c:forEach>
	</table>

	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
</body>
</html>
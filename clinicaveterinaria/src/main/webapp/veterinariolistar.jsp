<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Veterinarios</title>
</head>
<body>
	<form action="/clinicaveterinaria/VeterinarioListar" method="get">
			Buscar <input type="text" name="txt"> <br>
			<input type="hidden" name="next" value="/veterinariolistar.jsp">
			<input type="submit" value="Buscar">
	</form>
	
	<table border="1">
		<tr> <td> Id </td> <td> Nome </td> <td> Excluir </td>  <td> Alterar </td></tr>
	<c:forEach var="vet" items="${veterinarios}">
		<tr>
			<td> ${vet.id} </td>
			<td> ${vet.nome} </td>
			<td> <a href="/clinicaveterinaria/VeterinarioExcluir?id=${vet.id}"> Excluir  </a></td>
			<td> <a href="/clinicaveterinaria/VeterinarioPrepara?id=${vet.id}"> Alterar  </a></td>
		</tr>	
	</c:forEach>
	
	</table>
	<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Animais</title>
</head>
<body>
	<form action="/clinicaveterinaria/AnimalListar" method="get">
		Buscar <input type="text" name="txt"> <br>
		<input type="hidden" name="next" value="/animallistar.jsp">
		<input type="submit" value="Buscar">
	</form>

	<table border="1">
		<tr> <td> Id </td> <td> Nome </td> <td> Especie </td> 
		<td> Tutor </td> <td> Excluir </td>  <td> Alterar </td></tr>
	<c:forEach var="animal" items="${animais}">
		<tr>
			<td> ${animal.id} </td>
			<td> ${animal.nome} </td>
			<td> ${animal.especie} </td>
			<td> ${animal.cliente.nome} </td>

			<td> <a href="/clinicaveterinaria/AnimalExcluir?id=${animal.id}"> Excluir </a> </td>
			<td> <a href="/clinicaveterinaria/AnimalPrepara?id=${animal.id}"> Alterar </a> </td>			
		</tr>	
	</c:forEach>
</table>

<br>
	<a href="/clinicaveterinaria/menu.jsp">Voltar ao menu </a> <br>
</body>
</html>
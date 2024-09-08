<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<a href="/clinicaveterinaria/frmcliente.jsp"> Registrar Cliente </a> <br>
	<a href="/clinicaveterinaria/ClienteListar?next=clientelistar.jsp"> Listar Clientes </a><br><br>
	
	<a href="/clinicaveterinaria/ClienteListar?next=frmanimal.jsp"> Registrar Animal </a><br>
	<a href="/clinicaveterinaria/AnimalListar?next=animallistar.jsp"> Listar Animais </a><br><br>
	
	<a href="/clinicaveterinaria/ListarAnimalVeterinario?next=frmconsulta.jsp"> Registrar Consulta </a> <br>
	<a href="/clinicaveterinaria/ConsultaListar?next=consultalistar.jsp"> Listar Consultas </a><br><br>
	
	<a href="/clinicaveterinaria/frmveterinario.jsp"> Registrar Veterinario </a> <br>
	<a href="/clinicaveterinaria/VeterinarioListar?next=veterinariolistar.jsp"> Listar Veterinarios </a><br><br>
</body>
</html>
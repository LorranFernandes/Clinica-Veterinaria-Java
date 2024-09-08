<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Administrador</title>
</head>
<body>
	<form action="/clinicaveterinaria/AdministradorAdd" method="POST">
		Nome: <input type="text" name="nome" value="${admin.nome}"><br>
		Login: <input type="password" name="login" value="${admin.login}"><br>
		Senha: <input type="password" name="senha" value="${admin.senha}"><br>
		<input type="submit">
	</form>
</body>
</html>
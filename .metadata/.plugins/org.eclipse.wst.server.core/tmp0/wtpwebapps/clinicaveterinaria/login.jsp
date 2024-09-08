<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%
        Cookie[] cookies = request.getCookies();
        String savedLogin = "";
        String savedSenha = "";
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("login".equals(cookie.getName())) {
                    savedLogin = cookie.getValue();
                } else if ("senha".equals(cookie.getName())) {
                    savedSenha = cookie.getValue();
                }
            }
        }
    %>
    
    <form action="/clinicaveterinaria/AdministradorLogar" method="POST">
        Login <input type="text" name="login" value="<%= savedLogin %>"> <br>
        Senha <input type="password" name="senha" value="<%= savedSenha %>"> <br>
        <input type="submit"> 
    </form>
    
    <p>${msg}</p>
</body>
</html>
package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.dao.AdministradorDao;
import br.cefet.clinicaveterinaria.model.Administrador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdministradorLogar
 */
public class AdministradorLogar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministradorLogar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = null;
		String nextPage = null;
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Administrador admin = null;
		AdministradorDao adminDao = new AdministradorDao();
		try {
			admin = adminDao.logar(login, senha);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("administrador", admin);
		
		if (admin == null) {
			msg = "Login inválido!";
			nextPage = "/login.jsp";
			request.setAttribute("msg", msg);
		}else {
			// Salva o login e a senha nos cookies
	        Cookie loginCookie = new Cookie("login", login);
	        Cookie senhaCookie = new Cookie("senha", senha);
	        
	        // Define o tempo de vida dos cookies 7 dias
	        loginCookie.setMaxAge(7 * 24 * 60 * 60); // 7 dias em segundos
	        senhaCookie.setMaxAge(7 * 24 * 60 * 60);
	        
	        // Adiciona os cookies na resposta
	        response.addCookie(loginCookie);
	        response.addCookie(senhaCookie);
	        
			nextPage = "menu.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.dao.ClienteDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClienteExcluir
 */
public class ClienteExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		String msg = "";
		String next = "/ClienteListar?next=clientelistar.jsp";
		
		ClienteDao cliDao = new ClienteDao();
		try {
			cliDao.excluir(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			next = "/erro.jsp";
			msg = "Não foi excluir o cliente. Tente novamente!";	
		}
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher(next);
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

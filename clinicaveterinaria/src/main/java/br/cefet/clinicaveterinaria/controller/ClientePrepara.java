package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.dao.ClienteDao;
import br.cefet.clinicaveterinaria.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClientePrepara
 */
public class ClientePrepara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientePrepara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair o id cliente
		int id = Integer.valueOf(request.getParameter("id"));
		
		// Próxima página
		String next = "/frmclientealterar.jsp";
		String msg = "";
		
		// Buscar o cliente
		Cliente cliente = null;
		ClienteDao cliDao = new ClienteDao();
		try {
			cliente = cliDao.listarUm(id);
		} catch (SQLException e) {
			next = "/erro.jsp";
			msg = "Não foi possível buscar o cliente. Tente novamente!";		
		}
				
						
		// Despachar um objeto - o cliente - para a o form do update
		request.setAttribute("cliente", cliente);
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

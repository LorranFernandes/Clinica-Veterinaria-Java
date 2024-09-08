package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefet.clinicaveterinaria.dao.ClienteDao;
import br.cefet.clinicaveterinaria.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ClienteListar
 */
public class ClienteListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteListar() {
        super();
        // TODO Auto-generated constructor stub 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. Instanciar o ClienteDao
		 * 2. Fazer um List de clientes
		 * 3. Despachar para a página clientelistar.jsp
		 */
		String txt = request.getParameter("txt");
		ClienteDao cliDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			if(txt != null) {
				clientes = cliDao.listar(txt);
			}else{
				clientes = cliDao.listarTodos();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clientes", clientes);
		
		String next = request.getParameter("next");
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

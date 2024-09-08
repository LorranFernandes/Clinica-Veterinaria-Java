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
 * Servlet implementation class ClienteAlterar
 */
public class ClienteAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteAlterar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		
		// Instanciar um cliente
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);


		//Salvar um cliente
		ClienteDao cliDao = new ClienteDao();
		boolean sucesso = false;
		try {
			cliDao.alterar(cliente);
			sucesso = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Definir atributo com o nome para exibir na página JSP
		request.setAttribute("nomeCliente", nome);
		request.setAttribute("sucesso", sucesso);

		// Encaminhar para a página JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("frmclientealterar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

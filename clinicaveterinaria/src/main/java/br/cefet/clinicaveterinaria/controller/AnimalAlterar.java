package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.dao.AnimalDao;
import br.cefet.clinicaveterinaria.dao.ClienteDao;
import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnimalAlterar
 */
public class AnimalAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalAlterar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String especie = request.getParameter("especie");
		String raca = request.getParameter("raca");
		int idade = Integer.valueOf(request.getParameter("idade"));
		int idcliente = Integer.valueOf(request.getParameter("idcliente"));
		
		// Instanciar um produto
		Animal animal = new Animal();
		animal.setId(id);
		animal.setNome(nome);
		animal.setEspecie(especie);
		animal.setRaca(raca);
		animal.setIdade(idade);

		//Buscar um cliente para o id informado em <frmanimalalterar.jsp> 
		ClienteDao cliDao = new ClienteDao();
		Cliente cliente = null;
		try {
			cliente = cliDao.listarUm(idcliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		animal.setCliente(cliente);

		//Salvar um produto
		AnimalDao aniDao = new AnimalDao();
		boolean sucesso = false;
		try {
			aniDao.alterar(animal);
			sucesso = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Definir atributo com o nome para exibir na página JSP
		request.setAttribute("nomeAnimal", nome);
		request.setAttribute("sucesso", sucesso);

		// Encaminhar para a página JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ClienteListar?next=frmanimalalterar.jsp");
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

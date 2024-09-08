package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;

import br.cefet.clinicaveterinaria.dao.VeterinarioDao;
import br.cefet.clinicaveterinaria.model.Veterinario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class VeterinarioAdd
 */
public class VeterinarioAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeterinarioAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair o nome
		String nome = request.getParameter("nome");
		String especialidade = request.getParameter("especialidade");

		
		// Instanciar um cliente
		Veterinario veterinario = new Veterinario();
		veterinario.setNome(nome);
		veterinario.setEspecialidade(especialidade);

		// Salvar no BD
		VeterinarioDao vetDao = new VeterinarioDao();
		boolean sucesso = false;
		try {
			vetDao.adicionar(veterinario);
			sucesso = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		// Definir atributo com o nome para exibir na página JSP
		request.setAttribute("nomeVeterinario", nome);
		request.setAttribute("sucesso", sucesso);

		// Encaminhar para a página JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("frmveterinario.jsp");
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

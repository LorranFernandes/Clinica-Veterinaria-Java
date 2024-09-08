package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import br.cefet.clinicaveterinaria.dao.AnimalDao;
import br.cefet.clinicaveterinaria.dao.ConsultaDao;
import br.cefet.clinicaveterinaria.dao.VeterinarioDao;
import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Consulta;
import br.cefet.clinicaveterinaria.model.Veterinario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConsultaAdd
 */
public class ConsultaAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair os valores
		String horaStr = request.getParameter("hora") + ":00";
		Date data = Date.valueOf(request.getParameter("data"));
		Time hora = Time.valueOf(horaStr);
		float valor = Float.valueOf(request.getParameter("valor"));
		int idAnimal = Integer.valueOf(request.getParameter("idanimal"));
		int idVeterinario = Integer.valueOf(request.getParameter("idveterinario"));
		
		// Instanciar um consulta
		Consulta consulta = new Consulta();
		consulta.setData(data);
		consulta.setHora(hora);
		consulta.setValor(valor);
		
		//Buscar uma animal para o id informado em <frconsulta.jsp> 
		AnimalDao aniDao = new AnimalDao();
		Animal animal = null;
		try {
			animal = aniDao.listarUm(idAnimal);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consulta.setAnimal(animal);
		
		//Buscar uma veterinario para o id informado em <frconsulta.jsp> 
		VeterinarioDao vetDao = new VeterinarioDao();
		Veterinario veterinario = null;
		try {
			veterinario = vetDao.listarUm(idVeterinario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consulta.setVeterinario(veterinario);

		//Salvar no bd
		ConsultaDao conDao = new ConsultaDao();
		boolean sucesso = false;
		try {
			conDao.adicionar(consulta);
			sucesso = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Definir atributo com o nome para exibir na página JSP
		String txt = data+ " as "+ hora;
		request.setAttribute("data", txt);
		request.setAttribute("sucesso", sucesso);

		// Encaminhar para a página JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarAnimalVeterinario?next=frmconsulta.jsp");
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

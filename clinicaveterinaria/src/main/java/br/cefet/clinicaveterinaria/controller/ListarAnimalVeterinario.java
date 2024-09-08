package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.cefet.clinicaveterinaria.dao.AnimalDao;
import br.cefet.clinicaveterinaria.dao.VeterinarioDao;
import br.cefet.clinicaveterinaria.model.Animal;
import br.cefet.clinicaveterinaria.model.Veterinario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarAnimalVeterinario
 */
public class ListarAnimalVeterinario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAnimalVeterinario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String txt = request.getParameter("txt");

		// Listar Animais
		AnimalDao aniDao = new AnimalDao();
		List<Animal> animais = null;
		try {
		    if(txt != null) {
		        animais = aniDao.listar(txt);
		    }else{
		        animais = aniDao.listarTodos();
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		request.setAttribute("animais", animais);

		// Listar Veterinarios
		VeterinarioDao vetDao = new VeterinarioDao();
		List<Veterinario> veterinarios = null;
		try {
		    if(txt != null) {
		        veterinarios = vetDao.listar(txt);
		    }else{
		        veterinarios = vetDao.listarTodos();
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		request.setAttribute("veterinarios", veterinarios);

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

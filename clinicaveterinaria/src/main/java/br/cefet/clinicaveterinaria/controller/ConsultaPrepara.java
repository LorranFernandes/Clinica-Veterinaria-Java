package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class ConsultaPrepara
 */
public class ConsultaPrepara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPrepara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair o id consulta
				int id = Integer.valueOf(request.getParameter("id"));
				
				// Próxima página
				String next = "/ListarAnimalVeterinario?next=frmconsultaalterar.jsp";
				String msg = "";
				
				// Buscar a consulta
				Consulta consulta = null;
				ConsultaDao conDao = new ConsultaDao();
				try {
					consulta = conDao.listarUm(id);
				} catch (SQLException e) {
					next = "/erro.jsp";
					msg = "Não foi possível buscar a consulta. Tente novamente!";		
				}
						
				
				AnimalDao aniDao = new AnimalDao();
				List<Animal> animais = null;
				try {
					animais = aniDao.listarTodos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("animais", animais);
				
				
				VeterinarioDao vetDao = new VeterinarioDao();
				List<Veterinario> veterinarios = null;
				try {
					veterinarios = vetDao.listarTodos();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("veterinarios", veterinarios);
				
				
				
				// Despachar um objeto - o consulta - para a o form do update
				request.setAttribute("consulta", consulta);
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

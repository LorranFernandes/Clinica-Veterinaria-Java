package br.cefet.clinicaveterinaria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class AnimalPrepara
 */
public class AnimalPrepara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalPrepara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair o id animal
		int id = Integer.valueOf(request.getParameter("id"));
		
		// Próxima página
		String next = "/ClienteListar?next=frmanimalalterar.jsp";
		String msg = "";
		
		// Buscar o animal
		Animal animal = null;
		AnimalDao aniDao = new AnimalDao();
		try {
			animal = aniDao.listarUm(id);
		} catch (SQLException e) {
			next = "/erro.jsp";
			msg = "Não foi possível buscar o animal. Tente novamente!";		
		}
				
		
		ClienteDao cliDao = new ClienteDao();
		List<Cliente> clientes = null;
		try {
			clientes = cliDao.listarTodos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("clientes", clientes);
		
		
		
		// Despachar um objeto - o animal - para a o form do update
		request.setAttribute("animal", animal);
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

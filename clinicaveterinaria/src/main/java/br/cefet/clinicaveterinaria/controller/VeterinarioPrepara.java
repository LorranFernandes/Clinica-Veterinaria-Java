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
 * Servlet implementation class VeterinarioPrepara
 */
public class VeterinarioPrepara extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VeterinarioPrepara() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Extrair o id veterinario
		int id = Integer.valueOf(request.getParameter("id"));
		
		// Próxima página
		String next = "/frmveterinarioalterar.jsp";
		String msg = "";
		
		// Buscar o veterinario
		Veterinario veterinario = null;
		VeterinarioDao vetDao = new VeterinarioDao();
		try {
			veterinario = vetDao.listarUm(id);
		} catch (SQLException e) {
			next = "/erro.jsp";
			msg = "Não foi possível buscar o veterinario. Tente novamente!";		
		}
				
						
		// Despachar um objeto - o veterinario - para a o form do update
		request.setAttribute("veterinario", veterinario);
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

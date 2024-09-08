package br.cefet.clinicaveterinaria.filtro;

import java.io.IOException;

import br.cefet.clinicaveterinaria.model.Administrador;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroEntrada
 */
@WebFilter("/*")
public class FiltroEntrada extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroEntrada() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		// Url que o usuário esta tentando acessar
		String url = req.getRequestURI();
		
		// Pegar a session
		HttpSession session = req.getSession();
		
		// Pegar o Cliente
		Administrador admin = (Administrador) session.getAttribute("administrador");
		System.out.println(url);
			
		if (admin==null){			
		    if (url.startsWith("/clinicaveterinaria/login.jsp") ||
		    		url.startsWith("/clinicaveterinaria/AdministradorLogar"))
		    	chain.doFilter(request, response);			
		    else
		    	resp.sendRedirect("/clinicaveterinaria/login.jsp");        		
		}else{			
		    chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

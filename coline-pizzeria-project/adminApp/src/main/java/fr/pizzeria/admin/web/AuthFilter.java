package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {


    /**
     * Default constructor. 
     */
    public AuthFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		// pass the request along the filter chain

		System.out.println(session.getAttribute("email"));
	       Object login = session.getAttribute("email");
	       
	       if(login != null || req.getRequestURI().contains("/login")) {
	           // connect�
	            chain.doFilter(request, response);
	       } else {
	           // non connect�
	       
	           ((HttpServletResponse) response).sendRedirect(req.getContextPath() + "/login");
	           
	       }}
		
	/*	if((("admin@pizzeria.fr").equals(session.getAttribute("email"))) && (("admin").equals(session.getAttribute("password"))))
		{
			chain.doFilter(request, response);}
		else{
			((HttpServletResponse) response).sendRedirect("login");
			//System.out.println("vous devez vous identifier");
		}
	}*/

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}

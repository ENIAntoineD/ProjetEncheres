package fr.eni.ProjetEncheres;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JCheckBox;

/**
 * Servlet implementation class ServletSessionCookie
 */
@WebServlet("/ServletSessionCookie")
public class ServletSessionCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

	}
	
	public static void cookieConnexion(HttpServletRequest request, HttpServletResponse response)
	{
		
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		if (request.getParameter("souvenir") != null  ) {
			LocalDateTime dt =  LocalDateTime.now();
			String date = dt.toString();
	        setCookie(response, "cookieDerniereConnexion", date, 864000);
			session.setAttribute("cookie", true);
		}
		else {
			setCookie(response, "cookieDerniereConnexion", "", 0);
		}
		
		for (Cookie cookie : cookies) {
		if (cookie.getName().equals("cookieDerniereConnexion") ) 
		{
			LocalDateTime dt =  LocalDateTime.now();
			String date = dt.toString();
	        setCookie(response, "cookieDerniereConnexion", date, 864000);
	        System.out.println("test");
		}
			
		}
	}
	
	public static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
	    Cookie cookie = new Cookie( nom, valeur );
	    cookie.setMaxAge( maxAge );
	    response.addCookie( cookie );
	}

}

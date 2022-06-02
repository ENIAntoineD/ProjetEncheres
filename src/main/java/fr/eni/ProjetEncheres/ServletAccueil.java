package fr.eni.ProjetEncheres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (request.getParameter("deconnexion") != null) {
			ServletSessionCookie.setCookie(response, "cookieDerniereConnexion", "", 0);
			session.setAttribute("connecte", false);
		}
		
		
		if (request.getParameter("test") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/test.jsp");
			rd.forward(request, response);  
		}
		else {

			boolean isConnected = false;
			if(session != null && session.getAttribute("connecte")!= null) {
				isConnected = (boolean)session.getAttribute("connecte");
			}
			
		session.setAttribute("connecte", isConnected);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Accueil.jsp");
		rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package fr.eni.ProjetEncheres;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ProjetEncheres.bo.ArticleVendu;
import fr.eni.ProjetEncheres.dal.jdbc.ArticlesDAOJdbcImpl;

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
		
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		
		ArticlesDAOJdbcImpl articleDao = new ArticlesDAOJdbcImpl();
		
		//if (articleDao.getArticles() != null) {
			
			articles = articleDao.getArticles();
			session.setAttribute("afficher",articles );
			
	//	}
		if(request.getParameter("lien") != null) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailVente.jsp");
		rd.forward(request, response);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

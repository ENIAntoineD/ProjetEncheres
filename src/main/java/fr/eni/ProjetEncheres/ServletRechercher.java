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

import fr.eni.ProjetEncheres.bll.UtilisateurManager;
import fr.eni.ProjetEncheres.bo.Utilisateur;
import fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ServletRechercher
 */
@WebServlet("/ServletRechercher")
public class ServletRechercher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/recherche.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur user = new Utilisateur( 23, request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"), "",
				"", "", "", "", "", false);
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		
		
		UtilisateurDAOJdbcImpl utilisateur = new UtilisateurDAOJdbcImpl();
		
		if (utilisateur.getInfos(user) != null) {
			
			users = utilisateur.getInfos(user);
			request.setAttribute("rechercher",users );
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/recherche.jsp");
		rd.forward(request, response);
			
		
	}

}

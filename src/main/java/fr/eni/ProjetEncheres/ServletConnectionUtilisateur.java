package fr.eni.ProjetEncheres;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ProjetEncheres.bll.UtilisateurManager;
import fr.eni.ProjetEncheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletConnectionUtilisateur
 */
@WebServlet("/ServletConnectionUtilisateur")
public class ServletConnectionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexionUtilisateur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur user = new Utilisateur( 23, request.getParameter("pseudo"), "zez", "", "",
				"", "", "", "", request.getParameter("motdepasse"), false);
		UtilisateurManager utilisateur = new UtilisateurManager();
		boolean connect = false;
		
		
		if (utilisateur.VerificationPseudo(user) && utilisateur.VerificationMDP(user)) {
			System.out.println("connecté"); 
			connect = true;
			
		}
		
		if (!connect) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/erreurConnexion.jsp");
			rd.forward(request, response); 
		}
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexionUtilisateur.jsp");
			rd.forward(request, response); 
		}
	
		
	}

}
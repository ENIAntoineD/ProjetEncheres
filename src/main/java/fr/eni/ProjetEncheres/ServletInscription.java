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

import fr.eni.javaee.module4.bll.AvisManager;
import fr.eni.javaee.module4.bo.Avis;
import fr.eni.javaee.module4.servlets.CodesResultatServlets;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pseudo;
		String email;
		String motdepasse;
		
		
		try {
			pseudo = request.getParameter("pseudo");
			motdepasse = request.getParameter("motdepasse");
			email = request.getParameter("email");
			
			// BLL : UtilisateurManager (avec méthode ajouter).
			// BO Utilisateur à créer.
				
				
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			
			// Le pseudo n'accepte que des caractères alphanumériques. 
			if (pseudo.matches("^[a-zA-Z0-9]$")) {
			List<Utilisateur> nouveauUtilisateur= utilisateurManager.ajouter(pseudo, motdepasse, email);
			// Vérifier que la base de données ne contient pas déjà le pseudo et l'email
			// Peut-être faire un constructeur avec pseudo et email pour utiliser la méthode
			// contains(Objet obj) sur une liste ? 
 			}
		
			
			
			request.setAttribute("nouveauUtilisateur", nouveauUtilisateur);
		}
		catch (UtilisateurException e)
		{
			List<Integer> listeCodesErreur=new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_PSEUDO_ERREUR);
			//pseudo.matches(^[a-zA-Z0-9]$)
			request.setAttribute("listeCodesErreur",listeCodesErreur);
		}
			
			// Si c'est bon redirection vers page d'accueil 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response);
	}		

}

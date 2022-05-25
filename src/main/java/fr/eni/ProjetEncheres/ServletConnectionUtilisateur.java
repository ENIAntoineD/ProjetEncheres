package fr.eni.ProjetEncheres;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.setAttribute("connecte", false);
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
		Pattern pattern1 = Pattern.compile("^[a-zA-Z0-9@.]{2,10}$");
		Matcher m = pattern1.matcher(request.getParameter("pseudo"));
		boolean testRegex = m.matches();
		HttpSession session = request.getSession();
		
	
		if (!testRegex) {
			System.out.println("erreur pattern");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/erreurConnexion.jsp");
			rd.forward(request, response); 
		}
		
		if (utilisateur.VerificationPseudo(user) && utilisateur.VerificationMDP(user)) {
			System.out.println("connecté"); 
			
			session.setAttribute("connecte", true);
			connect = true;
			
		}
		
		if (!connect && testRegex) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/erreurConnexion.jsp");
			rd.forward(request, response); 
		}
		
		else if(testRegex && connect ){
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response); 
		}
		
	
		
	}

}
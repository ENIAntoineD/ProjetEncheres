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

import fr.eni.ProjetEncheres.bll.BusinessException;
import fr.eni.ProjetEncheres.bo.Utilisateur;
import fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAOJdbcImpl;

/**
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurDAOJdbcImpl userdao = new UtilisateurDAOJdbcImpl();
		Utilisateur user =  new Utilisateur(23, (String) request.getSession().getAttribute("pseudosession"), "zez", "", "",
				"", "", "", "", "", false);
		int index = userdao.selectbypseudo(user);
		user = userdao.getid(index);
		
		request.setAttribute("monprofil", user);
		
		
		
		
		if(request.getParameter("btEnregistrer") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
		rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurDAOJdbcImpl userdao = new UtilisateurDAOJdbcImpl();
		Utilisateur user =  new Utilisateur(0, 23, (String) request.getSession().getAttribute("pseudosession"), request.getParameter("Nom"), request.getParameter("Prenom"),request.getParameter("email"),
				request.getParameter("Telephone"), request.getParameter("Adresse"), request.getParameter("Cp"), request.getParameter("Ville"), request.getParameter("motdepasse"), false);
		int index = userdao.selectbypseudo(user);
		HttpSession session = request.getSession();
				
		request.setAttribute("monprofil", user);

		

		//Pattern pattern1 = Pattern.compile("^(?:(?:\+|00)33[\s.-]{0,3}(?:\(0\)[\s.-]{0,3})?|0)[1-9](?:(?:[\s.-]?\d{2}){4}|\d{2}(?:[\s.-]?\d{3}){2})$");
		//Matcher m = pattern1.matcher(request.getParameter("Telephone"));
		//boolean testRegex = m.matches();

		



//		if (!testRegex) {
//			System.out.println("erreur pattern");
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
//			rd.forward(request, response); 
		//}

		
		//doGet(request, response);
		
		
		if(request.getParameter("btSupprimer") != null) {
			if(userdao.VerificationMDP(index, user) == true) {
			try {
				
				userdao.deleteById(index);
				session.setAttribute("connecte", false);
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
				rd.forward(request, response);
			}
			 catch (BusinessException e) {
				e.printStackTrace();
				
			}
			}
			
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);
			}
		}
		
		if(request.getParameter("btEnregistrer") != null) {
			user = userdao.getid(index);
			user = new Utilisateur(index, 23, request.getParameter("pseudo"), request.getParameter("Nom"), request.getParameter("Prenom"),request.getParameter("email"),
					request.getParameter("Telephone"), request.getParameter("Adresse"), request.getParameter("Cp"), request.getParameter("Ville"), request.getParameter("motdepasse"), false);
			if(userdao.VerificationMDP(index, user) == true) {
			userdao.updateProfil(user);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp" + "?index=" + (String)session.getAttribute("pseudosession"));
			rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
			rd.forward(request, response);
			}
		}
	}

}

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
		
		if(request.getParameter("btEnregistrer") != null) {
			user = userdao.getid(index);
			System.out.println(index);
			user = new Utilisateur(index, 23, request.getParameter("pseudo"), request.getParameter("email"), request.getParameter("Nom"),request.getParameter("Prenom"),
					request.getParameter("Adresse"), request.getParameter("Cp"), request.getParameter("Ville"), request.getParameter("Telephone"), request.getParameter("motdepasse"), false);
			userdao.updateProfil(user);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Profil.jsp");
			rd.forward(request, response);
			System.out.println("update");
		}
		
		if(request.getParameter("btSupprimer") != null) {
			try {
				HttpSession session = request.getSession();
				userdao.deleteById(index);
				session.setAttribute("connecte", false);
			} catch (BusinessException e) {
				e.printStackTrace();
	
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Accueil.jsp");
			rd.forward(request, response);
		}
		
	if(request.getParameter("btEnregistrer") == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modifierProfil.jsp");
	rd.forward(request, response);
	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

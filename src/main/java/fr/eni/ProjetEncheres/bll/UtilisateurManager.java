package fr.eni.ProjetEncheres.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ProjetEncheres.bo.Utilisateur;
import fr.eni.ProjetEncheres.dal.jdbc.ConnectionBDD;
import fr.eni.ProjetEncheres.dal.jdbc.DAOFactory;
import fr.eni.ProjetEncheres.dal.jdbc.UtilisateurDAO;


public class UtilisateurManager {
	
	/*private String select;
	private String update;
	private String delete;
	private String insert;

	public boolean VerificationPseudo(Utilisateur utilisateur) {
		
		select = "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ? or email = ?";
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean pseudo = false;
		
		try {
			cnx = ConnectionBDD.getConnection();
			stmt =  cnx.prepareStatement(select);
			stmt.setString(1,utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getPseudo());
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("pseudo");
				System.out.println("mail");
				pseudo = true;
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cnx != null) {
				try {
					cnx.close();
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		
		}
		
		return pseudo;
	}
	
public boolean VerificationMDP(Utilisateur utilisateur) {
		
		select = "SELECT mot_de_passe FROM UTILISATEURS WHERE mot_de_passe = ? ";
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean mdp = false;
		
		try {
			cnx = ConnectionBDD.getConnection();
			stmt =  cnx.prepareStatement(select);
			stmt.setString(1,utilisateur.getMotDePasse());
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("mdp");
				mdp = true;
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (cnx != null) {
				try {
					cnx.close();
				} catch (SQLException e) { 
					e.printStackTrace(); 
				}
			}
		
		}
		
		return mdp;
	} */
	private UtilisateurDAO utilisateurDAO;
	
	/**
	 * Le constructeur permet d'initialiser la variable membre utilisateurDAO pour 
	 * permettre une communication avec la base de données. 
	 */
	public UtilisateurManager() {
		this.utilisateurDAO= DAOFactory.getUtilisateurDAO();
	}
	
	
	public Utilisateur ajouter(int credit, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, boolean admnistrateur) 
	{
		BusinessException exception = new BusinessException();
		
		// Ajouter un utilisateur non administrateur dans la base de données
		Utilisateur utilisateur = new Utilisateur(credit, pseudo, nom, prenom, email, telephone, rue,
			codePostal, ville, motDePasse, false);
		
		try {
			this.utilisateurDAO.insert(utilisateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Gérer exceptions
		// Et validations
		
		
		return utilisateur;
	}
	
	public boolean VerificationPseudoEtMDP(Utilisateur utilisateur) {
		// Select du pseudo ou de l'email de l'utilisateur
		return this.utilisateurDAO.VerificationPseudoEtMDP(utilisateur);
		
	}
	


	
}

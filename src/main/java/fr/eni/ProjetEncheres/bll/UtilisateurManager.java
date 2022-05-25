package fr.eni.ProjetEncheres.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.ProjetEncheres.bo.Utilisateur;
import fr.eni.ProjetEncheres.dal.jdbc.ConnectionBDD;

public class UtilisateurManager {
	
	private String select;
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
	}
	
}

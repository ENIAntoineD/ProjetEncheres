package fr.eni.tpencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import fr.eni.ProjetEncheres.bo.Utilisateur;


public class UtilisateurJDBCImpl {
	
	private final String SELECTPSEUDO ="SELECT pseudo FROM UTILISATEURS WHERE pseudo = ?";
	private final String SELECTEMAIL = "SELECT pseudo FROM UTILISATEURS WHERE email = ?";
	
	public boolean SelectByPseudo(Utilisateur utilisateur)
	{
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean pseudo = false;
		
		try {
			cnx = ConnectionBDD.getConnection();
			stmt =  cnx.prepareStatement(SELECTPSEUDO);
			stmt.setString(1,utilisateur.getPseudo());
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("pseudo");
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
	
	public boolean SelectByEmail(Utilisateur utilisateur)
	{
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean mail = false;
		
		try {
			cnx = ConnectionBDD.getConnection();
			stmt =  cnx.prepareStatement(SELECTEMAIL);
			stmt.setString(1,utilisateur.getPseudo());
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("mail");
				mail = true;
				
				
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
		
		return mail;
	}
	}



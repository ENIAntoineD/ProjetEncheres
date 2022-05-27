package fr.eni.ProjetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetEncheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	
	private static final String sqlSelectPseudoEtMDP = "SELECT pseudo,mot_de_passe FROM UTILISATEURS WHERE pseudo = ? or email = ? ";
	private static final String sqlSelectPseudo = "SELECT pseudo,nom,prenom,email FROM UTILISATEURS WHERE pseudo like ? or nom like ? or prenom like ? ";

	@Override
	public void insert(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Utilisateur utilisateur) {
		// TODO Auto-generated method stub

	}
	
public boolean VerificationPseudoEtMDP(Utilisateur utilisateur) {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean pseudo = false;
		
		try {
			cnx = ConnectionBDD.getConnection();
			stmt =  cnx.prepareStatement(sqlSelectPseudoEtMDP);
			stmt.setString(1, utilisateur.getPseudo() );
			stmt.setString(2,  utilisateur.getEmail() );
			rs = stmt.executeQuery();
			if (rs.next() && rs.getString(2).equals( utilisateur.getMotDePasse())) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
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

public List<Utilisateur> getInfos(Utilisateur utilisateur) {
	List<Utilisateur> liste = new ArrayList<>();
	Connection cnx = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Utilisateur user = null;
	
	try {
		cnx = ConnectionBDD.getConnection();
		stmt =  cnx.prepareStatement(sqlSelectPseudo);
		stmt.setString(1,"%" +utilisateur.getPseudo() + "%");
		stmt.setString(2,"%" + utilisateur.getNom() + "%");
		stmt.setString(3,"%" + utilisateur.getPrenom() + "%");
		rs = stmt.executeQuery();
		while (rs.next()) {
			 user = new Utilisateur(	 23, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					"", "", "", "", "", false);
			liste.add(user);
			
			
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
	
	return liste;
}
	

	

}

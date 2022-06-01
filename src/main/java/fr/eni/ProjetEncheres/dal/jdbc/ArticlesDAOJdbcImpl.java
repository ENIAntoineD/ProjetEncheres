package fr.eni.ProjetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.ProjetEncheres.bll.BusinessException;
import fr.eni.ProjetEncheres.bo.ArticleVendu;

public class ArticlesDAOJdbcImpl {
	
	// requetes SQL pour les encheres
	
		private static final String sqlSelectByNoArticle = "";
		private static final String sqlSelectAllArticles = "";
		private static final String sqlUpdateArticle = "";
		private static final String sqlDeleteArticle = "";
		private static final String sqlInsertArticle = "";
		
		
		// Insertion d'un utilisateur dans la base de données avec no_utilisateur ajouté automatiquement
		public void insert(ArticleVendu article) throws BusinessException {
			if(article==null)
			{
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatsDAL.INSERT_UTIL_NULL);
				throw businessException;
			}
			
			try (Connection cnx = ConnectionBDD.getConnection() ){

					PreparedStatement stmt = cnx.prepareStatement(sqlInsertArticle, PreparedStatement.RETURN_GENERATED_KEYS);
					int index = 1;
					stmt.setInt(index++, article.getNoArticle());
					stmt.setString(index++, article.getNomArticle());
					stmt.setString(index++, article.getDescription());
					stmt.setDate(index++, (Date)article.getDateDebutEncheres());
					stmt.setDate(index++, (Date)article.getDateFinEncheres());
					stmt.setInt(index++, article.getMiseAPrix());
					stmt.setInt(index++, article.getPrixVente());
					stmt.setBoolean(index++, article.isEtatVente());
					stmt.executeUpdate();
					
					stmt.getGeneratedKeys();
					ResultSet rs = stmt.getGeneratedKeys();
					while(rs.next()) {
						int no_article = rs.getInt(1); 
						article.setNoArticle(no_article);
						System.out.println("Clé générée automatiquement pour l'id: " + no_article);
					}
					System.out.println("Article inséré.");
				} catch (Exception e) 
			{
					e.printStackTrace();
			}
		}
}

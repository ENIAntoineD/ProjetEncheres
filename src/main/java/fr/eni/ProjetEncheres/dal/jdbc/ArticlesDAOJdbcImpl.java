package fr.eni.ProjetEncheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ProjetEncheres.bll.BusinessException;
import fr.eni.ProjetEncheres.bo.ArticleVendu;
import fr.eni.ProjetEncheres.bo.Utilisateur;

public class ArticlesDAOJdbcImpl {
	
	// requetes SQL pour les encheres
	
		private static final String sqlSelectByNoArticle = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie FROM ARTICLES_VENDUS WHERE no_article=?";
		private static final String sqlSelectAllArticles = "SELECT no_article, nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie FROM ARTICLES_VENDUS ";
		private static final String sqlUpdateArticle = "";
		private static final String sqlDeleteArticle = "";
		private static final String sqlInsertArticle = "INSERT INTO ARTICLES_VENDUS VALUES (?,?,?,?,?,?,?)";
		
		
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
		
		public List<ArticleVendu> getArticles() {
			List<ArticleVendu> liste = new ArrayList<>();
			Connection cnx = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArticleVendu article = null;
			
			try {
				cnx = ConnectionBDD.getConnection();
				stmt = cnx.createStatement();
				rs = stmt.executeQuery(sqlSelectAllArticles);
				while (rs.next()) {
					article = new ArticleVendu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
							rs.getInt(6),0, rs.getInt(7), false);
					liste.add(article);
					
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
		
		public ArticleVendu getArticleByID(int noArticle) {
			
			Connection cnx = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArticleVendu article = null;
			
			try {
				
				cnx = ConnectionBDD.getConnection();
				stmt =  cnx.prepareStatement(sqlSelectByNoArticle);
				stmt.setInt(1, noArticle );
				
				rs = stmt.executeQuery();
				
				if (rs.next() ) {
				
					 article = new ArticleVendu( rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
								rs.getInt(6),0, rs.getInt(7), false);
					
					
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
			
			return article;
		}
		
		
}

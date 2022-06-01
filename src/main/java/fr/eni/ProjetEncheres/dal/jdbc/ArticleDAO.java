package fr.eni.ProjetEncheres.dal.jdbc;

import fr.eni.ProjetEncheres.bll.BusinessException;
import fr.eni.ProjetEncheres.bo.ArticleVendu;

	public interface ArticleDAO {
		
		public void insert(ArticleVendu article) throws BusinessException;
		public void deleteById(Integer id) throws BusinessException;
	
}

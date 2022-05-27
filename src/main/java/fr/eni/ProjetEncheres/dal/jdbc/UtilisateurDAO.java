package fr.eni.ProjetEncheres.dal.jdbc;

import fr.eni.ProjetEncheres.bll.BusinessException;
import fr.eni.ProjetEncheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur) throws BusinessException;
	public void deleteById(Integer id) throws BusinessException;
	public boolean VerificationPseudoEtMDP(Utilisateur utilisateur);
	
	
}

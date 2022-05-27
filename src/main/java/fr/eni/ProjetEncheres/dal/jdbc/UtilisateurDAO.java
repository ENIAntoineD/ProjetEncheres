package fr.eni.ProjetEncheres.dal.jdbc;

import fr.eni.ProjetEncheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public void insert(Utilisateur utilisateur);
	public void delete(Utilisateur utilisateur);
	public boolean VerificationPseudo(Utilisateur utilisateur);
	public boolean VerificationMDP(Utilisateur utilisateur);
	
}

package fr.eni.ProjetEncheres.dal.jdbc;

public abstract class CodesResultatsDAL {
	/**
	 * Echec général quand tentative d'ajouter un utilisateur null
	 */
	public static final int INSERT_UTIL_NULL=10000;
	
	
	/**
	 * Echec général quand tentative de supprimer un utilisateur qui n'existe pas
	 */
	public static final Integer SUPPRESS_UTIL_NULL=10001;
	
}

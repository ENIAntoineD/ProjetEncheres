package fr.eni.ProjetEncheres.dal.jdbc;


public abstract class DAOFactory {
	
	public static UtilisateurDAO getUtilisateurDAO()
	{
		return new 	UtilisateurDAOJdbcImpl();
	}

}

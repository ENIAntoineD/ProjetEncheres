package fr.eni.tpencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionBDD {
	
	
	private static DataSource ds = null;
	static 
	{
		try {
			Context cxt = new InitialContext();
			 ds = (DataSource) cxt.lookup("java:comp/env/jdbc/sqlserver");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException
	{
	
			return ds.getConnection();
	
	

}
	
}

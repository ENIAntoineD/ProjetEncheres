package fr.eni.tpencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class ConnectionBDD {
	
	//Connection JAVA SE à la base de données
	
	/*Connection cnx = null;
	String url = "jdbc:sqlserver://localhost:1433;databaseName=NOM_BDD";
	cnx = DriverManager.getConnection(url, "sa", "Pa$$w0rd");
	
	Statement stmt = null;
	
	//Requête select avec Statement
	stmt = con.createStatement();
	String sql = "select ... from NOM_BDD";
	ResultSet rs = stmt.executeQuery(sql);
	
	while(rs.next()){
	System.out.println(rs.getString("nom") + " " + rs.getString("prenom") + " " + rs.getString("email"));
	}
	
	cnx.close();
	stmt.close();*/
	
	
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

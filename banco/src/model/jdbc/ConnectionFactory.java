package model.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String url = "jdbc:mysql://localhost/cnz";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String usuario = "root";
	private static final String senha = "123456";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName(driver);
			System.out.println("Conectando ao banco");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}
}

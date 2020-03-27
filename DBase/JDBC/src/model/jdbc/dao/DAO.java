package model.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.jdbc.ConnectionFactory;
import util.FileUtil;

public abstract class DAO<T, I> {
	protected Connection connection = null;
	private static String file = "resources/tabelas.sql";
	static {
		DAO.criaBanco();
	}
	public static void criaBanco() {
		try {
			String[] sql = FileUtil.readFile(file).split(";");
			Statement stmt = ConnectionFactory.getConnection().createStatement();
			for (int i=0; i<sql.length; i++)
				if(sql[i].length()>2)
					stmt.executeUpdate(sql[i]);			
			stmt.close();
		} catch (SQLException e) {
			System.out.println("Tabelas existentes!!!");
		}
	}
	
	public DAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	public DAO(Connection con) {
		this.connection = con;
	}
	public abstract void adiciona(T entity) throws SQLException;
	public abstract List<T> getLista() throws SQLException;
	public abstract void altera(T entity) throws SQLException;
	public abstract void remove(T entity) throws SQLException;
	public abstract T procura(I id) throws SQLException;
	public abstract boolean existeUnico(T entity) throws SQLException;
}

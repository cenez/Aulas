package model.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.jdbc.ConnectionFactory;
import util.FileUtil;

public abstract class DAO<T, I> {
	protected Connection connection = null;

	public DAO(Connection con) {
		this.connection = con;
	}
	public DAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public static void criaBanco() throws SQLException {
		String[] sql = FileUtil.readFile("resources/tabelas.sql").split(";");
		Statement stmt = ConnectionFactory.getConnection().createStatement();
		for (int i=0; i<sql.length; i++) {
			if(sql[i].length()>1)
				stmt.executeUpdate(sql[i]);			
		}
		stmt.close();
	}
	
	public abstract void adiciona(T entity) throws SQLException;
	public abstract List<T> getLista() throws SQLException;
	public abstract void altera(T entity) throws SQLException;
	public abstract void remove(T entity) throws SQLException;
	public abstract T procura(I id) throws SQLException;
	public abstract boolean existeUnico(T entity) throws SQLException;
}

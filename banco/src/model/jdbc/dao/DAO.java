package model.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import model.jdbc.ConnectionFactory;

public abstract class DAO<T, I> {
	protected Connection connection = null;

	public DAO(Connection con) {
		this.connection = con;
	}
	public DAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	
	public abstract void adiciona(T entity) throws SQLException;
	public abstract List<T> getLista() throws SQLException;
	public abstract void altera(T entity) throws SQLException;
	public abstract void remove(T entity) throws SQLException;
	public abstract T procura(I id) throws SQLException;
	public abstract boolean existeUnico(T entity) throws SQLException;
}

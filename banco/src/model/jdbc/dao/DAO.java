package model.jdbc.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidade.empresa.Contato;
import model.jdbc.ConnectionFactory;

public class DAO<T> {
	private Connection connection;
	private Class<T> persistentClass;
	private String[] objectFields = null;
	
	public DAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}
	public DAO(Connection con, Class<T> persistentClass) {
		this.connection = con;
		this.persistentClass = persistentClass;
		this.configFields();
	}
	private void configFields() {
		int i = 1;
		Field[] atributos = persistentClass.getClass().getDeclaredFields();
		this.objectFields = new String[atributos.length+1];
		this.objectFields[0] = persistentClass.getClass().getName();
		for (Field field : atributos)
			this.objectFields[i++] = field.getName();
	}
	public void adiciona(Contato contato) throws SQLException {
		PreparedStatement stmt = this.connection
				.prepareStatement("insert into contatos (nome,email,endereco) values (?, ?, ?)");

		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());

		stmt.execute();
		stmt.close();
	}

	public List<Contato> getLista() throws SQLException {

		PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
		ResultSet rs = stmt.executeQuery();

		List<Contato> list = new ArrayList<Contato>();
		while (rs.next()) {
			// criando o objeto Contato 
			Contato contato = new Contato();
			contato.setId(rs.getLong("id"));
			contato.setNome(rs.getString("nome"));
			contato.setEmail(rs.getString("email"));
			contato.setEndereco(rs.getString("endereco"));

			// adicionando o objeto para lista
			list.add(contato);
		}

		rs.close();
		stmt.close();

		return list;
	}

	public void altera(Contato contato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("update contatos set nome=?, email=?, endereco=? where id=?");
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setLong(4, contato.getId());
		stmt.execute();
		stmt.close();
	} 

	public void remove(Contato contato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
		stmt.setLong(1, contato.getId());
		stmt.execute();
		stmt.close();
	} 

	public Contato procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from contatos where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Contato c = new Contato();
		c.setId(rs.getLong("id"));
		c.setNome(rs.getString("nome"));
		c.setEmail(rs.getString("email"));
		c.setEndereco(rs.getString("endereco"));
		rs.close();
		stmt.close();
		return c; 
	}
	public String[] getObjectFields() { return objectFields; }
	public void setObjectFields(String[] objectFields) { this.objectFields = objectFields; }
}

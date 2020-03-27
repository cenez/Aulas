package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Empresa;

public class EmpresaDAO extends DAO<Empresa, Long> {
	public EmpresaDAO(Connection con) {
		super(con);
	}
	public EmpresaDAO() throws SQLException {
		super();
	}
	public void adiciona(Empresa empresa) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(
				"insert into empresa (nome, cnpj) values (?, ?)"
		);
		stmt.setString(1, empresa.getNome());
		stmt.setString(2, empresa.getCnpj());

		stmt.execute();
		stmt.close();
	}

	public List<Empresa> getLista() throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from empresa");
		ResultSet rs = stmt.executeQuery();

		List<Empresa> list = new ArrayList<Empresa>();
		while (rs.next()) {
			Empresa empresa = new Empresa();
			empresa.setId(rs.getLong("id"));
			empresa.setNome(rs.getString("nome"));
			empresa.setCnpj(rs.getString("cnpj"));
			list.add(empresa);
		}
		
		rs.close();
		stmt.close();
		return list;
	}

	public void altera(Empresa empresa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"update empresa set nome=?, cnpj=? where id=?"
		);
		stmt.setString(1, empresa.getNome());
		stmt.setString(2, empresa.getCnpj());
		stmt.setLong(3, empresa.getId());
		stmt.execute();
		stmt.close();
	} 

	public void remove(Empresa empresa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from empresa where id=?");
		stmt.setLong(1, empresa.getId());
		stmt.execute();
		stmt.close();
	} 

	public Empresa procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from empresa where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Empresa empresa = new Empresa();
		empresa.setId(rs.getLong("id"));
		empresa.setNome(rs.getString("nome"));
		empresa.setCnpj(rs.getString("cnpj"));
		rs.close();
		stmt.close();
		return empresa; 
	}
	public boolean existeUnico(Empresa empresa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"select * from empresa where cnpj=?"
		);
		stmt.setString(1, empresa.getCnpj());
		ResultSet rs = stmt.executeQuery();
		try {
			// se nao existir nenhuma empresa , da erro
			if (!rs.next()) {
				return false;
			}
			// false se existe mais de uma empresa com mesmo cnpj
			return !rs.next();
		} finally {
			rs.close();
			stmt.close();
		}
	}
}
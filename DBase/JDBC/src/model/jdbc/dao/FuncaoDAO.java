package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidade.empresa.Funcao;

public class FuncaoDAO extends DAO<Funcao, Long> {
	public FuncaoDAO(Connection con) {
		super(con);
	}
	public FuncaoDAO() throws SQLException {
		super();
	}
	public void adiciona(Funcao funcao) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(
				"insert into funcao (nome) values (?)"
		);
		stmt.setString(1, funcao.getNome());
		stmt.execute();
		stmt.close();
	}

	public List<Funcao> getLista() throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from funcao");
		ResultSet rs = stmt.executeQuery();

		List<Funcao> list = new ArrayList<Funcao>();
		while (rs.next()) {
			Funcao funcao = new Funcao();
			funcao.setId(rs.getLong("id"));
			funcao.setNome(rs.getString("nome"));
			
			list.add(funcao);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public void altera(Funcao funcao) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"update funcao set nome=?, usuario=?, senha=?, empresa_id=?, pessoa_id=? where id=?"
		);
		stmt.setString(1, funcao.getNome());
		
		stmt.setLong(6, funcao.getId());
		stmt.execute();
		stmt.close();
	} 

	public void remove(Funcao funcao) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from funcao where id=?");
		stmt.setLong(1, funcao.getId());
		stmt.execute();
		stmt.close();
	} 

	public Funcao procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from funcao where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Funcao funcao = new Funcao();
		funcao.setId(rs.getLong("id"));
		funcao.setNome(rs.getString("nome"));
		rs.close();
		stmt.close();
		return funcao; 
	}
	public boolean existeUnico(Funcao funcao) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"select * from funcao where nome=?"
		);
		stmt.setString(1, funcao.getNome());
		ResultSet rs = stmt.executeQuery();
		try {
			// se nao existir nenhum funcionario, da erro
			if (!rs.next()) {
				return false;
			}
			// false se existe mais de um funcionario com esse usuario e senha
			return !rs.next();
		} finally {
			rs.close();
			stmt.close();
		}
	}
}
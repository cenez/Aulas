package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Pessoa;

public class PessoaDAO extends DAO<Pessoa, Long> {
	public PessoaDAO(Connection con) {
		super(con);
	}
	public PessoaDAO() throws SQLException {
		super();
	}
	public void adiciona(Pessoa pessoa) throws SQLException {

		// prepared statement para insercao
		PreparedStatement stmt = this.connection
				.prepareStatement("insert into pessoa (nome,endereco,cpf,email) values (?, ?, ?, ?)");

		// seta os valores
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getEndereco());
		stmt.setString(3, pessoa.getCpf());
		stmt.setString(4, pessoa.getEmail());

		// executa
		stmt.execute();
		stmt.close();
	}

	public List<Pessoa> getLista() throws SQLException {

		PreparedStatement stmt = this.connection.prepareStatement("select * from pessoa");
		ResultSet rs = stmt.executeQuery();

		List<Pessoa> list = new ArrayList<Pessoa>();
		while (rs.next()) {
			// criando o objeto Pessoa 
			Pessoa pessoa = new Pessoa();
			pessoa.setId(rs.getLong("id"));
			pessoa.setNome(rs.getString("nome"));
			pessoa.setEndereco(rs.getString("endereco"));
			pessoa.setCpf(rs.getString("cpf"));
			pessoa.setEmail(rs.getString("email"));

			// adicionando o objeto para lista
			list.add(pessoa);
		}

		rs.close();
		stmt.close();

		return list;
	}

	public void altera(Pessoa pessoa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("update pessoa set nome=?, endereco=?, cpf=?, email=? where id=?");
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getEndereco());
		stmt.setString(3, pessoa.getCpf());
		stmt.setString(4, pessoa.getEmail());
		stmt.setLong(5, pessoa.getId());
		stmt.execute();
		stmt.close();
	} 

	public void remove(Pessoa pessoa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from pessoa where id=?");
		stmt.setLong(1, pessoa.getId());
		stmt.execute();
		stmt.close();
	} 

	public Pessoa procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from pessoa where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Pessoa pessoa = new Pessoa();
		pessoa.setId(rs.getLong("id"));
		pessoa.setNome(rs.getString("nome"));
		pessoa.setEndereco(rs.getString("endereco"));
		pessoa.setCpf(rs.getString("cpf"));
		pessoa.setEmail(rs.getString("email"));
		rs.close();
		stmt.close();
		return pessoa; 
	}
	public boolean existeUnico(Pessoa pessoa) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"select * from pessoa where cpf=?"
		);
		stmt.setString(1, pessoa.getCpf());
		ResultSet rs = stmt.executeQuery();
		try {
			// se nao existir nenhuma pessoa, da erro
			if (!rs.next()) {
				return false;
			}
			// false se existe mais de uma pessoa com esse cpf
			return !rs.next();
		} finally {
			rs.close();
			stmt.close();
		}
	}
}

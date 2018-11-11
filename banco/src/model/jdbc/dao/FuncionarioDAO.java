package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entidade.empresa.Funcionario;
import model.jdbc.ConnectionFactory;

public class FuncionarioDAO {

	// a conexao com o banco de dados
	private Connection connection;

	// construtor que recebe a conexao
	public FuncionarioDAO(Connection con) {
		this.connection = con;
	}

	public FuncionarioDAO() throws SQLException {
		this.connection = ConnectionFactory.getConnection();
	}

	public void adiciona(Funcionario f) throws SQLException {

		// prepared statement para insercao
		PreparedStatement stmt = this.connection
				.prepareStatement("insert into funcionarios (nome,usuario,senha) values (?, ?, ?)");

		// seta os valores
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getUsuario());
		stmt.setString(3, f.getSenha());

		// executa
		stmt.execute();
		stmt.close();
	}

	public boolean existeUnico(Funcionario funcionario)
			throws SQLException {

		PreparedStatement stmt = connection
				.prepareStatement("select * from funcionarios where usuario=? and senha=?");
		stmt.setString(1, funcionario.getUsuario());
		stmt.setString(2, funcionario.getSenha());
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

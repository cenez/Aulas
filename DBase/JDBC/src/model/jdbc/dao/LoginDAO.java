package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Login;

public class LoginDAO extends DAO<Login, Long> {
	private PessoaDAO pessoaDao;
	public LoginDAO() throws SQLException {
		super();
		loadDaos();
	}
	public LoginDAO(Connection con) {
		super(con);
		loadDaos();
	}
	private void loadDaos() {
		pessoaDao = new PessoaDAO(this.connection);
	}
	public void adiciona(Login login) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(
				"insert into login (usuario, senha, pessoa_id) values (?, ?, ?)"
		);
		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());
		stmt.setLong(3, login.getPessoa().getId());
		
		stmt.execute();
		stmt.close();
	}

	public List<Login> getLista() throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from login");
		ResultSet rs = stmt.executeQuery();

		List<Login> list = new ArrayList<Login>();
		while (rs.next()) {
			Login login = new Login();
			login.setId(rs.getLong("id"));
			login.setUsuario(rs.getString("usuario"));
			login.setSenha(rs.getString("senha"));
			login.setPessoa(pessoaDao.procura(rs.getLong("pessoa_id")));
			
			list.add(login);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public void altera(Login login) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"update login set usuario=?, senha=?, pessoa_id=? where id=?"
		);
		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());
		stmt.setLong(3, login.getPessoa().getId());
		stmt.setLong(4, login.getId());
		
		stmt.execute();
		stmt.close();
	} 

	public void remove(Login login) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from login where id=?");
		stmt.setLong(1, login.getId());
		stmt.execute();
		stmt.close();
	} 

	public Login procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from login where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Login login = new Login();
		login.setId(rs.getLong("id"));
		login.setUsuario(rs.getString("usuario"));
		login.setSenha(rs.getString("senha"));
		login.setPessoa(pessoaDao.procura(rs.getLong("pessoa_id")));
		rs.close();
		stmt.close();
		return login; 
	}
	public boolean existeUnico(Login login) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"select * from login where usuario=? and senha=?"
		);
		stmt.setString(1, login.getUsuario());
		stmt.setString(2, login.getSenha());
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
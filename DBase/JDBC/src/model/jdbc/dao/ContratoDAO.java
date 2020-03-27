package model.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entidades.Contrato;

public class ContratoDAO extends DAO<Contrato, Long> {
	private EmpresaDAO empresaDao;
	private PessoaDAO pessoaDao;
	private FuncaoDAO funcaoDao;
	public ContratoDAO(Connection con) {
		super(con);
		loadDaos();
	}
	public ContratoDAO() throws SQLException {
		super();
		loadDaos();
	}
	private void loadDaos() {
		empresaDao = new EmpresaDAO(this.connection);
		pessoaDao = new PessoaDAO(this.connection);
		funcaoDao = new FuncaoDAO(this.connection);
	}
	public void adiciona(Contrato contrato) throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement(
				"insert into contrato (empresa_id, pessoa_id, funcao_id) values (?, ?, ?)"
		);
		stmt.setLong(1, contrato.getEmpresa().getId());
		stmt.setLong(2, contrato.getPessoa().getId());
		stmt.setLong(3, contrato.getFuncao().getId());
		
		stmt.execute();
		stmt.close();
	}

	public List<Contrato> getLista() throws SQLException {
		PreparedStatement stmt = this.connection.prepareStatement("select * from contrato");
		ResultSet rs = stmt.executeQuery();

		List<Contrato> list = new ArrayList<Contrato>();
		while (rs.next()) {
			Contrato contrato = new Contrato();
			contrato.setId(rs.getLong("id"));
			contrato.setEmpresa(empresaDao.procura(rs.getLong("empresa_id")));
			contrato.setPessoa(pessoaDao.procura(rs.getLong("pessoa_id")));
			contrato.setFuncao(funcaoDao.procura(rs.getLong("funcao_id")));
			
			list.add(contrato);
		}
		rs.close();
		stmt.close();
		return list;
	}

	public void altera(Contrato contrato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"update contrato set empresa_id=?, pessoa_id=?, funcao_id=? where id=?"
		);
		stmt.setLong(1, contrato.getEmpresa().getId());
		stmt.setLong(2, contrato.getPessoa().getId());
		stmt.setLong(3, contrato.getFuncao().getId());
		stmt.setLong(4, contrato.getId());
		
		stmt.execute();
		stmt.close();
	} 

	public void remove(Contrato contrato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("delete from contrato where id=?");
		stmt.setLong(1, contrato.getId());
		stmt.execute();
		stmt.close();
	} 

	public Contrato procura(Long id) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("select * from contrato where id=?");
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		
		if(!rs.next()) return null;

		Contrato contrato = new Contrato();
		contrato.setId(rs.getLong("id"));
		contrato.setEmpresa(empresaDao.procura(rs.getLong("empresa_id")));
		contrato.setPessoa(pessoaDao.procura(rs.getLong("pessoa_id")));
		contrato.setFuncao(funcaoDao.procura(rs.getLong("funcao_id")));
		
		rs.close();
		stmt.close();
		return contrato; 
	}
	public boolean existeUnico(Contrato contrato) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"select * from contrato where empresa_id=? and pessoa_id=? and funcao_id=?"
		);
		stmt.setLong(1, contrato.getEmpresa().getId());
		stmt.setLong(2, contrato.getPessoa().getId());
		stmt.setLong(3, contrato.getFuncao().getId());
		
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
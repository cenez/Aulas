package all_tests;

import java.sql.SQLException;

import model.entidade.empresa.Contrato;
import model.entidade.empresa.Empresa;
import model.entidade.empresa.Funcao;
import model.entidade.empresa.Login;
import model.entidade.empresa.Pessoa;
import model.jdbc.dao.ContratoDAO;
import model.jdbc.dao.DAO;
import model.jdbc.dao.EmpresaDAO;
import model.jdbc.dao.FuncaoDAO;
import model.jdbc.dao.LoginDAO;
import model.jdbc.dao.PessoaDAO;

public class MainTestaBanco {
	public static void main(String[] args) throws SQLException {
		DAO<Pessoa, Long>  pessoaDao  = new PessoaDAO();
		DAO<Empresa, Long> empresaDao = new EmpresaDAO();
		DAO<Funcao, Long>  funcaoDao  = new FuncaoDAO();
		DAO<Login, Long>  loginDao  = new LoginDAO();
		DAO<Contrato, Long>  contratoDao  = new ContratoDAO();
		
		Pessoa joao = new Pessoa(1l, "Joao Silva", "Rua 5", "123", "joao@x.com");
		Pessoa maria = new Pessoa(2l, "Maria Silva", "Rua 6", "321", "maria@x.com");
		
		Empresa unifor = new Empresa(1l, "Universidade de Fortaleza", "6549871");
		Empresa ufc = new Empresa(2l, "Universidade Federal do Ceara", "9875236");
		
		Funcao operador = new Funcao(1l, "Operador");
		Funcao atendente = new Funcao(2l, "Atendente");
		
		Login loginJoao = new Login(joao, "joao", "123456");
		Login loginMaria = new Login(maria, "maria", "654321");
		
		Contrato contratoJoao = new Contrato(1l, unifor, joao, operador);
		Contrato contratoMaria = new Contrato(2l, ufc, maria, operador);
		
		pessoaDao.adiciona(joao);
		pessoaDao.adiciona(maria);

		empresaDao.adiciona(unifor);
		empresaDao.adiciona(ufc);
		
		funcaoDao.adiciona(operador);
		funcaoDao.adiciona(atendente);
		
		loginDao.adiciona(loginJoao);
		loginDao.adiciona(loginMaria);
		
		contratoDao.adiciona(contratoJoao);
		contratoDao.adiciona(contratoMaria);
	}
}

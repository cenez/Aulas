package all_tests;

import java.sql.SQLException;

import model.entidade.empresa.Empresa;
import model.entidade.empresa.Funcao;
import model.entidade.empresa.Pessoa;
import model.jdbc.dao.DAO;
import model.jdbc.dao.EmpresaDAO;
import model.jdbc.dao.FuncaoDAO;
import model.jdbc.dao.PessoaDAO;

public class MainTestaBanco {
	public static void main(String[] args) throws SQLException {
		Pessoa joao = new Pessoa(1l, "Joao Silva", "Rua 5", "123", "joao@x.com");
		Pessoa maria = new Pessoa(2l, "Maria Silva", "Rua 6", "321", "maria@x.com");
		
		Empresa uniA = new Empresa(1l, "Universidade A", "6549871");
		Empresa uniB = new Empresa(2l, "Universidade B", "9875236");
		
		Funcao fun1 = new Funcao(1l, "Operador","funjoao","0102",uniA, joao);
		Funcao fun2 = new Funcao(2l, "Atendente","funmaria","20103",uniA, maria);
		
		Funcao fun3 = new Funcao(3l, "Operador","funjoao","0102",uniB, joao);
		Funcao fun4 = new Funcao(4l, "Atendente","funmaria","20103",uniB, maria);
		
		DAO<Pessoa, Long>  pessoaDao  = new PessoaDAO();
		DAO<Empresa, Long> empresaDao = new EmpresaDAO();
		DAO<Funcao, Long>  funcaoDao  = new FuncaoDAO();
		
		pessoaDao.adiciona(joao);
		pessoaDao.adiciona(maria);
		empresaDao.adiciona(uniA);
		empresaDao.adiciona(uniB);
		
		funcaoDao.adiciona(fun1);
		funcaoDao.adiciona(fun2);
		funcaoDao.adiciona(fun3);
		funcaoDao.adiciona(fun4);
	}
}

package all_tests;

import java.sql.SQLException;

import model.entidade.empresa.Funcionario;
import model.jdbc.ConnectionFactory;
import model.jdbc.dao.DAO;

public class MainTestaGenericDao {
	public static void main(String[] args) {
		DAO<Funcionario> dao = null;
		try {
			dao = new DAO<Funcionario>(ConnectionFactory.getConnection(), Funcionario.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] fields = dao.getObjectFields();
		for (String s : fields) {
			System.out.println(s);
		}
	}
}

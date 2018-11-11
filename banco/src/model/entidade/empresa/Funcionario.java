package model.entidade.empresa;

/**
 * Um funcionario do sistema
 * 
 * @author Guilherme Silveira
 * @author $Revision$
 */
public class Funcionario {

	private String nome;

	private String usuario, senha;

	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return Returns the senha.
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            The senha to set.
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return Returns the usuario.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            The usuario to set.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}

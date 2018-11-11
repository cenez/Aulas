package model.entidade.empresa;
public class Contato {
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return Returns the endereco.
	 */
	public String getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco The endereco to set.
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return Returns the nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

        /**
         * @return Returns the id.
         */
        public Long getId() {
                return id;
        }
        /**
         * @param id The id to set.
         */
        public void setId(Long id) {
                this.id = id;
        }


	private String nome;
	private String email;
	private String endereco;
	private Long id;
}

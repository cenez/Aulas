package model.entidade.empresa;

public class Funcao {
	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private Empresa empresa;
	private Pessoa pessoa;
	
	public Funcao() {}
	public Funcao(String nome, String usuario, String senha, Empresa empresa, Pessoa pessoa) {
		super();
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.empresa = empresa;
		this.pessoa = pessoa;
	}
	public Funcao(Long id, String nome, String usuario, String senha, Empresa empresa, Pessoa pessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.empresa = empresa;
		this.pessoa = pessoa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getSenha() {
		return senha;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}

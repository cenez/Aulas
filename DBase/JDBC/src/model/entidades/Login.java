package model.entidades;

public class Login {
	private Long id;
	private String usuario;
	private String senha;
	private Pessoa pessoa;

	public Login() { super(); }
	public Login(Pessoa pessoa, String usuario, String senha) {
		this();
		this.pessoa = pessoa;
		this.usuario = usuario;
		this.senha = senha;
	}
	public Login(Long id, Pessoa pessoa, String usuario, String senha) {
		this(pessoa, usuario, senha);
		this.id = id;
	}
	
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }
	public Pessoa getPessoa() { return pessoa; }
	public String getUsuario() { return usuario; }
	public String getSenha() { return senha; }
	public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	public void setUsuario(String usuario) { this.usuario = usuario; }
	public void setSenha(String senha) { this.senha = senha; }	
}

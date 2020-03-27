package model.entidade.empresa;

public class Empresa {
	private Long id;
	private String nome;
	private String cnpj;
	
	public Empresa() { super(); }
	public Empresa(String nome, String cnpj) {
		this();
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public Empresa(Long id, String nome, String cnpj) {
		this(nome, cnpj);		
		this.id = id;
	}
	public Long getId() { return id; }
	public String getNome() { return nome; }
	public String getCnpj() { return cnpj; }
	public void setId(Long id) { this.id = id; }
	public void setNome(String nome) { this.nome = nome; }
	public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}

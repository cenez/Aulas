package model.entidade.empresa;

public class Contrato {
	private Long id;
	private Empresa empresa;
	private Pessoa pessoa;
	private Funcao funcao;

	public Contrato() { super(); }
	public Contrato(Long id, Empresa empresa, Pessoa pessoa, Funcao funcao) {
		this();
		this.id = id;
		this.empresa = empresa;
		this.pessoa = pessoa;
		this.funcao = funcao;
	}
	
	public Long getId() { return this.id; }
	public void setId(Long id) { this.id = id; }

	public Empresa getEmpresa() { return empresa; }
	public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
	
	public Pessoa getPessoa() { return pessoa; }
	public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
	
	public Funcao getFuncao() { return funcao; }
	public void setFuncao(Funcao funcao) { this.funcao = funcao; }
}

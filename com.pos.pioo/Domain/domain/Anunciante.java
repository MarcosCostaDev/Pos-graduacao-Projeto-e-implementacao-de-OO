
package domain;

import java.util.Date;

public class Anunciante extends Entidade {

	private String nome;
	private String documento;
	private String endereco;
	private String cidade;
	private String telefone;
	


	private Date dataCriacao;
	
	protected Anunciante()
	{
		super();
	}
	
	public Anunciante(String nome, String documento, String endereco, String cidade, String telefone)
	{
		super();
	
		super.naoDeveSerVazio(nome, "Nome deve ser informado!");
		super.naoDeveSerVazio(documento, "Documento deve ser informado!");
		super.naoDeveSerVazio(endereco, "Endereço deve ser informado!");
		super.naoDeveSerVazio(cidade, "Cidade deve ser informada!");
		super.naoDeveSerVazio(telefone, "Telefone deve ser informado!");
		
		this.nome = nome;
		this.documento = documento;
		this.endereco = endereco;
		this.cidade = cidade;
		this.telefone = telefone;	
		this.setDataCriacao(new Date());
	}
	
	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public String getTelefone() {
		return telefone;
	}
	

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}

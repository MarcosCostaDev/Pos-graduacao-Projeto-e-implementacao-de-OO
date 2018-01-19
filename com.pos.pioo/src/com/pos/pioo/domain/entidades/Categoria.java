package com.pos.pioo.domain;

public class Categoria extends Entidade {

	private String nome;
	
	protected Categoria()
	{
		super();
	}
	
	public Categoria(String nome)
	{
		super();
		super.naoDeveSerVazio(nome, "Nome da categoria deve ser informado!");
		this.nome = nome;		
	}
	
	public String getNome() {
		return this.nome;
	}
	
	
	
}

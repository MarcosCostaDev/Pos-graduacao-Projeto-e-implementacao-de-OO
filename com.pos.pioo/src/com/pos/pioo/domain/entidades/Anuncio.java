package com.pos.pioo.domain.entidades;

import java.util.Date;

public class Anuncio extends Entidade {
	private Date dataCriacao;
	private Date dataValidade;
	private Categoria categoria;
	private Anunciante anunciante;
	
	protected Anuncio()
	{
		super();
	}
	
	public Anuncio(Categoria categoria, Anunciante anunciante, Date dataValidade) {
		super();
		
		super.adicionarMensagens(categoria.obterMensagens());
		super.adicionarMensagens(anunciante.obterMensagens());		
		super.deveSerMaiorQue(dataValidade, new Date(), "Data de validade deve ser maior do que a data atual");
		
		this.setDataCriacao(new Date());
		this.categoria = categoria;
		this.anunciante = anunciante;
		this.dataValidade = dataValidade;	
		
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Anunciante getAnunciante() {
		return anunciante;
	}
	
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}

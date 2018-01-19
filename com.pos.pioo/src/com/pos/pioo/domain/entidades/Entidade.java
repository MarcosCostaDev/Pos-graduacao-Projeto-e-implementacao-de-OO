package com.pos.pioo.domain;

import java.util.UUID;

import com.pos.pioo.fluentvalidation.Validacao;

public abstract class Entidade extends Validacao {

	private UUID id;
	public Entidade() {
		super();
		this.setId(UUID.randomUUID());
	}
	
	private void setId(UUID valor) {
		this.id = valor;
	}
	public String getId()
	{
		return id.toString();
	}
}

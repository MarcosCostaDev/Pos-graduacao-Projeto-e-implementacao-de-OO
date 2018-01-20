package domain;

import java.util.UUID;

import com.pos.pioo.fluentvalidation.Validacao;

public abstract class Entidade extends Validacao {

	private UUID id;
	

	private boolean novoRegistro;
	public Entidade() {
		super();
		this.novoRegistro = true;
		this.setId(UUID.randomUUID());
	}

	private void setId(UUID valor) {
		this.novoRegistro = false;
		this.id = valor;
	}

	public void setId(String valor)
	{
		this.novoRegistro = false;
		this.id = UUID.fromString(valor);	
	}

	public String getId()
	{
		return id.toString();
	}
	
	public boolean isNovoRegistro() {
		return novoRegistro;
	}
}

package command.manipulador.Entrada;

import java.util.Date;

import domain.Anunciante;
import domain.Categoria;

public class AnuncioEntrada {
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
	public CategoriaEntrada getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaEntrada categoria) {
		this.categoria = categoria;
	}
	public AnuncianteEntrada getAnunciante() {
		return anunciante;
	}
	public void setAnunciante(AnuncianteEntrada anunciante) {
		this.anunciante = anunciante;
	}
	private Date dataCriacao;
	private Date dataValidade;
	private CategoriaEntrada categoria;
	private AnuncianteEntrada anunciante;
}

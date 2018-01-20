package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AnuncioCommand {
	public void inserir(HttpServletRequest request, HttpServletResponse response);
	public void atualizar(HttpServletRequest request, HttpServletResponse response);
	public void deletar(HttpServletRequest request, HttpServletResponse response);
	public void selecionar(HttpServletRequest request, HttpServletResponse response);
	public void listar(HttpServletRequest request, HttpServletResponse response);
}

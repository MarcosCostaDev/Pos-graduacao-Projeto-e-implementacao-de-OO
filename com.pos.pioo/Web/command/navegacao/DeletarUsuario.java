package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Usuario;
import repositorios.UsuarioRepositorio;

public class DeletarUsuario   implements Command {

	private UsuarioRepositorio usuarioRepositorio;
	public DeletarUsuario() {
		if(usuarioRepositorio == null)
		{
			this.usuarioRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Usuario usuario = new Usuario("", "");
			usuario.setId(request.getParameter("id"));

			this.usuarioRepositorio.excluir(usuario);

			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarUsuario");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
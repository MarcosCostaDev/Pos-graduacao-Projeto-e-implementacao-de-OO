package command.navegacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Usuario;
import repositorios.UsuarioRepositorio;

public class LogoutUsuario  implements Command {

	private UsuarioRepositorio usuarioRepositorio;
	public LogoutUsuario() {
		if(usuarioRepositorio == null)
		{
			this.usuarioRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getSession().setAttribute("usuarioLogado", null);
			request.getRequestDispatcher("/index.jsp").forward(request,response);

		} catch (IOException | ServletException  e) {
			e.printStackTrace();
		}
	}
}



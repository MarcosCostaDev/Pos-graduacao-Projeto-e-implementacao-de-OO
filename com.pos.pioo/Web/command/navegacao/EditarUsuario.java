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

public class EditarUsuario implements Command {

	private UsuarioRepositorio usuarioRepositorio;
	public EditarUsuario() {
		if(usuarioRepositorio == null)
		{
			this.usuarioRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Usuario usuario = null;
			if(request.getParameter("id") != null) {
				usuario = this.usuarioRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				usuario = new Usuario("", "", "");
			}
			
			request.setAttribute("usuario", usuario);

			RequestDispatcher d = request.getRequestDispatcher("/Usuario/EditarUsuario.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}

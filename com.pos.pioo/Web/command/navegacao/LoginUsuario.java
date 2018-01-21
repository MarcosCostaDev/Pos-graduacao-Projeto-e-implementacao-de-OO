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

public class LoginUsuario implements Command {

	private UsuarioRepositorio usuarioRepositorio;
	public LoginUsuario() {
		if(usuarioRepositorio == null)
		{
			this.usuarioRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			if(request.getAttribute("login") == null && request.getAttribute("senha") == null)
			{
				request.getSession().setAttribute("usuarioLogado", null);
				RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
				d.forward(request,response);

			}
			else
			{

				Usuario usuario = new Usuario(request.getAttribute("login").toString(), request.getAttribute("senha").toString());

				if(usuario.EValido())
				{
					usuario = this.usuarioRepositorio.Login(usuario);	
					if(usuario != null)
					{
						request.getSession().setAttribute("usuarioLogado", usuario);
						RequestDispatcher d = request.getRequestDispatcher("controller?command=ListarCategoria");
						d.forward(request,response);
					}
					else
					{
						request.getSession().setAttribute("usuarioLogado", null);
						RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
						d.forward(request,response);
					}
				}
				else
				{
					request.getSession().setAttribute("usuarioLogado", null);
					RequestDispatcher d = request.getRequestDispatcher("/Usuario/LoginUsuario.jsp");
					d.forward(request,response);

				}
			}

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}

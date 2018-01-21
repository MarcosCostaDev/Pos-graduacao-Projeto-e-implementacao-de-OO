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


public class SalvarUsuario  implements Command {

	private UsuarioRepositorio categoriaRepositorio;
	public SalvarUsuario() {
		if(categoriaRepositorio == null)
		{
			this.categoriaRepositorio = new infra.repositorios.UsuarioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Usuario usuariologado = (Usuario)request.getSession().getAttribute("usuarioLogado");
			Usuario usuario = new Usuario(request.getParameter("nome"), request.getParameter("login"), request.getParameter("senha"));

			if(!request.getParameter("isnew").equals("true"))
			{
				usuario.setId(request.getParameter("id"));
				isNovo = false;
			}

			if(usuario.EValido())
			{
				if(isNovo)
				{
					this.categoriaRepositorio.inserir(usuario);
				}
				else
				{
					this.categoriaRepositorio.alterar(usuario);
				}
			}

			
			if(usuariologado == null)
			{
				request.getRequestDispatcher("Controller?command=LoginUsuario").forward(request,response);
			}
			else
			{
				request.getRequestDispatcher("Controller?command=ListarUsuario").forward(request,response);
			}
		

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}
package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Categoria;
import repositorios.CategoriaRepositorio;

public class EditarCategoria implements Command {

	private CategoriaRepositorio categoriaRepositorio;
	public EditarCategoria() {
		if(categoriaRepositorio == null)
		{
			this.categoriaRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Categoria categoria = null;
			if(request.getParameter("id") != "") {
				categoria = this.categoriaRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				categoria = new Categoria("");
			}
			
			request.setAttribute("categoria", categoria);

			RequestDispatcher d = request.getRequestDispatcher("/Categoria/EditarCategoria.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}

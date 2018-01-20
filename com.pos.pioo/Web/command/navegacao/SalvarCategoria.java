package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Categoria;
import repositorios.CategoriaRepositorio;

public class SalvarCategoria  implements Command {

	private CategoriaRepositorio categoriaRepositorio;
	public SalvarCategoria() {
		if(categoriaRepositorio == null)
		{
			this.categoriaRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Categoria categoria = new Categoria(request.getParameter("name"));

			if(request.getParameter("id") == "")
			{
				categoria.setId(request.getParameter("id"));
			}

			if(categoria.EValido())
			{
				if(isNovo)
				{
					this.categoriaRepositorio.inserir(categoria);
				}
				else
				{
					this.categoriaRepositorio.alterar(categoria);
				}
			}

			RequestDispatcher d = request.getRequestDispatcher("/Categoria/EditarCategoria.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}
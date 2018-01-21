package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import command.Command;
import domain.Categoria;
import repositorios.CategoriaRepositorio;

public class ListarCategoria implements Command {

	private CategoriaRepositorio categoriaRepositorio;
	public ListarCategoria() {
		if(categoriaRepositorio == null)
		{
			this.categoriaRepositorio = new infra.repositorios.CategoriaRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			List<Categoria> categorias = this.categoriaRepositorio.listarConsulta("");
/*
			List<Categoria> categorias = new ArrayList<Categoria>();
			categorias.add(new Categoria("Teste"));
			categorias.add(new Categoria("Teste2"));
			categorias.add(new Categoria("Teste3"));	*/
			request.setAttribute("categorias", categorias);

			RequestDispatcher d = request.getRequestDispatcher("/Categoria/ListarCategoria.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}

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
import domain.Anunciante;
import domain.Categoria;
import repositorios.AnuncianteRepositorio;
import repositorios.AnuncioRepositorio;
import repositorios.CategoriaRepositorio;

public class EditarAnunciante implements Command {

	private CategoriaRepositorio categoriaRepositorio;
	private AnuncianteRepositorio anuncianteRepositorio;
	private AnuncioRepositorio anuncioRepositorio;

	public EditarAnunciante() {
		if(categoriaRepositorio == null)
		{
			this.categoriaRepositorio = new infra.repositorios.CategoriaRepositorio();
		}

		if(anuncianteRepositorio == null)
		{
			this.anuncianteRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}

		if(anuncioRepositorio == null)
		{
			this.anuncioRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			Anunciante anunciante = null;
			if(request.getParameter("id") != null) {
				anunciante = this.anuncianteRepositorio.selecionarConsulta(request.getParameter("id"));
			}
			else
			{
				anunciante = new Anunciante("", "", "", "", "");
			}
			request.setAttribute("anunciante", anunciante);

			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/EditarAnunciante.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
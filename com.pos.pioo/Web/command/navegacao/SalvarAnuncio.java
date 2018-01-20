package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Anunciante;
import domain.Anuncio;
import domain.Categoria;
import repositorios.AnuncioRepositorio;

public class SalvarAnuncio implements Command {

	private AnuncioRepositorio anuncioRepositorio;
	public SalvarAnuncio() {
		if(anuncioRepositorio == null)
		{
			this.anuncioRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			boolean isNovo = true;
			Categoria categoria = new Categoria("");			
			Anunciante anunciante = new Anunciante("", "", "", "", "");
			categoria.setId(request.getParameter("categoriaId"));


			Anuncio anuncio = new Anuncio(categoria, anunciante, new Date(request.getParameter("validade")));

			if(request.getParameter("id") == "")
			{
				anunciante.setId(request.getParameter("id"));
			}

			if(anunciante.EValido())
			{
				if(isNovo)
				{
					this.anuncioRepositorio.inserir(anuncio);
				}
				else
				{
					this.anuncioRepositorio.alterar(anuncio);
				}
			}

			RequestDispatcher d = request.getRequestDispatcher("/Categoria/ListarAnunciante.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}
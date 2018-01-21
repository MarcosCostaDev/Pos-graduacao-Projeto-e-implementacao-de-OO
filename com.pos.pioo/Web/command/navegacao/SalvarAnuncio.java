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
			categoria.setId(request.getParameter("categoriaId").toString());
			anunciante.setId(request.getParameter("anuncianteId").toString());

			Anuncio anuncio = new Anuncio(categoria, anunciante, new Date());


			if(!request.getParameter("isnew").equals("true"))
			{
				anuncio.setId(request.getParameter("id"));
				isNovo = false;
			}


			if(isNovo)
			{
				this.anuncioRepositorio.inserir(anuncio);
			}
			else
			{
				this.anuncioRepositorio.alterar(anuncio);
			}


			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarAnuncio");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}

	}

}
package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Anunciante;
import domain.Anuncio;
import domain.Categoria;
import repositorios.AnuncioRepositorio;
import repositorios.CategoriaRepositorio;

public class ListarAnuncio implements Command {

	private AnuncioRepositorio anuncioRepositorio;
	public ListarAnuncio() {
		if(anuncioRepositorio == null)
		{
			this.anuncioRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Anuncio> anuncios = new ArrayList<Anuncio>();
			anuncios.add(new Anuncio(new Categoria("categoria 1"), new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"), new Date()));
			anuncios.add(new Anuncio(new Categoria("categoria 1"), new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"), new Date()));
			anuncios.add(new Anuncio(new Categoria("categoria 1"), new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"), new Date()));
			anuncios.add(new Anuncio(new Categoria("categoria 1"), new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"), new Date()));
			request.setAttribute("anuncios", anuncios);
			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/ListarAnuncio.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
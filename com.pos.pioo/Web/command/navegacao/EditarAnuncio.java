package command.navegacao;

import java.io.IOException;
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

public class EditarAnuncio implements Command {

	private CategoriaRepositorio categoriaRepositorio;
	private AnuncianteRepositorio anuncianteRepositorio;
	private AnuncioRepositorio anuncioRepositorio;
	
	public EditarAnuncio() {
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
			
			/*
			List<Categoria> categorias = this.categoriaRepositorio.listarConsulta("");
			List<Anunciante> anunciantes = this.anuncianteRepositorio.listarConsulta("");
			*/
			
			List<Categoria> categorias = new ArrayList<Categoria>();
			List<Anunciante> anunciantes = new ArrayList<Anunciante>();
			
			anunciantes.add(new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"));
			anunciantes.add(new Anunciante("Nome2", "123456789", "teste rua 21", "cidade2", "588785662"));
			anunciantes.add(new Anunciante("Nome3", "123456789", "teste rua 21", "cidade3", "588785662"));	
			
			categorias.add(new Categoria("Teste"));
			categorias.add(new Categoria("Teste2"));
			categorias.add(new Categoria("Teste3"));	
			
			request.setAttribute("categorias", categorias);
			request.setAttribute("anunciantes", anunciantes);

			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/EditarAnuncio.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
package command.navegacao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import domain.Anuncio;
import repositorios.AnuncioRepositorio;

public class MostrarAnuncio implements Command {

	private AnuncioRepositorio anuncioRepositorio;
	public MostrarAnuncio() {
		if(anuncioRepositorio == null)
		{
			this.anuncioRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Anuncio> anuncios = this.anuncioRepositorio.listarConsulta("");
			request.setAttribute("anuncios", anuncios);
			RequestDispatcher d = request.getRequestDispatcher("/Anuncios/MostrarAnuncios.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
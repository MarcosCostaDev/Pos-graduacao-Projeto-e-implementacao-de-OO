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
import domain.Anuncio;
import domain.Categoria;
import repositorios.AnuncianteRepositorio;
import repositorios.AnuncioRepositorio;

public class ListarAnunciante  implements Command {

	private AnuncianteRepositorio anuncianteRepositorio;
	public ListarAnunciante() {
		if(anuncianteRepositorio == null)
		{
			this.anuncianteRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Anunciante> anunciantes = this.anuncianteRepositorio.listarConsulta("");
		
			request.setAttribute("anunciantes", anunciantes);
			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/ListarAnunciante.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
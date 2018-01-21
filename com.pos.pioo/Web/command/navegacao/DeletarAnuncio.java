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

public class DeletarAnuncio  implements Command {

	private AnuncioRepositorio anuncioRepositorio;
	public DeletarAnuncio() {
		if(anuncioRepositorio == null)
		{
			this.anuncioRepositorio = new infra.repositorios.AnuncioRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			Anuncio anuncio = new Anuncio(new Categoria(""), new Anunciante("", "", "", "", ""), new Date());
			
			anuncio.setId(request.getParameter("id"));
			
			this.anuncioRepositorio.excluir(anuncio);
		
			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/ListarAnuncio.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
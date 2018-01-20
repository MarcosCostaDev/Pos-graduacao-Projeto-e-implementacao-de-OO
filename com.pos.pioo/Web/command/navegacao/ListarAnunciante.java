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
			List<Anunciante> anunciantes = new ArrayList<Anunciante>();
			anunciantes.add(new Anunciante("Nome1", "123456789", "teste rua 21", "cidade1", "588785662"));
			anunciantes.add(new Anunciante("Nome2", "123456789", "teste rua 21", "cidade2", "588785662"));
			anunciantes.add(new Anunciante("Nome3", "123456789", "teste rua 21", "cidade3", "588785662"));	
			request.setAttribute("anunciantes", anunciantes);
			RequestDispatcher d = request.getRequestDispatcher("/Anunciantes/ListarAnunciante.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}
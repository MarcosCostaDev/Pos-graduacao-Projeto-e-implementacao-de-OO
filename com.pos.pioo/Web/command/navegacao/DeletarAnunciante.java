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
import repositorios.AnuncianteRepositorio;

public class DeletarAnunciante  implements Command {

	private AnuncianteRepositorio anuncianteRepositorio;
	public DeletarAnunciante() {
		if(anuncianteRepositorio == null)
		{
			this.anuncianteRepositorio = new infra.repositorios.AnuncianteRepositorio();
		}
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			
			Anunciante anunciante = new Anunciante("","","","","");
			
			anunciante.setId(request.getParameter("id"));
			
			this.anuncianteRepositorio.excluir(anunciante);
			
			RequestDispatcher d = request.getRequestDispatcher("Controller?command=ListarAnunciante");
			d.forward(request,response);

		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

}
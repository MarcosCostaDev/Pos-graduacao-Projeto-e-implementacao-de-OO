package com.pos.pioo.web.command.navegacao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pos.pioo.web.command.NavegacaoCommand;

public class EditarCategoria implements NavegacaoCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			RequestDispatcher d = request.getRequestDispatcher("/Categoria/EditarCategoria.jsp");
			d.forward(request,response);

		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

}

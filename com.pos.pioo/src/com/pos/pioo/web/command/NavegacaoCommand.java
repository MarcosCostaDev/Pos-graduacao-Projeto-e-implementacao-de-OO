package com.pos.pioo.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NavegacaoCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}

function onVoltarAnuncio(){
	navegarPrincipal("/com.pos.pioo/Controller?command=ListarAnunciante");
}

function onSalvarAnunciante(){
	var valores = $('#AnuncianteFormulario').serialize();
	var command = "/com.pos.pioo/Controller?command=SalvarAnunciante&" + valores;
	executarCommand(command);
}
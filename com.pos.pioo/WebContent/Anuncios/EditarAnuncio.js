function onVoltarAnuncio(){
	executarCommand("/com.pos.pioo/Controller?command=ListarAnuncio");
}

function onSalvarAnuncio(){
	var valores = $('#AnuncioFormulario').serialize();
	var command = "/com.pos.pioo/Controller?command=SalvarAnuncio&" + valores;
	executarCommand(command);
}
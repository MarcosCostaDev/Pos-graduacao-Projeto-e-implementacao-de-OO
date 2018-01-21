function onVoltarCategoria(){
	executarCommand("/com.pos.pioo/Controller?command=ListarCategoria");
}

function onSalvarCategoria(){
	var valores = $('#CategoriaFormulario').serialize();
	var command = "/com.pos.pioo/Controller?command=SalvarCategoria&" + valores;
	executarCommand(command);
}
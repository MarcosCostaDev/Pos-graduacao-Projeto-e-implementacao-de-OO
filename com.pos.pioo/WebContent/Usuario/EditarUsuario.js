function onVoltarUsuario(){
	executarCommand("/com.pos.pioo/Controller?command=ListarUsuario");
}

function onVoltarLogin(){
	executarCommand("/com.pos.pioo/Controller?command=LoginUsuario");
}

function onSalvarUsuario(){
	var valores = $('#UsuarioFormulario').serialize();
	var command = "/com.pos.pioo/Controller?command=SalvarUsuario&" + valores;
	executarCommand(command);
}


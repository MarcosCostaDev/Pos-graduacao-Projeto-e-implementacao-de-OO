function onLoginUsuario(){
	var valores = $('#LoginFormulario').serialize();
	var command = "/com.pos.pioo/Controller?command=LoginUsuario&" + valores;
	$("body").load(command);
}

function onCadastrarUsuario(){
	executarCommand("/com.pos.pioo/Controller?command=EditarUsuario");
}

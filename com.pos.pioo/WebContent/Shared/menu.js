function executarCommand(url){
	$("#com-pos-pioo-div-principal").load(url);
}

function executarCommandBody(url, dados)
{
	$.ajax({
		type: "POST",
		url: url,
		data: dados
	}).then(function(resultado){

		$("#com-pos-pioo-div-principal").html(resultado);
	});
}

$(document).ready(function(){
	$(".com-pos-pioo-menu-homes").on("click",  function(){ 
		$("#com-pos-pioo-div-principal").html("uma tela de boas vindas qualquer!");
	});

	$(".com-pos-pioo-menu-categorias").on("click", function(){
		executarCommand("/com.pos.pioo/Controller?command=ListarCategoria");
	});
	$(".com-pos-pioo-menu-anunciantes").on("click", function(){ 
		executarCommand("/com.pos.pioo/Controller?command=ListarAnunciante"); 
	});
	$(".com-pos-pioo-menu-anuncios").on("click",  function(){ 
		executarCommand("/com.pos.pioo/Controller?command=ListarAnuncio");
	});

	$(".com-pos-pioo-menu-usuarios").on("click",  function(){ 
		executarCommand("/com.pos.pioo/Controller?command=ListarUsuario");
	});

	$(".com-pos-pioo-menu-login").on("click",  function(){ 
		executarCommand("/com.pos.pioo/Controller?command=LoginUsuario");
	});

	$(".com-pos-pioo-menu-home").on("click", function(){
		executarCommand("/com.pos.pioo/Controller?command=MostrarAnuncio");
	});

	$(".com-pos-pioo-menu-logout").on("click", function(){
		$("body").load("/com.pos.pioo/Controller?command=LogoutUsuario");
	});
});


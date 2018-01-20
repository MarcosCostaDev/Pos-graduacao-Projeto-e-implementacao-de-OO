function navegarPrincipal(url){
	$("#com-pos-pioo-div-principal").load(url);
}

$(document).ready(function(){
	$(".com-pos-pioo-menu-homes").on("click",  function(){ 
		$("#com-pos-pioo-div-principal").html("uma tela de boas vindas qualquer!");
	});
	
	$(".com-pos-pioo-menu-categorias").on("click", function(){
		navegarPrincipal("/com.pos.pioo/NavegacaoController?partial=ListarCategoria");
	});
	$(".com-pos-pioo-menu-anunciantes").on("click", function(){ 
		navegarPrincipal("/com.pos.pioo/NavegacaoController?partial=ListarAnunciante"); 
	});
	$(".com-pos-pioo-menu-anuncios").on("click",  function(){ 
		navegarPrincipal("/com.pos.pioo/NavegacaoController?partial=ListarAnuncio");
	});
});


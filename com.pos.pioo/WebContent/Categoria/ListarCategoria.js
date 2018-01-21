$(document).ready(function(){
});

function onEditarCategoria(id)
{
	if(id)
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarCategoria&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarCategoria");
	}
}



function onExluirCategoria(id){
	if(confirm("Deseja deletar o categoria?"))
	{
		executarCommand("/com.pos.pioo/Controller?command=DeletarCategoria&id=" + id);
	}
}
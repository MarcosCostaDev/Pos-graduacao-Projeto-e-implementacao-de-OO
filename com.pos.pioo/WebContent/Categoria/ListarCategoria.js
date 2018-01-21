$(document).ready(function(){
});

function onEditarCategoria(id)
{
	if(id)
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarCategoria&id=" + id);
	}
	else
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarCategoria");
	}
}



function onDeletarCategoria(id){
	if(confirm("Deseja deletar o categoria?"))
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=DeletarCategoria&id=" + id);
	}
}
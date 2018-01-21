$(document).ready(function(){
});

function onEditarCategoria(id)
{
	if(id)
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarCategoria");
	}
	else
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarCategoria");
	}
}
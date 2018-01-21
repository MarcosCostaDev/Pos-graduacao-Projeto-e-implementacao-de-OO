function onEditarAnuncio(id)
{
	if(id)
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarAnuncio&id=" + id);
	}
	else
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarAnuncio");
	}
}


function onDeletarAnuncio(id){
	if(confirm("Deseja deletar o anuncio?"))
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=DeletarAnuncio&id=" + id);
	}
}
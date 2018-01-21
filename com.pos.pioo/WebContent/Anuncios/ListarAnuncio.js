function onEditarAnuncio(id)
{
	if(id)
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarAnuncio&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarAnuncio");
	}
}


function onDeletarAnuncio(id){
	if(confirm("Deseja deletar o anuncio?"))
	{
		executarCommand("/com.pos.pioo/Controller?command=DeletarAnuncio&id=" + id);
	}
}
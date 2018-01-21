function onEditarAnunciante(id)
{
	if(id)
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarAnunciante&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarAnunciante");
	}
}

function onDeletarAnunciante(id){
	if(confirm("Deseja deletar o anunciante?"))
	{
		executarCommand("/com.pos.pioo/Controller?command=DeletarAnunciante&id=" + id);
	}
}
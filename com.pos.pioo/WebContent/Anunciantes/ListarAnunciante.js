function onEditarAnunciante(id)
{
	if(id)
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarAnunciante&id=" + id);
	}
	else
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=EditarAnunciante");
	}
}

function onDeletarAnunciante(id){
	if(confirm("Deseja deletar o anunciante?"))
	{
		navegarPrincipal("/com.pos.pioo/Controller?command=DeletarAnunciante&id=" + id);
	}
}
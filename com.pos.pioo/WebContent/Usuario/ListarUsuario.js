

function onEditarUsuario(id)
{
	if(id)
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarUsuario&id=" + id);
	}
	else
	{
		executarCommand("/com.pos.pioo/Controller?command=EditarUsuario");
	}
}



function onExluirUsuario(id){
	if(confirm("Deseja deletar o usuario?"))
	{
		executarCommand("/com.pos.pioo/Controller?command=DeletarUsuario&id=" + id);
	}
}
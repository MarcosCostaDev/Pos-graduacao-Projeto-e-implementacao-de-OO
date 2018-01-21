package repositorios;

import domain.Usuario;

public interface UsuarioRepositorio extends RepositorioBase<Usuario> {

	Usuario AlterarSenha(Usuario objeto);
	Usuario Login(Usuario objeto);
	
}

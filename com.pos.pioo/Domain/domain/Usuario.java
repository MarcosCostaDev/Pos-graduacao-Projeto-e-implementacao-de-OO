package domain;

public class Usuario extends Entidade {

	private String nome;
	private String login;
	private String senha;

	public Usuario(String login, String senha)
	{
		super();
		
	
		naoDeveSerVazio(login, "Login deve ser informado");
		naoDeveSerVazio(senha, "Senha deve ser informado");
		
		
		this.login = login;
		this.senha = senha;	
	}

	public Usuario(String nome, String login, String senha)
	{

		super();
		
		naoDeveSerVazio(nome, "Nome deve ser informado");
		naoDeveSerVazio(login, "Login deve ser informado");
		naoDeveSerVazio(senha, "Senha deve ser informado");
		
		this.nome = nome;		
		this.login = login;
		this.senha = senha;

	}

	public void setSenha(String senha, String senhaCompare)
	{
		
		deveSerIgual(senha, senhaCompare, "Senhas não coicidem");
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		
		return senha;
	}
}

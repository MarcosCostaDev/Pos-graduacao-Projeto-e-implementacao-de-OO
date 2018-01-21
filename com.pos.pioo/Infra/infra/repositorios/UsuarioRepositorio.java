package infra.repositorios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import domain.Usuario;

public class UsuarioRepositorio extends RepositorioBase implements repositorios.UsuarioRepositorio {


	@Override
	public void inserir(Usuario objeto) throws SQLException {
		try {  

			String query = "insert into Usuario(guid, nome, login, senha) values (?, ?, ?, ?)" ;

			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getId());
			ps.setString(2, objeto.getNome());
			ps.setString(3, objeto.getLogin());
			ps.setString(4, objeto.getSenha());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao inserir categoria");  
			objeto.adicionarMensagem("Erro ao inserir categoria");
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

	}

	@Override
	public void alterar(Usuario objeto) throws SQLException {
		try {  

			String query = "update usuario set nome = ?, login = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getLogin());
			ps.setString(3, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar anunciante");  
			objeto.adicionarMensagem("Erro ao alterar anunciante");
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

	}

	@Override
	public void excluir(Usuario objeto) throws SQLException {
		try {  

			String query = "delete from usuario where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao excluir categoria");  
			objeto.adicionarMensagem("Erro ao excluir categoria");
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

	}

	@Override
	public List<Usuario> listarConsulta(String filtro) throws SQLException {
		ArrayList<Usuario> objetos = new ArrayList<Usuario>();

		try {  

			String query = "select guid, nome, login from usuario ";

			if(!filtro.isEmpty())
			{
				query += filtro;
			}

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ResultSet resultado = ps.executeQuery();



			while(resultado.next())
			{
				Usuario objeto = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
				objetos.add(objeto);
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar anunciante");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

		return objetos;
	}

	@Override
	public Usuario selecionarConsulta(String codigo) throws SQLException {
		Usuario objeto = null;

		try {  
			String query = "select guid, nome, login from usuario where guid = ?";
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, codigo);
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				objeto = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar categoria");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

		return objeto;
	}

	@Override
	public Usuario AlterarSenha(Usuario objeto) {
		try {  

			String query = "update usuario set senha = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getSenha());
			ps.setString(2, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar anunciante");  
			objeto.adicionarMensagem("Erro ao alterar anunciante");
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		} 
		
		return objeto;
	}

	@Override
	public Usuario Login(Usuario objeto) {
		try {  
			String query = "select guid, nome, login from usuario where login = ? and senha = ?";
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getLogin());
			ps.setString(2, objeto.getSenha());
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				objeto = new Usuario(resultado.getString("nome"), resultado.getString("login"), "");
				objeto.setId(resultado.getString("guid"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar categoria");  
			System.out.println(e.toString());  
		}finally{ 
			try{ 
				if(rs != null) 
					rs.close(); 
				if(ps != null) 
					ps.close(); 
				if(con != null) 
					con.close();            
			}catch(SQLException e){ 
				e.printStackTrace(); 
			}catch(Exception ex){ 
				ex.printStackTrace(); 
			}  
		}  

		return objeto;
	}
}



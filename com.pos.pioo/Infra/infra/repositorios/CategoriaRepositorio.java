package infra.repositorios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Anunciante;
import domain.Categoria;

public class CategoriaRepositorio extends RepositorioBase implements repositorios.CategoriaRepositorio {


	@Override
	public void inserir(Categoria objeto) throws SQLException {
		try {  

			String query = "insert into Categoria(guid, nome) values (?, ?)" ;

			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getId());
			ps.setString(2, objeto.getNome());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao inserir categoria");  
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
	public void alterar(Categoria objeto) throws SQLException {
		try {  

			String query = "update categoria set nome = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getNome());
			ps.setString(2, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar anunciante");  
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
	public void excluir(Categoria objeto) throws SQLException {
		try {  

			String query = "delete from categoria where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao excluir categoria");  
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
	public List<Categoria> listarConsulta(String filtro) throws SQLException {
		ArrayList<Categoria> objetos = new ArrayList<Categoria>();

		try {  

			String query = "select * from categoria ";

			if(!filtro.isEmpty())
			{
				query += filtro;
			}

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ResultSet resultado = ps.executeQuery();



			while(resultado.next())
			{
				Categoria objeto = new Categoria(resultado.getString("nome"));
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
	public Categoria selecionarConsulta(String codigo) throws SQLException {
		Categoria objeto = null;

		try {  
			String query = "select * from categoria where guid = ?";
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, codigo);
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				objeto = new Categoria(resultado.getString("nome"));
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



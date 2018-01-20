package infra.repositorios;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Anunciante;
import domain.Anuncio;
import domain.Categoria;

public class AnuncioRepositorio extends RepositorioBase implements repositorios.AnuncioRepositorio {
	
	
	@Override
	public void inserir(Anuncio objeto) throws SQLException {
		try {
			String query = "insert into anuncio(guid, guidanunciante, guidcategoria, datavalidade, datacriacao) values (?, ?, ?, ?)" ;

			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, objeto.getId());
			ps.setString(2, objeto.getAnunciante().getId());
			ps.setString(3, objeto.getCategoria().getId());
			ps.setDate(4, (Date)objeto.getDataValidade());
			ps.setDate(5, (Date) objeto.getDataCriacao());

			ps.executeUpdate();  

		} catch (SQLException e) {  
			System.out.println("Erro ao inserir anuncio");  
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
	public void alterar(Anuncio objeto) throws SQLException {
		try {  

			String query = "update anuncio set guidanunciante = ?, guidcategoria = ?, datavalidade = ? where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getAnunciante().getId());
			ps.setString(2, objeto.getCategoria().getId());
			ps.setDate(3, (Date)objeto.getDataValidade());
			ps.setString(4, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao alterar anuncio");  
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
	public void excluir(Anuncio objeto) throws SQLException {
		try {  

			String query = "delete from anuncio where guid = ?";

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ps.setString(1, objeto.getId());
			ps.executeUpdate();  
		} catch (SQLException e) {  
			System.out.println("Erro ao excluir anuncio");  
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
	public List<Anuncio> listarConsulta(String filtro) throws SQLException {
		ArrayList<Anuncio> objetos = new ArrayList<Anuncio>();

		try {  

			String query = "SELECT ANUNCIO.GUID, ANUNCIO.GUIDANUNCIANTE, ANUNCIO.GUIDCATEGORIA, ANUNCIO.DATAVALIDADE, ANUNCIO.DATACRIACAO, ANUNCIANTE.NOME AS ANUNCIANTENOME, ANUNCIANTE.DOCUMENTO, ANUNCIANTE.ENDERECO, ANUNCIANTE.TELEFONE, " + 
					"                  CATEGORIA.NOME AS CATEGORIANOME " + 
					" FROM     ANUNCIO INNER JOIN" + 
					"                  ANUNCIANTE ON ANUNCIANTE.GUID = ANUNCIO.GUIDANUNCIANTE INNER JOIN" + 
					"                  CATEGORIA ON CATEGORIA.GUID = ANUNCIO.GUIDCATEGORIA ";

			if(!filtro.isEmpty())
			{
				query += filtro;
			}

			con = getConnection();  
			ps = con.prepareStatement(query);  

			ResultSet resultado = ps.executeQuery();



			while(resultado.next())
			{
				Categoria categoria = new Categoria(resultado.getString("CATEGORIANOME"));
				categoria.setId(resultado.getString("GUIDCATEGORIA"));
				Anunciante anunciante = new Anunciante(resultado.getString("ANUNCIANTENOME"), resultado.getString("documento"), resultado.getString("endereco"), resultado.getString("cidade"), resultado.getString("telefone"));
				anunciante.setId(resultado.getString("GUIDANUNCIANTE"));
				Anuncio objeto = new Anuncio(categoria, anunciante, (Date)resultado.getDate("DATAVALIDADE"));
				objeto.setId(resultado.getString("guid"));
				objeto.setDataCriacao((Date)resultado.getDate("datacriacao"));
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
	public Anuncio selecionarConsulta(String codigo) throws SQLException {
		Anuncio objeto = null;

		try {  
			String query = "SELECT ANUNCIO.GUID, ANUNCIO.GUIDANUNCIANTE, ANUNCIO.GUIDCATEGORIA, ANUNCIO.DATAVALIDADE, ANUNCIO.DATACRIACAO, ANUNCIANTE.NOME AS ANUNCIANTENOME, ANUNCIANTE.DOCUMENTO, ANUNCIANTE.ENDERECO, ANUNCIANTE.TELEFONE, " + 
					"                  CATEGORIA.NOME AS CATEGORIANOME " + 
					" FROM     ANUNCIO INNER JOIN" + 
					"                  ANUNCIANTE ON ANUNCIANTE.GUID = ANUNCIO.GUIDANUNCIANTE INNER JOIN" + 
					"                  CATEGORIA ON CATEGORIA.GUID = ANUNCIO.GUIDCATEGORIA " +
					" WHERE ANUNCIO.GUID = ? ";
					
			con = getConnection();  
			ps = con.prepareStatement(query);  
			ps.setString(1, codigo);
			ResultSet resultado = ps.executeQuery();

			if(resultado.next())
			{
				Categoria categoria = new Categoria(resultado.getString("CATEGORIANOME"));
				categoria.setId(resultado.getString("GUIDCATEGORIA"));
				Anunciante anunciante = new Anunciante(resultado.getString("ANUNCIANTENOME"), resultado.getString("documento"), resultado.getString("endereco"), resultado.getString("cidade"), resultado.getString("telefone"));
				anunciante.setId(resultado.getString("GUIDANUNCIANTE"));
				objeto = new Anuncio(categoria, anunciante, (Date)resultado.getDate("DATAVALIDADE"));
				objeto.setId(resultado.getString("guid"));
				objeto.setDataCriacao((Date)resultado.getDate("datacriacao"));
			}


		} catch (SQLException e) {  
			System.out.println("Erro ao selecionar anuncio");  
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

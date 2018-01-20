package infra.repositorios;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;  

public class RepositorioBase {
	protected Connection con = null;  
	protected PreparedStatement ps= null;  
	protected ResultSet rs = null;  
    
    
    protected Connection getConnection() throws SQLException{  
            Connection conn;  
            conn = ConnectionFactory.getInstance().getConnection();  
            return conn;  
    }
}

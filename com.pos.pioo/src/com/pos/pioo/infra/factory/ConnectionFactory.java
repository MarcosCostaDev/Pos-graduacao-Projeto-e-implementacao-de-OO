package com.pos.pioo.infra.factory;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

public class ConnectionFactory {

	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    private String connectionStr = "jdbc:sqlserver://localhost:1433;databaseName=PooProjeto";  
    private String usuario = "sa";  
    private String senha = "14112011";  
      
    private static ConnectionFactory connectionFactory = null;  

    private ConnectionFactory(){  
        try{  
            Class.forName(driver);  
        }catch(ClassNotFoundException e){  
            e.printStackTrace();  
        }  
    }  

    public Connection getConnection() throws SQLException{  
        Connection conn = null;  
        try{  
        conn = DriverManager.getConnection(connectionStr, usuario, senha);  
        }catch(SQLException e){  
            e.printStackTrace();  
        }  
        return conn;  
    }  
      
    public static ConnectionFactory getInstance(){  
        if(connectionFactory == null)  
            connectionFactory = new ConnectionFactory();  

        return connectionFactory;  
    }  
}

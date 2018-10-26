package edu.co.sergio.mundo.dao;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class Conexion {
	
	private static Connection CONEXION=null;
    	public static Connection getConnection() throws URISyntaxException{
        /*String HOST = "ec2-54-225-115-234.compute-1.amazonaws.com"; 
        String DATABASE = "d2f6dtq4uph3un";
        String USER = "smedyucvlefair";
        String PASS = "cf23f0134648f96a10d01d23886547988e5ab08005f5db46ff7f2257065110c0";*/
        
        
        URI dbUri = new URI(System.getenv("DATABASE_URL"));
        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    
		  if(CONEXION == null){
                        try {
                        CONEXION = DriverManager.getConnection(dbUrl, username, password);
                        } catch (SQLException e) {
                        System.out.println("Connection Failed! Check output console");
                        e.printStackTrace();
                        }
                            
                    }
              return CONEXION;
              }
	
	public static void closeConnection(){
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	

}

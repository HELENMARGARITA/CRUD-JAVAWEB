package config;

//import com.mysql.jdbc.Connection;
//import java.sql.DriverManager;
import java.sql.*;

public class Conexion {
    Connection con;
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud", "root", "");
        }catch (Exception e){
            System.err.println("Error" + e);
        }
    }
    
    public Connection getConnection (){
        return con;
    }
}

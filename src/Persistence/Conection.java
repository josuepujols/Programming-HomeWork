/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Josue Pujols
 */
public class Conection {
    public static final String URL = "jdbc:mysql://localhost:3306/user_manager";
    public static final String USER = "root";
    public static final String CLAVE = "";
     
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}

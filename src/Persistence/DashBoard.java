/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;
import usersystem.RegisterUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Josue Pujols
 */
public class DashBoard {
    private Conection con;
    private Connection conexion;
    
    //Constructor
    public DashBoard() {
        con = new Conection();
        conexion = con.getConexion();
    }
    
   public String Update(int Id, String UserName, String Name, String LastName, String Number, String Mail, String Password) {
       String Message = "";
       try {
            String query = "UPDATE USERS SET USERNAME = ?, NAME = ?, LASTNAME = ?, PHONE = ?, MAIL = ?, PASSWORD = ? WHERE ID = " + Id;
            PreparedStatement PreQuery = conexion.prepareStatement(query);
            PreQuery.setString(1, UserName);
            PreQuery.setString(2, Name);
            PreQuery.setString(3, LastName);
            PreQuery.setString(4, Number);
            PreQuery.setString(5, Mail);
            PreQuery.setString(6, Password);
            
            PreQuery.execute();
            Message = "Se ha actualizado el usuario con existo.";
       }
       catch(Exception e){
            System.out.println("Error: " + e.getMessage());
       }
       
       return Message;
   }
    
}

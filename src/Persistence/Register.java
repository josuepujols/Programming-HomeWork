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
public class Register extends RegisterUser {
    private Conection con;
    private Connection conexion;
    
    public Register() {
        con = new Conection();
        conexion = con.getConexion();
    }
    
    
    public String RegisterUser(String UserName, String Name, String LastName, String Number, String Mail, String Password) {
        String Message = "";
        if (!UserExists(UserName)) {
            try {
                String query = "INSERT INTO USERS (username, name, lastname, phone, mail, password) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement PreQuery = conexion.prepareStatement(query);
                PreQuery.setString(1, UserName);
                PreQuery.setString(2, Name);
                PreQuery.setString(3, LastName);
                PreQuery.setString(4, Number);
                PreQuery.setString(5, Mail);
                PreQuery.setString(6, Password);
                
                PreQuery.execute();
                Message = "Se ha registrado el usuario con existo.";
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
            
        }
        else {
             Message = "El usuario " + UserName + " ya existe.";
        }
        
        return Message;
    }
    
    public boolean UserExists(String user) {
        boolean Message = false;
        
        String query = "SELECT * FROM USERS WHERE USERNAME = '" + user + "'";
        try {
            Statement s = conexion.createStatement();
            ResultSet result = s.executeQuery(query);
            
            if (result.next()) {
                Message = true;
            }
            
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return Message;
    }
    
}

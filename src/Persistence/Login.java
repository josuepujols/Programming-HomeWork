/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Josue Pujols
 */
public class Login {
    private Conection con;
    private Connection conexion;
    
    public Login() {
        con = new Conection();
        conexion = con.getConexion();
    }
    
    
    public int LogIn(String UserName, String Password) {
        int FinalResult = 0;
        Register reg = new Register();
        
        try {
            if (reg.UserExists(UserName)) {
                String query = "SELECT * FROM USERS WHERE USERNAME = '" + UserName + "' AND PASSWORD = '" + Password + "'";
                Statement s = conexion.createStatement();
                ResultSet result = s.executeQuery(query);
                
                if (result.next()) {
                    //if the finalresult is 1 the users is loged in
                    FinalResult = 1;
                }
                else {
                    //if finalresult is 2 the password is incorrect
                    FinalResult = 2;
                }
            }
            else {
                //if the result is 3 the user does not exist 
                FinalResult = 3;
            }
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        return FinalResult; 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;
/**
 *
 * @author Pushpendra
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {   
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","onlineexam","students");
            JOptionPane.showMessageDialog(null, "Successfully connected to the DB","Connection Successful",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot connect to the DB","Connection fail!",JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }        
    }
    
    public static Connection getConnection()
    {
        return conn;
    }
    
    public static void closeConnection()
    {
        if(conn!=null)
        {
            try
            {
                conn.close();
                JOptionPane.showMessageDialog(null, "Disconnected successfully to the DB","Disconnected",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Cannot close the connection to DB","Error",JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class dbConnection {
    private String uid = "root";
    private String pwd = "";
        
    //DECLARING DB PROPERTIES
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    
    public Connection getConnection()
    {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/dbPeter",uid,pwd);
        } catch (Exception e) {
            
        }
        return con;
    }
}

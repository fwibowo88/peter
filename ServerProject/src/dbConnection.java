
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class dbConnection{
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
    
    public boolean checkCon() throws SQLException
    {
        boolean msg = false;
        if(!con.isClosed())
        {
            msg = true;
        }
        return msg;
    
    }
    
    
    public void closeConnection(){
         if(con != null)
                try {
                    con.close();
            } catch (SQLException ex) {
                    System.out.println("Err : "+ex.getMessage());
            }
    }
    
    public PreparedStatement getP(String sql) throws SQLException
    {
        return con.prepareStatement(sql);
    
    }
}

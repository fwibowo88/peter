
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class User {
    private String uidDB = "root";
    private String pwdDB = "";
        
    //DECLARING DB PROPERTIES
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    
    public Connection getConnection()
    {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/peter",uidDB,pwdDB);
            
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public void closeConnection(){
         if(con != null)
                try {
                    con.close();
            } catch (SQLException ex) {
                    System.out.println("Err : "+ex.getMessage());
            }
    }
    
    public boolean addUser(String xID,String xPwd)
    {
        boolean msg = false;
        try {
            stat = (Statement)con.createStatement();
            if(!con.isClosed())
            {
                PreparedStatement sql = (PreparedStatement)con.prepareStatement("INSERT INTO user VALUES(?,?)");
                sql.setString(1, xID);
                sql.setString(2, xPwd);
                sql.executeUpdate();
                System.out.println("SUCCESS ADD NEW USER");
                msg = true;
                con.close();
            
            }
        } catch (SQLException ex) {
            System.out.println("Error Insert : "+ex.getMessage());
        }
        
        return msg;
    }
    public boolean editUser(String xID,String xPWD)
    {
        System.out.println(xID+xPWD);
        boolean msg = false;
        
        try {
            stat = (Statement)con.createStatement();
            if(!con.isClosed())
            {
                PreparedStatement sql = (PreparedStatement)con.prepareStatement("UPDATE user SET password=? WHERE username=?");
                sql.setString(1, xPWD);
                sql.setString(2, xID);
                sql.executeUpdate();
                System.out.println("SUCCESS EDIT USER");
                msg = true;
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error Edit : "+ex.getMessage());
        }
        return msg;
    }
    public boolean loginUser(String xID,String xPwd)
    {
        getConnection();
        boolean msg = false;
        ArrayList<User> listUser = new ArrayList<>();
        //QUERY SELECT
        try {
            stat = (Statement) con.createStatement();
            if (stat != null)
            {
                rs = stat.executeQuery("SELECT * FROM user WHERE username='" + xID + "' AND password='" + xPwd + "'");
                while(rs.next())
                {
                User u = new User(
                rs.getString("username"),
                rs.getString("password"));
                listUser.add(u);
            
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR FETCH DATA");
        }
        
        if(listUser.size()==1)
        {
            msg = true;
        
        }
        return msg;
    }
    public String findUser(String xID)
    {
        getConnection();
        String tmpName = "";
        String tmpPWD = "";
        //QUERY SELECT
        try {
            stat = (Statement) con.createStatement();
            if (stat != null)
            {
                rs = stat.executeQuery("SELECT * FROM user WHERE username='" + xID + "'");
                while(rs.next())
                {
                    tmpName = rs.getString("username");
                    tmpPWD = rs.getString("password");
                    System.out.println(tmpName + tmpPWD);
                } 
            }
            
        } catch (SQLException ex) {
            System.out.println("ERROR FETCH DATA");
        }
        
        return tmpName+"/"+tmpPWD;

    }
    
    //ATTR FOR USER
    private String idUser;
    private String pwdUser;
    
    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the pwdUser
     */
    public String getPwdUser() {
        return pwdUser;
    }

    /**
     * @param pwdUser the pwdUser to set
     */
    public void setPwdUser(String pwdUser) {
        this.pwdUser = pwdUser;
    }
    public User()
    {
        getConnection();
    }
    public User(String xID, String xPWD)
    {
        this.idUser = xID;
        this.pwdUser = xPWD;
        getConnection();
    }
    
    
}

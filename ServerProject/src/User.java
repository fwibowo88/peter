
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
                sql.setString(1, idUser);
                sql.setString(2, pwdUser);
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
    public boolean editUser()
    {
        boolean msg = false;
        
        try {
            stat = (Statement)con.createStatement();
            if(!con.isClosed())
            {
                PreparedStatement sql = (PreparedStatement)con.prepareStatement("UPDATE tbluser SET pwd=? WHERE id='?'");
                sql.setString(1, pwdUser);
                sql.setString(2, idUser);
                sql.executeUpdate();
                System.out.println("SUCCESS EDIT USER");
                msg = true;
                con.close();
            
            }
        } catch (SQLException ex) {
            System.out.println("Error Insert : "+ex.getMessage());
        }
        return msg;
    }
    public boolean loginUser(String xID,String xPwd)
    {
        boolean msg = false;
        ArrayList<User> listUser = new ArrayList<>();
        //QUERY SELECT
        try {
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery("SELECT * FROM user WHERE id='?' AND pwd='?'");
            while(rs.next())
            {
                User u = new User(
                        rs.getString("id"),
                        rs.getString("pwd"));
                listUser.add(u);
            
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
    
    }
    public User(String xID, String xPWD)
    {
        this.idUser = xID;
        this.pwdUser = xPWD;
    
    }
    
    
}

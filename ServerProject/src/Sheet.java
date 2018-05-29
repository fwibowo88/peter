
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class Sheet {
    private String loc;
    private String desc;
    
    private Connection con;
    private Statement stat;
    private ResultSet rs;
    private String uid = "root";
    private String pwd = "";
    
    //dbConnection con = new dbConnection();

    /**
     * @return the loc
     */
    
    public Connection getConnection()
    {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/peter",uid,pwd);
            
            System.out.println(con);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    
    public String getLoc() {
        return loc;
    }

    /**
     * @param loc the loc to set
     */
    public void setLoc(String loc) {
        this.loc = loc;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public Sheet()
    {
        
    }
    public Sheet(String xLoc,String xDesc)
    {
        this.loc = xLoc;
        this.desc = xDesc;
    
    }
    public boolean editSheet(String xLoc, String xData)
    {
        boolean msg = false;
        //EDIT QUERY-KE DATABASE
        getConnection();
        try 
        {
            stat = (Statement) con.createStatement();
            if(!con.isClosed())
            {
                PreparedStatement sql = (PreparedStatement) con.prepareStatement("UPDATE data SET val=? where loc=?");
                sql.setString(1, xData);
                sql.setString(2, xLoc);
                sql.executeUpdate();
                System.out.println(xLoc + " updated, val: " + xData);
                msg = true;
            }
            con.close();
            
        } catch (SQLException e) 
        {
            System.out.println("ERROR : "+e.getMessage());
        
        }
        
        //INSERT ke TBL LOG
        return msg;
    
    }
    public String getData(String loc)
    {
        boolean msg = false;
        String val = "";
        getConnection();      
        try 
        {
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery("SELECT val FROM data WHERE loc='" + loc + "'");
            while(rs.next())
            {
                val = rs.getString("val");
            }
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println("error get data: " + e.getMessage());
        }
        
        return val;
    }
    
    public ArrayList<String> getLogData()
    {
        ArrayList<String> val= new ArrayList<String>();
        getConnection();      
        try 
        {
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery("SELECT * FROM log");
            while(rs.next())
            {
                val.add(rs.getString("time") + "#" + rs.getString("author") + "#"+rs.getString("location"));
            }
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR : " + e.getMessage());
        }
        
        return val;
    }
    public int countLogData()
    {
        int count = 0;
        getConnection();      
        try 
        {
            stat = (Statement) con.createStatement();
            rs = stat.executeQuery("SELECT COUNT(*)AS count FROM log");
            while(rs.next())
            {
                count = rs.getInt("count");
            }
            con.close();
        } 
        catch (Exception e) 
        {
            System.out.println("error get data: " + e.getMessage());
        }
        
        return count;
    }
    public boolean insertLog(String xAuth,String xLoc)
    {
        getConnection(); 
        boolean msg = false;
        try {
            stat = (Statement)con.createStatement();
            if(!con.isClosed())
            {
                com.mysql.jdbc.PreparedStatement sql = (com.mysql.jdbc.PreparedStatement)con.prepareStatement("INSERT INTO log VALUES(NOW(),?,?)");
                sql.setString(1, xAuth);
                sql.setString(2, xLoc);
                sql.executeUpdate();
                System.out.println("LOGGING SUCCESS");
                msg = true;
                con.close();
            
            }
        } catch (SQLException ex) {
            System.out.println("Error Insert : "+ex.getMessage());
        }
        
        return msg;
    }
    
}

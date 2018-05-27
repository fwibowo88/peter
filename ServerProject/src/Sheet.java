
import java.sql.PreparedStatement;

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
    
    dbConnection con = new dbConnection();

    /**
     * @return the loc
     */
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
        try {
            PreparedStatement sql = (PreparedStatement) con.getP(loc);
        } catch (Exception e) {
        }
        
        //INSERT ke TBL LOG
        return msg;
    
    }
    public boolean getData()
    {
        boolean msg = false;
        con.getConnection();
        
        try {
            
        } catch (Exception e) {
            
        }
        return msg;
    }
    
    
}

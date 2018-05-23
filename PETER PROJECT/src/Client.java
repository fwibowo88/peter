
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class Client {
    //NET ATTRIBUTE
    private String srvAddres;
    private int port;

    //PROPERTIES
    /**
     * @return the srvAddres
     */
    public String getSrvAddres() {
        return srvAddres;
    }

    /**
     * @param srvAddres the srvAddres to set
     */
    public void setSrvAddres(String srvAddres) {
        this.srvAddres = srvAddres;
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(int port) {
        this.port = port;
    }
    //CONSTRUCTOR
    public Client()
    {
    
    }    
    public Client(String xAddr,int xPort)
    {
        this.srvAddres = xAddr;
        this.port = xPort;
    }
    
    
}

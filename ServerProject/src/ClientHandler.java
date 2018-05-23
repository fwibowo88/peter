
import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
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
public class ClientHandler extends Thread{
    
    private Thread t;
    private String nameThread;
    
    private boolean runThread =true;
    
    //NET ATTRIBUTTE
    private Socket clientSocket;
    private BufferedReader in;
    private PrintStream out;
    
    
    private Server server;
    
    public ClientHandler(Socket sockx, Server parent, String name)
    {
        try {
            this.clientSocket = sockx;
            this.server = parent;
            this.nameThread = name;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintStream(clientSocket.getOutputStream());
        } catch (IOException ex) {
            //Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public String getNameThread()
    {
        return nameThread;
    
    }
    public void setNameThread(String xName)
    {
        this.nameThread = xName;
        t.setName(xName);
    
    }
    
    @Override
    public void run()
    {
        try {
            System.out.println("Accept Address Client : "+clientSocket.getInetAddress().getHostName());
            out.println("Anda Terhubung dalam Server");
            
            while(runThread)
            {
                String clientCmd = in.readLine();
                System.out.println("CMD >> " + clientCmd);
                server.DisplayReceived(nameThread, clientCmd);
                
                if(!server.isServerOn())
                {
                    System.out.println("CMD >> Server Off");
                    out.println("OFF");
                    this.ServiceOff();
                
                }
                else if(clientCmd.equalsIgnoreCase("quit"))
                {
                    this.ServiceOff();
                    server.Shutdown();
                    System.out.println("CMD >> " + "Client Offline");
                    server.losingClient(this);
                }
                else if(clientCmd.equalsIgnoreCase("end"))
                {
                    this.ServiceOff();
                    server.Shutdown();
                    System.out.println("CMD >> " + "Client Offline");
                    System.out.println("CMD >> "+ "Server Off");
                    server.losingClient(this);
                }
                else if(clientCmd.equalsIgnoreCase("all"))
                {
                    server.BroadcastMsg("Halo Broadcast");
                
                }
                else if(clientCmd.equalsIgnoreCase("test"))
                {
                    server.BroadcastMsg("Hello World!");
                
                }
            
            }
        } catch (IOException e) {
            System.out.println("Try Readline : "+e.getMessage());
            server.losingClient(this);
        }
    
    }
    public void ServiceOff()
    {
        this.runThread = false;
    }
    public void ServiceOn()
    {
        this.runThread = true;
    
    }
    public void sendMessage(String message)
    {
        out.println(message);
    
    }
    public String toString()
    {
        return nameThread;
    
    }
}

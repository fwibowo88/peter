
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
public class ConHandler_1 extends Thread{
    private Thread t;
    private String nameThread;
    
    private Socket mySocket;
    private BufferedReader inChannel;
    private PrintStream outChannel;
    
    private Client_1 xClient;
    
    public ConHandler_1(Socket myXSock, Client_1 xxClient)
    {
        try {
            this.mySocket = myXSock;
            this.xClient = xxClient;
            inChannel = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            outChannel = new PrintStream(mySocket.getOutputStream());
            
        } catch (IOException e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    
    @Override
    public void run()
    {
        try {
            System.out.println("Server Address : "+mySocket.getInetAddress().getHostName());
            outChannel.println("CLIENT OK");
            while(true)
            {
                String srvMsg = inChannel.readLine();
                System.out.println("SRV >> " + srvMsg);
                if(srvMsg.equalsIgnoreCase("ss"))
                {
                    System.out.println("SENT TO SERVER BACK");  
                
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    
    }
    
    public void sendMessage(String xMessage)
    {
        outChannel.println(xMessage);
    }
    
}

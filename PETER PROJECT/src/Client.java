
import java.io.IOException;
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
public class Client {
    PrintStream outNet;
    Socket mySocket;
    
    clientForm cForm;
    
    //CONSTRUCTOR
    public Client(clientForm xForm) throws IOException
    {
        this.mySocket = new Socket("localhost",8888);
        ConHandler cHandler = new ConHandler(mySocket,this);
        this.cForm = xForm;
        cHandler.start();
        
        outNet = new PrintStream(mySocket.getOutputStream());
    
    }
    
    //METHOD
    public void sendMsg(String xMsg)
    {
        outNet.println(xMsg);
    }
    
    public void cmdUI(String cmd)
    {
        cForm.uiControl(cmd);
    }
}

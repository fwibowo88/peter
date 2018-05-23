
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Server {
    private boolean serverOn = true;
    //SAVE CONNECTED CLIENT
    ArrayList<ClientHandler> listOfClient;
    
    public boolean isServerOn()
    {
        return serverOn;
    
    }
    public void setServerOn(boolean serverOn)
    {
        this.serverOn = serverOn;
    
    }
    public Server()
    {
        listOfClient = new ArrayList<ClientHandler>();
        
        int x = 1;
        try {
            ServerSocket ss = new ServerSocket(3321);
            while (serverOn) {
                Socket cliSocket = ss.accept();
                ClientHandler cliThread = new ClientHandler(cliSocket,this,"Service" + x);
                x++;
                listOfClient.add(cliThread);
                
                cliThread.start();
                
                //SENT TO CLIENT LIST
            }
        } catch (IOException e) {
            System.out.println("Try main Server : "+e.getMessage());
        }
    
    }
    public void Shutdown()
    {
        this.serverOn = false;
        
    }
    public void Active()
    {
        this.serverOn = true;
    
    }
    
    public void BroadcastMsg(String msg)
    {
        for(ClientHandler client : listOfClient)
        {
            client.sendMessage(msg);
        
        }
        
    }
    public void DisplayReceived(String nama,String pesan)
    {
        System.out.println(nama = ": " +pesan);
    
    }
    public void losingClient(ClientHandler ch)
    {
        listOfClient.remove(ch);
    
    }
    
}

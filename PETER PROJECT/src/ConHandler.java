
import java.io.BufferedReader;
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
public class ConHandler extends Thread{
    //NET ATTR
    BufferedReader in;
    Socket sockX;
   private Client cl;
    
    public ConHandler(Socket xSocket, Client parent) throws IOException
    {
        try {
            this.sockX = xSocket;
            this.in = new BufferedReader(new InputStreamReader(sockX.getInputStream()));
            this.cl = parent;
        } catch (IOException e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    }
    
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                String msg = in.readLine();
                System.out.println("SERVER :  "+msg);
                
                cl.cmdUI(msg);
                
            } catch (IOException e) {
                System.out.println("ERROR : "+e.getMessage());
                
            }
        }    
    }
    
}

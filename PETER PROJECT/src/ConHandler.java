
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
 * @author fwadmin
 */
public class ConHandler extends Thread {
    BufferedReader in;
    Socket s;
    
    public ConHandler(Socket xSock)
    {
        try
        {
            s = xSock;
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        }
        catch(IOException ex)
        {
            System.out.println("Error : "+ ex.getMessage());
        }
    }
    public void run()
    {
        while(true)
        {
            try {
                String msg = in.readLine();
                System.out.println("Server : "+msg);
            } catch (IOException e) {
                System.out.println("Error : "+ e.getMessage());
            }
        
        }
    
    }
}

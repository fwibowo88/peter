
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
public class Client_1 {
    
    clientForm cform;
    
    
    public Client_1() throws IOException
    {
        cform = new clientForm();
        cform.setVisible(true);
        
        try {
            Socket sockx = new Socket("localhost",8888);
            //while(true)
            //{
                ConHandler_1 cHandler = new ConHandler_1(sockx, this);
                cHandler.start();
            //}
        } catch (IOException e) {
            System.out.println("ERROR : "+e.getMessage());
        }
    
    }
}

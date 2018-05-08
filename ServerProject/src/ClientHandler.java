
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private Socket client;
    private BufferedReader input;
    private DataOutputStream output;
    
    private Thread t;
    private String namaThread = "thread";
    private User usr = new User();
    
    private Sheet sh = new Sheet();//Edit Lembar Kerja
    String idx,pwdx;//JUST EXAMPLE
    
    private ArrayList<User> data_usr; // = new ArrayList<User>; - RAGU
        
    public ClientHandler(Socket socket)
    {
        client = socket;
        try {
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            output = new DataOutputStream(client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void run()
    {
        try {
            String received;
            output.writeBytes("PLASE LOGIN : ");
            int status = 0;
            while(status !=1)
            {
                received = input.readLine();
                System.out.println(received);
                String[] data = received.split("-");
                for(int x = 0;x<data_usr.size();x++)
                {
                    if((data[0]).equals(data_usr.get(x).getId()))
                    {
                        status = 1;
                        break;    
                    }
                    else
                    {
                        //Belum Register - USER Register
                        usr.addUser(idx,pwdx);
                    
                    }
                }
                if(data[1].equals("location"))
                {
                    sh.editSheet(data[2],data[3]);
                    //Fetch Data from Sheet Koneksi ke DB PARAM loc & DATA
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }    
}

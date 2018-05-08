
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
    //DECLARING PORT
    private static final int PORT =1234;
    
    public static void main(String[] args) {
        Socket sock = null;
        try {
            sock = new Socket("localhost",PORT);
            BufferedReader netInput = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            DataOutputStream netOutput = new DataOutputStream(sock.getOutputStream());
            
            BufferedReader usrEntry = new BufferedReader(new InputStreamReader(System.in));
            String message, response, id,pwd;
            int status =0;
            response = netInput.readLine();
            System.out.print("\nServer> " +response);
            while(status != 1)
            {
                System.out.print("ID : ");
                id = usrEntry.readLine();
                System.out.print("PWD : ");
                pwd = usrEntry.readLine();
                netOutput.writeBytes(id+"-"+pwd+"\n");
                status = Integer.parseInt(netInput.readLine());
                response = netInput.readLine();
                System.out.println("\nServer : " +response);
            }
            do
            {
                response = netInput.readLine();
                System.out.println("\nServer : "+response);
                System.out.print("Input D");
                message = usrEntry.readLine();
                netOutput.writeBytes(message + "\n");
            
            }while(!message.equals(3));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        finally{
        
            try {
                System.out.println("\nCLOSING CONNECTION . . .");
                sock.close();
            } catch (IOException ex) {
                System.out.println("FAIL TO CLOSE CONNECTION.");
                System.exit(1);
            }
            
        }
    }  
    
}


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Clock;

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
    private static ServerSocket serverSocket;
    private static final int port =1234;
    
    public static void main(String[] args) throws IOException{
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("SERVER STARTED, WAITING CLIENT . . .");
            
        } catch (Exception e) {
            System.out.println("\nTidak dapat menutup Port!");
            System.exit(1);
        }
        while(true)
        {
            Socket clientSocket = serverSocket.accept();
            System.out.println("NEW CLIENT CONNECTED.");
            
            ClientHandler handler = new ClientHandler(clientSocket);
            handler.start();
        
        }
    
    }
}

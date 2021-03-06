
import com.sun.istack.internal.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
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
            System.out.println("ERR HANDLING : "+ ex.getMessage());
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
                String str = clientCmd;
                String[] split = str.split("/");
                
                if(!server.isServerOn())
                {
                    System.out.println("CMD >> Server Off");
                    out.println("OFF");
                    this.ServiceOff();               
                }
                else if(clientCmd.equalsIgnoreCase("END"))
                {
                    this.ServiceOff();
                    //erver.Shutdown();
                    System.out.println("CMD >> " + "Client Offline");
                    server.losingClient(this);
                    server.BroadcastMsg("02"+"/"+"00"+"/"+"00"+"/"+"RES"); //CLEAR AREA ONLINE
                    for(int x = 0;x<server.listOfClient.size();x++)// SEND LIST ONLINE USER
                    {
                        System.out.println(server.getName(x));
                        server.BroadcastMsg("02"+"/"+server.getName(x)+"/"+"**"+"/"+"OL");
                    }
                }
                else if(split[0].equals("01")) //LOGIN
                {
                    User usr = new User();
                    boolean res = usr.loginUser(split[1], split[2]);
                    if(res == true)
                    {
                        out.println(split[0]+"/"+split[1]+"/"+split[2]+"/"+"OK");//SENT MSG OK VERIFICATION
                        server.BroadcastMsg("02"+"/"+"00"+"/"+"00"+"/"+"RES"); //CLEAR AREA ONLINE
                        server.BroadcastMsg("02"+"/"+split[1]+"/"+"00"+"/"+"NOTIF"); // SENT USR NOTIFICATION
                        this.nameThread = split[1];
                        
                        for(int x = 0;x<server.listOfClient.size();x++)// SEND LIST ONLINE USER
                        {
                            System.out.println(server.getName(x));
                            server.BroadcastMsg("02"+"/"+server.getName(x)+"/"+"**"+"/"+"OL");
                        }
                    }
                    else
                    {
                        out.println(split[0]+"/"+split[1]+"/"+split[2]+"/"+"ERR");
                    }
                }
                else if(split[0].equals("03")) // CHAT
                {
                    server.BroadcastMsg(split[0]+"/"+split[1]+"/"+split[2]+"/"+split[3]);
                }
                else if(split[0].equals("04")) // UPDATE TABLE
                {
                    Sheet sh = new Sheet();
                    Boolean res = sh.editSheet(split[2], split[3]);
                    Boolean msgLog = sh.insertLog(split[1], split[2]);
                    
                    if (res == true)
                    {
                        System.out.println("UPDATE SUKSES");
                    }
                    server.BroadcastMsg(split[0]+"/"+split[1]+"/"+split[2]+"/"+split[3]);
                    
                    
                }
                else if(split[0].equals("05")) // GET DATA FROM DB TABLE
                {
                    Sheet sh = new Sheet();
                    String t = split[1];
                    String value = sh.getData(split[1]);
                    server.BroadcastMsg(split[0]+"/"+split[1]+"/"+value+"/"+"UPDATE TABLE");
                }
                else if(split[0].equals("06"))// REGISTER USER
                {
                    User usr = new User();
                    usr.addUser(split[1],split[2]);
                    
                }
                else if(split[0].equals("07"))//EDIT USER PWD
                {
                    User usr = new User();
                    usr.editUser(split[1],split[2]);
                    
                }
                else if(split[0].equals("08")) // FIND DATA PROFILE
                {
                    User usr = new User();
                    
                    String tmpData = usr.findUser(split[1]);
                    String[] sTMP = tmpData.split("/");
                    System.out.println(sTMP[1]);
                    out.println(split[0]+"/"+sTMP[0]+"/"+sTMP[1]+"/"+"RDATA");
                }
                else if(split[0].equals("10")) //LOG TABLE
                {
                    Sheet sh = new Sheet();                    
                    server.BroadcastMsg(split[0]+"/"+"00"+"/"+"00"+"/"+"RES"); //CLEAR AREA LOG
                    System.out.println(sh.countLogData());
                    ArrayList<String> xVal = sh.getLogData();
                    for(int x = 0;x<xVal.size();x++)// SEND LIST LOG
                    {
                        System.out.println(xVal.get(x));
                        String[] sTMP = xVal.get(x).split("#");
                        server.BroadcastMsg(split[0]+"/"+sTMP[0]+"/"+sTMP[1]+"/"+sTMP[2]);
                    }
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
    
    public String updateTMP()
    {
        String xx = "";
        return xx;
    
    }
    
}

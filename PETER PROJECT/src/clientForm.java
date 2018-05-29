
import com.sun.management.jmx.Trace;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Component;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
//import com.itextpdf.text.Document;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */

public class clientForm extends javax.swing.JFrame {
    Client c = new Client(this);
    //MODEL JTABLE
    DefaultTableModel model;
    /**
     * Creates new form clientForm
     * @throws java.io.IOException
     */
    public clientForm() throws IOException {
        initComponents();
        setEnabled(false);
        //EVENT TABLE LISTENER
        model = (DefaultTableModel)tblWorking.getModel();
        String cAksi= "05";
        for(int i =0; i <= 19; i++)
        {
            for(int x = 0; x <= 19; x++)
            {
                String loc = String.valueOf(i)+"-"+String.valueOf(x);
                c.sendMsg(cAksi+"/"+loc+"/"+"UPDATE"+"/"+"00");
            }
        }
        
        model.addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) //MODIFIED//////////////
            {
                //System.out.println(e.getColumn()+"-"+e.getLastRow());
                //String a = model.getValueAt(e.getLastRow(), e.getColumn()).toString();
                
                String cAksi = "04";
                String uName = labelUser.getText();
                String vLocation = e.getLastRow()+"-"+e.getColumn();
                //vValue = "";
                String vValue = model.getValueAt(e.getLastRow(), e.getColumn()).toString();
                
                try
                {
                    String func = vValue.substring(0, Math.min(vValue.length(), 3));
                    //System.out.println(func);
                    if (func.equals("AVG"))
                    {
                        String temp = vValue.substring(3);
                        String[] cell = temp.split(",");
                        //System.out.println(cell[0]);
                        //System.out.println(cell[1]);
                        double val = 0;
                        for(int i = 0; i < cell.length; i++)
                        {
                            System.out.println(cell[i]);
                            String[] tempCell = cell[i].split(":");
                            int row = Integer.parseInt(tempCell[0]);
                            int col = Integer.parseInt(tempCell[1]);
                            try
                            {
                                double avg = 0;
                                val = (Double.parseDouble(model.getValueAt(row, col).toString()) + val);
                                avg = val/cell.length;
                                vValue = String.valueOf(avg);
                                int crow = e.getLastRow();
                                int ccol = e.getColumn();
                                //model.setValueAt(avg, crow, ccol);
                                //System.out.println(avg);
                            }
                            catch(Exception ex1)
                            {
                                System.out.println("bukan angka");
                            }
                            
                        }
                    }
                    
                    if (func.equals("SUM"))
                    {
                        String temp = vValue.substring(3);
                        String[] cell = temp.split(",");
                        //System.out.println(cell[0]);
                        //System.out.println(cell[1]);
                        double val = 0;
                        for(int i = 0; i < cell.length; i++)
                        {
                            System.out.println(cell[i]);
                            String[] tempCell = cell[i].split(":");
                            int row = Integer.parseInt(tempCell[0]);
                            int col = Integer.parseInt(tempCell[1]);
                            try
                            {
                                //double avg = 0;
                                val = (Double.parseDouble(model.getValueAt(row, col).toString()) + val);
                                vValue = String.valueOf(val);
                                //avg = val/cell.length;
                                int crow = e.getLastRow();
                                int ccol = e.getColumn();
                                //model.setValueAt(val, crow, ccol);
                                //System.out.println(val);
                            }
                            catch(Exception ex1)
                            {
                                System.out.println("bukan angka");
                            }
                            
                        }
                    }
                    
                    if (func.equals("MIN"))
                    {
                        String temp = vValue.substring(3);
                        String[] cell = temp.split(",");
                        //System.out.println(cell[0]);
                        //System.out.println(cell[1]);
                        double val = 0;
                        ArrayList data = new ArrayList();
                        for(int i = 0; i < cell.length; i++)
                        {
                            System.out.println(cell[i]);
                            String[] tempCell = cell[i].split(":");
                            int row = Integer.parseInt(tempCell[0]);
                            int col = Integer.parseInt(tempCell[1]);
                            try
                            {
                                val = (Double.parseDouble(model.getValueAt(row, col).toString()));
                                data.add(new Double(val));
                                Object minim = Collections.min(data);
                                int crow = e.getLastRow();
                                int ccol = e.getColumn();
                                vValue = String.valueOf(minim);
                                //model.setValueAt(val, crow, ccol);
                                //System.out.println(val);
                            }
                            catch(Exception ex2)
                            {
                                System.out.println("bukan angka");
                            }         
                        }
                    }
                }
                catch (Exception ex)
                {
                    System.out.println(ex);
                }
                //System.out.println(vValue);
                //c = new Client();
                //String FinalValue = model.getValueAt(e.getLastRow(), e.getColumn()).toString();
                if (vValue.equals(""))
                {
                    System.out.println("000");
                    vValue = " ";
                }
                c.sendMsg(cAksi+"/"+uName+"/"+vLocation+"/"+vValue);
            }
        });        
    }
    //METHOD
    
    public void setEnabled(boolean cmd)
    {
        txtAreaOnline.setEnabled(cmd);
        txtChat.setEnabled(cmd);
        txtAreaChat.setEnabled(cmd);
        btnClose.setEnabled(cmd);
        btnSend.setEnabled(cmd);
        btnPDF.setEnabled(cmd);
        tblWorking.setEnabled(cmd);
        btnProfile.setEnabled(cmd);
        btnLog.setEnabled(cmd);
    }

    
    public void getDataReg(String xName,String xPwd)
    {
        String cAksi = "06";
        String tmpName = xName;
        String tmpPWD = xPwd;
        
        c.sendMsg(cAksi+"/"+tmpName+"/"+tmpPWD+"/"+"REG");
    
    }
    public void getDataProfile(String xName,String xPwd)
    {
        String cAksi = "07";
        String tmpName = xName;
        String tmpPWD = xPwd;
        
        c.sendMsg(cAksi+"/"+tmpName+"/"+tmpPWD+"/"+"PROF");
    
    }

    public void uiControl(String cmd) // MODIFIED///////////////////////////////
    {
        String value = cmd;
        String[] split = value.split("/");
        if(split[0].equals("01"))//LOGIN
        {
            
            if(split[3].equalsIgnoreCase("OK"))
            {
                setEnabled(true);
                txtUsername.setEnabled(false);
                txtPass.setEnabled(false);
                btnLogin.setEnabled(false);
                btnCreate.setEnabled(false);
                labelUser.setText(split[1]);//GET USERNAME
                
            }
            else if(split[3].equalsIgnoreCase("ERR"))
            {
                JOptionPane.showMessageDialog(this, "USERNAME or PWD INVALID");
            
            }
            else if(split[3].equalsIgnoreCase("NOTIF")) //DEVELOP NOTIF
            {
                JOptionPane.showMessageDialog(this, split[1] + " is ONLINE");
                c.sendMsg("09"+"/"+split[1]);
            
            }

        }
        else if(split[0].equals("02"))//LISTUSER
        {
            if(split[3].equalsIgnoreCase("RES"))
            {
                txtAreaOnline.setText("");
            }
            else if(split[3].equalsIgnoreCase("OL"))
            {
                txtAreaOnline.append(split[1]+"\n");
            }


            System.out.println("USR ONLINE");
        
        }
        else if(split[0].equals("03"))//CHAT
        {
            txtAreaChat.append(split[1] + " : " + split[2]+"\n");
        }
        else if(split[0].equals("04"))//UPDATE SPREADSHEET
        {
            //GET LOCATION
            String[] tmpSplit = split[2].split("-");
            int row = Integer.parseInt(tmpSplit[0]);
            int column = Integer.parseInt(tmpSplit[1]);
            String val = split[3]; // GET VALUE
            String oldVal = model.getValueAt(row, column).toString();
            if(val.equals(oldVal))
            {
                
            }
            else
            {
                //model = (DefaultTableModel)tblWorking.getModel();
                model.setValueAt(val, row, column); //SET VALUE TO TABLE
                System.out.println("");
            }
            
        
        }
        else if(split[0].equals("05"))//SET TABLE
        {
            String[] loc = split[1].split("-");
            System.out.println(split[1]);
            int row = Integer.parseInt(loc[0]);
            int col = Integer.parseInt(loc[1]);
            model.setValueAt(split[2], col, row);
        }
        
        else if(split[0].equals("08"))//FIND USER
        {
            profileForm pFORM = new profileForm(this);
            pFORM.setVisible(true);
            
            pFORM.lblUsername.setText(split[1]);
            pFORM.txtPWD.setText(split[2]);
            pFORM.txtPWD1.setText(split[2]);
        }
        
        else if(split[0].equals("09"))//ADD TO USER ONLINE
        {
            System.out.println(split[0]);
            System.out.println(split[1]);
            txtAreaOnline.append(split[1]+"/n");
            //txtAreaOnline.append("XXXXXX"+"/n");
        }
        else if(split[0].equals("10"))//ADD DATA TO LOG
        {
            
            if(split[3].equals("RES"))
            {
                lform.txtAreaLog.setText("");
            }
            else
            {
                lform.txtAreaLog.append(split[1]+"-"+split[2]+"-"+split[3]+"\n");
            }

        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaChat = new javax.swing.JTextArea();
        btnClose = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaOnline = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblWorking = new javax.swing.JTable();
        txtPass = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Online");

        txtAreaChat.setColumns(20);
        txtAreaChat.setRows(5);
        jScrollPane1.setViewportView(txtAreaChat);

        btnClose.setText("LOGOUT");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        txtAreaOnline.setColumns(20);
        txtAreaOnline.setRows(5);
        jScrollPane2.setViewportView(txtAreaOnline);

        btnSend.setText("SEND");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnProfile.setText("PROFIL SAYA");
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnPDF.setText("SIMPAN PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        tblWorking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "J", "K", "L"
            }
        ));
        jScrollPane3.setViewportView(tblWorking);

        btnLogin.setText("LOGIN");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Hello,");

        labelUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelUser.setText("user");

        btnCreate.setText("REGISTER");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel4.setText("Chat Room : ");

        btnLog.setText("VIEW LOG");
        btnLog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSend))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCreate))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLog)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(144, 144, 144)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelUser)
                        .addGap(127, 127, 127))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSend, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProfile)
                            .addComponent(btnPDF)
                            .addComponent(btnLog))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClose))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCreate)))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLogin))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelUser))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed

        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page 1");
        try
        {
            tblWorking.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch(PrinterException e)
        {
            System.out.println("ERROR PRINTING TO FILE");
        }
    }//GEN-LAST:event_btnPDFActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        String cAksi= "03";
        String uName = labelUser.getText();
        String uMsg = txtChat.getText();
        c.sendMsg(cAksi+"/"+uName+"/"+uMsg+"/"+"00");
        txtChat.setText("");
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        String cAksi = "01";
        String user = txtUsername.getText();
        String pass = txtPass.getText();
        c.sendMsg(cAksi+"/"+user+"/"+pass+"/"+"LOGIN");
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //setEnabled(false);
        c.sendMsg("END");
        System.exit(1);
    }//GEN-LAST:event_btnCloseActionPerformed

    
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:        
        registerForm regForm = new registerForm(this);
        regForm.setVisible(true); 
        

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        // TODO add your handling code here:
        String cAksi = "08";
        String user = labelUser.getText();
        
        c.sendMsg(cAksi+"/"+user+"/"+"00"+"/"+"REQ");
    }//GEN-LAST:event_btnProfileActionPerformed
    logForm lform = new logForm(this);
    private void btnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogActionPerformed
        // TODO add your handling code here:
        String cAksi = "10";
        
        c.sendMsg(cAksi+"/"+"00"+"/"+"00"+"/"+"LOG");
        
        //logForm lform = new logForm(this);
        lform.setVisible(true);
    }//GEN-LAST:event_btnLogActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new clientForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(clientForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnLog;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelUser;
    private javax.swing.JTable tblWorking;
    private javax.swing.JTextArea txtAreaChat;
    private javax.swing.JTextArea txtAreaOnline;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

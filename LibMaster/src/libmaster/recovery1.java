package libmaster;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

 



public class recovery1 extends javax.swing.JFrame {

   public String email;
   Connection con;
   Statement S;
   PreparedStatement pst;
   ResultSet R;
   public int code;
    
   
   
   public recovery1() 
   {
        initComponents();
        email=new String();
        this.setTitle("Mailer");
        
         try {
              
             String host ="jdbc:oracle:thin:@localhost:1521:orcl";
             String Name="Eng_Dania";
             String password="123456";
             con = DriverManager.getConnection(host, Name, password);
             S=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                   
           }
        catch(SQLException e)
          { 
            System.out.println(e);
          }
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 64, 32));
        jLabel1.setText("Reset Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 64, 32));
        jLabel2.setText("What's your email,or username?");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(96, 64, 32));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Send");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       email=String.valueOf( jTextField1.getText());
       String m=new String();     
       
    try 
    {
        R=S.executeQuery("Select * from USER_ where EMAIL='"+email+"'");
        Random ran = new Random();
        int code = ran.nextInt(10000) + 5;
        
       while(R.next())
       {
           if(String.valueOf(R.getString(1)).equals(String.valueOf(email)))
           {
              m="Dear "+R.getString(2)+"\n"+"It appears that you are having difficulty remembering your password.\n" +
                "This code will help you to reset your password:"+"\n" +code+"\n" +"If you want to change it, you can do so through your page on the site"+"\n"+"We thank you for writing to us\n" +
                "Have a nice day";
         
        Properties props=new Properties();
        props.put("mail.smtp.user","username"); 
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "25"); 
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.starttls.enable","true"); 
        props.put("mail.smtp.EnableSSL.enable","true");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
        props.setProperty("mail.smtp.socketFactory.fallback", "false");   
        props.setProperty("mail.smtp.port", "465");   
        props.setProperty("mail.smtp.socketFactory.port", "465"); 
        
        String myAcc="libmastersystem2021@gmail.com";
        String myPass="jxszmhwmsezmlblf";
        
        Session session = Session.getDefaultInstance(props,  
           new javax.mail.Authenticator()
           {  
               protected PasswordAuthentication getPasswordAuthentication()
               {  
                 return new PasswordAuthentication(myAcc,myPass);  
               }  
           });  
       
        
         try
         {  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(myAcc));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
            message.setSubject("javatpoint");  
            message.setText(m);  
            Transport transport = session.getTransport("smtp"); 
            transport.connect("smtp.gmail.com", myAcc, myPass);
            Transport.send(message);  
            transport.close();
  
           JOptionPane.showMessageDialog(recovery1.this,"message sent successfully...");  
           recovery2 r2=new recovery2(email,code);
           r2.setVisible(true);
           this.setVisible(false);
   
       }
      catch (MessagingException e) 
       {
         e.printStackTrace();
       }    
       }
       
      else JOptionPane.showMessageDialog(null,"Gmail is incorrect.");
       }
    } 
    catch (SQLException ex) 
    {
        ex.printStackTrace();
    }
    
    
   
        
       
    }//GEN-LAST:event_jButton1MouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

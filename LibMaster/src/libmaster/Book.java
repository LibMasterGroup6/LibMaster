package libmaster;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Mn
 */
public class Book extends javax.swing.JFrame {

    Connection con;
    Statement S;
    PreparedStatement pst;
    ResultSet R;
    ArrayList <String>data;
    String email;
    int admin;
    ArrayList <String>B;
    
    public Book(String email, int admin) {
        initComponents();
        this.email=email;
        this.admin=admin;
        data=new ArrayList <String>();
        DefaultTableModel ds;
        ds=(DefaultTableModel) jTable1.getModel();
        B=new ArrayList <String>();
        B.add("   ");
        
        if(admin==1)
        {
            update.setVisible(true);
            update1.setVisible(true);
            update2.setVisible(true);
            
            
        }
             
        else 
        {
            update.setVisible(false);
            update1.setVisible(false);
            update2.setVisible(false);
        }
        
        
         try 
         {
              String host ="jdbc:oracle:thin:@localhost:1521:orcl";
              String Name="Eng_Dania";
              String password="123456";
              con = DriverManager.getConnection(host, Name, password);
              con = DriverManager.getConnection(host, Name, password);
              S=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
              
              
               R=S.executeQuery("Select * From Book");
               while(R.next())
               {
                 
                    data.add(R.getString(1));
                    data.add(R.getString(2));
                    data.add(R.getString(3));
                    data.add(R.getString(4));
                    data.add(R.getString(5));
                    data.add(R.getString(6));
                    data.add(R.getString(7));                    
                    ds.addRow(data.toArray());
                    B.add(R.getString(1));

                    data.clear();
               }
         
         }
        catch(SQLException e)
          { 
            System.out.println(e);
          } 
       
         for(int i=0;i<B.size();i++)
             books.addItem(B.get(i));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        books = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        update1 = new javax.swing.JLabel();
        update2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(217, 177, 140));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(96, 62, 32));
        jButton1.setText("Buy Book");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(96, 62, 32));
        jButton2.setText("Borrow Book");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Name", "ID", "Auther", "Publisher", "Year Of Release", "Type"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel3);

        books.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel1.setIcon(new ImageIcon("p2.PNG"));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("NSimSun", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(136, 113, 112));
        jLabel4.setText("Today a reader, tomorrow a leader");

        jLabel5.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        jLabel5.setText("Sign out");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        jLabel6.setText("Search");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        jLabel7.setText("Profile");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        update.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        update.setText("Update Books");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });

        update1.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        update1.setText("Orders");
        update1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update1MouseClicked(evt);
            }
        });

        update2.setFont(new java.awt.Font("Javanese Text", 0, 16)); // NOI18N
        update2.setText("Loaned");
        update2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update2)
                .addGap(36, 36, 36)
                .addComponent(update1)
                .addGap(29, 29, 29)
                .addComponent(update)
                .addGap(32, 32, 32)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(update)
                    .addComponent(update1)
                    .addComponent(update2)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        login_Fr l =new login_Fr();
        l.setVisible(true);
        email="";
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        search s=new search(email);
        s.setAdmin(admin);
        s.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        bookadmin ba=new bookadmin(email);
        ba.setAdmin(admin);
        ba.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_updateMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Edit_info ed=new Edit_info(email);
        ed.setAdmin(admin);
        ed.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try 
        {
            String SQL="Select * From User_";
            R=S.executeQuery(SQL);
                
            
            while(R.next())
            {
                if(email.equals(R.getString(1))&&R.getInt(5)==0)
                {
                    subscribe s=new subscribe(email);
                    s.setVisible(true);
                    s.setAdmin(R.getInt(3));
                    this.setVisible(false);
                    break;  
                } 
                
                if(email.equals(R.getString(1))&&R.getInt(5)==1)
                {
                    String bn=String.valueOf(books.getSelectedItem());
                    if(checkAvi(bn))
                    {
                        pst=con.prepareStatement("UPDATE  Book SET Avilable='0' Where Bookname='"+bn+"'");
                        pst.executeUpdate();
                        updateLoaned(email,bn);
                        JOptionPane.showMessageDialog(Book.this,"Done");  
                    }
                    
                    else 
                        JOptionPane.showMessageDialog(Book.this,"Sorry, the book is not available");  
                    
                    break;
                    
                }
                
               
            }
              
              
        }
    catch (SQLException ex) 
    {
        ex.printStackTrace();
    }
           
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        String bn=String.valueOf(books.getSelectedItem());
        updateOrders(email,bn);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void update1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update1MouseClicked
        Orders o =new Orders(email);
        o.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_update1MouseClicked

    private void update2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update2MouseClicked
        Loaned l =new Loaned(email);
        l.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_update2MouseClicked

    private void booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_booksActionPerformed

 public void updateOrders(String email,String bn)
 {
     try 
        {
            String SQL="Select * From Book";
            R=S.executeQuery(SQL);
            while(R.next())
            {
                if(bn.equals(R.getString(1)))
                {
                    pst=con.prepareStatement("INSERT INTO Orders(Email,BookName,Price) " + "VALUES(?,?,?)");
                    pst.setString(1,email);
                    pst.setString(2,bn);
                    pst.setInt(3,R.getInt(9));
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(Book.this,"Done");          
                }
            }
            
            
        }
     
      catch (SQLException ex) 
       {
          ex.printStackTrace();
       }
     
     
 }
 
 public void updateLoaned(String email,String bn)
 {
     try 
        {
            String SQL="Select * From Book";
            R=S.executeQuery(SQL);
            while(R.next())
            {
                if(bn.equals(R.getString(1)))
                {
                    pst=con.prepareStatement("INSERT INTO loaned(Email,BookName) " + "VALUES(?,?)");
                    pst.setString(1,email);
                    pst.setString(2,bn);
                    pst.executeUpdate();
            
                    
                }
            }
            
            
        }
     
      catch (SQLException ex) 
       {
          ex.printStackTrace();
       }
     
     
 }
 
 public boolean checkAvi(String bn)
 {
     boolean A=false;
     try 
        {
            String SQL="Select * From Book";
            R=S.executeQuery(SQL);
            while(R.next())
            {
                if(bn.equals(R.getString(1))&&R.getInt(8)==1)
                {
                    A=true;
                    break;
                }
                 if(bn.equals(R.getString(1))&&R.getInt(8)==1)
                 {
                      A=false;
                 }   
            }
        }
     
      catch (SQLException ex) 
       {
          ex.printStackTrace();
       }
     
     return A;
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> books;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel update;
    private javax.swing.JLabel update1;
    private javax.swing.JLabel update2;
    // End of variables declaration//GEN-END:variables
}

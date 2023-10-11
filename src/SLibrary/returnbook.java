/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTextField;




/**
 *
 * @author ASUS
 */
public final class returnbook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public returnbook() 
    {
        
        initComponents();
        Connect();
        Return_Load();
        

    }
    
    
    public class CategoryItem
    {
        int id;
        String name;
        
        public CategoryItem(int id,String name)
        {
            this.id=id;
            this.name=name;
            
        }
        
        public String toString()
        {
            return name;
            
        }
          
            
    }
    
    public class AuthorItem
    {
        int id;
        String name;
        
        public AuthorItem(int id,String name)
        {
            this.id=id;
            this.name=name;
            
        }
        
        public String toString()
        {
            return name;
            
        }
          
            
    }
    
    public class PublisherItem
    {
        int id;
        String name;
        
        public PublisherItem(int id,String name)
        {
            this.id=id;
            this.name=name;
            
        }
        
        public String toString()
        {
            return name;
            
        }
          
            
    }
    

   Connection conn;
   PreparedStatement pst;
   ResultSet rs;
   

    public void Connect()
    {
       
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/slibrary","root","");
            Logger.getLogger(returnbook.class.getName()).log(Level.INFO, "Database connection established.");
        } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, "Database connection failed.", ex);
             
            
        }
    }
    

    
    
//    
//    public void Category()
//    {
//        try {
//            pst=conn.prepareStatement("SELECT * FROM category");
//            rs=pst.executeQuery();
//            txtcategory.removeAllItems();
//            while(rs.next())
//            {
//                txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    

    
//    public void Publisher()
//    {
//        try {
//            pst=conn.prepareStatement("SELECT * FROM publisher");
//            rs=pst.executeQuery();
//            txtpublisher.removeAllItems();
//            while(rs.next())
//            {
//                txtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(lendbook.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    

    
//   public void Book_Load()
//   {
//        int c;
//       
//       try 
//           
//       {
////           // pst=conn.prepareStatement("SELECT b.id,b.bname,c.category,a.name,p.name,b.contents,b.edition FROM book b JOIN category c On b.category=c.id JOIN author a On b.author=a.id JOIN publisher p On b.publisher=p.id");
////           // pst = conn.prepareStatement("SELECT b.id, b.bname, c.category, a.name AS author_name, p.name AS publisher_name, b.contents, b.edition FROM book b JOIN category c ON b.category = c.id JOIN author a ON b.author = a.id JOIN publisher p ON b.publisher = p.id");
//////           pst = conn.prepareStatement("SELECT b.Category ID, b.bname, c.Category_Name, a.name AS author_name, p.name AS publisher_name, b.contents, b.edition FROM book b JOIN category c ON b.category = c.Category ID JOIN author a ON b.author = a.id JOIN publisher p ON b.publisher = p.id");
//////            pst=conn.prepareStatement("SELECT b.Category ID,b.bname,a.name,p.name,b.contents,b.pages,b.edition FROM book b JOIN category c ON b.category =c.Category ID JOIN author a ON b.author =a.Category ID JOIN publisher p ON b.publisher =p.Category ID");
//                pst = conn.prepareStatement("SELECT b.`Category ID`, b.bname, a.name AS author_name, p.name AS publisher_name, b.contents, b.pages, b.edition " +
//                           "FROM book b " +
//                         "JOIN category c ON b.category = c.`Category_Name` " +
//                         "JOIN author a ON b.author = a.`Category ID` " +
//                          "JOIN publisher p ON b.publisher = p.`Category ID`");
//
//                        rs=pst.executeQuery();
////            
//                        ResultSetMetaData rsd=rs.getMetaData();
//                        c = rsd.getColumnCount();
////            
//                        DefaultTableModel d= (DefaultTableModel) jTable1.getModel();
//                        d.setRowCount(0);
////            
//              while(rs.next())
//              {
//                 Vector v2 = new Vector();
//                 v2=null;
//////                for(int i=0;i<c;i++)
//////                {
////////                    v2.add(rs.getInt("Category ID"));
////////                    v2.add(rs.getString("name"));
////////                    v2.add(rs.getString("address"));
////////                    v2.add(rs.getString("phone"));
//////                    
//////         
//////                }
////////                d.addRow(v2);
//                        for(int i=0; i< c;i++)
//                        {
//                            v2.add(rs.getInt("Category ID"));
//                            v2.add(rs.getString("bname"));
//                            v2.add(rs.getString("category"));
//                            v2.add(rs.getInt("author")); // Use the correct alias for the author name
//                            v2.add(rs.getInt("publisher")); // Use the correct alias for the publisher name
//                            v2.add(rs.getString("contents"));
//                            v2.add(rs.getInt("pages"));
//                            v2.add(rs.getInt("edition"));
//                            d.addRow(v2);
//                      
//                        }
//                        
//
//                        }
//                           
//        }
//        
// 
//      catch (SQLException ex) 
//        {
//            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
//       }
//    }
    
public void Return_Load() {
    try {
//        pst = conn.prepareStatement("SELECT b.`Category ID`, b.bname, a.name AS author_name, p.name AS publisher_name, b.contents, b.pages, b.edition " +
//                   "FROM book b " +
//                   "JOIN category c ON b.category = c.`Category ID` " +
//                   "JOIN author a ON b.author = a.`Category ID` " +
//                   "JOIN publisher p ON b.publisher = p.`Category ID`");
          pst = conn.prepareStatement("SELECT *FROM returnbook");

        rs = pst.executeQuery();
        ResultSetMetaData rsd = rs.getMetaData();
        int columnCount = rsd.getColumnCount();

        DefaultTableModel d = (DefaultTableModel) jTable1.getModel();
        d.setRowCount(0);

        while (rs.next()) {
            Vector<Object> rowData = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.add(rs.getObject(i));
            }
            d.addRow(rowData);
        }
    } catch (SQLException ex) {
        Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtmname = new javax.swing.JLabel();
        txtbook = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtelp = new javax.swing.JTextField();
        txtfine = new javax.swing.JTextField();
        txtrdate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Return Book");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Member ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Member Name ");

        txtmid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmidActionPerformed(evt);
            }
        });
        txtmid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmidKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member ID", "Member Name", "Book", "Return Book", "Days Elap", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("Return Date");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Book");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtmname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtmname.setForeground(new java.awt.Color(255, 255, 255));
        txtmname.setText("jLabel7");

        txtbook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtbook.setForeground(new java.awt.Color(255, 255, 255));
        txtbook.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 51));
        jLabel9.setText("Days Elaps");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 51));
        jLabel10.setText("Fine");

        txtelp.setText("jTextField1");

        txtfine.setText("jTextField2");

        txtrdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtrdate.setForeground(new java.awt.Color(255, 255, 255));
        txtrdate.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 124, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtmid, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                            .addComponent(txtmname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtbook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtelp, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(5, 5, 5))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmname))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbook, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrdate))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 196, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtmidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmidActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String mid=txtmid.getText();
        String membername=txtmname.getText();
        String bookname=txtbook.getText();
        String returndate=txtrdate.getText();
        String elpdays=txtelp.getText();
        String fine=txtfine.getText();


    try {
       pst = conn.prepareStatement("INSERT INTO returnbook(mid, mname, bname, returndate, elp, fine) VALUES (?, ?, ?, ?, ?, ?)");
       pst.setString(1, mid);
       pst.setString(2, membername);
       pst.setString(3, bookname);
       pst.setString(4, returndate);
       pst.setString(5, elpdays);
       pst.setString(6, fine);

        int rowsAffected = pst.executeUpdate();
        pst=conn.prepareStatement("DELETE FROM lendbook WHERE memberid = ?");
        pst.setString(1,mid);
        pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Return Book Successfully!!!");
            txtmid.setText("");
            txtmname.setText("");
            txtbook.setText("");
            txtrdate.setText("");
            txtelp.setText("");
            txtfine.setText("");
//            Return_Load();
            txtmid.requestFocus();
            
        } else {
            JOptionPane.showMessageDialog(this, "Error returning Book");
        }
    } catch (SQLException ex) {
        Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        
        txtmid.setText(d1.getValueAt(selectIndex, 1).toString());
        txtmname.setText(d1.getValueAt(selectIndex, 2).toString());
        txtbook.setText(d1.getValueAt(selectIndex, 3).toString());
        txtrdate.setText(d1.getValueAt(selectIndex, 4).toString());
        txtelp.setText(d1.getValueAt(selectIndex, 5).toString());
        txtfine.setText(d1.getValueAt(selectIndex, 6).toString());
        
        
        
        jButton1.setEnabled(false);



      
        
        
        



    }//GEN-LAST:event_jTable1MouseClicked



    
    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
        
       
       
       
       
    }//GEN-LAST:event_jTable1MouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        

        
        try {
           // pst=conn.prepareStatement("INSERT INTO 'category'('Category_name','Status')values(?,?)");
            //pst = conn.prepareStatement("INSERT INTO `Category` (`Category_name`, `status`) VALUES (?, ?)");
            //pst = conn.prepareStatement("update category set Category_Name= ?, Status= ? where Category ID= ?");
            //pst = conn.prepareStatement("UPDATE author SET name = ?, phone = ? WHERE `Category_ID` = ?");
            pst = conn.prepareStatement("DELETE FROM returnbook WHERE `ID` = ?");
            pst.setInt(1, id);
            
            
            

            //int k=pst.executeUpdate();
            
            int rowsAffected=pst.executeUpdate();
            

               if(rowsAffected>0)
               {
                   JOptionPane.showMessageDialog(this, " Return Book deleted.");
                   txtmid.setText("");
           //        txtaddress.setText("");
                   txtmname.setText("");
                   txtmid.requestFocus();
                    Return_Load();
                   jButton1.setEnabled(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Error deleting Return Book");
               }

      } catch (SQLException ex) {
            Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtmidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER)
        {
            String id=txtmid.getText();
            try {
                pst = conn.prepareStatement("SELECT m.name, b.bname, l.returndate, DATEDIFF(NOW(), l.returndate) AS elap " +
                    "FROM lendbook l " +
                    "JOIN member m ON l.memberid = m.`Category ID` " +
                    "JOIN book b ON l.bookid = b.`Category ID` " +
                    "WHERE l.memberid = ?");
                pst.setString(1, id);
                rs=pst.executeQuery();

                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"Member ID not Found.");
                }
                else
                {
                    String mname=rs.getString("m.name");
                    String bname=rs.getString("b.bname");

                    txtmname.setText(mname.trim());
                    txtbook.setText(bname.trim());

                    String date=rs.getString("l.returndate");

                    txtrdate.setText(date);

                    String elp=rs.getString("elap");

                    int elaped=Integer.parseInt(elp);

                    if(elaped>0)
                    {
                        txtelp.setText(elp);
                        int fine=elaped*100;
                        txtfine.setText(String.valueOf(fine));
                     
                          

                    }
                    else
                    {
                        txtelp.setText("0");
                        txtfine.setText("0");
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(returnbook.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        
     
    }//GEN-LAST:event_txtmidKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
        
        
         String id_one=txtmid.getText();
        String member_name=txtmname.getText();
        String book_name=txtbook.getText();
        String return_date=txtrdate.getText();
        String elp_days=txtelp.getText();
        String  fine=txtfine.getText();
        
  
        
           // Check if issuedate and returndate are not null
   
        
                try {
           // pst=conn.prepareStatement("INSERT INTO 'category'('Category_name','Status')values(?,?)");
            //pst = conn.prepareStatement("INSERT INTO `Category` (`Category_name`, `status`) VALUES (?, ?)");
            //pst = conn.prepareStatement("update category set Category_Name= ?, Status= ? where Category ID= ?");
           pst = conn.prepareStatement("UPDATE returnbook SET mid = ?, mname = ?, bname = ?, returndate = ?, elp = ?, fine = ? WHERE id = ?");



//            pst.setString(1, id_one);
           // pst.setString(2,address );
            
            pst.setString(1, member_name);
            pst.setString(2, book_name);
            pst.setString(3, return_date);
            pst.setString(4, elp_days);
            pst.setString(5, fine);
            pst.setString(6, id_one);
            pst.setInt(7, id);
//            
            
            
            //int k=pst.executeUpdate();
            
            int rowsAffected=pst.executeUpdate();
            

               if(rowsAffected>0)
               {
                   JOptionPane.showMessageDialog(this, "Returning Book Table updated");
                    txtmid.setText("");
                    txtbook.setText("");
                    txtrdate.setText("");
                    txtelp.setText("");
                    txtfine.setText("");
                    txtmid.requestFocus();
                    jButton2.setEnabled(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Error updating Returning Book Table.");
               }

      } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtbook;
    private javax.swing.JTextField txtelp;
    private javax.swing.JTextField txtfine;
    private javax.swing.JTextField txtmid;
    private javax.swing.JLabel txtmname;
    private javax.swing.JLabel txtrdate;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ASUS
 */
public final class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() 
    {
        initComponents();
        Connect();
        Book_Load();
        Category();
        Author();
        Publisher();
        
       

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
            Logger.getLogger(Book.class.getName()).log(Level.INFO, "Database connection established.");
        } catch (SQLException | ClassNotFoundException ex) {
             Logger.getLogger(Book.class.getName()).log(Level.SEVERE, "Database connection failed.", ex);
             
            
        }
    }
    
    
    
    public void Category()
    {
        try {
            pst=conn.prepareStatement("SELECT * FROM category");
            rs=pst.executeQuery();
            txtcategory.removeAllItems();
            while(rs.next())
            {
                txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Author()
    {
        try {
            pst=conn.prepareStatement("SELECT * FROM author");
            rs=pst.executeQuery();
            txtauthor.removeAllItems();
            while(rs.next())
            {
                txtauthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Publisher()
    {
        try {
            pst=conn.prepareStatement("SELECT * FROM publisher");
            rs=pst.executeQuery();
            txtpublisher.removeAllItems();
            while(rs.next())
            {
                txtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    
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
    
public void Book_Load() {
    try {
//        pst = conn.prepareStatement("SELECT b.`Category ID`, b.bname, a.name AS author_name, p.name AS publisher_name, b.contents, b.pages, b.edition " +
//                   "FROM book b " +
//                   "JOIN category c ON b.category = c.`Category ID` " +
//                   "JOIN author a ON b.author = a.`Category ID` " +
//                   "JOIN publisher p ON b.publisher = p.`Category ID`");
          pst = conn.prepareStatement("SELECT b.`Category ID`,b.bname,c.`Category ID`,a.name,p.name,b.contents,b.pages,b.edition FROM book b JOIN category c ON b.category=c.`Category ID` JOIN author a ON b.author=a.`Category ID` JOIN publisher p ON b.publisher = p.`Category ID`");

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
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        txtname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtcontent = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("    Book");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText(" Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Category");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Book  Name", "Category", "Author", "Publisher", "Contents", "No of Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
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
        jLabel4.setText("Contents");

        txtcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoryActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jLabel6.setText("Author");

        txtauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtauthorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 51));
        jLabel7.setText("Number of Pages");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 51));
        jLabel8.setText("Edition");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 212, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtno, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcontent, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtpublisher, javax.swing.GroupLayout.Alignment.LEADING, 0, 254, Short.MAX_VALUE)
                                        .addComponent(txtauthor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtcategory, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtname, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txtedition, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            String bname=txtname.getText();
            CategoryItem citem= (CategoryItem) txtcategory.getSelectedItem();
            AuthorItem aitem= (AuthorItem) txtauthor.getSelectedItem();
            PublisherItem pitem= (PublisherItem) txtpublisher.getSelectedItem();
            
            String contents=txtcontent.getText();
            String pages=txtno.getText();
            String edition=txtedition.getText();

        try {
           // pst=conn.prepareStatement("INSERT INTO 'category'('Category_name','Status')values(?,?)");
            //pst = conn.prepareStatement("INSERT INTO `Category` (`Category_name`, `status`) VALUES (?, ?)");
            //pst = conn.prepareStatement("INSERT INTO `author` (`name`, `address`,'phone') VALUES (?, ?,?)");
//            pst = conn.prepareStatement("INSERT INTO `publisher` (`bname`,`category`, `author`, `publisher` ,`contents` ,`pages` ,`edition`) VALUES (?,?,?,?,?,?,?)");
             pst = conn.prepareStatement("INSERT INTO book (bname, category, author, publisher, contents, pages, edition) VALUES (?,?,?,?,?,?,?)");



            pst.setString(1, bname);
            pst.setInt(2,citem.id);
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5, contents);
            pst.setString(6, pages);
            pst.setString(7,edition);
            
            
            
            
             // int k=pst.executeUpdate();
           
            
            int rowsAffected=pst.executeUpdate();
            

               if(rowsAffected>0)
               {
                   JOptionPane.showMessageDialog(this, "Book Created");
                   
                   txtname.setText("");
                   txtcategory.setSelectedIndex(-1);
                   txtauthor.setSelectedIndex(-1);
                   txtpublisher.setSelectedIndex(-1);
                   txtcontent.setText("");
                   txtno.setText("");
                   txtedition.setText("");
 
                  
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Error creating Book");
                   
               }

      } catch (SQLException ex) 
        {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Print the stack trace for debugging purposes
        // Print the stack trace for debugging purposes
        // Print the stack trace for debugging purposes
        // Print the stack trace for debugging purposes
 
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
       
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
       
       txtname.setText(d1.getValueAt(selectIndex, 1).toString());
       txtcontent.setText(d1.getValueAt(selectIndex, 2).toString());
       txtno.setText(d1.getValueAt(selectIndex, 3).toString());
       txtedition.setText(d1.getValueAt(selectIndex, 4).toString());
        //txtaddress.setText(d1.getValueAt(selectIndex, 2).toString());
       // txtcontent.setText(d1.getValueAt(selectIndex, 3).toString());
        
        
       jButton1.setEnabled(false);
 
        

        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
        int selectIndex=jTable1.getSelectedRow();
        
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
 
        
        String name=txtname.getText();
        String contents=txtcontent.getText();
         String number = txtno.getText();
        String edition=txtedition.getText();
        
        


      //  String address=txtaddress.getText();
        
  
        
        try {
           // pst=conn.prepareStatement("INSERT INTO 'category'('Category_name','Status')values(?,?)");
            //pst = conn.prepareStatement("INSERT INTO `Category` (`Category_name`, `status`) VALUES (?, ?)");
            //pst = conn.prepareStatement("update category set Category_Name= ?, Status= ? where Category ID= ?");
            pst = conn.prepareStatement("UPDATE book SET bname = ?, contents = ?, pages = ?, edition = ? WHERE `Category ID` = ?");


            pst.setString(1, name);
            pst.setString(2, contents);
            pst.setString(3, number); 
            pst.setString(4, edition);
            pst.setInt(5, id);
 
            pst.executeUpdate();
            
      
            int rowsAffected=pst.executeUpdate();
            

               if(rowsAffected>0)
               {
                   JOptionPane.showMessageDialog(this, "Book updated");
                   txtname.setText("");
                   txtcontent.setText("");
                   txtname.requestFocus();
                   jButton2.setEnabled(true);
                   
                   
              
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Error updating Book .");
               }

      } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_jButton2ActionPerformed

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
            pst = conn.prepareStatement("DELETE FROM book WHERE `Category ID` = ?");
            pst.setInt(1, id);
            
            
            
            
            
            //int k=pst.executeUpdate();
            
            int rowsAffected=pst.executeUpdate();
            

               if(rowsAffected>0)
               {
                   JOptionPane.showMessageDialog(this, "Book deleted.");
                   txtname.setText("");
           //        txtaddress.setText("");
                   txtcontent.setText("");
                   txtname.requestFocus();
           //        Publisher_Load();
                   jButton1.setEnabled(true);
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Error creating Book");
               }

      } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoryActionPerformed

    private void txtauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtauthorActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontent;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtno;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables
}

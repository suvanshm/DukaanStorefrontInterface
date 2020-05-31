package computer.science.ia;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class AddInventory extends javax.swing.JFrame {
    
    Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null; 

    public AddInventory() {
        initComponents();
        ProdNum();
        update1();
        qadded.setText("0");
       
    }
    
    
    public void ProdNum() { 
        try{
        String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
        conn = DriverManager.getConnection(url);    
        String sql = "select max(ID) from Food";
        // String sql = "select count(*) from Food";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(); 
        while (rs.next()) {
        int y = rs.getInt(1);
        int x = y+1; 
        String xyz = Integer.toString(x);
        productid.setText(xyz);
        }
        }
         catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
            try{
                rs.close();
                pst.close();   
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
        
    }
    
    public void update1() {
        try{ 
             String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
           conn = DriverManager.getConnection(url);
            String sql = "select ID, Name, Quantity, CostPrice, SalePrice from Food";
            pst=conn.prepareStatement(sql); 
           rs=pst.executeQuery();
           inventorytable.setModel(DbUtils.resultSetToTableModel(rs));
         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
    }
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(int ID, String Name, int Quantity, int CostPrice,int SalePrice,int ProfitPerUnit) {
        String sql = "INSERT INTO Food(ID,Name,Quantity,CostPrice,SalePrice,ProfitPerUnit) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, Name);
            pstmt.setInt(3,Quantity);
            pstmt.setInt(4,CostPrice); 
            pstmt.setInt(5,SalePrice);
            pstmt.setInt(6, ProfitPerUnit);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        newbutton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        costprice = new javax.swing.JLabel();
        saleprice = new javax.swing.JLabel();
        cprice = new javax.swing.JTextField();
        sprice = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        productid = new javax.swing.JTextField();
        prodname = new javax.swing.JLabel();
        productname = new javax.swing.JTextField();
        quantavailable = new javax.swing.JLabel();
        qavailable = new javax.swing.JTextField();
        quantadded = new javax.swing.JLabel();
        clearbutton = new javax.swing.JButton();
        qadded = new javax.swing.JTextField();
        menu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventorytable = new javax.swing.JTable();
        searchstring = new javax.swing.JLabel();
        searchfield = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(150, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        newbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        newbutton.setForeground(new java.awt.Color(0, 153, 153));
        newbutton.setText("New");
        newbutton.setToolTipText("Enter New Data");
        newbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newbuttonActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        update.setForeground(new java.awt.Color(0, 153, 153));
        update.setText("Update");
        update.setToolTipText("Update Data in the Table");
        update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 153, 153));
        delete.setText("Delete");
        delete.setToolTipText("Delete Data From Table");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        costprice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        costprice.setForeground(new java.awt.Color(255, 255, 255));
        costprice.setText("Cost Price");

        saleprice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        saleprice.setForeground(new java.awt.Color(255, 255, 255));
        saleprice.setText("Sale Price");

        cprice.setBackground(new java.awt.Color(0, 153, 153));
        cprice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        cprice.setForeground(new java.awt.Color(255, 255, 255));
        cprice.setBorder(null);

        sprice.setBackground(new java.awt.Color(0, 153, 153));
        sprice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        sprice.setForeground(new java.awt.Color(255, 255, 255));
        sprice.setBorder(null);

        title.setFont(new java.awt.Font("Futura", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Manage Inventory");

        id.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("Product ID");

        productid.setBackground(new java.awt.Color(0, 153, 153));
        productid.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        productid.setForeground(new java.awt.Color(255, 255, 255));
        productid.setBorder(null);
        productid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productidActionPerformed(evt);
            }
        });

        prodname.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        prodname.setForeground(new java.awt.Color(255, 255, 255));
        prodname.setText("Product Name");

        productname.setBackground(new java.awt.Color(0, 153, 153));
        productname.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        productname.setForeground(new java.awt.Color(255, 255, 255));
        productname.setBorder(null);
        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });

        quantavailable.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        quantavailable.setForeground(new java.awt.Color(255, 255, 255));
        quantavailable.setText("Quantity Available");

        qavailable.setBackground(new java.awt.Color(0, 153, 153));
        qavailable.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        qavailable.setForeground(new java.awt.Color(255, 255, 255));
        qavailable.setBorder(null);
        qavailable.setMinimumSize(new java.awt.Dimension(80, 26));

        quantadded.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        quantadded.setForeground(new java.awt.Color(255, 255, 255));
        quantadded.setText("Quantity Added");

        clearbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(0, 153, 153));
        clearbutton.setText("Clear Form");
        clearbutton.setToolTipText("Doesn't Delete Data, Clears Form");
        clearbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        qadded.setBackground(new java.awt.Color(0, 153, 153));
        qadded.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        qadded.setForeground(new java.awt.Color(255, 255, 255));
        qadded.setBorder(null);

        menu.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        menu.setForeground(new java.awt.Color(0, 153, 153));
        menu.setText("Back to Main Menu");
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quantavailable)
                    .addComponent(prodname)
                    .addComponent(id)
                    .addComponent(quantadded)
                    .addComponent(costprice)
                    .addComponent(saleprice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(qadded, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(273, 273, 273)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cprice, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearbutton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(newbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(delete)
                        .addGap(18, 18, 18)
                        .addComponent(update)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id)
                    .addComponent(productid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodname)
                    .addComponent(productname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantavailable)
                    .addComponent(qavailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantadded)
                        .addComponent(qadded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costprice)
                    .addComponent(cprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saleprice)
                    .addComponent(sprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(newbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu)
                    .addComponent(clearbutton))
                .addGap(37, 37, 37))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        inventorytable.setFont(new java.awt.Font("Futura", 0, 13)); // NOI18N
        inventorytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        inventorytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventorytableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inventorytable);

        searchstring.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        searchstring.setForeground(new java.awt.Color(0, 153, 153));
        searchstring.setText("Search Product Details By Name:");

        searchbutton.setBackground(new java.awt.Color(0, 153, 153));
        searchbutton.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(0, 153, 153));
        searchbutton.setText("Search");
        searchbutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        searchbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(118, 118, 118))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(searchstring)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbutton)
                    .addComponent(searchstring))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1020, 561));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void productidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productidActionPerformed

    public void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
        String value1 = productid.getText();
        String value2 = productname.getText();
        String value3 = qavailable.getText();
        String value = qadded.getText();
        String value4 = cprice.getText();
        String value5 = sprice.getText();
        
        int q1 = Integer.parseInt(value); 
        int q2 = Integer.parseInt(value3);
        int cp = Integer.parseInt(value4);
        int sp = Integer.parseInt(value5);
        
        int profit = sp-cp;
        
        int qf = q1 + q2; 
        String qfinal = Integer.toString(qf); 
        String profit1 = Integer.toString(profit);
        
        String sql = "update Food set ID='"+value1+"', Name = '"+value2+"', Quantity= '"+qfinal+"', CostPrice= '"+value4+"', SalePrice='"+value5+"', ProfitPerUnit= '"+profit1+"' where ID='"+value1+"' ";
        pst=conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Updated");
        update1();
        ProdNum();
        productname.setText("");
        qavailable.setText("");
        cprice.setText("");
        sprice.setText(""); 
       qadded.setText("0");
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }finally {
            try{
                rs.close();
                pst.close();
                
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
        
        
    }//GEN-LAST:event_updateActionPerformed

    public void newbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newbuttonActionPerformed
        // TODO add your handling code here:
        AddInventory app = new AddInventory();
        String id = productid.getText();
        int ID = Integer.parseInt(id);
        String name = productname.getText(); 
        String quant1 = qavailable.getText(); 
        String quant2 = qadded.getText(); 
        String costprice = cprice.getText(); 
        int costp = Integer.parseInt(costprice);
        String sellprice = sprice.getText(); 
        int sellp = Integer.parseInt(sellprice); 
        int profit = sellp-costp; 
        int q1 = Integer.parseInt(quant1); 
        int q2 = Integer.parseInt(quant2);
        int quantity = q1 + q2;
        app.insert(ID,name,quantity,costp,sellp,profit); 
        JOptionPane.showMessageDialog(null, "Added");
        update1();
        productname.setText("");
        qavailable.setText("");
        cprice.setText("");
        sprice.setText(""); 
       qadded.setText("0");
       ProdNum();
    }//GEN-LAST:event_newbuttonActionPerformed

    public void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed

        productname.setText("");
        qavailable.setText("");
        cprice.setText("");
        sprice.setText(""); 
       qadded.setText("0");
       ProdNum();
    }//GEN-LAST:event_clearbuttonActionPerformed

    public void inventorytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventorytableMouseClicked
        // TODO add your handling code here:
        connect();
        int row = inventorytable.getSelectedRow(); 
        String click = (inventorytable.getModel().getValueAt(row, 0).toString());
        String sql = "select * from Food where ID = '"+click+"'";
        String abc = "0";
        try {
        pst=conn.prepareStatement(sql); 
        rs=pst.executeQuery();
        if(rs.next()) {
        String add1 = rs.getString("ID");
        productid.setText(add1);
        String add2 = rs.getString("Name");
        productname.setText(add2);
        String add3 = rs.getString("Quantity");
        qavailable.setText(add3);
        String add4 = rs.getString("CostPrice");
        cprice.setText(add4);
        String add5 = rs.getString("SalePrice");
        sprice.setText(add5);
        qadded.setText(abc);
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
            try{
                rs.close();
                pst.close();                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
    }//GEN-LAST:event_inventorytableMouseClicked

    public void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if (p==0) {
        connect();
        String sql = "delete from Food where ID = ?"; 
        try {
        pst=conn.prepareStatement(sql);
        pst.setString(1, productid.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        update1();
        productname.setText("");
        qavailable.setText("");
        cprice.setText("");
        sprice.setText(""); 
       qadded.setText("0");
       ProdNum();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
            try{
                rs.close();
                pst.close();                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
        }        
    }//GEN-LAST:event_deleteActionPerformed

    public void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        Menu menu = new Menu(); 
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    public void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
       try{
           String sql = "select * from Food where Name=?"; 
           pst=conn.prepareStatement(sql);
           pst.setString(1, searchfield.getText());
           rs=pst.executeQuery(); 
           if (rs.next()) {
           String add1 = rs.getString("ID");
           productid.setText(add1); 
           String add2 = rs.getString("Name");
           productname.setText(add2); 
           String add3 = rs.getString("Quantity");
           qavailable.setText(add3); 
           String add4 = rs.getString("CostPrice");
           cprice.setText(add4); 
           String add5 = rs.getString("SalePrice");
           sprice.setText(add5); 
           }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "No data found for the inputed name");
        }
       finally {
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
    }//GEN-LAST:event_searchbuttonActionPerformed

    public void productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productnameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               
        java.awt.EventQueue.invokeLater(() -> {
            new AddInventory().setVisible(true);
       });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel costprice;
    private javax.swing.JTextField cprice;
    private javax.swing.JButton delete;
    private javax.swing.JLabel id;
    private javax.swing.JTable inventorytable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton menu;
    private javax.swing.JButton newbutton;
    private javax.swing.JLabel prodname;
    private javax.swing.JTextField productid;
    private javax.swing.JTextField productname;
    private javax.swing.JTextField qadded;
    private javax.swing.JTextField qavailable;
    private javax.swing.JLabel quantadded;
    private javax.swing.JLabel quantavailable;
    private javax.swing.JLabel saleprice;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel searchstring;
    private javax.swing.JTextField sprice;
    private javax.swing.JLabel title;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

    
}



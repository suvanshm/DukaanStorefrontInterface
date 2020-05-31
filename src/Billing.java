/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.ia;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.sql.*; 
import javax.swing.table.DefaultTableModel;
import java.awt.print.*; 
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 *
 * @author Manektala
 */
public class Billing extends javax.swing.JFrame {

    Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null; 
    
    public Billing() {
        initComponents();
        ComboFill();
        discounttext.setText("0");
        BillNum();
        clock();
    }
    
    public void printComponenet(Component component){
  PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable (new Printable() {    
    public int print(Graphics pg, PageFormat pf, int pageNum){
      if (pageNum > 0){
      return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      component.paint(g2);
      return Printable.PAGE_EXISTS;
    }
  });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
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
    
    
    public void BillNum() { 
        
        try{
        String sql = "select max(BillNumber) from Bills";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(); 
        while (rs.next()) {
        int x = rs.getInt(1);
        int z = x+1; 
        String xyz = Integer.toString(z);
        numberbill.setText(xyz);
        }
        
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally{
        closerecordset();
        }
    }
    
        public void clock () 
       {
           

           Thread clock = new Thread (){

           public void run() { 
           for (;;) {
           Calendar cal = new GregorianCalendar();            
           int hour = cal.get(Calendar.HOUR);
           int minute = cal.get(Calendar.MINUTE);
           int second = cal.get(Calendar.SECOND);
           
           timelabel.setText( hour + ":" + minute + ":" + second);
           
           try{ 
           sleep(1000);
           }
           catch(Exception e) {
               JOptionPane.showMessageDialog(null, "error");
           
           }
           
           
           } 
           }
           
           
           };
           clock.start();
      
        
    }
    
    public void closerecordset () {
    
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }

        public void UpdateQuantity() {
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
          for(int i = 0; i < billtable.getRowCount(); i++){
            String idcode = (String) billtable.getValueAt(i, 0); 
            try{
          String sql = "select * from Food where ID = '"+idcode+"' ";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery(); 
           if(rs.next()) {
             try {      
         String q1 = rs.getString("Quantity");
         int Q1 = Integer.parseInt(q1);  
         String q2 = (String) model.getValueAt(i, 3); 
         int Q2 = Integer.parseInt(q2);
         int Q3 = Q1-Q2;
         String qqq = Integer.toString(Q3);
         String q4 = rs.getString("UnitsSold");
         int Q4 = Integer.parseInt(q4);
         int Q5 = Q4 + Q2; 
         String ppu = rs.getString("ProfitPerUnit"); 
         int PPU = Integer.parseInt(ppu);
         int profit = PPU * Q5;
         String qqq1 = Integer.toString(Q5);
         try{ 
         String sql2 = "update Food set Quantity='"+qqq+"', UnitsSold='"+qqq1+"' "
                 + ", Profit='"+profit+"' where ID='"+idcode+"' ";
         pst = conn.prepareStatement(sql2);
         pst.executeUpdate(); 
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         }
             }
             catch (Exception e) {
            System.out.println(e.getMessage());            
        }
             finally {
         closerecordset();
        }
           }
            }
            catch (Exception e) {
            System.out.println(e.getMessage());            
        }
             finally {
    closerecordset();
    }
          }
                   JOptionPane.showMessageDialog(null, "Inventory Updated");
    }

       /* String s = jTextField4.getText();
        System.out.println(s);
        try{
        String sql = "select * from Food where ID = '"+s+"' ";
        System.out.println(s);
       pst = conn.prepareStatement(sql);
         rs = pst.executeQuery(); 
         if(rs.next()) {
             try {
         int Q1 = rs.getInt("Quantity");
         int Q2 = Integer.parseInt(jTextField6.getText());
         int Q3 = Q1-Q2;
         String qqq = Integer.toString(Q3);
         int Q4 = rs.getInt("UnitsSold");
         int Q5 = Q4 + Q2; 
         String qqq1 = Integer.toString(Q5);
         String sql2 = "update Food set Quantity='"+qqq+"', UnitsSold='"+qqq1+"' where ID='"+s+"' ";
         pst = conn.prepareStatement(sql2);
         pst.executeUpdate(); 
         JOptionPane.showMessageDialog(null, "Inventory Updated");
             }
             catch (Exception e) {
            System.out.println(e.getMessage());            
        }
             finally {
    closerecordset();
    }
         }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());            
        }
        finally {
    closerecordset();
    }
        
*/


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jPopupMenu4 = new javax.swing.JPopupMenu();
        jPopupMenu5 = new javax.swing.JPopupMenu();
        jPopupMenu6 = new javax.swing.JPopupMenu();
        jPopupMenu7 = new javax.swing.JPopupMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        prodid = new javax.swing.JLabel();
        prodname = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        customername = new javax.swing.JLabel();
        billnumber = new javax.swing.JLabel();
        quant = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        numberbill = new javax.swing.JTextField();
        namecustomer = new javax.swing.JTextField();
        idproduct = new javax.swing.JTextField();
        discounttext = new javax.swing.JTextField();
        quantitytext = new javax.swing.JTextField();
        amount = new javax.swing.JLabel();
        pricetext = new javax.swing.JTextField();
        amounttext = new javax.swing.JTextField();
        nameproduct = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        deletebutton = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        clearallbutton = new javax.swing.JButton();
        calcbutton = new javax.swing.JButton();
        clearbutton = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        invoicetitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billtable = new javax.swing.JTable();
        grandtotal = new javax.swing.JLabel();
        totallabel = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        timelabel = new javax.swing.JLabel();
        rupeesign = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        registerinvoice = new javax.swing.JButton();
        printinvoice = new javax.swing.JButton();
        menubutton = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(150, 300));
        setPreferredSize(new java.awt.Dimension(975, 635));

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N

        jLabel14.setToolTipText("");
        jLabel14.setMaximumSize(new java.awt.Dimension(53, 16));
        jLabel14.setMinimumSize(new java.awt.Dimension(53, 16));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        prodid.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        prodid.setForeground(new java.awt.Color(255, 255, 255));
        prodid.setText("Product ID");

        prodname.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        prodname.setForeground(new java.awt.Color(255, 255, 255));
        prodname.setText("Product Name");

        price.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        price.setForeground(new java.awt.Color(255, 255, 255));
        price.setText("Price");

        customername.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        customername.setForeground(new java.awt.Color(255, 255, 255));
        customername.setText("Customer Name");

        billnumber.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        billnumber.setForeground(new java.awt.Color(255, 255, 255));
        billnumber.setText("Bill Number");

        quant.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        quant.setForeground(new java.awt.Color(255, 255, 255));
        quant.setText("Quantity");

        discount.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        discount.setForeground(new java.awt.Color(255, 255, 255));
        discount.setText("Discount (%)");

        numberbill.setBackground(new java.awt.Color(0, 153, 153));
        numberbill.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        numberbill.setForeground(new java.awt.Color(255, 255, 255));
        numberbill.setBorder(null);

        namecustomer.setBackground(new java.awt.Color(0, 153, 153));
        namecustomer.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        namecustomer.setForeground(new java.awt.Color(255, 255, 255));
        namecustomer.setBorder(null);

        idproduct.setBackground(new java.awt.Color(0, 153, 153));
        idproduct.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        idproduct.setForeground(new java.awt.Color(255, 255, 255));
        idproduct.setBorder(null);
        idproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idproductActionPerformed(evt);
            }
        });

        discounttext.setBackground(new java.awt.Color(0, 153, 153));
        discounttext.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        discounttext.setForeground(new java.awt.Color(255, 255, 255));
        discounttext.setBorder(null);

        quantitytext.setBackground(new java.awt.Color(0, 153, 153));
        quantitytext.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        quantitytext.setForeground(new java.awt.Color(255, 255, 255));
        quantitytext.setBorder(null);

        amount.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setText("Amount");

        pricetext.setBackground(new java.awt.Color(0, 153, 153));
        pricetext.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        pricetext.setForeground(new java.awt.Color(255, 255, 255));
        pricetext.setBorder(null);
        pricetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pricetextActionPerformed(evt);
            }
        });

        amounttext.setBackground(new java.awt.Color(0, 153, 153));
        amounttext.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        amounttext.setForeground(new java.awt.Color(255, 255, 255));
        amounttext.setBorder(null);

        nameproduct.setBackground(new java.awt.Color(255, 255, 255));
        nameproduct.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        nameproduct.setForeground(new java.awt.Color(0, 153, 153));
        nameproduct.setMaximumRowCount(20);
        nameproduct.setToolTipText("");
        nameproduct.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nameproduct.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                nameproductPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        nameproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameproductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(billnumber)
                            .addComponent(prodid)
                            .addComponent(price)
                            .addComponent(quant)
                            .addComponent(discount)
                            .addComponent(amount))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(customername)
                            .addComponent(prodname))
                        .addGap(37, 37, 37)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(namecustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberbill, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(amounttext, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                        .addComponent(discounttext, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(quantitytext, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pricetext, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idproduct, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(billnumber)
                    .addComponent(numberbill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customername, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(namecustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(prodname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(nameproduct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prodid)
                    .addComponent(idproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(pricetext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quant)
                    .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discount)
                    .addComponent(discounttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount)
                    .addComponent(amounttext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        title.setFont(new java.awt.Font("Futura", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Billing System");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        deletebutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        deletebutton.setForeground(new java.awt.Color(0, 153, 153));
        deletebutton.setText("Remove");
        deletebutton.setToolTipText("Deletes Data From Invoice Table");
        deletebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });

        updatebutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        updatebutton.setForeground(new java.awt.Color(0, 153, 153));
        updatebutton.setText("Update");
        updatebutton.setToolTipText("Updates Data in Invoice Table");
        updatebutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        clearallbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        clearallbutton.setForeground(new java.awt.Color(0, 153, 153));
        clearallbutton.setText("Clear All");
        clearallbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearallbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearallbuttonActionPerformed(evt);
            }
        });

        calcbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        calcbutton.setForeground(new java.awt.Color(0, 153, 153));
        calcbutton.setText("Calculate ");
        calcbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calcbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcbuttonActionPerformed(evt);
            }
        });

        clearbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(0, 153, 153));
        clearbutton.setText("Clear Product Info");
        clearbutton.setToolTipText("");
        clearbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        addbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        addbutton.setForeground(new java.awt.Color(0, 153, 153));
        addbutton.setText("Add");
        addbutton.setToolTipText("Adds Product To Invoice Table");
        addbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addbutton)
                        .addGap(18, 18, 18)
                        .addComponent(deletebutton)
                        .addGap(18, 18, 18)
                        .addComponent(updatebutton)
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(calcbutton)
                        .addGap(18, 18, 18)
                        .addComponent(clearbutton)
                        .addGap(18, 18, 18)
                        .addComponent(clearallbutton)
                        .addGap(81, 81, 81))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatebutton)
                    .addComponent(deletebutton)
                    .addComponent(addbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearallbutton)
                    .addComponent(clearbutton)
                    .addComponent(calcbutton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(180, 180, 180))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton3.setText("Print Invoice");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton2.setText("Register Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(back)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jButton2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(back)
                        .addComponent(jButton2))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        invoicetitle.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        invoicetitle.setForeground(new java.awt.Color(0, 153, 153));
        invoicetitle.setText("Dukaan Invoice Date");

        billtable.setFont(new java.awt.Font("Futura", 0, 13)); // NOI18N
        billtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product", "Price", "Quantity", "Discount", "Amount"
            }
        ));
        billtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billtable);

        grandtotal.setFont(new java.awt.Font("Futura", 1, 20)); // NOI18N
        grandtotal.setForeground(new java.awt.Color(0, 153, 153));
        grandtotal.setText("[Add Items To Display Total]");

        totallabel.setFont(new java.awt.Font("Futura", 1, 20)); // NOI18N
        totallabel.setForeground(new java.awt.Color(0, 153, 153));
        totallabel.setText("Grand Total:");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer/science/ia/CF1.png"))); // NOI18N

        timelabel.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        timelabel.setForeground(new java.awt.Color(0, 153, 153));
        timelabel.setText("jLabel18");

        rupeesign.setFont(new java.awt.Font("Futura", 1, 19)); // NOI18N
        rupeesign.setForeground(new java.awt.Color(0, 153, 153));
        rupeesign.setText("₹");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(image)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(invoicetitle)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(totallabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rupeesign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grandtotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timelabel)
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(image))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(invoicetitle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totallabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grandtotal)
                    .addComponent(timelabel)
                    .addComponent(rupeesign))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        registerinvoice.setBackground(new java.awt.Color(0, 153, 153));
        registerinvoice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        registerinvoice.setForeground(new java.awt.Color(0, 153, 153));
        registerinvoice.setText("Register Invoice");
        registerinvoice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        registerinvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerinvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerinvoiceActionPerformed(evt);
            }
        });

        printinvoice.setBackground(new java.awt.Color(0, 153, 153));
        printinvoice.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        printinvoice.setForeground(new java.awt.Color(0, 153, 153));
        printinvoice.setText("Print Invoice");
        printinvoice.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        printinvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        printinvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printinvoiceActionPerformed(evt);
            }
        });

        menubutton.setBackground(new java.awt.Color(0, 153, 153));
        menubutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        menubutton.setForeground(new java.awt.Color(0, 153, 153));
        menubutton.setText("Back To Main Menu");
        menubutton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        menubutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menubutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menubuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(registerinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(menubutton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printinvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(menubutton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(454, 454, 454)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1232, 1232, 1232)
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12)
                            .addGap(154, 154, 154)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1087, 1087, 1087)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(120, 120, 120)
                            .addComponent(jLabel15))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1173, 717));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      String sql = "insert into Bills (BillNumber,CustomerName,Amount,Date) values (?,?,?,?)";
       UpdateQuantity(); 
       try  { 
            pst=conn.prepareStatement(sql);
            pst.setString(1, numberbill.getText());
            pst.setString(2, namecustomer.getText());
            pst.setString(3, grandtotal.getText());
            pst.setString(4, dateChooserCombo1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Invoice Registered"); 
            amounttext.setText("");
        numberbill.setText("");
        namecustomer.setText("");
        idproduct.setText("");
        discounttext.setText("0");
        quantitytext.setText("");
        pricetext.setText("");   
        getsum(); 
        BillNum();
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
         try { 
        model.setRowCount(0);
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
       finally {
    closerecordset();
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        Menu info = new Menu();
            info.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_backActionPerformed

    public void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        if (amounttext.getText().trim().isEmpty() || numberbill.getText().trim().isEmpty()||namecustomer.getText().trim().isEmpty()||idproduct.getText().trim().isEmpty() || discounttext.getText().trim().isEmpty()||quantitytext.getText().trim().isEmpty()||pricetext.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please do not leave any field unfilled.");
          }
        else 
        {
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
        model.addRow(new Object[]{idproduct.getText(),nameproduct.getSelectedItem(),pricetext.getText(),quantitytext.getText(),discounttext.getText(),amounttext.getText()});  
        getsum();
        quantitytext.setText("");
        amounttext.setText("");
        discounttext.setText("0");
        }
    }//GEN-LAST:event_addbuttonActionPerformed

    public void getsum()
      {
          int total = 0;
          String xyz = " ";
          for(int i = 0; i < billtable.getRowCount(); i++){
        
        int Amount = Integer.parseInt(billtable.getValueAt(i, 5)+"");
        total = Amount+total;
         xyz = Integer.toString(total);
          }
          grandtotal.setText( xyz );
          
      }
    
    public void clearallbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearallbuttonActionPerformed
        amounttext.setText("");
        numberbill.setText("");
        namecustomer.setText("");
        idproduct.setText("");
        discounttext.setText("0");
        quantitytext.setText("");
        pricetext.setText("");   
        getsum(); 
        BillNum();
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
         try { 
        model.setRowCount(0);
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_clearallbuttonActionPerformed

    public void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if (p==0) {
        
                    DefaultTableModel model = (DefaultTableModel)billtable.getModel();
         try { int rr = billtable.getSelectedRow();
        model.removeRow(rr);
        quantitytext.setText("");
        amounttext.setText("");
        discounttext.setText("0");
        pricetext.setText(""); 
        idproduct.setText("");
        getsum(); 
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            
        }
         
    }//GEN-LAST:event_deletebuttonActionPerformed

    public void calcbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcbuttonActionPerformed
        if (numberbill.getText().trim().isEmpty()||namecustomer.getText().trim().isEmpty()||idproduct.getText().trim().isEmpty() ||
            discounttext.getText().trim().isEmpty()||quantitytext.getText().trim().isEmpty()||pricetext.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please do not leave any field unfilled.");
          }
        else {
        try{
        String a = discounttext.getText();
        String b = quantitytext.getText();
        String c = pricetext.getText();
        int pr = Integer.parseInt(c);
        int q = Integer.parseInt(b);
        int ds = Integer.parseInt(a);
        int amt = (pr * q);
        int dsc = 100-ds; 
        int famt = (dsc*amt)/100; 
        String finalamt = Integer.toString(famt);
        amounttext.setText(finalamt);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
    closerecordset();
    }
        }
    }//GEN-LAST:event_calcbuttonActionPerformed

    public void billtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billtableMouseClicked
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
        int rr = billtable.getSelectedRow(); 
        idproduct.setText(model.getValueAt(rr, 0).toString());
        pricetext.setText(model.getValueAt(rr, 2).toString());
        quantitytext.setText(model.getValueAt(rr, 3).toString());
        discounttext.setText(model.getValueAt(rr, 4).toString());
        amounttext.setText(model.getValueAt(rr, 5).toString());
        
    }//GEN-LAST:event_billtableMouseClicked

    public void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed
        if (amounttext.getText().trim().isEmpty() || numberbill.getText().trim().isEmpty()||namecustomer.getText().trim().isEmpty()||idproduct.getText().trim().isEmpty() || discounttext.getText().trim().isEmpty()||quantitytext.getText().trim().isEmpty()||pricetext.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Please do not leave any field unfilled.");
            
          }
        else {
        int i = billtable.getSelectedRow(); 
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
        if(i>=0) {
        model.setValueAt(idproduct.getText(), i, 0);    
        model.setValueAt(nameproduct.getSelectedItem(), i, 1);
        model.setValueAt(pricetext.getText(), i, 2);
        model.setValueAt(quantitytext.getText(), i, 3);
        model.setValueAt(discounttext.getText(), i, 4);
        model.setValueAt(amounttext.getText(), i, 5);
        getsum();
        quantitytext.setText("");
        amounttext.setText("");
        discounttext.setText("0");
        }
        else {
        JOptionPane.showMessageDialog(null, "Error");
        }
        }
           
    }//GEN-LAST:event_updatebuttonActionPerformed

    public void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        amounttext.setText("");
        idproduct.setText("");
        discounttext.setText("0");
        quantitytext.setText("");
        pricetext.setText("");
    }//GEN-LAST:event_clearbuttonActionPerformed

    public void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable ((Graphics pg, PageFormat pf, int pageNum) -> {
      if (pageNum > 0){
          return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      jPanel3.paint(g2);
      return Printable.PAGE_EXISTS;
      });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }
        
        /*     MessageFormat header = new MessageFormat("Invoice Print");
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        try{
        jTable1.print(JTable.PrintMode.NORMAL, header, footer);
        
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,e);
        }
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    public void nameproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameproductActionPerformed

    public void nameproductPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_nameproductPopupMenuWillBecomeInvisible
        String tmp = (String)nameproduct.getSelectedItem();
        String sql = "select * from Food where Name=?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("ID");
                idproduct.setText(add1);
                String add2 = rs.getString("SalePrice");
                pricetext.setText(add2);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        finally {
            closerecordset();
        }
    }//GEN-LAST:event_nameproductPopupMenuWillBecomeInvisible

    public void pricetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pricetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pricetextActionPerformed

    private void idproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idproductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idproductActionPerformed

    private void printinvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printinvoiceActionPerformed
             PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable ((Graphics pg, PageFormat pf, int pageNum) -> {
      if (pageNum > 0){
          return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      jPanel3.paint(g2);
      return Printable.PAGE_EXISTS;
      });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }
  
    }//GEN-LAST:event_printinvoiceActionPerformed

    private void registerinvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerinvoiceActionPerformed
        String sql = "insert into Bills (BillNumber,CustomerName,Amount,Date) values (?,?,?,?)";
       UpdateQuantity(); 
       try  { 
            pst=conn.prepareStatement(sql);
            pst.setString(1, numberbill.getText());
            pst.setString(2, namecustomer.getText());
            pst.setString(3, grandtotal.getText());
            pst.setString(4, dateChooserCombo1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Invoice Registered"); 
        amounttext.setText("");
        numberbill.setText("");
        namecustomer.setText("");
        idproduct.setText("");
        discounttext.setText("0");
        quantitytext.setText("");
        pricetext.setText("");   
        getsum(); 
        BillNum();
        DefaultTableModel model = (DefaultTableModel)billtable.getModel();
         try { 
        model.setRowCount(0); }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       finally {
    closerecordset();
    }
    }//GEN-LAST:event_registerinvoiceActionPerformed

    private void menubuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menubuttonActionPerformed
               Menu info = new Menu();
            info.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_menubuttonActionPerformed
 
     
    public void ComboFill() {
    try {
        String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
        conn = DriverManager.getConnection(url);
        String sql = "select * from Food";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        
        while(rs.next()) {
        String n2 = rs.getString("Name"); 
        nameproduct.addItem(n2);
        
        }
    
    }
    catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    finally {
    closerecordset();
    }
    }
    
    
    public void insert(int BillNumber, String CustomerName, int Amount) {
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField amounttext;
    private javax.swing.JButton back;
    private javax.swing.JLabel billnumber;
    private javax.swing.JTable billtable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton calcbutton;
    private javax.swing.JButton clearallbutton;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel customername;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton deletebutton;
    private javax.swing.JLabel discount;
    private javax.swing.JTextField discounttext;
    private javax.swing.JLabel grandtotal;
    private javax.swing.JTextField idproduct;
    private javax.swing.JLabel image;
    private javax.swing.JLabel invoicetitle;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JPopupMenu jPopupMenu4;
    private javax.swing.JPopupMenu jPopupMenu5;
    private javax.swing.JPopupMenu jPopupMenu6;
    private javax.swing.JPopupMenu jPopupMenu7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton menubutton;
    private javax.swing.JTextField namecustomer;
    private javax.swing.JComboBox<String> nameproduct;
    private javax.swing.JTextField numberbill;
    private javax.swing.JLabel price;
    private javax.swing.JTextField pricetext;
    private javax.swing.JButton printinvoice;
    private javax.swing.JLabel prodid;
    private javax.swing.JLabel prodname;
    private javax.swing.JLabel quant;
    private javax.swing.JTextField quantitytext;
    private javax.swing.JButton registerinvoice;
    private javax.swing.JLabel rupeesign;
    private javax.swing.JLabel timelabel;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totallabel;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables
}

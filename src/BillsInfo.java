/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.ia;


import java.sql.*;
import javax.swing.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.table.DefaultTableModel;


public class BillsInfo extends javax.swing.JFrame {

    Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null; 
    
    public BillsInfo() {
        initComponents();
                   String s = dateChooserCombo1.getText();
          // System.out.println(s);
           
    }
    
    public void cleartable () {
        DefaultTableModel model = (DefaultTableModel)billinfo.getModel();
         try { 
        model.setRowCount(0);
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        searchbillnum = new javax.swing.JButton();
        searchcustomername = new javax.swing.JButton();
        searchdate = new javax.swing.JButton();
        bnum = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        customername = new javax.swing.JTextField();
        custname = new javax.swing.JLabel();
        datesearch = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        menu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billinfo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        title.setFont(new java.awt.Font("Futura", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Bill Records");

        print.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        print.setForeground(new java.awt.Color(0, 153, 153));
        print.setText("Print Records");
        print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        clear.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 153, 153));
        clear.setText("Clear Form and Table");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        searchbillnum.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        searchbillnum.setForeground(new java.awt.Color(0, 153, 153));
        searchbillnum.setText("Search");
        searchbillnum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchbillnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbillnumActionPerformed(evt);
            }
        });

        searchcustomername.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        searchcustomername.setForeground(new java.awt.Color(0, 153, 153));
        searchcustomername.setText("Search");
        searchcustomername.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchcustomername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcustomernameActionPerformed(evt);
            }
        });

        searchdate.setFont(new java.awt.Font("Futura", 0, 14)); // NOI18N
        searchdate.setForeground(new java.awt.Color(0, 153, 153));
        searchdate.setText("Search");
        searchdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchdateActionPerformed(evt);
            }
        });

        bnum.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        bnum.setForeground(new java.awt.Color(255, 255, 255));
        bnum.setText("Search By Bill Number");

        number.setBackground(new java.awt.Color(0, 153, 153));
        number.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        number.setForeground(new java.awt.Color(255, 255, 255));
        number.setBorder(null);
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });

        customername.setBackground(new java.awt.Color(0, 153, 153));
        customername.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        customername.setForeground(new java.awt.Color(255, 255, 255));
        customername.setBorder(null);
        customername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customernameActionPerformed(evt);
            }
        });

        custname.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        custname.setForeground(new java.awt.Color(255, 255, 255));
        custname.setText("Search By Customer Name");

        datesearch.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        datesearch.setForeground(new java.awt.Color(255, 255, 255));
        datesearch.setText("Search By Date");

        dateChooserCombo1.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Lucida Grande", java.awt.Font.PLAIN, 13),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserCombo1.setAutoScroll(false);
    dateChooserCombo1.setCalendarBackground(new java.awt.Color(0, 153, 153));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(bnum)
                .addComponent(custname)
                .addComponent(datesearch))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(customername, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(number)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGap(18, 18, 18))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(searchcustomername)
                .addComponent(searchbillnum)
                .addComponent(searchdate))
            .addGap(33, 33, 33))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bnum)
                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(searchbillnum))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(custname)
                            .addGap(3, 3, 3)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(searchcustomername))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(datesearch)
                .addComponent(searchdate))
            .addGap(11, 11, 11))
    );

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap(61, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addComponent(print)
                    .addGap(18, 18, 18)
                    .addComponent(clear)
                    .addGap(141, 141, 141))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addComponent(title)
                    .addGap(266, 266, 266))))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(title)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(print)))
    );

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 300));

    jPanel3.setBackground(new java.awt.Color(0, 153, 153));

    menu.setFont(new java.awt.Font("Futura", 0, 16)); // NOI18N
    menu.setForeground(new java.awt.Color(0, 153, 153));
    menu.setText("Back to Main Menu");
    menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    menu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            menuActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap(269, Short.MAX_VALUE)
            .addComponent(menu)
            .addGap(243, 243, 243))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
            .addContainerGap(25, Short.MAX_VALUE)
            .addComponent(menu)
            .addGap(15, 15, 15))
    );

    getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 650, 700, 70));

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setMaximumSize(new java.awt.Dimension(800, 800));

    billinfo.setFont(new java.awt.Font("Futura", 0, 13)); // NOI18N
    billinfo.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "BillNumber", "CustomerName", "Amount", "Date"
        }
    ));
    jScrollPane1.setViewportView(billinfo);

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(109, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(81, 81, 81))
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addContainerGap(13, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(17, 17, 17))
    );

    getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 700, 350));

    setSize(new java.awt.Dimension(700, 738));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void customernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customernameActionPerformed

    public void searchbillnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbillnumActionPerformed
        
        try{
          String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
           conn = DriverManager.getConnection(url);
           String sql = "select * from Bills where BillNumber=?"; 
           pst=conn.prepareStatement(sql);
           pst.setString(1, number.getText());
           rs = pst.executeQuery();
           if (rs.next()) {
           String add1 = rs.getString("BillNumber");
           String add2 = rs.getString("CustomerName");
           String add3 = rs.getString("Amount");
           String add4 = rs.getString("Date");
           DefaultTableModel model = (DefaultTableModel)billinfo.getModel();
           model.addRow(new Object[]{add1,add2,add3,add4});
           
           }
           else {
               JOptionPane.showMessageDialog(null, "No results found for the inputed data");
           }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "No results found for the inputed data");
        }  
        finally{
           try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_searchbillnumActionPerformed

    public void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    public void searchcustomernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcustomernameActionPerformed
        cleartable();
        try{
          String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
           conn = DriverManager.getConnection(url);
           String sql = "select * from Bills where CustomerName=?"; 
           pst=conn.prepareStatement(sql);
           pst.setString(1, customername.getText());
           rs = pst.executeQuery();
           if (rs.next()) {
               do {String add1 = rs.getString("BillNumber");
           String add2 = rs.getString("CustomerName");
           String add3 = rs.getString("Amount");
           String add4 = rs.getString("Date");
           DefaultTableModel model = (DefaultTableModel)billinfo.getModel();
           model.addRow(new Object[]{add1,add2,add3,add4});} while (rs.next());
           }
           else {
           JOptionPane.showMessageDialog(null, "No results found for the inputed data");
           }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "No results found for the inputed data");
        } 
        finally{
           try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_searchcustomernameActionPerformed

    public void searchdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchdateActionPerformed
        
        try{
          String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
           conn = DriverManager.getConnection(url);
           String sql = "select * from Bills where Date=?"; 
           pst=conn.prepareStatement(sql);
           pst.setString(1, dateChooserCombo1.getText());
           rs = pst.executeQuery();
           if (rs.next()) {
               do{
           String add1 = rs.getString("BillNumber");
           String add2 = rs.getString("CustomerName");
           String add3 = rs.getString("Amount");
           String add4 = rs.getString("Date");
           DefaultTableModel model = (DefaultTableModel)billinfo.getModel();
           model.addRow(new Object[]{add1,add2,add3,add4});
               } while(rs.next());
           }
           else {
           JOptionPane.showMessageDialog(null, "No results found for the inputed data");
           }
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "No results found for the inputed data");
        } 
        finally{
           try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        }
    }//GEN-LAST:event_searchdateActionPerformed

    public void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        number.setText("");
        customername.setText("");
        DefaultTableModel model = (DefaultTableModel)billinfo.getModel();
         try { 
        model.setRowCount(0);
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
                 
    }//GEN-LAST:event_clearActionPerformed

    public void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        MessageFormat header = new MessageFormat("Bill Records Print");
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        try{
        billinfo.print(JTable.PrintMode.NORMAL, header, footer);
        
        }
        catch(PrinterException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_printActionPerformed

    public void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        Menu menu = new Menu(); 
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

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
            java.util.logging.Logger.getLogger(BillsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillsInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillsInfo().setVisible(true);
            }
        });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billinfo;
    private javax.swing.JLabel bnum;
    private javax.swing.JButton clear;
    private javax.swing.JLabel custname;
    private javax.swing.JTextField customername;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private javax.swing.JLabel datesearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton menu;
    private javax.swing.JTextField number;
    private javax.swing.JButton print;
    private javax.swing.JButton searchbillnum;
    private javax.swing.JButton searchcustomername;
    private javax.swing.JButton searchdate;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
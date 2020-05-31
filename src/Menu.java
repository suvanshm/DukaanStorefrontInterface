package computer.science.ia;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;



public class Menu extends javax.swing.JFrame {
    
    Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null; 

   
    public Menu() {
        initComponents();
        clock();
        setname(); 
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        exit = new javax.swing.JButton();
        slogan = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        exit1 = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        add_inventory = new javax.swing.JButton();
        billing_info = new javax.swing.JButton();
        financial_information = new javax.swing.JButton();
        billing = new javax.swing.JButton();
        volunteerinfo = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        login = new javax.swing.JLabel();
        login2 = new javax.swing.JLabel();
        login3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(280, 200));
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(685, 425));
        setUndecorated(true);
        setSize(new java.awt.Dimension(685, 425));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Futura", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("This Is");

        title.setFont(new java.awt.Font("Futura", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Dukaan.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        exit.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(0, 153, 153));
        exit.setText("Exit Program");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        slogan.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        slogan.setForeground(new java.awt.Color(255, 255, 255));
        slogan.setText("Serving For A Good Cause.");

        time.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setText("jLabel3");

        exit1.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        exit1.setForeground(new java.awt.Color(0, 153, 153));
        exit1.setText("Log Out");
        exit1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(slogan)
                .addGap(114, 114, 114)
                .addComponent(exit)
                .addGap(31, 31, 31)
                .addComponent(exit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(time)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slogan)
                    .addComponent(time)
                    .addComponent(exit)
                    .addComponent(exit1))
                .addGap(21, 21, 21))
        );

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer/science/ia/CF.png"))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        add_inventory.setBackground(new java.awt.Color(255, 255, 255));
        add_inventory.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        add_inventory.setForeground(new java.awt.Color(255, 255, 255));
        add_inventory.setText("Manage Inventory");
        add_inventory.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        add_inventory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_inventoryActionPerformed(evt);
            }
        });

        billing_info.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        billing_info.setForeground(new java.awt.Color(255, 255, 255));
        billing_info.setText("Bill Records");
        billing_info.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billing_info.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        billing_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billing_infoActionPerformed(evt);
            }
        });

        financial_information.setBackground(new java.awt.Color(255, 255, 255));
        financial_information.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        financial_information.setForeground(new java.awt.Color(255, 255, 255));
        financial_information.setText("Financial Report");
        financial_information.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        financial_information.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        financial_information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                financial_informationActionPerformed(evt);
            }
        });

        billing.setBackground(new java.awt.Color(255, 255, 255));
        billing.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        billing.setForeground(new java.awt.Color(255, 255, 255));
        billing.setText("Billing");
        billing.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        billing.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        billing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billingActionPerformed(evt);
            }
        });

        volunteerinfo.setBackground(new java.awt.Color(255, 255, 255));
        volunteerinfo.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        volunteerinfo.setForeground(new java.awt.Color(255, 255, 255));
        volunteerinfo.setText("Volunteer Info");
        volunteerinfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        volunteerinfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        volunteerinfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteerinfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(add_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(billing, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(billing_info, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(financial_information, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(volunteerinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billing, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(billing_info, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(financial_information, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volunteerinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        filler1.setForeground(new java.awt.Color(0, 153, 153));

        jSeparator1.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));

        jSeparator2.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(0, 153, 153));

        login.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        login.setForeground(new java.awt.Color(0, 153, 153));
        login.setText("Logged in as: ");

        login2.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        login2.setForeground(new java.awt.Color(0, 153, 153));
        login2.setText("jLabel7");

        login3.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        login3.setForeground(new java.awt.Color(0, 153, 153));
        login3.setText("jLabel8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(image)
                .addGap(306, 306, 306))
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(397, 397, 397)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(image)
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(login2)
                    .addComponent(login3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setSize(new java.awt.Dimension(1012, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    LoginClass login123 = new LoginClass();
    String naam = login123.nameuser;
    public void setname() {
         String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
          
        String sql = "select * from Volunteers where Username=?";
    try {
            conn = DriverManager.getConnection(url); 
           pst=conn.prepareStatement(sql);
           pst.setString(1, naam);
           rs=pst.executeQuery(); 
           if(rs.next()) {
           String add1 = rs.getString("Name");
           login2.setText(add1); 
           String add2 = rs.getString("UserType");
           login3.setText("("+add2+")"); 
           }
    }
    catch(Exception e){
            JOptionPane.showMessageDialog(null, "Username not matching in database.");
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
    
    private void volunteerinfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteerinfoActionPerformed
       
        if ("Admin".equals(login123.user)) {
        UserDetails ud = new UserDetails();
        ud.setVisible(true);
        this.dispose();
        }
        else {
             JOptionPane.showMessageDialog(null, "Volunteers not allowed.", "Invalid Login Credentials", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_volunteerinfoActionPerformed

    private void billingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billingActionPerformed
        Billing info = new Billing();
        info.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_billingActionPerformed

    private void financial_informationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_financial_informationActionPerformed
        FinancialReport fr = new FinancialReport();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_financial_informationActionPerformed

    private void billing_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billing_infoActionPerformed
        BillsInfo xyz = new BillsInfo();
        xyz.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_billing_infoActionPerformed

    private void add_inventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_inventoryActionPerformed
        AddInventory tt = new AddInventory();
        tt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_add_inventoryActionPerformed

    private void exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit1ActionPerformed
       
        login123.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exit1ActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed


    
    public void clock () 
       {
           

           Thread clock = new Thread (){
           public void run() { 
           for (;;) {
           Calendar cal = new GregorianCalendar(); 
           int date = cal.get(Calendar.DATE);
           int month = cal.get(Calendar.MONTH);
           int year = cal.get(Calendar.YEAR);
           
           int hour = cal.get(Calendar.HOUR);
           int minute = cal.get(Calendar.MINUTE);
           int second = cal.get(Calendar.SECOND);
           
           time.setText(date + "/" + month + "/" + year + "  " + hour + ":" + minute + ":" + second);
           
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
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_inventory;
    private javax.swing.JButton billing;
    private javax.swing.JButton billing_info;
    private javax.swing.JButton exit;
    private javax.swing.JButton exit1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton financial_information;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel login;
    private javax.swing.JLabel login2;
    private javax.swing.JLabel login3;
    private javax.swing.JLabel slogan;
    private javax.swing.JLabel time;
    private javax.swing.JLabel title;
    private javax.swing.JButton volunteerinfo;
    // End of variables declaration//GEN-END:variables
}

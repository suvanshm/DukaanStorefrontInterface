package computer.science.ia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginClass extends javax.swing.JFrame {

    public static String user = "x"; 
    public static String nameuser = "y";
        Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null;
    


    
    public LoginClass() {
        initComponents();
        connect();
        password.setEchoChar('•');
        
    }
 int tries = 1;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jMenu1 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        titlelabel = new javax.swing.JLabel();
        sloganlabel = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        pword = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        dblabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        showpassword = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        usrname = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        dblabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        type = new javax.swing.JLabel();
        usertype = new javax.swing.JComboBox<>();

        jLabel3.setFont(new java.awt.Font("Heiti SC", 1, 48)); // NOI18N
        jLabel3.setText("Welcome to Dukaan!");

        jMenu1.setText("jMenu1");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer/science/ia/cfinitiative (1).png"))); // NOI18N
        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(100, 350));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        titlelabel.setBackground(new java.awt.Color(255, 255, 255));
        titlelabel.setFont(new java.awt.Font("Futura", 1, 36)); // NOI18N
        titlelabel.setForeground(new java.awt.Color(0, 153, 153));
        titlelabel.setText("This is Dukaan.");

        sloganlabel.setBackground(new java.awt.Color(255, 255, 255));
        sloganlabel.setFont(new java.awt.Font("Futura", 1, 24)); // NOI18N
        sloganlabel.setForeground(new java.awt.Color(0, 153, 153));
        sloganlabel.setText("Serving For A Good Cause");

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/computer/science/ia/CF.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 700));

        username.setBackground(new java.awt.Color(0, 153, 153));
        username.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(0, 153, 153));
        LoginButton.setText("Login");
        LoginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        ClearButton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        ClearButton.setForeground(new java.awt.Color(0, 153, 153));
        ClearButton.setText("Clear");
        ClearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        exitbutton.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        exitbutton.setForeground(new java.awt.Color(0, 153, 153));
        exitbutton.setText("Exit");
        exitbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        pword.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        pword.setForeground(new java.awt.Color(255, 255, 255));
        pword.setText("Password");

        title2.setFont(new java.awt.Font("Futura", 1, 28)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Sign in here");

        dblabel.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        dblabel.setForeground(new java.awt.Color(255, 255, 255));
        dblabel.setText("Database Connection Status: ");

        showpassword.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        showpassword.setForeground(new java.awt.Color(255, 255, 255));
        showpassword.setText("Show Password");
        showpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordActionPerformed(evt);
            }
        });

        usrname.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        usrname.setForeground(new java.awt.Color(255, 255, 255));
        usrname.setText("Username");

        dblabel2.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        dblabel2.setForeground(new java.awt.Color(255, 255, 255));
        dblabel2.setText("jLabel2");

        password.setBackground(new java.awt.Color(0, 153, 153));
        password.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        password.setAlignmentX(0.0F);
        password.setAlignmentY(0.0F);
        password.setBorder(null);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        type.setFont(new java.awt.Font("Futura", 0, 24)); // NOI18N
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setText("User Type");

        usertype.setBackground(new java.awt.Color(255, 255, 255));
        usertype.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        usertype.setForeground(new java.awt.Color(0, 153, 153));
        usertype.setMaximumRowCount(20);
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Volunteer" }));
        usertype.setToolTipText("");
        usertype.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usertype.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                usertypePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        usertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(298, 298, 298))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(title2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(showpassword)
                                    .addComponent(usrname)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(pword)
                                        .addGap(169, 169, 169)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(LoginButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(ClearButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(exitbutton))
                                    .addComponent(type)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(dblabel)
                                    .addGap(129, 129, 129)))
                            .addComponent(dblabel2)
                            .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 173, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(title2)
                .addGap(28, 28, 28)
                .addComponent(type)
                .addGap(11, 11, 11)
                .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usrname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showpassword)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton)
                    .addComponent(ClearButton)
                    .addComponent(exitbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dblabel)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7))
                    .addComponent(dblabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(image)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(titlelabel)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(sloganlabel)
                                .addGap(56, 56, 56)))))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(titlelabel)
                .addGap(18, 18, 18)
                .addComponent(sloganlabel)
                .addGap(94, 94, 94)
                .addComponent(image)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1498, 1498, 1498)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(619, 619, 619))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(859, 620));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordActionPerformed
        // TODO add your handling code here:
        if(showpassword.isSelected())
        {
            password.setEchoChar((char)0);
        }
        else{
            password.setEchoChar('•');
        }
    }//GEN-LAST:event_showpasswordActionPerformed

    public void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbuttonActionPerformed

    public void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        username.setText(null);
        password.setText(null);
    }//GEN-LAST:event_ClearButtonActionPerformed

    public void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
     user = usertype.getSelectedItem().toString();
     nameuser = username.getText();
     String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
     String sql = "select * from Volunteers where Username=? and Password=? and UserType=?"; 
     try{
     String myPass=String.valueOf(password.getPassword());    
     conn = DriverManager.getConnection(url);  
     pst = conn.prepareStatement(sql); 
     pst.setString(1,username.getText());
     pst.setString(2,myPass);
     pst.setString(3,usertype.getSelectedItem().toString());
     rs = pst.executeQuery();
     if(rs.next()) {
     JOptionPane.showMessageDialog(null, "Login Successful");   
     Menu info = new Menu();
     info.setVisible(true);  
     }
     else{
     JOptionPane.showMessageDialog(null, "Incorrect. Maximum attempts: 3. You have attempted: " + tries, "Invalid Login Details", JOptionPane.ERROR_MESSAGE);
            tries=tries+1;
            username.setText(null);
            password.setText(null);
            if (tries==4) {
                JOptionPane.showMessageDialog(null, "Login Unsuccessful. You exceeded maximum attempts", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
     }
     }
      catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
      finally {
     closerecordset();
     }
     }
     
        
        
        
        /*  String pwd = password.getText();
        String uname = username.getText();
        int flag = 0;
        if ("ashok".equals(uname) && "muwci123".equals(pwd)) {
            username.setText(null);
            password.setText(null);
            JOptionPane.showMessageDialog(null, "Login Successful", "Login Success", JOptionPane.INFORMATION_MESSAGE);
            Menu info = new Menu();
            info.setVisible(true);
            this.dispose();
        } else if (username.getText()!="ashok" || password.getText()!="muwci123"){
            JOptionPane.showMessageDialog(null, "You entered the incorrect username or password. Maximum attempts: 3. You have attempted: " + tries, "Invalid Login Details", JOptionPane.ERROR_MESSAGE);
            tries++;
            username.setText(null);
            password.setText(null);

            if (tries==4) {
                JOptionPane.showMessageDialog(null, "Login Unsuccessful. You exceeded maximum attempts", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
    }//GEN-LAST:event_LoginButtonActionPerformed
    
    */
    
    
        public void closerecordset () {
    
            try{
                rs.close();
                pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
            }
    
    public void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        //  add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usertypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_usertypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypePopupMenuWillBecomeInvisible

    private void usertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypeActionPerformed

     
    public void connect() {
        Connection conn = null;
        try {
           
            String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
            conn = DriverManager.getConnection(url);
            dblabel2.setText("The program is connected to SQLite. You're good to go!");
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            dblabel2.setText("There's an error in connection. Please check database.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
   public static void main(String args[]) {
               
        java.awt.EventQueue.invokeLater(() -> {
            new LoginClass().setVisible(true);
       });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel dblabel;
    private javax.swing.JLabel dblabel2;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel pword;
    private javax.swing.JCheckBox showpassword;
    private javax.swing.JLabel sloganlabel;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel titlelabel;
    private javax.swing.JLabel type;
    public javax.swing.JTextField username;
    public javax.swing.JComboBox<String> usertype;
    private javax.swing.JLabel usrname;
    // End of variables declaration//GEN-END:variables
}

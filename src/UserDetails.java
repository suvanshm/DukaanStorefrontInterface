package computer.science.ia;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;


public class UserDetails extends javax.swing.JFrame {
    
    Connection conn=null; 
    ResultSet rs=null; 
    PreparedStatement pst=null; 

    public UserDetails() {
        initComponents();
        BillNum();
        update1();
    }
    
    public void BillNum() { 
        
        try{
        String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
        conn = DriverManager.getConnection(url);    
        String sql = "select max(ID) from Volunteers";
        // String sql = "select count(*) from Food";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery(); 
        while (rs.next()) {
        int y = rs.getInt(1);
        int x = y+1; 
        String xyz = Integer.toString(x);
        volunteerid.setText(xyz);
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
            String sql = "select * from Volunteers";
            pst=conn.prepareStatement(sql); 
           rs=pst.executeQuery();
           volunteerinfo.setModel(DbUtils.resultSetToTableModel(rs));
         
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
    
    public void insert(int ID, String Name, String Username, String Password,String UserType ,String Shift) {
        String sql = "INSERT INTO Volunteers(ID,Name,Username,Password,UserType,Shift) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, ID);
            pstmt.setString(2, Name);
            pstmt.setString(3,Username);
            pstmt.setString(4,Password); 
            pstmt.setString(5,UserType);
            pstmt.setString(6, Shift);
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
        pword = new javax.swing.JLabel();
        typeuser = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        idvolunteer = new javax.swing.JLabel();
        volunteerid = new javax.swing.JTextField();
        namevolunteer = new javax.swing.JLabel();
        volunteername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        uname = new javax.swing.JLabel();
        clear = new javax.swing.JButton();
        menu = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        shift = new javax.swing.JLabel();
        shopkeepingshift = new javax.swing.JComboBox<>();
        password = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        usertype = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        volunteerinfo = new javax.swing.JTable();
        searchlabel = new javax.swing.JLabel();
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

        pword.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        pword.setForeground(new java.awt.Color(255, 255, 255));
        pword.setText("Password");

        typeuser.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        typeuser.setForeground(new java.awt.Color(255, 255, 255));
        typeuser.setText("User Type");

        title.setFont(new java.awt.Font("Futura", 1, 28)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Student Volunteer Information");

        idvolunteer.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        idvolunteer.setForeground(new java.awt.Color(255, 255, 255));
        idvolunteer.setText("Volunteer ID");

        volunteerid.setBackground(new java.awt.Color(0, 153, 153));
        volunteerid.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        volunteerid.setForeground(new java.awt.Color(255, 255, 255));
        volunteerid.setBorder(null);
        volunteerid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteeridActionPerformed(evt);
            }
        });

        namevolunteer.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        namevolunteer.setForeground(new java.awt.Color(255, 255, 255));
        namevolunteer.setText(" Volunteer Name");

        volunteername.setBackground(new java.awt.Color(0, 153, 153));
        volunteername.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        volunteername.setForeground(new java.awt.Color(255, 255, 255));
        volunteername.setBorder(null);
        volunteername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volunteernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        username.setBackground(new java.awt.Color(0, 153, 153));
        username.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.setMinimumSize(new java.awt.Dimension(80, 26));

        uname.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        uname.setForeground(new java.awt.Color(255, 255, 255));
        uname.setText("Username");

        clear.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        clear.setForeground(new java.awt.Color(0, 153, 153));
        clear.setText("Clear Form");
        clear.setToolTipText("Doesn't Delete Data, Clears Form");
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        menu.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        menu.setForeground(new java.awt.Color(0, 153, 153));
        menu.setText("Back to Main Menu");
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        shift.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        shift.setForeground(new java.awt.Color(255, 255, 255));
        shift.setText("Shopkeeping Shift");

        shopkeepingshift.setBackground(new java.awt.Color(255, 255, 255));
        shopkeepingshift.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        shopkeepingshift.setForeground(new java.awt.Color(0, 153, 153));
        shopkeepingshift.setMaximumRowCount(20);
        shopkeepingshift.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afternoon\t", "Evening", "Night" }));
        shopkeepingshift.setToolTipText("");
        shopkeepingshift.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        shopkeepingshift.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                shopkeepingshiftPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        shopkeepingshift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shopkeepingshiftActionPerformed(evt);
            }
        });

        password.setBackground(new java.awt.Color(0, 153, 153));
        password.setFont(new java.awt.Font("Futura", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.setMinimumSize(new java.awt.Dimension(80, 26));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(title)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uname))
                            .addComponent(namevolunteer)
                            .addComponent(idvolunteer)
                            .addComponent(pword)
                            .addComponent(typeuser)
                            .addComponent(shift))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(volunteerid, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(volunteername, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(shopkeepingshift, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(273, 273, 273)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(menu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clear))
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
                    .addComponent(idvolunteer)
                    .addComponent(volunteerid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namevolunteer)
                    .addComponent(volunteername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pword)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeuser)
                    .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shift)
                    .addComponent(shopkeepingshift, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(newbutton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu)
                    .addComponent(clear))
                .addGap(37, 37, 37))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        volunteerinfo.setFont(new java.awt.Font("Futura", 0, 13)); // NOI18N
        volunteerinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        volunteerinfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volunteerinfoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(volunteerinfo);

        searchlabel.setFont(new java.awt.Font("Futura", 0, 15)); // NOI18N
        searchlabel.setForeground(new java.awt.Color(0, 153, 153));
        searchlabel.setText("Search Volunteer Details By Name:");

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
                        .addComponent(searchlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbutton)
                    .addComponent(searchlabel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(1000, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void volunteeridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteeridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volunteeridActionPerformed

    public void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        try {
        String value1 = volunteerid.getText();
        String value2 = volunteername.getText();
        String value3 = username.getText();
        String value = password.getText();
        Object Value4 = usertype.getSelectedItem();
        String value4 = Value4.toString();
        Object Value5 = shopkeepingshift.getSelectedItem();
        String value5 = Value5.toString();

        
        String sql = "update Volunteers set ID='"+value1+"', Name = '"+value2+"', Username= '"+value3+"', Password= '"+value+"', UserType='"+value4+"', Shift= '"+value5+"' where ID='"+value1+"' ";
        pst=conn.prepareStatement(sql);
        pst.execute();
        JOptionPane.showMessageDialog(null, "Updated");
        update1();
        BillNum();

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
        UserDetails app = new UserDetails();
        String id = volunteerid.getText();
        int ID = Integer.parseInt(id);
        String name = volunteername.getText(); 
        String uname = username.getText(); 
        String pword = password.getText(); 
        Object type = usertype.getSelectedItem();
        String usertype = type.toString();
        Object shifts = shopkeepingshift.getSelectedItem();
        String shift = shifts.toString();
        app.insert(ID,name,uname,pword,usertype,shift); 
        JOptionPane.showMessageDialog(null, "Added");
        update1();
        volunteername.setText("");
        username.setText("");
        password.setText("");
       BillNum();
                
    }//GEN-LAST:event_newbuttonActionPerformed

    public void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed

        volunteername.setText("");
        username.setText("");
        password.setText("");
       BillNum();
    }//GEN-LAST:event_clearActionPerformed

    public void volunteerinfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volunteerinfoMouseClicked
        // TODO add your handling code here:
        connect();
        int row = volunteerinfo.getSelectedRow(); 
        String click = (volunteerinfo.getModel().getValueAt(row, 0).toString());
        String sql = "select * from Volunteers where ID = '"+click+"'";
        String abc = "0";
        try {
        pst=conn.prepareStatement(sql); 
        rs=pst.executeQuery();
        if(rs.next()) {
        String add1 = rs.getString("ID");
        volunteerid.setText(add1);
        String add2 = rs.getString("Name");
        volunteername.setText(add2);
        String add3 = rs.getString("Username");
        username.setText(add3);
        String add4 = rs.getString("Password");
        password.setText(add4);
        String add5 = rs.getString("UserType");
        usertype.setSelectedItem(add5);
        String add6 = rs.getString("Shift");
        shopkeepingshift.setSelectedItem(add6);
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
    }//GEN-LAST:event_volunteerinfoMouseClicked

    public void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?","Delete",JOptionPane.YES_NO_OPTION);
        if (p==0) {
        
        connect();
        String sql = "delete from Volunteers where ID = ?"; 
        try {
        pst=conn.prepareStatement(sql);
        pst.setString(1, volunteerid.getText());
        pst.execute();
        JOptionPane.showMessageDialog(null, "Deleted");
        update1();
        volunteername.setText("");
        username.setText("");
        password.setText("");
       BillNum();

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
           String sql = "select * from Volunteers where Name=?"; 
           pst=conn.prepareStatement(sql);
           pst.setString(1, searchfield.getText());
           rs=pst.executeQuery(); 
           if (rs.next()) {
           String add1 = rs.getString("ID");
           volunteerid.setText(add1); 
           String add2 = rs.getString("Name");
           volunteername.setText(add2); 
           String add3 = rs.getString("Username");
           username.setText(add3); 
           String add4 = rs.getString("Password");
           password.setText(add4); 
           String add5 = rs.getString("UserType");
           usertype.setSelectedItem(add5);
           String add6 = rs.getString("Shift");
           shopkeepingshift.setSelectedItem(add6);
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

    public void volunteernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volunteernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_volunteernameActionPerformed

    private void shopkeepingshiftPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_shopkeepingshiftPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_shopkeepingshiftPopupMenuWillBecomeInvisible

    private void shopkeepingshiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shopkeepingshiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_shopkeepingshiftActionPerformed

    private void usertypePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_usertypePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypePopupMenuWillBecomeInvisible

    private void usertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
               
        java.awt.EventQueue.invokeLater(() -> {
            new UserDetails().setVisible(true);
       });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JLabel idvolunteer;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JButton menu;
    private javax.swing.JLabel namevolunteer;
    private javax.swing.JButton newbutton;
    private javax.swing.JTextField password;
    private javax.swing.JLabel pword;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchfield;
    private javax.swing.JLabel searchlabel;
    private javax.swing.JLabel shift;
    private javax.swing.JComboBox<String> shopkeepingshift;
    private javax.swing.JLabel title;
    private javax.swing.JLabel typeuser;
    private javax.swing.JLabel uname;
    private javax.swing.JButton update;
    private javax.swing.JTextField username;
    private javax.swing.JComboBox<String> usertype;
    private javax.swing.JTextField volunteerid;
    private javax.swing.JTable volunteerinfo;
    private javax.swing.JTextField volunteername;
    // End of variables declaration//GEN-END:variables

    
}



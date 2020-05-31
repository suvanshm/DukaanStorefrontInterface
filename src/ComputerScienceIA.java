package computer.science.ia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ComputerScienceIA {
    


    public static void main(String[] args) {
            splash Splash = new splash();
    LoginClass lg = new LoginClass();
    Splash.setVisible(true);
    try{
    for (int i = 0;i<=100;i++) {
    Thread.sleep(40);
    Splash.loadingnum.setText(Integer.toString(i)+"%");
    Splash.loadingbar.setValue(i);
    if(i==100){
    lg.setVisible(true);
    Splash.setVisible(false);
    }
    }
    }
    catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        connect();
    }
    
    public static void connect() {
        Connection conn = null;
        try {
           
            String url = "jdbc:sqlite:/Users/mac/Desktop/products.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
    
    
    
}

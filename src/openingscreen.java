/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.ia;

import javax.swing.JOptionPane;

/**
 *
 * @author Manektala
 */
public class openingscreen {
    
    
    public static void main(String[] args) {
    splash Splash = new splash();
    LoginClass lg = new LoginClass();
    Splash.setVisible(true);
    try{
    for (int i = 0;i<=100;i++) {
    Thread.sleep(40);
    Splash.loadingnum.setText("Program "+Integer.toString(i)+"% Loaded");
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
    }
}


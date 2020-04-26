/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserAccount;
import Service.AccountList;
import StudentIO.LoginIO;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.MainFrame;

public class AccountController {
    private JDialog dialog;
    private JButton btnLogin;
    private JTextField jtfUserName;
    private JPasswordField jtfPassword;
    private JLabel jlbMsg;   
    AccountList accountList = new AccountList();
    
    public AccountController(JDialog dialog, JButton btnLogin, JTextField jtfUserName, JPasswordField jtfPassword, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnLogin = btnLogin;
        this.jtfUserName = jtfUserName;
        this.jtfPassword = jtfPassword;
        this.jlbMsg = jlbMsg;
    }
    
    public void setEvent(){
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {              
                if (jtfUserName.getText().length() == 0 || jtfPassword.getText().length() == 0){
                    jlbMsg.setText("Please enter Username and Password!");
                } else {
                        if (jtfUserName.getText().equals(accountList.getDefaultUserName()) && jtfPassword.getText().equals(accountList.getDefaultPassword())){
                                dialog.dispose();
                                MainFrame frame = new MainFrame();
                                frame.setVisible(true);                    
                        } else{
                            jlbMsg.setText("Username or Password is incorrect!");
                        }
                }  
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setBackground(new Color(0,200,83));                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setBackground(new Color(255,255,255));
            }
        });
    }
}

package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLOutput;

public class Login extends JFrame implements ActionListener {

    JTextField textField1;
    JPasswordField passwordField;

    JButton loginButton;

    Login() {

        // Username Label
        JLabel label1 = new JLabel("Username");
        label1.setBounds(100, 150, 120, 30);
        label1.setFont(new Font("Serif", Font.BOLD, 20));
        label1.setForeground(new Color(212, 175, 55)); // Gold color
        add(label1);

        // Password Label
        JLabel label2 = new JLabel("Password");
        label2.setBounds(100, 220, 120, 30);
        label2.setFont(new Font("Serif", Font.BOLD, 20));
        label2.setForeground(new Color(212, 175, 55)); // Gold color
        add(label2);

        // Username Text Field
        textField1 = new JTextField();
        textField1.setBounds(230, 150, 200, 30);
        textField1.setFont(new Font("SansSerif", Font.PLAIN, 18));
        textField1.setForeground(Color.black);
        textField1.setBackground(new Color(245, 245, 245)); // Light color
        add(textField1);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setBounds(230, 220, 200, 30);
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        passwordField.setForeground(Color.black);
        passwordField.setBackground(new Color(245, 245, 245)); // Light color
        add(passwordField);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(230, 290, 200, 40);
        loginButton.setFont(new Font("Serif", Font.BOLD, 18));
        loginButton.setForeground(Color.white);
        loginButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        loginButton.addActionListener(this);
        add(loginButton);

        // Frame settings
        getContentPane().setBackground(new Color(20, 20, 20)); // Dark background
        setSize(600, 450);
        setLocation(380, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
           try{
               System.out.println("Clicked on login");
               Connectiondb con = new Connectiondb();
               String user = textField1.getText();
               String pass = passwordField.getText();

               String query = "Select * from login where username ='"+user+"' and password = '"+pass+"' ";
               ResultSet resultSet = con.statement.executeQuery(query);
               if(resultSet.next()){
                   System.out.println("Login Success");
                   new Dashboard();
                   setVisible(false);
               }
               else{
                   System.out.println("Login Failed");
                   JOptionPane.showMessageDialog(null,"Login invalid");
               }
           }
           catch(Exception ee){
               ee.printStackTrace();
           }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}

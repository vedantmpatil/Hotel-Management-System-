package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener {

    JTextField t2,t4;

    JComboBox t3,t5,t6;

    JButton b1,b2;

    Room(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label1 = new JLabel("Add Room");
        label1.setBounds(194,10,160,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,22));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(64,70,152,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Availability");
        label3.setBounds(64,110,152,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Price");
        label4.setBounds(64,150,152,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Cleaning Status");
        label5.setBounds(64,190,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JLabel label6 = new JLabel("Bed Type");
        label6.setBounds(64,230,152,22);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        t6 = new JComboBox(new String[]{"Single Bed","Double Bed"} );
        t6.setBounds(200,230,156,20);
        t6.setFont(new Font("Tahoma",Font.PLAIN,22));
        t6.setForeground(Color.white);
        t6.setBackground(new Color(16,108,115));
        panel.add(t6);

        t5 = new JComboBox(new String[]{"Cleaned","Uncleaned"} );
        t5.setBounds(200,190,156,20);
        t5.setFont(new Font("Tahoma",Font.PLAIN,22));
        t5.setForeground(Color.white);
        t5.setBackground(new Color(16,108,115));
        panel.add(t5);

        t4 = new JTextField();
        t4.setBounds(200,150,156,20);
        t4.setFont(new Font("Tahoma",Font.PLAIN,22));
        t4.setForeground(Color.white);
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        t3 = new JComboBox(new String[]{"Available","Occupied"} );
        t3.setBounds(200,110,156,20);
        t3.setFont(new Font("Tahoma",Font.PLAIN,22));
        t3.setForeground(Color.white);
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        t2 = new JTextField();
        t2.setBounds(200,70,156,20);
        t2.setFont(new Font("Tahoma",Font.PLAIN,22));
        t2.setForeground(Color.white);
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        b1 = new JButton("Add");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(64,321,111,33);
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(198,321,111,33);
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(500, 60, 300, 300);
        panel.add(IconLabel1);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == b1){
                System.out.println("Clicked on Add Button");

                Connectiondb con = new Connectiondb();

                String room = t2.getText();
                String price = t4.getText();
                String ava = (String) t3.getSelectedItem();
                String status = (String) t5.getSelectedItem();
                String type = (String) t6.getSelectedItem();

                String query = "INSERT INTO room values('"+room+"', '"+ava+"', '"+status+"','"+price+"','"+type+"') ";
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Room Added");
                setVisible(false);

            }
            if(e.getSource() == b2){
                System.out.println("Clicked on Back Button");
                new Admin();
                setVisible(false);
            }

        }
        catch(Exception eobj){
            eobj.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}

package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomFeature extends JFrame implements ActionListener {

    JTable table;

    JButton btnBack;

    RoomFeature(){


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        table = new JTable();
        table.setLayout(null);
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connectiondb con = new Connectiondb();

            String query = "SELECT * FROM room";

            ResultSet resultSet = con.statement.executeQuery(query);

            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch(Exception eobj){
            eobj.printStackTrace();
        }

        JLabel label1 = new JLabel("Availability");
        label1.setBounds(109,15,80,19);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Clean Status");
        label2.setBounds(206,15,150,19);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(310,15,80,19);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(407,15,80,19);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Room No.");
        label5.setBounds(12,15,80,19);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(600, 200, 200, 200);
        panel.add(IconLabel1);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.BLACK);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(200,500,120,30);
        btnBack.setFont(new Font("Tahoma",Font.BOLD,15));
        btnBack.addActionListener(this);
        panel.add(btnBack);

//        setUndecorated(true);
        setLocation(500,100);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(900,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            System.out.println("Clicked on Back Button");
            new Reception();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new RoomFeature();
    }
}

package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(3,45,48));
        add(panel1);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cccc.gif"));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(200, 800, Image.SCALE_DEFAULT);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundImg);
        JLabel backgroundLabel = new JLabel(backgroundScaledIcon);
        backgroundLabel.setBounds(3000, 20, 800, 800);
        panel.add(backgroundLabel);

        ImageIcon backgroundIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image backgroundImg1 = backgroundIcon1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon backgroundScaledIcon1 = new ImageIcon(backgroundImg1);
        JLabel backgroundLabel1 = new JLabel(backgroundScaledIcon1);
        backgroundLabel1.setBounds(5,480,250,250);
        panel1.add(backgroundLabel1);

        JButton btnNCF = new JButton("Check-In");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.black);
        btnNCF.setForeground(Color.white);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckIn();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnRoom = new JButton("All Rooms");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setBackground(Color.black);
        btnRoom.setForeground(Color.white);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new RoomFeature();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnAE = new JButton("All Employees");
        btnAE.setBounds(30,110,200,30);
        btnAE.setBackground(Color.black);
        btnAE.setForeground(Color.white);
        panel1.add(btnAE);
        btnAE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   new EmployeeFeature();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,150,200,30);
        btnCI.setBackground(Color.black);
        btnCI.setForeground(Color.white);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,190,200,30);
        btnMI.setBackground(Color.black);
        btnMI.setForeground(Color.white);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     new ManagerFeature();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnC0 = new JButton("Checkout");
        btnC0.setBounds(30,230,200,30);
        btnC0.setBackground(Color.black);
        btnC0.setForeground(Color.white);
        panel1.add(btnC0);
        btnC0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckOut();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnUpdate = new JButton("Update check-in details");
        btnUpdate.setBounds(30,270,200,30);
        btnUpdate.setBackground(Color.black);
        btnUpdate.setForeground(Color.white);
        panel1.add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheckIn();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnURS = new JButton("Update Room Status");
        btnURS.setBounds(30,310,200,30);
        btnURS.setBackground(Color.black);
        btnURS.setForeground(Color.white);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnPS = new JButton("Pickup Service");
        btnPS.setBounds(30,350,200,30);
        btnPS.setBackground(Color.black);
        btnPS.setForeground(Color.white);
        panel1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new PickUpFeature();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,390,200,30);
        btnSR.setBackground(Color.black);
        btnSR.setForeground(Color.white);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     new SearchRoomFeature();
                }
                catch(Exception obj){
                    obj.printStackTrace();
                }
            }
        });

        disableFocusPaintingForAllButtons(this.getContentPane());

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(1950,1090);
        setVisible(true);
    }

    // Method to disable focus painting for all buttons
    private void disableFocusPaintingForAllButtons(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFocusPainted(false);
            } else if (component instanceof Container) {
                disableFocusPaintingForAllButtons((Container) component); // Recursive call for nested containers
            }
        }
    }

    // Call this method after initializing all your buttons



    public static void main(String[] args) {
        new Reception();
    }
}

package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton add_Employee,add_Room,add_Driver,logout,back;

    Admin(){

        add_Employee = new JButton("Add Employee");
        add_Employee.setForeground(Color.BLACK);
        add_Employee.setBackground(Color.WHITE);
        add_Employee.setBounds(250,230,200,30);
        add_Employee.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Employee.addActionListener(this);
        add(add_Employee);

        add_Room = new JButton("Add Room");
        add_Room.setForeground(Color.BLACK);
        add_Room.setBackground(Color.WHITE);
        add_Room.setBounds(250,380,200,30);
        add_Room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Driver = new JButton("Add Driver");
        add_Driver.setForeground(Color.BLACK);
        add_Driver.setBackground(Color.WHITE);
        add_Driver.setBounds(250,530,200,30);
        add_Driver.setFont(new Font("Tahoma",Font.BOLD,15));
        add_Driver.addActionListener(this);
        add(add_Driver);

        logout = new JButton("Logout");
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.WHITE);
        logout.setBounds(10,750,95,30);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        back.setBounds(110,750,95,30);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(70, 180, 120, 120);
        add(IconLabel1);

        ImageIcon Icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image Iconimg2 = Icon2.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon2 = new ImageIcon(Iconimg2);
        JLabel IconLabel2 = new JLabel(ScaledIcon2);
        IconLabel2.setBounds(70, 330, 120, 120);
        add(IconLabel2);

        ImageIcon Icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image Iconimg3 = Icon3.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon3 = new ImageIcon(Iconimg3);
        JLabel IconLabel3 = new JLabel(ScaledIcon3);
        IconLabel3.setBounds(50, 470, 180, 180);
        add(IconLabel3);

        ImageIcon Icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image Iconimg4 = Icon4.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon4 = new ImageIcon(Iconimg4);
        JLabel IconLabel4 = new JLabel(ScaledIcon4);
        IconLabel4.setBounds(1000, 250, 400, 400);
        add(IconLabel4);

        // Call this method after initializing all your buttons
        disableFocusPaintingForAllButtons(this.getContentPane());

        getContentPane().setBackground(new Color(3,45,48));
        setSize(1950,1090);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try{
             if(e.getSource() == add_Employee){
                 System.out.println("Clicked on Employee Button");
                 new Employee();
             }
             else if(e.getSource() == add_Room){
                 System.out.println("Clicked on Room Button");
                 new Room();
             } else if(e.getSource() == add_Driver){
                 new Driver();
                 System.out.println("Clicked on Driver Button");
             } else if(e.getSource() == logout){
                 System.out.println("Clicked on Logout Button");
                 System.exit(102);
             } else if(e.getSource() == back){
                 System.out.println("Clicked on Back Button");
                 new Dashboard();
                 setVisible(false);
             }
         }catch(Exception eobject){
             eobject.printStackTrace();
         }
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

    public static void main(String[] args) {
        new Admin();
    }
}

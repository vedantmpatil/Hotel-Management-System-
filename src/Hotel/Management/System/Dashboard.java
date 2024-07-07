package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton admin, reception;

    Dashboard() {
        super("Hotel Management System");

        // Adding Background Image
        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image backgroundImg = backgroundIcon.getImage().getScaledInstance(1950, 1090, Image.SCALE_DEFAULT);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundImg);
        JLabel backgroundLabel = new JLabel(backgroundScaledIcon);
        backgroundLabel.setBounds(0, 0, 1950, 1090);
        add(backgroundLabel);

        // Admin Image
        ImageIcon adminIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image adminImg = adminIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT); // Tripled size
        ImageIcon adminScaledIcon = new ImageIcon(adminImg);
        JLabel adminLabel = new JLabel(adminScaledIcon);

        // Reception Image
        ImageIcon receptionIcon = new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image receptionImg = receptionIcon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT); // Tripled size
        ImageIcon receptionScaledIcon = new ImageIcon(receptionImg);
        JLabel receptionLabel = new JLabel(receptionScaledIcon);

        // Set positions for images and buttons
        adminLabel.setBounds(400, 200, 300, 300);
        backgroundLabel.add(adminLabel);

        receptionLabel.setBounds(800, 200, 300, 300);
        backgroundLabel.add(receptionLabel);

        // Admin Button
        admin = new JButton("Admin");
        admin.setBounds(450, 520, 200, 50); // Positioned below the admin image
        admin.setFont(new Font("Serif", Font.BOLD, 18));
        admin.setForeground(Color.white);
        admin.setBackground(new Color(139, 69, 19)); // Saddle brown color
        admin.addActionListener(this);
        backgroundLabel.add(admin);

        // Reception Button
        reception = new JButton("Reception");
        reception.setBounds(850, 520, 200, 50); // Positioned below the reception image
        reception.setFont(new Font("Serif", Font.BOLD, 18));
        reception.setForeground(Color.white);
        reception.setBackground(new Color(139, 69, 19)); // Saddle brown color
        reception.addActionListener(this);
        backgroundLabel.add(reception);

        // Call this method after initializing all your buttons
        disableFocusPaintingForAllButtons(this.getContentPane());

        // Frame settings
        setLayout(null);
        setSize(1950, 1090);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == admin){
                System.out.println("Clicked on Admin Button");
                new Admin();
            }
            else{
                System.out.println("Clicked on Reception Button");
                new Reception();
            }
        }catch (Exception eobj){
            eobj.printStackTrace();
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
        new Dashboard();
    }
}

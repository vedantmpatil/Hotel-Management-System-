package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    JTable table;
    JButton btnBack;

    CustomerInfo() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        table = new JTable();
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(3, 45, 48));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 40, 820, 400);
        scrollPane.setBackground(new Color(3, 45, 48));
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());  // Remove border
        scrollPane.getViewport().setBackground(new Color(3, 45, 48));
        panel.add(scrollPane);

        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT * FROM customer";
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.BLACK);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(200, 500, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBack.addActionListener(this);
        panel.add(btnBack);

        // Adding the image last to ensure it is on top
        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(650, 350, 200, 200);  // Adjusted position
        panel.add(IconLabel1);
        panel.setComponentZOrder(IconLabel1, 0);  // Set the image to be on top

        setLocation(500, 100);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(900, 600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            System.out.println("Clicked on Back Button");
            new Reception();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}

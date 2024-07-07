package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUpFeature extends JFrame implements ActionListener {

    JTable table;
    JButton btnBack, btnDisplay;
    JComboBox<String> comboBoxCarType;

    PickUpFeature() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel headerLabel = new JLabel("Pick up Service");
        headerLabel.setBounds(350, 10, 200, 30);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        panel.add(headerLabel);

        JLabel carTypeLabel = new JLabel("Type of Car Company:");
        carTypeLabel.setBounds(30, 50, 200, 30);
        carTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        carTypeLabel.setForeground(Color.WHITE);
        panel.add(carTypeLabel);

        comboBoxCarType = new JComboBox<>(new String[]{"Tata", "Hyundai", "Toyota", "Tesla", "Ford"});
        comboBoxCarType.setBounds(200, 50, 150, 30);
        panel.add(comboBoxCarType);

        table = new JTable();
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.WHITE);
        table.getTableHeader().setBackground(new Color(3, 45, 48));
        table.getTableHeader().setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 100, 820, 400);
        scrollPane.setBackground(new Color(3, 45, 48));
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());  // Remove border
        scrollPane.getViewport().setBackground(new Color(3, 45, 48));
        panel.add(scrollPane);

        btnDisplay = new JButton("Display");
        btnDisplay.setForeground(Color.BLACK);
        btnDisplay.setBackground(Color.WHITE);
        btnDisplay.setBounds(200, 520, 120, 30);
        btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnDisplay.addActionListener(this);
        panel.add(btnDisplay);

        btnBack = new JButton("Back");
        btnBack.setForeground(Color.BLACK);
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(350, 520, 120, 30);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnBack.addActionListener(this);
        panel.add(btnBack);

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
        } else if (e.getSource() == btnDisplay) {
            System.out.println("Clicked on Display Button");
            displayDrivers();
        }
    }

    private void displayDrivers() {
        String carType = (String) comboBoxCarType.getSelectedItem();

        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT * FROM driver WHERE carcompany = '" + carType + "'";
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PickUpFeature();
    }
}

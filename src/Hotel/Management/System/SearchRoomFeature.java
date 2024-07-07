package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoomFeature extends JFrame implements ActionListener {

    JTable table;
    JButton btnBack, btnSearch;
    JComboBox<String> comboBoxBedType;
    JCheckBox checkBoxAvailable;

    SearchRoomFeature() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel headerLabel = new JLabel("Search Rooms");
        headerLabel.setBounds(350, 10, 200, 30);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        panel.add(headerLabel);

        JLabel bedTypeLabel = new JLabel("Room Bed Type:");
        bedTypeLabel.setBounds(30, 50, 150, 30);
        bedTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bedTypeLabel.setForeground(Color.WHITE);
        panel.add(bedTypeLabel);

        comboBoxBedType = new JComboBox<>(new String[]{"Single Bed", "Double Bed"});
        comboBoxBedType.setBounds(150, 50, 150, 30);
        panel.add(comboBoxBedType);

        checkBoxAvailable = new JCheckBox("Show Only Available Rooms");
        checkBoxAvailable.setBounds(320, 50, 220, 30);
        checkBoxAvailable.setBackground(new Color(3, 45, 48));
        checkBoxAvailable.setForeground(Color.WHITE);
        panel.add(checkBoxAvailable);

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

        btnSearch = new JButton("Search");
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setBackground(Color.WHITE);
        btnSearch.setBounds(200, 520, 120, 30);
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSearch.addActionListener(this);
        panel.add(btnSearch);

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
        } else if (e.getSource() == btnSearch) {
            System.out.println("Clicked on Search Button");
            searchRooms();
        }
    }

    private void searchRooms() {
        String bedType = (String) comboBoxBedType.getSelectedItem();
        boolean showOnlyAvailable = checkBoxAvailable.isSelected();

        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT * FROM room WHERE bedtype = '" + bedType + "'";
            if (showOnlyAvailable) {
                query += " AND availability = 'Available'";
            }
            ResultSet resultSet = con.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SearchRoomFeature();
    }
}

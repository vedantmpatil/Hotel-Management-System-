package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateRoom extends JFrame implements ActionListener {

    JTable roomTable;
    DefaultTableModel tableModel;
    JButton btn1, btn2, btn3;

    UpdateRoom() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel headerLabel = new JLabel("Update Room Details");
        headerLabel.setBounds(350, 10, 300, 30);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        panel.add(headerLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 50, 700, 300);
        scrollPane.setBackground(new Color(3, 45, 48));
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());  // Remove border
        scrollPane.getViewport().setBackground(new Color(3, 45, 48));
        // Remove the setBackground(Color.WHITE) call for the scroll pane
        panel.add(scrollPane);

        tableModel = new DefaultTableModel();
        roomTable = new JTable(tableModel);
        tableModel.addColumn("Room Number");
        tableModel.addColumn("Bed Type");
        tableModel.addColumn("Price");
        tableModel.addColumn("Availability");
        tableModel.addColumn("Clean Status");
        scrollPane.setViewportView(roomTable);

        btn1 = new JButton("Update");
        btn1.setBounds(60, 360, 120, 30);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("Refresh");
        btn2.setBounds(220, 360, 120, 30);
        btn2.addActionListener(this);
        panel.add(btn2);

        btn3 = new JButton("Back");
        btn3.setBounds(140, 400, 120, 30);
        btn3.addActionListener(this);
        panel.add(btn3);

        setLocation(500, 140);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(3, 45, 48));
        // Remove the getContentPane().setBackground(Color.white) call
        setSize(850, 500);
        setVisible(true);

        fetchDirtyRooms();

        // Adjust the size of the scroll pane to fit the table's size
        scrollPane.setPreferredSize(new Dimension(700, roomTable.getRowHeight() * 5 + roomTable.getTableHeader().getPreferredSize().height));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            updateSelectedRoom();
        } else if (e.getSource() == btn2) {
            refreshTable();
        } else {
            new Reception();
            setVisible(false);
        }
    }

    private void fetchDirtyRooms() {
        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT * FROM room WHERE cleaningstatus IN ('Dirty', 'Uncleaned')";
            ResultSet resultSet = con.statement.executeQuery(query);
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getString("roomnumber"));
                row.add(resultSet.getString("bedtype"));
                row.add(resultSet.getString("price"));
                row.add(resultSet.getString("availability"));
                row.add(resultSet.getString("cleaningstatus"));
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateSelectedRoom() {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow != -1) {
            String roomNumber = (String) roomTable.getValueAt(selectedRow, 0);
            String availability = (String) roomTable.getValueAt(selectedRow, 3);
            String cleaningStatus = (String) roomTable.getValueAt(selectedRow, 4);

            // Update the room in the database
            try {
                Connectiondb con = new Connectiondb();
                String updateQuery = "UPDATE room SET availability = '" + availability + "', cleaningstatus = '" + cleaningStatus + "' WHERE roomnumber = '" + roomNumber + "'";
                int rowsUpdated = con.statement.executeUpdate(updateQuery);
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Room details updated successfully.");
                    refreshTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update room details.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a room to update.");
        }
    }

    private void refreshTable() {
        // Clear the table
        tableModel.setRowCount(0);
        // Fetch dirty rooms again to refresh the table
        fetchDirtyRooms();
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}

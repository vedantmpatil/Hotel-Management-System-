package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateCheckIn extends JFrame implements ActionListener {

    JLabel label1, label2, label3, label4, label5, label6;
    JComboBox<String> comboBoxId;
    JTextField t1, t2, t3, t4, t5;
    JButton btn1, btn2, btn3;

    UpdateCheckIn() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel headerLabel = new JLabel("Update Check-In Details");
        headerLabel.setBounds(350, 10, 300, 30);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE);
        panel.add(headerLabel);

        label1 = new JLabel("ID:");
        label1.setBounds(30, 50, 100, 30);
        label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        comboBoxId = new JComboBox<>();
        comboBoxId.setBounds(150, 50, 150, 30);
        panel.add(comboBoxId);
        populateComboBox();

        label2 = new JLabel("Room Number:");
        label2.setBounds(30, 90, 120, 30);
        label2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        t1 = new JTextField();
        t1.setBounds(150, 90, 150, 30);
        panel.add(t1);

        label3 = new JLabel("Name:");
        label3.setBounds(30, 130, 100, 30);
        label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        t2 = new JTextField();
        t2.setBounds(150, 130, 150, 30);
        panel.add(t2);

        label4 = new JLabel("Checked In:");
        label4.setBounds(30, 170, 100, 30);
        label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        t3 = new JTextField();
        t3.setBounds(150, 170, 150, 30);
        panel.add(t3);

        label5 = new JLabel("Amount Paid:");
        label5.setBounds(30, 210, 100, 30);
        label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        t4 = new JTextField();
        t4.setBounds(150, 210, 150, 30);
        panel.add(t4);

        label6 = new JLabel("Pending Amount:");
        label6.setBounds(30, 250, 100, 30);
        label6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        t5 = new JTextField();
        t5.setBounds(150, 250, 150, 30);
        panel.add(t5);

        btn1 = new JButton("Update");
        btn1.setBounds(60, 360, 120, 30);
        btn1.addActionListener(this);
        panel.add(btn1);

        btn2 = new JButton("Check");
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
        setSize(850, 500);
        setVisible(true);

    }


    private void populateComboBox() {
        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT idnumber FROM customer";
            ResultSet resultSet = con.statement.executeQuery(query);
            while (resultSet.next()) {
                comboBoxId.addItem(resultSet.getString("idnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == btn2){
                System.out.println("CLicked on Check Button");
                String id = (String) comboBoxId.getSelectedItem();
                Connectiondb con = new Connectiondb();
                String query = "select * from customer where idnumber = '"+id+"'";

                ResultSet resultSet = con.statement.executeQuery(query);
                while(resultSet.next()){
                    t1.setText(resultSet.getString("allocatedroom"));
                    t2.setText(resultSet.getString("name"));
                    t3.setText(resultSet.getString("checkedin"));
                    t4.setText(resultSet.getString("deposit"));
                }

                String query2 = "select * from room where roomnumber = '"+t1.getText()+"' ";

                ResultSet resultSet2 = con.statement.executeQuery(query2);
                while(resultSet2.next()){
                    String price = resultSet2.getString("price");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(t4.getText());
                    t5.setText(""+amountPaid);
                }
            }
            else if(e.getSource() == btn1){
                System.out.println("Clicked on Update Button");
                System.out.println("Clicked on Update Button");
                String id = (String) comboBoxId.getSelectedItem();
                Connectiondb con = new Connectiondb();

                // Construct the SQL query to update the customer's details
                String updateQuery = "UPDATE customer SET allocatedroom = '" + t1.getText() + "', name = '" + t2.getText() + "', " +
                        "checkedin = '" + t3.getText() + "', deposit = '" + t4.getText() + "' WHERE idnumber = '" + id + "'";


                    // Execute the update query
                    int rowsUpdated = con.statement.executeUpdate(updateQuery);
                    if (rowsUpdated > 0) {
                        System.out.println("Customer details updated successfully.");
                    } else {
                        System.out.println("Failed to update customer details.");
                    }

            }else{
                System.out.println("Clicked on Back Button");
                new Reception();
                setVisible(false);
            }
        }catch(Exception eobj){
            eobj.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new UpdateCheckIn();
    }
}

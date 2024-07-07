package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;

public class CheckIn extends JFrame implements ActionListener {

    JComboBox<String> comboBoxId;
    JTextField textFieldNumber, textFieldName, textFieldCountry, textFieldDeposit;
    JRadioButton radioButtonMale, radioButtonFemale;
    ButtonGroup genderGroup;
    JComboBox<String> comboBoxRoomNumber;
    JLabel labelCheckInDateTime;
    JButton btnSubmit, btnCancel;

    CheckIn() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel label1 = new JLabel("New Customer Form");
        label1.setBounds(118, 11, 260, 53);
        label1.setFont(new Font("Tahoma", Font.BOLD, 22));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel labelId = new JLabel("ID:");
        labelId.setBounds(35, 80, 100, 30);
        labelId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelId.setForeground(Color.white);
        panel.add(labelId);

        comboBoxId = new JComboBox<>(new String[]{"Passport", "Aadhar Card", "Voter ID", "Driving License"});
        comboBoxId.setBounds(150, 80, 150, 30);
        panel.add(comboBoxId);

        JLabel labelNumber = new JLabel("ID Number:");
        labelNumber.setBounds(35, 120, 100, 30);
        labelNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(150, 120, 150, 30);
        panel.add(textFieldNumber);

        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(35, 160, 100, 30);
        labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelName.setForeground(Color.white);
        panel.add(labelName);

        textFieldName = new JTextField();
        textFieldName.setBounds(150, 160, 150, 30);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 200, 100, 30);
        labelGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        radioButtonMale = new JRadioButton("Male");
        radioButtonMale.setBounds(150, 200, 70, 30);
        radioButtonMale.setBackground(new Color(3, 45, 48));
        radioButtonMale.setForeground(Color.white);
        panel.add(radioButtonMale);

        radioButtonFemale = new JRadioButton("Female");
        radioButtonFemale.setBounds(230, 200, 70, 30);
        radioButtonFemale.setBackground(new Color(3, 45, 48));
        radioButtonFemale.setForeground(Color.white);
        panel.add(radioButtonFemale);

        genderGroup = new ButtonGroup();
        genderGroup.add(radioButtonMale);
        genderGroup.add(radioButtonFemale);

        JLabel labelCountry = new JLabel("Country:");
        labelCountry.setBounds(35, 240, 100, 30);
        labelCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCountry.setForeground(Color.white);
        panel.add(labelCountry);

        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(150, 240, 150, 30);
        panel.add(textFieldCountry);

        JLabel labelRoomNumber = new JLabel("Allocated Room:");
        labelRoomNumber.setBounds(35, 280, 120, 30);
        labelRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelRoomNumber.setForeground(Color.white);
        panel.add(labelRoomNumber);

        comboBoxRoomNumber = new JComboBox<>();
        comboBoxRoomNumber.setBounds(150, 280, 150, 30);
        panel.add(comboBoxRoomNumber);

        populateRoomNumbers();  // Populate the room numbers from the database

        JLabel labelCheckIn = new JLabel("Checked In:");
        labelCheckIn.setBounds(35, 320, 100, 30);
        labelCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCheckIn.setForeground(Color.white);
        panel.add(labelCheckIn);

        labelCheckInDateTime = new JLabel();
        labelCheckInDateTime.setBounds(150, 320, 200, 30);
        labelCheckInDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelCheckInDateTime.setForeground(Color.white);
        panel.add(labelCheckInDateTime);

        // Set current date and time
        Date currentDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        labelCheckInDateTime.setText(dateFormatter.format(currentDate));

        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(35, 360, 100, 30);
        labelDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelDeposit.setForeground(Color.white);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(150, 360, 150, 30);
        panel.add(textFieldDeposit);

        btnSubmit = new JButton("Submit");
        btnSubmit.setForeground(Color.BLACK);
        btnSubmit.setBackground(Color.WHITE);
        btnSubmit.setBounds(60, 420, 120, 30);
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSubmit.addActionListener(this);
        panel.add(btnSubmit);

        btnCancel = new JButton("Cancel");
        btnCancel.setForeground(Color.BLACK);
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setBounds(220, 420, 120, 30);
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnCancel.addActionListener(this);
        panel.add(btnCancel);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(500, 150, 200, 200);
        panel.add(IconLabel1);

        setLocation(500, 150);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(850, 500);
        setVisible(true);
    }

    private void populateRoomNumbers() {
        try {
            Connectiondb con = new Connectiondb();
            String query = "SELECT roomnumber FROM room WHERE availability = 'Available'";
            ResultSet resultSet = con.statement.executeQuery(query);
            while (resultSet.next()) {
                comboBoxRoomNumber.addItem(resultSet.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnSubmit) {
                System.out.println("Clicked on Submit Button");

                String idType = (String) comboBoxId.getSelectedItem();
                String number = textFieldNumber.getText();
                String name = textFieldName.getText();
                String gender = radioButtonMale.isSelected() ? "Male" : "Female";
                String country = textFieldCountry.getText();
                String roomNumber = (String) comboBoxRoomNumber.getSelectedItem();
                String checkInTime = labelCheckInDateTime.getText();
                String deposit = textFieldDeposit.getText();

                Connectiondb con = new Connectiondb();

                String query = "INSERT INTO customer VALUES ('" + idType + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + roomNumber + "', '" + checkInTime + "', '" + deposit + "')";

                con.statement.executeUpdate(query);

                String updateRoomQuery = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = '" + roomNumber + "'";
                con.statement.executeUpdate(updateRoomQuery);

                JOptionPane.showMessageDialog(null, "Customer Checked In Successfully");
                setVisible(false);


            } else if (e.getSource() == btnCancel) {
                new Reception();
                setVisible(false);
            }
        }catch(Exception eobj){
            eobj.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CheckIn();
    }
}

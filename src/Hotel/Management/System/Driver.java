package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JFrame implements ActionListener {

    JTextField btName,btAge, btCarCompany, btCarModel, btCarNumber, btPhone,btAadhar,btLicence;

    JComboBox btAvailability,btGender;

    JButton b1,b2;
    Driver(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,580);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label1 = new JLabel("Add Driver");
        label1.setBounds(194,10,160,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,22));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(64,70,152,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        JLabel label3 = new JLabel("Age");
        label3.setBounds(64,110,152,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel label4 = new JLabel("Gender");
        label4.setBounds(64,150,152,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel label5 = new JLabel("Car Company");
        label5.setBounds(64,190,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JLabel label6 = new JLabel("Car Model");
        label6.setBounds(64,230,152,22);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JLabel label7 = new JLabel("Car Number");
        label7.setBounds(64,270,152,22);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.white);
        panel.add(label7);

        JLabel label8 = new JLabel("Availability");
        label8.setBounds(64,310,152,22);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        label8.setForeground(Color.white);
        panel.add(label8);

        JLabel label9 = new JLabel("Phone");
        label9.setBounds(64,350,152,22);
        label9.setFont(new Font("Tahoma",Font.BOLD,14));
        label9.setForeground(Color.white);
        panel.add(label9);

        JLabel label10 = new JLabel("Aadhar");
        label10.setBounds(64,390,152,22);
        label10.setFont(new Font("Tahoma",Font.BOLD,14));
        label10.setForeground(Color.white);
        panel.add(label10);

        JLabel label11 = new JLabel("Licence");
        label11.setBounds(64,430,152,22);
        label11.setFont(new Font("Tahoma",Font.BOLD,14));
        label11.setForeground(Color.white);
        panel.add(label11);

        btName = new JTextField();
        btName.setBounds(200,70,156,20);
        btName.setFont(new Font("Tahoma",Font.PLAIN,22));
        btName.setForeground(Color.white);
        btName.setBackground(new Color(16,108,115));
        panel.add(btName);

        btAge = new JTextField();
        btAge.setBounds(200,110,156,20);
        btAge.setFont(new Font("Tahoma",Font.PLAIN,22));
        btAge.setForeground(Color.white);
        btAge.setBackground(new Color(16,108,115));
        panel.add(btAge);

        btCarCompany = new JTextField();
        btCarCompany.setBounds(200,190,156,20);
        btCarCompany.setFont(new Font("Tahoma",Font.PLAIN,22));
        btCarCompany.setForeground(Color.white);
        btCarCompany.setBackground(new Color(16,108,115));
        panel.add(btCarCompany);

        btCarModel = new JTextField();
        btCarModel.setBounds(200,230,156,20);
        btCarModel.setFont(new Font("Tahoma",Font.PLAIN,22));
        btCarModel.setForeground(Color.white);
        btCarModel.setBackground(new Color(16,108,115));
        panel.add(btCarModel);

        btCarNumber = new JTextField();
        btCarNumber.setBounds(200,270,156,20);
        btCarNumber.setFont(new Font("Tahoma",Font.PLAIN,22));
        btCarNumber.setForeground(Color.white);
        btCarNumber.setBackground(new Color(16,108,115));
        panel.add(btCarNumber);

        btPhone = new JTextField();
        btPhone.setBounds(200,350,156,20);
        btPhone.setFont(new Font("Tahoma",Font.PLAIN,22));
        btPhone.setForeground(Color.white);
        btPhone.setBackground(new Color(16,108,115));
        panel.add(btPhone);

        btAadhar = new JTextField();
        btAadhar.setBounds(200,390,156,20);
        btAadhar.setFont(new Font("Tahoma",Font.PLAIN,22));
        btAadhar.setForeground(Color.white);
        btAadhar.setBackground(new Color(16,108,115));
        panel.add(btAadhar);

        btLicence = new JTextField();
        btLicence.setBounds(200,430,156,20);
        btLicence.setFont(new Font("Tahoma",Font.PLAIN,22));
        btLicence.setForeground(Color.white);
        btLicence.setBackground(new Color(16,108,115));
        panel.add(btLicence);

        btAvailability = new JComboBox(new String[]{"Available","Unavailable"} );
        btAvailability.setBounds(200,310,156,20);
        btAvailability.setFont(new Font("Tahoma",Font.PLAIN,22));
        btAvailability.setForeground(Color.white);
        btAvailability.setBackground(new Color(16,108,115));
        panel.add(btAvailability);

        btGender = new JComboBox(new String[]{"Female","Male","Other"} );
        btGender.setBounds(200,150,156,20);
        btGender.setFont(new Font("Tahoma",Font.PLAIN,22));
        btGender.setForeground(Color.white);
        btGender.setBackground(new Color(16,108,115));
        panel.add(btGender);


        b1 = new JButton("Add");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(64,500,111,33);
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(198,500,111,33);
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(500, 60, 300, 300);
        panel.add(IconLabel1);


        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(900,600);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == b1){

                System.out.println("Clicked on Add Button");

                Connectiondb con = new Connectiondb();

                String name = btName.getText();
                String age = btAge.getText();
                String gender = (String) btGender.getSelectedItem();
                String carcompany =  btCarCompany.getText();
                String carmodel = btCarModel.getText();
                String carnumber = btCarNumber.getText();
                String availability = (String) btAvailability.getSelectedItem();
                String phone = btPhone.getText();
                String aadhar = btAadhar.getText();
                String licence = btLicence.getText();

                String query = "INSERT INTO driver values('"+name+"','"+age+"','"+gender+"','"+carcompany+"','"+carmodel+"','"+carnumber+"','"+availability+"','"+phone+"','"+aadhar+"','"+licence+"')";
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Added Driver");

            }else{
                System.out.println("Clicked on Back Button");
                new Admin();
                setVisible(false);
            }

        }
        catch(Exception eobj){
            eobj.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Driver();
    }

}

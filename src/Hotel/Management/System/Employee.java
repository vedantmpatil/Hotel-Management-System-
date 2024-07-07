package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class Employee extends JFrame implements ActionListener {

    JTextField btName,btAge,btSalary,btPhone,btAadhar,btEmail;

    JComboBox btJob,btGender;

    JButton b1,b2;

    Employee(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel label1 = new JLabel("Add Employee");
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

        JLabel label5 = new JLabel("Job");
        label5.setBounds(64,190,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JLabel label6 = new JLabel("Salary");
        label6.setBounds(64,230,152,22);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JLabel label7 = new JLabel("Phone");
        label7.setBounds(64,270,152,22);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.white);
        panel.add(label7);

        JLabel label8 = new JLabel("Aadhar");
        label8.setBounds(64,310,152,22);
        label8.setFont(new Font("Tahoma",Font.BOLD,14));
        label8.setForeground(Color.white);
        panel.add(label8);

        JLabel label9 = new JLabel("Email");
        label9.setBounds(64,350,152,22);
        label9.setFont(new Font("Tahoma",Font.BOLD,14));
        label9.setForeground(Color.white);
        panel.add(label9);

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

        btSalary = new JTextField();
        btSalary.setBounds(200,230,156,20);
        btSalary.setFont(new Font("Tahoma",Font.PLAIN,22));
        btSalary.setForeground(Color.white);
        btSalary.setBackground(new Color(16,108,115));
        panel.add(btSalary);

        btPhone = new JTextField();
        btPhone.setBounds(200,270,156,20);
        btPhone.setFont(new Font("Tahoma",Font.PLAIN,22));
        btPhone.setForeground(Color.white);
        btPhone.setBackground(new Color(16,108,115));
        panel.add(btPhone);

        btAadhar = new JTextField();
        btAadhar.setBounds(200,310,156,20);
        btAadhar.setFont(new Font("Tahoma",Font.PLAIN,22));
        btAadhar.setForeground(Color.white);
        btAadhar.setBackground(new Color(16,108,115));
        panel.add(btAadhar);

        btEmail = new JTextField();
        btEmail.setBounds(200,350,156,20);
        btEmail.setFont(new Font("Tahoma",Font.PLAIN,22));
        btEmail.setForeground(Color.white);
        btEmail.setBackground(new Color(16,108,115));
        panel.add(btEmail);

        btJob = new JComboBox(new String[]{"Manager",
                "Receptionist",
                "Housekeeper",
                "Bellhop",
                "Chef",
                "Maid",
                "Waiter",
                "Bartender",
                "Maintenance Worker",
                "Security Guard"} );
        btJob.setBounds(200,190,156,20);
        btJob.setFont(new Font("Tahoma",Font.PLAIN,22));
        btJob.setForeground(Color.white);
        btJob.setBackground(new Color(16,108,115));
        panel.add(btJob);

        btGender = new JComboBox(new String[]{"Female","Male","Other"} );
        btGender.setBounds(200,150,156,20);
        btGender.setFont(new Font("Tahoma",Font.PLAIN,22));
        btGender.setForeground(Color.white);
        btGender.setBackground(new Color(16,108,115));
        panel.add(btGender);

        b1 = new JButton("Add");
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.setBounds(64,400,111,33);
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.setBounds(198,400,111,33);
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon Icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image Iconimg1 = Icon1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon ScaledIcon1 = new ImageIcon(Iconimg1);
        JLabel IconLabel1 = new JLabel(ScaledIcon1);
        IconLabel1.setBounds(500, 60, 300, 300);
        panel.add(IconLabel1);


        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        getContentPane().setBackground(new Color(3, 45, 48));
        setSize(900,500);
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
                String job = (String) btJob.getSelectedItem();
                String salary = btSalary.getText();
                String phone = btPhone.getText();
                String aadhar = btAadhar.getText();
                String email = btEmail.getText();

                String query = "INSERT INTO employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
                con.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Added Employee");
            }else{
                System.out.println("Clicked on Back Button");
                new Admin();
                setVisible(false);
            }
        }catch(Exception eobj){
            eobj.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Employee();
    }
}

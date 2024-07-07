package Hotel.Management.System;

import javax.swing.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("icon/ItalyHotel.jpg"));
        JLabel label = new JLabel(imageicon);
        label.setBounds(0,0,1000,600);
        add(label);


        setLayout(null);
        setLocation(280,100);
        setSize(1000,600);
        setVisible(true);
        try{
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}


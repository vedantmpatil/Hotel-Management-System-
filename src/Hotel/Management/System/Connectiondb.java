package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Connectiondb {

     Connection connection;
     Statement statement;

     Connectiondb(){
          try{
               connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/hotelMS","root","root");
               statement = connection.createStatement();
          }
          catch(Exception e){
               e.printStackTrace();
          }
     }
}

package com.xworkz.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankApplicationUpdate {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Class is java.lang package & forName is static method which will accepts fully qualified class name
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String password="Xworkzodc@123";

       String sql="update bank set branch='davangere' where name='SBI'";
       String sql1="update bank set location='davangere' where name='SBI'";
       String sql2="update bank set name='SBI' where location='Davangere'";
       String sql3="update bank set branch='chennai' where name='SBI'";
       String sql4="update bank set branch='Anjaneya badavane' where name='SBI'";
       String sql5="update bank set location='Banglore' where branch='Axis'";
      String sql6="update bank set location='Jayadeva' where name='Canara'";
       String sql7="update bank set branch='vidyanagara' where name='ICICI'";
      String sql8="update bank set location='vijayanagara' where name='HDFC'";
        String sql9="update bank set location='davangere' where branch='mandipete'";

        try {
            Connection connection= DriverManager.getConnection(url,userName,password);
            System.out.println("Connection to database is sucessfull");
            Statement st=connection.createStatement();
            boolean result=st.execute(sql);
            boolean result1=st.execute(sql1);
            boolean result2=st.execute(sql2);
            boolean result3=st.execute(sql3);
            boolean result4=st.execute(sql4);
            boolean result5=st.execute(sql5);
            boolean result6=st.execute(sql6);
            boolean result7=st.execute(sql7);
            boolean result8=st.execute(sql8);
            boolean result9=st.execute(sql9);

            System.out.println(result+" "+result1+" "+result2+" "+result3+" "+result4+" "+result5+" "+result6+" "+result7+" "+result8+" "+result9);
            System.out.println("updated data into bank");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //how to make class as immutable--> by using final keyword to the class.
        //10 insertions and updates

    }
}

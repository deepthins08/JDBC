package com.xworkz.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataUsingPreparedStatement {

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver"); //Class is java.lang package & forName is static method which will accepts fully qualified class name
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String password="Xworkzodc@123";
        Connection connection=null;


        String sql="update bank set location=?,branch=? where name=?";

        try {
            connection= DriverManager.getConnection(url,userName,password);
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setString(1,"Mumbai");
            preparedStatement.setString(2,"Maharashtra");
            preparedStatement.setString(3,"SBI");
            preparedStatement.execute();

            System.out.println("updated data to the bank using prepared statement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.xworkz.bank;

import java.sql.*;

public class PreparedStatementInsertion {

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
        Statement statement=null;

        String sql="insert into bank values(?,?,?,?)";

        try {
            connection= DriverManager.getConnection(url,userName,password);
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1,11);
            preparedStatement.setString(2,"PKG");
            preparedStatement.setString(3,"chamrajpete");
            preparedStatement.setString(4,"davangere");
            preparedStatement.execute();
            System.out.println("inserted data into the bank using prepared statement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

// create a new maven project
        // create new database and table
        // perform insert,update,delete,select using statement interface
        // diff btw the equals and hashcode
    }
}

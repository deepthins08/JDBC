package com.xworkz.bank;

import java.sql.*;

public class DeleteDataUsingPreparedStatement {
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


        String sql="delete from bank where location=? and branch=?";

        try {
            connection= DriverManager.getConnection(url,userName,password);
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            preparedStatement.setString(1,"vidyanagara");
            preparedStatement.setString(2,"banglore");
            preparedStatement.execute();

            System.out.println("deleted data from the bank using prepared statement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

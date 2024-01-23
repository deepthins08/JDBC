package com.xworkz.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

    public static void main(String[] args) {

        String url="jdbc:mysql://localhost:3306/bankapplication";
        String name="root";
        String pass="Xworkzodc@123";
        String deleteQuery="delete from bank where name='Axis'";
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
           connection =DriverManager.getConnection(url,name,pass);
            statement= connection.createStatement();
            int result=statement.executeUpdate(deleteQuery);
            System.out.println(result);
            System.out.println("Data is Deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        finally {
            try{
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try{
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}

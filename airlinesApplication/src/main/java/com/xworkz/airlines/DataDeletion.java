package com.xworkz.airlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataDeletion {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String pass="Xworkzodc@123";
        String deleteQuery="delete from airlines  where plane_name='spacejet'";


        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);
            Statement statement=connection.createStatement();
            Boolean result=statement.execute(deleteQuery);

            System.out.println("data is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

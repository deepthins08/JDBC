package com.xworkz.airlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataUpdation {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String pass="Xworkzodc@123";
        String updateQuery="update airlines set no_of_seats=550 where plane_name='indigo'";
        String updateQuery1="update airlines set no_of_seats=1000 where plane_name='vistara'";
        String updateQuery2="update airlines set price=5500 where plane_name='vistara'";


        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);
            Statement statement=connection.createStatement();
            Boolean result=statement.execute(updateQuery);
            statement.execute(updateQuery1);
            statement.execute(updateQuery2);
            System.out.println("data is updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    }


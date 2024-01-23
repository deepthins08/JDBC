package com.xworkz.airlines;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseCreation {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String pass="Xworkzodc@123";
        String createQuery="create table airlines(id int,plane_name varchar(20),no_of_seats bigint,price bigint)";

        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);
            Statement statement=connection.createStatement();
            Boolean result=statement.execute(createQuery);
            System.out.println("table is crated is created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

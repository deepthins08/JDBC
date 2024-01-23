package com.xworkz.airlines;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataInsertion {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String pass="Xworkzodc@123";
        String insertQuery="insert into airlines values(1,'indigo',500,2500),(2,'spacejet',550,3300)," +
                "(3,'vistara',400,3500),(4,'air_india',400,3000),(5,'emirates',600,12000)";

        try {
            Connection connection= DriverManager.getConnection(url,userName,pass);
            Statement statement=connection.createStatement();
            Boolean result=statement.execute(insertQuery);
            System.out.println(result);
            System.out.println("Data is inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

package com.xworkz.airlines;

import java.sql.*;

public class RetriveData {

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

        String query = "SELECT * FROM airlines";


        try {
            connection= DriverManager.getConnection(url,userName,password);
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("plane_name"));
                System.out.println(resultSet.getInt("no_of_seats"));
                System.out.println(resultSet.getInt("price"));

            }
            System.out.println("fetching data from airlines");
            System.out.println("Connection to database is sucessfull");
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

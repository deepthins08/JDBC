package com.xworkz.bank;

import java.sql.*;

public class FetchingData {

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

        String query = "SELECT * FROM bank";


        try {
           connection= DriverManager.getConnection(url,userName,password);
            statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

//             Process the resultset.
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String branch=resultSet.getString("branch");
//                String location= resultSet.getString("location");
//                System.out.println("id: " + id + ", name: " + name + ", branch: " + branch + ", location: "+location);
//            }
//            or

            while(resultSet.next()){
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("branch"));
                System.out.println(resultSet.getString("location"));

            }
            System.out.println("fetching data from bank");
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

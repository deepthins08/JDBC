package com.xworkz.bank;

import java.sql.*;

public class DatabaseConnection {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver"); //Class is java.lang package & forName is static method which will accepts fully qualified class name
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String url="jdbc:mysql://localhost:3306/bankapplication";
        String userName="root";
        String password="Xworkzodc@123";

      String sql="insert into bank values(1,'SBI','BTM','Banglore'),(2,'Canara','rajajinagara','Banglore'),(3,'Axis','Jayadeva','Banglore')," +
              "(4,'ICICI','Jayanagara','Banglore'),(5,'HDFC','Banashankari','Banglore'),(6,'PKG','Vijaynagara','Banglore')," +
              "(7,'SBI','Mandipete','Davangere'),(8,'Union','Mejestic','Banglore'),(9,'ICICI','Vidyanagara','Davangere')," +
              "(10,'Canara','Vinobanagara','Davangere')";

        //String query = "SELECT * FROM bank";


        try {
           Connection connection= DriverManager.getConnection(url,userName,password);
            Statement st=connection.createStatement();
            //ResultSet resultSet = st.executeQuery(query);

           /* // Process the resultset.
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String branch=resultSet.getString("branch");
                String location= resultSet.getString("location");
                System.out.println("id: " + id + ", name: " + name + ", branch: " + branch + ", location: "+location);
            }
         // int result=st.executeUpdate(sql);*/
            boolean result= st.execute(sql);
           System.out.println(result);

            System.out.println("inserted data into bank");
            System.out.println("Connection to database is sucessfull");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

/*** when finally block will not execute, pack   ages of exceptions,
 -->when we called System.exit() in try it will stop the execution
 and finally block will not execute. and also if we return before any
 statement in finally block it throws an error as unreachable statement.
 also it may be caused by jvm crash ***/
// DriverManager,getConnection...etc.
    }
}

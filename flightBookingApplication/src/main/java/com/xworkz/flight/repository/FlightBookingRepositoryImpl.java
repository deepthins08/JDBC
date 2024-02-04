package com.xworkz.flight.repository;

import com.xworkz.flight.dto.FlightBooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FlightBookingRepositoryImpl implements FlightBookingRepository{
    @Override
    public void save(FlightBooking booking) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/ticket_system";
        String user="root";
        String pass="Xworkzodc@123";
        String insertQuery="insert into airticket(flight_name,source,destination,price) values(?,?,?,?)";

        try {
            Connection connection= DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);

            preparedStatement.setString(1,booking.getFlight_name());
            preparedStatement.setString(2, booking.getSource());
            preparedStatement.setString(3,booking.getDestination());
            preparedStatement.setDouble(4,booking.getPrice());
            preparedStatement.execute();
            System.out.println("Inserted values to the table");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<FlightBooking> booking) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/ticket_system";
        String user="root";
        String pass="Xworkzodc@123";
        String insertQuery="insert into airticket(flight_name,source,destination,price) values(?,?,?,?)";

        try {
            Connection connection=DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            for(FlightBooking booking1:booking){
                preparedStatement.setString(1,booking1.getFlight_name());
                preparedStatement.setString(2,booking1.getSource());
                preparedStatement.setString(3, booking1.getDestination());
                preparedStatement.setDouble(4,booking1.getPrice());
                preparedStatement.execute();
                System.out.println("inserted values to the table "+booking1.getFlight_name());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String flightName, String source, String destination) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/ticket_system";
        String user="root";
        String pass="Xworkzodc@123";
        String updateQuery="update airticket set source=?,destination=? where flight_name=?";

        try {
            Connection connection=DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
            preparedStatement.setString(1,source);
            preparedStatement.setString(2,destination);
            preparedStatement.setString(3,flightName);
            preparedStatement.executeUpdate();
            System.out.println("Updated data");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String flightName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/ticket_system";
        String user="root";
        String pass="Xworkzodc@123";
        String deleteQuery="delete from airticket where flight_name=?";

        try {
            Connection connection=DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1,flightName);
            preparedStatement.executeUpdate();
            System.out.println("deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void updateAll(List<FlightBooking> bookings) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url="jdbc:mysql://localhost:3306/ticket_system";
        String user="root";
        String pass="Xworkzodc@123";
        String updateAllQuery="update airticket set source=?,price=? where flight_name=?";

        try {
            Connection connection=DriverManager.getConnection(url,user,pass);
            PreparedStatement preparedStatement=connection.prepareStatement(updateAllQuery);
            for(FlightBooking booking:bookings){
                preparedStatement.setString(1,booking.getSource());
                preparedStatement.setDouble(2,booking.getPrice());
                preparedStatement.setString(3,booking.getFlight_name());
                preparedStatement.execute();

                System.out.println("updated all the data "+booking.getFlight_name());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

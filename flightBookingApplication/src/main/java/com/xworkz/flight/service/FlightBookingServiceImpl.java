package com.xworkz.flight.service;

import com.xworkz.flight.dto.FlightBooking;
import com.xworkz.flight.repository.FlightBookingRepository;
import com.xworkz.flight.repository.FlightBookingRepositoryImpl;

import java.util.List;

public class FlightBookingServiceImpl implements FlightBookingService{

    FlightBookingRepository flightBookingRepository=new FlightBookingRepositoryImpl();
    @Override
    public void save(FlightBooking booking) {

        if(booking.getFlight_name().isEmpty()){
            System.out.println("please enter valid flight name");
        }
        else{
            flightBookingRepository.save(booking);
        }
    }

    @Override
    public void saveAll(List<FlightBooking> booking) {

     boolean validBooking=true;

        for(FlightBooking booking1:booking) {
            if (booking1.getFlight_name().isEmpty()) {
                System.out.println("please enter valid flight name");
                validBooking = false;
            }
            if (!validBooking) {
                return;
            }
        }

            flightBookingRepository.saveAll(booking);



    }

    @Override
    public void update(String flightName, String source, String destination) {

        if(flightName==null && flightName.isEmpty()){
            System.out.println("please enter valid flight name");
        }
        else{
            flightBookingRepository.update(flightName, source, destination);
        }
    }

    @Override
    public void delete(String flightName) {

        if(flightName==null && flightName.isEmpty()){
            System.out.println("please enter valid flight name");

        }
        else{
            flightBookingRepository.delete(flightName);
        }
    }

    @Override
    public void updateAll(List<FlightBooking> bookings) {

        boolean validBooking=true;

        for(FlightBooking booking:bookings){
            if(booking.getFlight_name().isEmpty()){
                System.out.println("please enter valid flight name");
            }

            if(!validBooking){
                return;
            }
        }

        flightBookingRepository.updateAll(bookings);
    }
}

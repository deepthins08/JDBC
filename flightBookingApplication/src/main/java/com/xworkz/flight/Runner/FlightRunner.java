package com.xworkz.flight.Runner;

import com.xworkz.flight.dto.FlightBooking;
import com.xworkz.flight.repository.FlightBookingRepository;
import com.xworkz.flight.repository.FlightBookingRepositoryImpl;
import com.xworkz.flight.service.FlightBookingService;
import com.xworkz.flight.service.FlightBookingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FlightRunner {

    public static void main(String[] args) {
       // FlightBookingRepository flightBookingRepository=new FlightBookingRepositoryImpl();
     //   FlightBooking flightBooking=new FlightBooking("emirates","banglore","dubai",75000);
      //  flightBookingRepository.saveFlightBookingDetails(flightBooking);
        FlightBookingService flightBookingService=new FlightBookingServiceImpl();
       // flightBookingService.save(flightBooking);

        List<FlightBooking> list=new ArrayList<>();
        FlightBooking flightBooking1=new FlightBooking("Indigo","banglore","delhi",10000);
        FlightBooking flightBooking2=new FlightBooking("air_india","Mumbai","Hyderabad",15000);

        list.add(flightBooking1);
        list.add(flightBooking2);
//        flightBookingService.saveAll(list);


        //flightBookingService.update("air_india","banglore","mumbai");

        //flightBookingService.delete("indigo");

        List<FlightBooking> list1=new ArrayList<>();
        FlightBooking flightBooking=new FlightBooking("Banglore",20000,"emirates");
        FlightBooking flightBooking3=new FlightBooking("Dubai",80000,"air_india");
        list1.add(flightBooking);
        list1.add(flightBooking3);
        flightBookingService.updateAll(list1);
    }
}

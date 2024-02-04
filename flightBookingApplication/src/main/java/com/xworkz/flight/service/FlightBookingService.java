package com.xworkz.flight.service;

import com.xworkz.flight.dto.FlightBooking;

import java.util.List;

public interface FlightBookingService {

    public void save(FlightBooking booking);
    public  void saveAll(List<FlightBooking> booking);

    public void update(String flightName,String source,String destination);

    public void delete(String flightName);

    public void updateAll(List<FlightBooking> bookings);

}

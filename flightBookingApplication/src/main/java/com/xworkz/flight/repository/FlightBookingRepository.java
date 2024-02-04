package com.xworkz.flight.repository;

import com.xworkz.flight.dto.FlightBooking;

import java.util.List;

public interface FlightBookingRepository {

    public void save(FlightBooking booking);
    public void saveAll(List<FlightBooking> booking);

    public void update(String flightName,String source,String destination);

    public void delete(String flightName);

    public void updateAll(List<FlightBooking> bookings);
}

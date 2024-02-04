package com.xworkz.flight.dto;

import lombok.*;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor@ToString
public class FlightBooking {

    private int id;
    private String flight_name;
    private String source;
    private String destination;
    private double price;

    public FlightBooking(String flight_name,String source,String destination,double price){
        this.flight_name=flight_name;
        this.source=source;
        this.destination=destination;
        this.price=price;
    }

    public FlightBooking(String source,double price,String flight_name){
        this.source=source;
        this.price=price;
        this.flight_name=flight_name;
    }
}

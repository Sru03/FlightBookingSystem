package com.example.flight.model;

import java.lang.annotation.Inherited;

@Entity
@Table(name= "flights")

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String flightNumber;

    private String origin;

    private String destination;
    

    public Flight() {
    }


    public Flight(Long id, String flightNumber, String origin, String destination){
        this.id = id;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
    }

    public long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFlightNumber(){
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber){
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public String getDestination(){
        return this.destination;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }





    
}

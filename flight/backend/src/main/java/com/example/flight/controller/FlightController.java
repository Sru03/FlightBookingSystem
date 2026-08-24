package com.example.flight.controller;
import com.example.flight.entity.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @GetMapping 
    public Flight getFlight(){
        Flight flight = new Flight();

        flight.setId(1L);
        flight.setFlightNumber("NZ001");
        flight.setOrigin("AKL");
        flight.setDestination("SYD");

        return flight;

    }
}

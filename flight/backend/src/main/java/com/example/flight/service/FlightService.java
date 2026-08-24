package com.example.flight.service;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightById(Long id){
        return flightRepository.findById(id);
    }
}
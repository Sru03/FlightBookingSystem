package com.example.flight.service;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;
import com.example.flight.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
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

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight) {
        flight.setId(null);
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight incoming) {
        Flight existing = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found with id : " + id));

        existing.setFlightNumber(incoming.getFlightNumber());
        existing.setOrigin(incoming.getOrigin());
        existing.setDestination(incoming.getDestination());

        return flightRepository.save(existing);
    }
}
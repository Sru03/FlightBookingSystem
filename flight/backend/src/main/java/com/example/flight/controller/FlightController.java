package com.example.flight.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @GetMapping
    public String getFlights() {
        return "All flights";
    }
}

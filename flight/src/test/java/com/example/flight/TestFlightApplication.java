package com.example.flight;

import org.springframework.boot.SpringApplication;

public class TestFlightApplication {

	public static void main(String[] args) {
		SpringApplication.from(FlightApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

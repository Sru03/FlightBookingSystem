package com.example.flight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.flight.entity.Flight;
import com.example.flight.repository.FlightRepository;
import com.example.flight.service.FlightService;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FlightServiceContractTest {

    @Mock
    private FlightRepository flightRepository;

    private FlightService flightService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        flightService = new FlightService(flightRepository);
    }

    @Test
    void createFlightIgnoresIncomingId() {
        Flight incoming = new Flight(7L, "AI101", "DEL", "BLR");
        when(flightRepository.save(any(Flight.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Flight created = flightService.createFlight(incoming);

        assertEquals("AI101", created.getFlightNumber());
        assertEquals("DEL", created.getOrigin());
        assertEquals("BLR", created.getDestination());
        verify(flightRepository).save(argThat(flight -> flight.getId() == null));
    }

    @Test
    void updateFlightLooksUpThePathIdAndWriteOnlyTheMutatingFields() {
        Flight stored = new Flight(1L, "AI100", "DEL", "BLR");
        Flight updateBody = new Flight(99L, "AI102", "MUM", "HYD");

        when(flightRepository.findById(1L)).thenReturn(Optional.of(stored));
        when(flightRepository.save(any(Flight.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Flight updated = flightService.updateFlight(1L, updateBody);

        assertEquals(1L, updated.getId());
        assertEquals("AI102", updated.getFlightNumber());
        assertEquals("MUM", updated.getOrigin());
        assertEquals("HYD", updated.getDestination());
        verify(flightRepository).save(stored);
    }
}


@Service
public class FlightService {


    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository){
        this.flightRepository  = flightRepository;
    }

}
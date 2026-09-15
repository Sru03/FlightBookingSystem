# FlightBookingSystem


Software Architecture 


                         FRONTEND
                            │
                            ▼
                     ┌─────────────┐
                     │ API Gateway │
                     └──────┬──────┘
                            │
          ┌─────────────────┼─────────────────┐
          ▼                 ▼                 ▼
   ┌────────────┐    ┌────────────┐    ┌────────────┐
   │ Flight     │    │ Booking    │    │ Payment    │
   │ Service    │    │ Service    │    │ Service    │
   └─────┬──────┘    └─────┬──────┘    └─────┬──────┘
         │                 │                 │
         ▼                 ▼                 ▼
      Flight DB         Booking DB        Payment DB
         │                 │                 │
         └─────────────────┼─────────────────┘
                           │
                           ▼
                        KAFKA
                           │
                ┌──────────┴──────────┐
                ▼                     ▼
         Notification             Analytics
           Service                  Service
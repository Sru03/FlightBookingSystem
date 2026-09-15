# FlightBookingSystem




Software Architecture 


                      # Flight Booking System Architecture

```mermaid
flowchart TD
    A[React Frontend] --> B[API Gateway]

    B --> C[Flight Service]
    B --> D[Booking Service]
    B --> E[Payment Service]

    C --> F[(Flight Database)]
    D --> G[(Booking Database)]
    E --> H[(Payment Database)]

    C -. Publishes Events .-> I[Kafka]
    D -. Publishes Events .-> I
    E -. Publishes Events .-> I

    I --> J[Notification Service]
    I --> K[Analytics Service]


```

#Resources
<br> [Introduction to Kafka]   (https://kafka.apache.org/43/getting-started/introduction) <br>

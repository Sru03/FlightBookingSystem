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

    C e1@-. Publishes Events .-> I[Kafka]
    D e2@-. Publishes Events .-> I
    E e3@-. Publishes Events .-> I

    e1@{animate: true}
    e2@{animate: true}
    e3@{animate: true}

    I --> J[Notification Service]
    I --> K[Analytics Service]

 

    C ~~~ I
    D ~~~ I
    E ~~~ I

 

    
```


#Resources
<br>[Introduction to Kafka]<br>
<br>https://kafka.apache.org/43/getting-started/introduction<br>


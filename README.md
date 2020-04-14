# Spring DATA JPA
This code repository is based on presentation given to Endurance Burlington team.

## About the demo
Spring Data JPA provides rich functionality to work with Relational Database Management Systems (RDMS).  Check out documentation and samples at https://spring.io/projects/spring-data-jpa.  The project was build using Spring Boot version 2.2.5.

## Instructions
* This project requires Open JDK version 11 or higher.

* Use IntelliJ IDEA ultimate edition (required for JPA persistence mapping tool).

* Use gradle menu 'build' to build the application.

* Use gradle menu 'bootRun' to run the application.

## REST APIs
* The project exposes the following REST end point for get request: http://localhost:8080/customers/{lastname}

* Following is sample request and response:
1. Request: 
http://localhost:8080/customers/Ford

1. Response:
```json5 
{
    "first": "Gerald",
    "last": "Ford",
    "addresses": [
        {
            "city": "Martha's Vineyard",
            "state": "Massachusetts"
        },
        {
            "city": "Boston",
            "state": "Massachusetts"
        },
        {
            "city": "Boston",
            "state": "Massachusetts"
        }
    ]
}
```



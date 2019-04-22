Travel API Client 
=================
Requirement / Instructions :
Create a user interface and  web user interface where a customer of the site could do the following:
 * Be able to select an origin.
 * Be able to select a destination.
 * Retrieve a fare offer for the given origin-destination combination.
 
## Technology Used

	1. Java 8
	2. Spring boot 2.x
	3. swagger 2.9.x
	4. Gradle
	5. JQuery
	6. HTML
 
### How to build and run
###### Windows
`gradlew bootRun`

to list all tasks:

`gradlew tasks`
###### Linux
`./gradlew bootRun` 

to list all tasks:

`./gradlew tasks`
## To view the assignment 
(after starting the application) go to: [http://localhost:9000/travel/index.html](http://localhost:9000/travel/index.html)
## Design Pattern
* Strategy Pattern
* Builder Pattern

### Strategy  Pattern
I have used **_Strategy pattern_** to parse multiple mock file for a specific data and application decides the actual implementation to be used at runtime.
### Builder  Pattern
I decided to use **_Builder  Pattern_** to get fare details based on the input and search and filter the fares based on the search parameter from mock since its providing a more flexible way to separate the object creation, functionality from service layer and scalable.
## API Document
Please use [http://localhost:9000/travel/swagger-ui.html](http://localhost:9000/travel/swagger-ui.html) or you can use any web service testing tools to test the same by using below APIs.

	http://localhost:9000/travel/getAirports		-X GET
	http://localhost:9000/travel/searchAirports		-X POST
	http://localhost:9000/travel/searchFares		-X POST
	http://localhost:9000/travel/statistics_data		-X GET
## Approach and why?
Based on the user entered search criteria, application will find the right flights based on the origin, destination and departure date. And it will check whether any applicable fares are available for the matched flight based on the flight id which is there in fare data model.

### why?

In modern software architecture, we need to build more de-coupled system to serve the purpose, so I have decided to create a Travel API with micro services architecture and de-coupled from Flights and Fare System. I have created my mock data of flights and fares as a JSON document with the assumption of those two services are different micro services which Travel API is consuming them to show the fares for user input.

## Statistics 
Travel API system is fully integrated and tracking the each request in received to system and monitoring the system performance of service call. You can use the below link to show statistics data of Travel API

go to: [http://localhost:9000/travel/statistics.html](http://localhost:9000/travel/statistics.html)

## Sample Response Structure
```{
  "status": "Success",
  "fares": [
    {
      "departure": "04/21/2019",
      "flightNumber": "KL008",
      "economyFare": "EUR 510.5",
      "businessFare": "EUR 950.4",
      "totalJouneryTime": "7h 45m",
      "departTime": "08:40",
      "arrivalTime": "13:35"
    }
  ]
} 
```

## More Details
Please refer below link for more details about data model and screen shots

[Design Document](https://github.com/udayakumarrajan/travel-api/blob/master/original-case/document/Travel%20API%20Design%20Document.pdf)




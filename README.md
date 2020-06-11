# The Broad Institue

# The DSP's MBTA Challenge

**Background**

Boston's transportation system, the MBTA (https://mbta.com/), has a website with APIs for software developers to access its transportation information. Refer to
   https://api-v3.mbta.com/docs/swagger/index.html.
   
##### Java version:  1.8.0_231 . 

  This exercise was compiled and tested against the Java version stated above.

This code project was authored in IntelliJ v 2020.1.1 Ultimate edition, and this GitHub directory contains all of the project artefacts and libraries needed to compile and run the project.

**Project Organization**

This project is organized as a multi-module maven project, where each module corresponds
to a layer of the application.  This layering approach conforms to a conventional hierarchical enterprise package format so that
functionality is isolated to its appropriate layer of concern. This design approach tries to maintain the independence of each layer
so that libraries and functionality can be more easily swapped in or out. Each layer has its own pom.xml configuration file,
but the overall project as a root level pom.xml file as the parent.

The layers include:
- service (/service/src/main/java/org/broadinstitute/mbta/service)
    - a service layer which is responsible for retrieving a specific type of MBTA information such as mbta Routes or Stops
- client (/client/src/main/java/org/broadinstitute/mbta/client)
    - a client layer responsible for creating REST clients.  Note: SpringBoot has the 
    older RestTemplate client implementation and a more recent WebClient rest. So, isolating
    rest client functionality in this layer woul allow one to use either type of rest client 
    
- core (/core/src/main/java/org/broadinstitute/mbta/core)
    - The business objects or POJOs are placed here. There is typically a mapping between JSON entities and
    their corresponding Java object. The mapping of JSON entities to Java objects occurs through (de)serliazation.

**Exploration of MBTA V3 API through Postman**

[Postman](https://www.postman.com/) is a collaboration platform for API development. Quickly and easily send REST and SOAP  requests directly within Postman. Before any coding,
I used Postman extensively to evaluate the json information retrieved from the MBTA site to determine how it can be transformed and used for business purposes

In particular, I found these two cURL commands through Postman to be most useful as an entry point.
- For Routes. **GET** `https://api-v3.mbta.com/routes?filter[type]=0,1`
- For Stops. **GET** `https://api-v3.mbta.com/stops?filter[route_type]=0,1&include=route,parent_station`


**Exercise**

***Question 1***

``` 
Write a program that retrieves data representing all, what we'll call "subway" routes: "Light Rail"
(type 0) and “Heavy Rail” (type 1). The program should list their “long names” on the console.
Partial example of long name output: Red Line, Blue Line, Orange Line...
There are two ways to filter results for subway-only routes. Think about the two options below
and choose:
1. Download all results from https://api-v3.mbta.com/routes then filter locally
2. Rely on the server API (i.e., https://api-v3.mbta.com/routes?filter[type]=0,1) to
filter before results are received
Please document your decision and your reasons for it.
``` 


***Question 2***

```
Extend your program so it displays the following additional information.
1. The name of the subway route with the most stops as well as a count of its stops.
2. The name of the subway route with the fewest stops as well as a count of its stops.
3. A list of the stops that connect two or more subway routes along with the relevant route
names for each of those stops.
```

***Question 3***

```
Extend your program again such that the user can provide any two stops on the subway routes
you listed for question 1.
List a rail route you could travel to get from one stop to the other. We will not evaluate your
solution based upon the efficiency or cleverness of your route-finding solution. Pick a simple
solution that answers the question. We will want you to understand and be able to explain how
your algorithm performs.
Examples:
1. Davis to Kendall -> Redline
2. Ashmont to Arlington -> Redline, Greenline
```

**Test Coverage**

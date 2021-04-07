# Airport Data Center

### This application fetches airport information of all the countries from the given data ( in csv files ) and provides api to search specific information ###

### Technical Stack  ###
 1. Java 8
 2. Spring boot Framework
 3. Maven
 4. Custom Libraries: Lombok, ModelMapper, OpenCSV
 5. Spring Boot Test
 6. Swagger API

### Features ###

The Application loads data from csv files in "resources" folder. The data includes information of Airports, Countries and Runways. The application reads this information from csv, processes and puts it in H2 Database and provides following APIs :

1. `GET` Runways ( `/airport/runways?countryName=<search word>` ) : In this api, if you pass name string ( minimum 3 characters for The country name, and minimum 2 characters for Country Code ), the API will return all matching name countries with their runway information of each airport.
2. `GET` Top Countries ( `/airport/topcountries` ) : This API returns top 10 country names which has the highest number of airports.

    
### Local Installation ###

1. Checkout the project from git repository ( git clone <url> )

2. Import the project in your IDE as Java project ( Browse pom.xml / Convert to maven project if needed ).

2. Install lombok . Download jar from [website](https://plugins.jetbrains.com/plugin/6317-lombok) ( for Eclipse ) / IntelliJ marketplace.

3. The default port to run the server is 8080. It can be modified in application.properties file if you want.
  
5. Refer following swagger API for Rest API specifications in json :

   ` http://localhost:8080/swagger-ui/ `
   
### Unit Tests 

Unit tests are located in `src/test` folder.
   
### Deploy-able Artifact ( Current Version 0.0.1 )

Run `mvn clean install`, it will create `airport-0.0.1-SNAPSHOT.war` file in the target folder
   
### Author
 
Jyoti Kale (jyoti.y.kale@gmail.com)
 
 
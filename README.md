# Event Tracker Project
### Overview
'Event Tracker' is a broad term for anything that keeps track of information over time. Examples of these applications are 'Mint' (financial tracking) and 'MyFitnessPal' (diet and exercise tracker). These are very involved applications with a huge feature set.

You are embarking on a weekend project that you may or may not come back to afterwards, thus we would caution you to limit your scope significantly. Examples of limited scope would be 'Gas Tracker' (keep track of your fill ups and total mileage to determine dollar/gallon in your car) or 'Timesheet' (track time in and time out to calculate total hours at some rate of pay).

### Learning Objectives
* Create a JPA Project
* Create a Java entity class POJO that models your database table.
* Map your POJO using JPA.
* Configure a Spring Boot app to publish a REST API.
* Use Spring REST annotations.
* Use Spring Data JPA to perform all CRUD operations.
* Send and receive JSON.

### Technologies
* Spring Boot/Tool Suite
* RESTFul API
* JPA Repositories
* MySQL Database
* Java SE/EE
* Gradle
* Amazon AWS-EC2
* Postman API Development
* JSON
### Goal

Stretch Goals
JUnit tests for your repository, service, and controller layers.
Supplemental tables, mappings, and controller routes for nested CRUD.

### AWS-EC2 Connection:
[AWS-EC2 Link] (http://13.59.166.203:8080/FuelMileageREST/)



### Postman Operations
To test the api mapping copy the top link to the AWS-EC2 site. Next, in a Postman API Development Environment copy the the link and append the the proper GET method and the appropriate api path. For Example, a GET reference would look similar to  http://13.59.166.203:8080/FuelMileageREST/api/fuels to retrieve a complete list of all the entries. Below are all the programmed access paths. 

### Fuel RESTFul API:
| Return Type | Route | Functionality|
| --------: | ------: |----------: |
|List<Fuel> | GET api/fuels | Gets all fuels |
|Fuel | GET api/fuels/{id}	|Gets one fuel entry by id |
|Fuel | POST api/fuels |	Creates a new fuel entry |
|Fuel | PUT api/fuels/{id }| Replace a fuel entry by id |
|Fuel | PATCH api/fuels/{id} |	Update a fuel entry by id |
|Boolean | DELETE api/fuels/{id} |	Deletes a fuel entry by id |
  

### Vehicle RESTFul API:
| Return Type	| Route	| Functionality |
| --------: | ------: |----------: |
| List<Vehicle> | GET api/vehicles |	Gets all vehicle | 
| Vehicle |	GET api/vehicles/{id} |	Gets one vehicle entry by id |
| Vehicle |	POST api/vehicles |	Creates a new vehicle entry |
| Vehicle |	PUT api/vehicles/{id} |	Replace a vehicle entry by id |
| Vehicle |	PATCH api/vehicles/{id} |	Update a vehicle entry by id |
| Boolean |	DELETE api/vehicles/{id} |	Deletes a vehicle entry by id |
  



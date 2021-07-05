# Opera
This is my simple REST application that represents work of opera service. Users in this application have roles which is determined by authorization like Admin and User with corresponding possibilities. By default, new users have User's role. Project based on N-tier architecture(DAO layer, Service layer, Controller layer).  

## Possibilities of unauthorized person:
- registration
- view all stages
- view all performances
- view all available performance sessions

## Possibilities of User:
- view all orders history
- view list of tickets in shopping cart
- add the ticket to the shopping cart
- complete the order

## Possibilities of Admin:
- view user by email
- create stage
- create performance
- create, update or delete performance session

## Technologies
- Apache Tomcat
- Maven  
- Spring (Core, Web, MVC, Security)
- Hibernate
- MySQL
- Lombok
- JSON

## Setup configuration
- Clone this project to your local machine
- Configure Tomcat (recommend to use version 9.0.46, Deployment - war_exploded, context address - "/")
- Install MySQL
- Configure src/main/resources/db.properties 
- Start application

###### HINT: Users with roles User and Admin create automatically after starting application. To test application you can use Postman
###### To login as Admin use email: Admin@i.ua, password: admin123.
###### To login as Admin use email: User@i.ua, password: user1234.

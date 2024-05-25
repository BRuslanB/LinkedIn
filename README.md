# LinkedInApp
This Java-based application is supported by a REST API for storing and processing contact and organization profiles.
Note. This service was created as a test task for an internship in one of the IT companies.

## Functions
LinkedIn is a web application for registering and searching for candidates. The application must consist of 3 pages:
1. Admin page: the user adds the “Company” and “Specialty” directories.
2. Candidate page: the user fills out his profile data and also selects a company and specialty from the list.
3. HR page: the user opens the page and searches by company and/or specialty.

## Technologies used
The user transaction service is built using the following technologies:

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* Hibernate
* PostgreSQL
* Liquibase
* Thymeleaf
* Bootstrap

## Prerequisites
Before starting the Service, the following software must be installed on your computer:

* Java Development Kit (JDK) 17 or higher.
* PostgreSQL

## Beginning
To start the service locally, follow these steps:

1. Clone the repository to your local computer:
``` bash
git clone https://github.com/BRuslanB/LinkedIn.git
```
2. Create a database in PostgreSQL:
``` 
linkedin_db
```
3. Build and run the Java application.
``` bash
java -jar ./build/libs/LinkedIn-0.0.1-SNAPSHOT.jar
```
or for MS Windows
```
java -jar .\build\libs\LinkedIn-0.0.1-SNAPSHOT.jar
```
4. Open in a browser.
``` 
http://localhost:8000/
``` 

## Contribution
If you would like to contribute to the development of this Application, please submit a pull request or open an issue on the GitHub repository.

## License
This Service is licensed under the MIT License. For more information, see the LICENSE file.

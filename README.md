# Spring Boot Example Project

This is a small Java / Gradle / Spring Boot (version 2.1.5) application that can be used as a starter for creating a microservice used to store notes into a MySQL database.

## How to Run 

* Clone this repository 
* Make sure you are using JDK 1.8 and Gradle 5.4.
* You can run the service by using this method:
```
        gradlew bootRun
```
* Check the stdout to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2019-05-26 22:20:49.391  INFO 8200 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-05-26 22:20:49.394  INFO 8200 --- [  restartedMain] dev.munger.noted.NotedApplication        : Started NotedApplication in 5.209 seconds (JVM running for 5.715)
```

## About the Service

The service is a note taking REST service. A MySQL database hosted on port 3306 stores the data sent by the user. It is possible to achieve the same result using PostgreSQL or an in-memory H2 database. If the database connection is completed successfully, some REST endpoints can be called as defined in ```dev.munger.noted.controller.NoteController``` on **port 8080** (endpoints detailed below).

This service sets out to lay down the conventions and configurations that allow you to create a DB-backed RESTful service. Once the core project structure and operationing is understood, many services may be added to expand on the project.
 
Here is what this little application demonstrates: 

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Writing a RESTful service using annotation: supports both XML and JSON request / response; simply use desired ``Accept`` header in your request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations. 
* Automatic CRUD functionality against the data source using Spring *Repository* pattern

Here are some endpoints you can call:

### Create a note

```
POST /notes
Accept: application/json
Content-Type: application/json

{
    "title" : "Beds R Us",
    "content" : "Very basic, small rooms but clean",
}

RESPONSE: HTTP 200 
Content-Type: application/json;charset=UTF-8

{
    "id": 12,
    "title": "Title of note",
    "content": "<< Body 2 >>",
    "createdAt": "2019-05-27T02:27:47.398+0000",
    "updatedAt": "2019-05-27T02:27:47.398+0000",
    "info": "12/Title of note/<< Body 2 >>"
}
```

### Retrieve a List[] of notes

```
GET /notes

Response: HTTP 200
Content-Type: application/json;charset=UTF-8

[
    {
        "id": 9,
        "title": "Title of note",
        "content": "<< Body >>",
        "createdAt": "2019-05-20T04:00:00.000+0000",
        "updatedAt": "2019-05-20T04:00:00.000+0000",
        "info": "9/Title of note/<< Body >>"
    },
    {
        "id": 10,
        "title": "Title of second note",
        "content": "<< Body 2 >>",
        "createdAt": "2019-05-26T04:00:00.000+0000",
        "updatedAt": "2019-05-26T04:00:00.000+0000",
        "info": "10/Title of second note/<< Body 2 >>"
    }
]

```

### Retrieve a single note

```
GET /notes/{id}

Response: HTTP 200
Content-Type: application/json

{
    "id": 14,
    "title": "Title of aaa",
    "content": "<< Body 2 >>",
    "createdAt": "2019-05-26T04:00:00.000+0000",
    "updatedAt": "2019-05-26T04:00:00.000+0000",
    "info": "14/Title of aaa/<< Body 2 >>"
}

```

### Delete a note

```
DELETE /notes/{id}

RESPONSE: HTTP 200 OK (No Content)
```

### Update a note (replaces title and content)

```

PUT /notes/{id}

RESPONSE: HTTP 200
Content-Type: application/json;charset=UTF-8

{
    "id": 14,
    "title": "New title",
    "content": "New content",
    "createdAt": "2019-05-26T04:00:00.000+0000",
    "updatedAt": "2019-05-27T02:39:24.079+0000",
    "info": "14/New title/New content"
}
```

# About Spring Boot

Spring Boot is an application bootstrapping framework that makes creating a RESTful service easy, as well as other applications. It provides an easy to work with solution to handling these types of applications. In addition, Spring has many add-ons and components that can be added to it to to further develop an application.


### To view the MySQL database

The 'root' profile is hosted on the MySQL database located at port 3036 (as per src/main/resources/application.properties) and the password is set to 'password1234'.
## Local deployment
### Dependencies for Local Development
this application uses spring boot embed server and runs in 8080 port.
Just run the AssignmentApplication class

#### Database:
This application uses an H2 in memory database, once application is running the database is created.
Database credentials and properties(db name, user, password, connection) are in the application.properties file
Once the application stops the Database will be deleted.
If a persistent Database is needed modify in application.properties file like this
```
#spring.datasource.url=jdbc:h2:mem:db_user_manager
spring.datasource.url=jdbc:h2:./src/main/resources/data/db_user_manager
```

#### cURLs:
####Update user
```
PATCH /users/ HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 93

{
    "firstName": "Leandro",
    "lastName": "Erazo",
    "email": "leorb23@gmail.com"
}
```
####search all users
```
GET /users/ HTTP/1.1
Host: localhost:8080
```

####search user by email
```
GET /users/leorb23@gmail.com HTTP/1.1
Host: localhost:8080
```
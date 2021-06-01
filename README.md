# Kotlin-Java Demo ToDo app

Simple ToDo app containing RESTful API written in Java and Kotlin using:
* Spring Data JPA
* Flyway Migration Tool
* PostgresDB 12 (scripts)
* JUnit5


## Steps for setting and running app:
1. Create `todo_db` database in Postgres DB ver 12 using `postgres` both as **username** and **password**
2. Enter directory of `first-java-kotlin-gradle-project` module
3. Execute `./gralew bootRun` command

## Target one of following endpoints:

1. GET all Todo(s) [http://localhost:8080/api/todos](http://localhost:8080/api/todos) <br/>
2. GET Single Todo (with id=1) [http://localhost:8080/api/todos/1](http://localhost:8080/api/todos/1) <br/>
3. POST Todo [http://localhost:8080/api/todos](http://localhost:8080/api/todos) <br/>
   ```json
   {
      "title": "Kotlin app review",
      "description": "Survive the Kotlin app review"
   }
   ```
<br/>4. PATCH Todo [http://localhost:8080/api/todos/3](http://localhost:8080/api/todos/1) <br/>  
```json
    {
        "title": "Push created Kotlin project"
    }
 ```
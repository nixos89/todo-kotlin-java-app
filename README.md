# Kotlin-Java Demo ToDo app

Simple ToDo app containing REST API written in Java and Kotlin using:
* Spring Data JPA
* Flyway Migration Tool
* PostgresDB 12 (scripts)
* JUnit5


## Steps for setting and running app:
1. Create `todo_db` database in Postgres DB ver 12 using following credentials:
   **username**=`postgres`<br/>
   **password**=`system`<br/>
   **NOTE**: Make sure they are matching `spring.datasource.username` / `spring.flyway.user` properties in `application.properties` file
2. Enter directory of `first-java-kotlin-gradle-project` module
3. Make sure  property `spring.flyway.enabled` is set to `true` located in `src/main/resources/application.properties`
4. Execute `./gradlew bootRun` command
5. Before 2nd and every other app run (i.e. before executing Step4) set `spring.flyway.enabled` property to `false` located in `src/main/resources/application.properties` 

## Target one of following endpoints:

1. **GET** all Todo(s) [http://localhost:8080/api/todos](http://localhost:8080/api/todos) <br/>
2. **GET** Single Todo (with id=1) [http://localhost:8080/api/todos/1](http://localhost:8080/api/todos/1) <br/>
3. **POST** Todo [http://localhost:8080/api/todos](http://localhost:8080/api/todos) <br/>
...using following body
```json
   {
      "title": "Kotlin app review",
      "description": "Survive the Kotlin app review"
   }
   ```
4. **PATCH** Todo [http://localhost:8080/api/todos/3](http://localhost:8080/api/todos/3) <br/>
...using following body
```json
    {
        "title": "Push created Kotlin project!!!"
    }
 ```
5. **DELETE** Todo [http://localhost:8080/api/todos/2](http://localhost:8080/api/todos/2) <br/>
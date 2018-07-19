# Spring boot mybatis h2db demo
<table>
<tr>
<td>
  This is Create, Read, Update, Delete Restful API for Advertisers based in Spring Boot, Java 8, Rest API, MyBatis, H2 DD, Junit, Jacoco, Swagger2, Gradle 
</td>
</tr>
</table>


## Built with 

- [Java 8](https://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Java 8 is a revolutionary release of the world’s #1 development platform. It includes a huge upgrade to the Java programming model and a coordinated evolution of the JVM, Java language, and libraries.
- [Spring Boot](http://spring.io/projects/spring-boot) - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".                                                         
- [H2 DB](http://www.h2database.com/html/main.html) - H2 DB, the Java SQL database
- [MyBatis](http://www.mybatis.org/mybatis-3/) - MyBatis is a first class persistence framework with support for custom SQL, stored procedures and advanced mappings.
- [Jacoco](https://www.eclemma.org/jacoco/) - JaCoCo is a free code coverage library for Java, which has been created by the EclEmma team based on the lessons learned from using and integration existing libraries for many years.
- [JUnit](https://junit.org/junit5/) - JUnit 5 is the next generation of JUnit. The goal is to create an up-to-date foundation for developer-side testing on the JVM. This includes focusing on Java 8 and above, as well as enabling many different styles of testing.
- [Swagger2](https://swagger.io/) - Swagger is an open source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services. You can access it thru this - [Localhost Swagger2 Link](http://localhost:8080/swagger-ui.html)

- [Gradle](https://gradle.org/) - Gradle is an open-source build automation tool focused on flexibility and performance. Gradle build scripts are written using a Groovy or Kotlin DSL


## [Usage] 

You can do all CRUD (Create, Read, Update, Delete) operations and one extra validation for advertiser if eligible for transaction operation. Here is how:


### Create (with JSON object)

You can easily add a record using the POST method (x-www-form-urlencoded, see rfc1738). The call returns the "int".

```
POST http://localhost:8090/api/advertisers

Payload:
{
    "advertiserName": "Advertiser01",
    "advertiserContactName": "Alisson Krauss",
    "creditLimit": 12000
}
```

Output:

```
1
```

```$ curl -X POST "http://localhost:8090/api/advertiser" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"advertiserContactName\": \"string\", \"advertiserName\": \"string\", \"creditLimit\": 0}" ```


### Read

If you want to read a single object you can use:

```
GET http://localhost:8090/api/advertisers/10001
```

Output:

```
{
  "advertiserName": "Inmobi",
  "advertiserContactName": "Will SMith",
  "creditLimit": 10000
}
```

``` $ curl -X GET "http://localhost:8090/api/advertiser/10001" -H "accept: */*"```

### Update (with JSON object)

Editing a record is done with the PUT method. The call returns the number of rows affected.

```
PUT http://localhost:8090/api/advertisers/

Payload:
{
  "advertiserName": "Inmobi",
  "advertiserContactName": "Will SMith",
  "creditLimit": 12000
}
```

Output:

```
1
```

``` $ curl -X PUT "http://localhost:8090/api/advertiser/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"advertiserContactName\": \"Inmobi\", \"advertiserName\": \"string\", \"creditLimit\": 10}"```

Note that only fields that are specified in the request will be updated.


### Delete

The DELETE verb is used to delete a record. The call returns int.

```
DELETE http://localhost:8090/api/advertisers/10001
```

Output:

```
1
```

``` $ curl -X DELETE "http://localhost:8090/api/advertiser/10005" -H "accept: */*"```

### Validate Advertiser Credit Limit

The GET verb is used to retrieve a record. This retrieves the Advertiser and validate if it has a Credit Limit to do a Transaction. This returns the Adveriser if It has a credit but return Advertiser Not Allowed if it has no credit

```
GET http://localhost:8090/api/advertiser/validate/10003
```

Output:

```
1
```

``` $ curl -X GET "http://localhost:8090/api/advertiser/validate/10003" -H "accept: */*""```



### Generate executable
```./gradlew build && java -jar <your file name>.jar```
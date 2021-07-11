# Introduction
A small application to reproduce the error from [this](https://stackoverflow.com/questions/67922344/logback-does-not-log-constraintviolationexception-in-spring-boots-exceptionhan) Stackoverflow question.

## Running the application
Running as a java project should be all fine


When running the application, the request

```
http://localhost:8080/endpointurl/?CustomQueryParameter=700x
```

will trigger the `ConstraintViolationException`.


**NOTE**: The application is a stripped version of my works project, so if something looks odd, like Danish names or unnused code, it is just because I have overlooked it, when creating this example.
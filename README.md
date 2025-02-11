# Accessing Data JPA Modified

## Description

This repo adapts the tutorial found 
[here](https://spring.io/guides/gs/accessing-data-jpa)
to add:

* Data persistence for increased usefulness.
* Null checks for increased reliability.
* Spring web for database console functionality.

## Run Instructions

### Command Line

Clone the repo, cd into repo root, then:

```
./gradlew bootRun
```

You should see a bunch of output eventually and some logging of the db contents.

If you want to use the H2 Console to inspect the db contents, visit [http://localhost:8080/h2](http://localhost:8080/h2) while the app is running, and click Connect.

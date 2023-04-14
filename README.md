# booking-api

Kotlin based Spring Boot application.

## Table of Contents
* [Resources](#resources)
* [What does it include/use?](#what-does-it-includeuse)
* [Dependencies included with Spring Boot Framework](#dependencies-included-with-spring-boot-framework)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Development](#development)



## Resources
* [Spring Boot](https://spring.io/projects/spring-boot)

## What does it include/use?

- Gradle 7.5.1
- Java 18
- Spring Boot 2.7.5 (Compatible with Java 17 && Kotlin)

## Dependencies included with Spring Boot Framework

- Spring Web package (Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.)
- Spring Boot Actuator (Supports built in (or custom) endpoints that let you monitor and manage your application - such as application health, metrics, sessions, etc.)

### About the Architecture

The base folder structure was based on Hexagonal Architecure:
![image](https://user-images.githubusercontent.com/15172908/202044518-36d720d3-fadc-41d4-8696-e9787a685f75.png)


_Note: It is recommended to rename the main package name inside the `src/main/kotlin` folder, to match the name of your project/domain._

## Getting started
### Prerequisites

**Required JDK**
- [JDK](https://www.oracle.com/java/technologies/downloads/)
    * Download the latest version compatible with Kotlin.

- At the moment the Docker development is slow, we recommend using [IntelliJ IDEA](https://www.jetbrains.com/idea/) for the application, and the rest of dependencies using [Docker](https://docs.docker.com/desktop/mac/install/)

**Required Tools**
- [Docker](https://docs.docker.com/desktop/mac/install/)
    * Also available via HomeBrew, `brew install docker docker-compose && brew cask install docker`
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=mac)

**Configure your IDE**
- As stated, we use IntelliJ IDEA to spin up the application, the IDE should be smart enough to configure everything except environment variables, you need to expose these through:
    - Edit configuration (**BookingApplication**) -> *Modify Options* -> *Operating System* -> enable Environment Variables.


### Development

Clone this repository:
```bash
git clone git@github.com:shaydaroglu/booking-api.git
```

Run
```bash
docker-compose up -d mysql
```
After this is done, run the service using your IDE, you should be able to load (**http://127.0.0.1:8080/healthcheck**) and be greeted with:
```text
{
	"booking-api": "is_alive"
}
```



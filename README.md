# Binary Search Tree REST API

Simple Spring Boot application that exposes adding and searching numbers in binary tree via REST Api.

## Prerequisites
- Java 11

## Build

- Run `./mvnw clean install` to build the application.
- Run `./mvnw spring-boot:run` to run.

## Usage

Following endpoints implemented:

- Get tree structure in XML format.
    - GET `/api/v1/`
- Get distance from root node for particular number.
    - GET `/api/v1/{number}`
- Add number to the tree.
    - POST `/api/v1/{number}`
- Delete number from tree.
    - DELETE `/api/v1/{number}`

In case of adding a duplicate number, deleting non-existing number, or trying to delete number with child nodes - 
exception will be thrown and correlated messages will be given to the requester.

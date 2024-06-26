# Cybrary (Java)
Simple web app for posting and searching e-books using Java, Spring framework and the MVC architecture.
<br/>
<br/>

## Table of contents
0. [Project status](#Project-status)
1. [Description](#Description)
3. [Key features and functionalities](#Key-features-and-functionalities)
4. [Structure](#Structure)
5. [Installation instructions](#Installation-instructions)
6. [Dependencies](#Dependencies)
7. [System requirements](#System-requirements)
8. [Usage examples](#Usage-examples)
9. [API references](#API-references)
10. [Bugs](#Bugs)
11. [Future improvements](#Futute-improvements)
<br/>

## Project status
Completed and working. Not expecting changes.
<br/>
<br/>

## Description
The purpose and goal of the project is to create an MVC project using Java and Spring framework.

The intended audiences for the project are the teacher in my web programming - java servlets class and myself.
<br/>
<br/>

## Key features and functionalities
* ### KEY FEATURES
  * Users can browse books without an account but can't post books;
  * Users can register an account;
  * Users can login with a registered account;
  * Logged users can upload books;
  * Users can search books using the search bar and also apply filters.
 
* ### FUNCTIONALITIES
  * Custom user;
  * Java SQL Database connector;
  * Search and Filtering.
<br/>

## Structutre
Here are some of the important directories and files you need to know about this project:
* `pom.xml`- config file for dependencies;
* `src/main/resources`:
  * `application.properties` - config file for the database and user;
  * `templates` - folder, containing frontend web page files.
* `src/main/java/com/project/cybrary`:
  * `book` - folder, containing the files for the book entity;
  * `user` - folder, containing the files for the user entity;
  * `CybraryApplication.java` - the source file to run the application.
<br/>

## Installation instructions
Usually, the project is supposed to be hosted on a server and given a domain. However, I don't have a HomeLab or am I able to rent a server or a domain. Instead:
1. Download this project;
2. Open the Project in Apache NetBeans;
4. Ensure you have all the needed dependencies (from `pom.xml`);
5. Start an instance of Apache Tomcat Server;
6. Ensure you are connecting to your local database;
7. Build the project. You should have access now.
<br/>

## Dependencies
This is a list of dependencies that you need if you want to run the project locally. Aside from **an internet connection**, you will need:
* Apache NetBeans;
* Java 17;
* Apache Tomcat Server 9.0.71;
* Java SQL connector?;
* Maven build system;
* Packages (from `pom.xml`):
  * org.springframework.boot:
    * spring-boot-maven-plugin;
    * spring-boot-starter-data-jpa;
    * spring-boot-starter-test;
    * spring-boot-starter-web;
    * spring-boot-starter-thymeleaf;
    * spring-boot-starter-security;
    * spring-boot-starter-validation.
  * org.springframework.security:
    * spring-security-test.
  * com.mysql:
    * mysql-connector-j. 
<br/>

## System requirements
The project has been developed for the Miscrosoft Windows operating system.
| System requirements  |
| -------------------- | 
| Microsoft Windows 10 | 
<br/>

## Usage examples
We assume that the project has been accessed on the internet or has been run on a local instance. 
<br/>

1. For unregistered users:
  * They can look at books and search for them, but not edit;
  * They can register and/or login.
2. For logged-in users:
  * They can create their own books;
  * They can search for books.
3. For Administrators:
<br/>

## API references
Nothing to mention here.
<br/>
<br/>

## Bugs
- [x] No bugs have been caught.
<br/>

## Future improvements
- [ ] Pick a domain for the website and a hosting solution;
- [ ] Implement a simple frontend.

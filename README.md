# Spotify Social Media Web Application

## Project Structure

### Frontend (React Application)

Located in the [```spotify_social_media/```](./spotify_social_media/README.md) directory

### Backend (Java + Springboot API)

Located in the [```SSMApplication/```](./SSMApplication/README.md) directory

### Database (MySQL - Queries uses to setup the local database)

Located in the [```database-setup-queries/```](./database-setup-queries/README.md) directory

## Development Environment

### Pre-requisites

- NodeJS v18.18.0, npm v9.8.1

- Java OPENJDK JDK/JRE v17

- MySQL Server v5.7.38

- CLIENT IDE: Visual Studio Code v1.82+

  - (Open folder with Client source code)

- SERVER IDE: Eclipse IDE for Enterprise Java and Web Developers v2022-06

  - (Open Projects from File System..., select Server source code folder)

- MYSQL IDE:  MySQL Workbench v8.0+

  - (Create localhost connection to {database_name} with user {db_username})

- API client: Postman v10.18+

### Setup

#### CLIENT SETUP

- Install nvm 0.39.1+

- Install NodeJS v18.18.0

  - ```# nvm install 18.18.0```
  
- Remove create-react-app module

  - ```# npm uninstall -g create-react-app```

- Create app with create-react-app and typescript (replace {name_of_app} with your app name)

  - ```# npx create-react-app {name_of_app} --template typescript```

#### SERVER SETUP

- Create base project in [Spring Boot](http://start.spring.io)

  - Select Maven or Gradle-Groovy(preferred)

  - Select Java 17 and Spring Boot 3.2.3

  - Fill project values in form or leave default

  - Select dependency Spring Web (spring-boot-starter-web)

  - Select dependency Rest Repositories (spring-boot-starter-data-jpa)

  - Generate Project (a zip file will be downloaded with the project files)

#### DATABASE SETUP

##### MYSQL SERVER

- Install locally MySQL v5.7.38

  - Select root password

- Connect to MySQL via localhost

  - ```# mysql -u root -p```

- Create database

  - ```mysql>create database {database_name};```

- Create user for database

  - ```mysql>CREATE USER '{db_username}'@'localhost' IDENTIFIED BY '{db_strong_password}';```

- Grant all permissions to user for this database

  - ```mysql>GRANT ALL ON {database_name}.* TO '{db_username}'@'localhost';```

***Note: As an alternative the database can be managed with H2(easier) or Postgresql***

## See Also

### Client Example

- [ITNext](https://itnext.io/build-a-react-redux-with-typescript-using-redux-toolkit-package-d17337aa6e39)

### Server Example

- [Geeks for Geeks](https://www.geeksforgeeks.org/spring-boot-spring-data-jpa/)

### Database Examples

- Console: [W3Schools](https://www.w3schools.com/python/python_mysql_create_db.asp)

- MySQL Workbench: [YouTube](https://www.youtube.com/watch?v=ImqxBiv5yIY)

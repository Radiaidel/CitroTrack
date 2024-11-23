# CitroTrack Project

## Project Overview

**CitroTrack** is a farm management application developed to help citrus farmers track the production, harvesting, and sale of their crops. The application allows for effective management of farms, fields, trees, harvests, and sales while optimizing the tracking of tree productivity based on their age.

## Key Features

### Farm Management
- Create, update, and view farm information (name, location, size, creation date).
- Multicriteria search using the Criteria Builder.

### Field Management
- Associate fields with a farm with a defined area.
- Ensure consistency of field sizes: the total area of fields in a farm must be strictly less than the farm’s total area.

### Tree Management
- Track trees by their plantation date, age, and field association.
- Calculate tree age.
- Determine annual productivity based on tree age:
    - Young tree (< 3 years): 2.5 kg/season
    - Mature tree (3-10 years): 12 kg/season
    - Old tree (> 10 years): 20 kg/season

### Harvest Management
- Track harvests per season (winter, spring, summer, autumn).
- Only one harvest per season (every 3 months).
- Record harvest date and total amount collected.

### Harvest Detail Tracking
- Track the amount harvested per tree in a given harvest.
- Associate each harvest detail with a specific tree.

### Sales Management
- Record sales with date, unit price, client, and associated harvest.
- Calculate revenue: Revenue = quantity * unit price.

## Constraints
- **Minimum field size**: A field must have a minimum area of 0.1 hectares (1,000 m²).
- **Maximum field size**: No field can exceed 50% of the farm's total area.
- **Maximum number of fields**: A farm can have no more than 10 fields.
- **Tree spacing**: Each field must contain enough trees so that the maximum density is 100 trees per hectare (10 trees per 1,000 m²).
- **Tree lifespan**: Trees can only be productive for up to 20 years; after this, they are considered non-productive.
- **Planting period**: Trees can only be planted between March and May.
- **Seasonal limit**: Each field can only be associated with one harvest per season.
- **No double harvests**: A tree cannot be part of more than one harvest for the same season.

## Technologies Used

- **Backend**: Java 23
- **Database**: PostgreSQL
- **API**: Spring Boot (REST API)
- **Others**: Spring Validation, Lombok, MapStruct, JUnit, Mockito

## How to Execute the Project

To run the CitroTrack project on your local machine, follow these steps:

### 1. Clone the Repository

```bash
git clone https://github.com/Radiaidel/CitroTrack
cd citroTrack
````

## 2. Set Up PostgreSQL Database

Make sure you have PostgreSQL installed and running. You will need to configure the database in `application.yaml`.

## 3. Configure `application.yaml`

In the `src/main/resources` folder, open `application.yaml` and configure the database connection with your PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/citrotrack_db
    username: your_db_username
    password: your_db_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
````

## 4. Build and Run the Application

If you are using Maven, you can build and run the application with the following commands:

```bash
mvn clean install
mvn spring-boot:run
````

## 5. Access the API

Once the application is running, you can test the endpoints using **Postman** or **Swagger** if it's enabled in your project. The API documentation should provide detailed information about the available endpoints.

If Swagger is enabled, you can access the API documentation at the following URL:

http://localhost:8080/swagger-ui.html

This link will lead you to the Swagger interface where you can interact with the API and explore its endpoints.
Replace localhost:8080 with the actual URL or port if your application is configured differently.

## Author
Idelkadi Radia 
[idelkadiradia@gmail.com]
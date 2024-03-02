# Spring Boot Employee Application

This is a simple Spring Boot application that demonstrates a RESTful API for managing employee data.

## Prerequisites

Before running the application, ensure you have the following installed on your machine:

- [Java Development Kit (JDK)](https://adoptopenjdk.net/)
- [Apache Maven](https://maven.apache.org/) (or use the included `mvnw` wrapper)

## Running the Application

Follow these steps to run the Spring Boot application:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/julito93/CJ-DEMO.git
   cd CJ-DEMO
   
2. **Build the application**
   ```bash 
   ./mvnw clean install
   
3. **Run the application:**
   ```bash 
   ./mvnw spring-boot:run
   
3. **Test the controller in the web Browser**
   * For happyPath http://localhost:8080/api/employees/0
   * For edge case with no name http://localhost:8080/api/employees/1
   * For edge case with no amount http://localhost:8080/api/employees/2
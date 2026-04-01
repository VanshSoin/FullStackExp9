🧪 Experiment Title
Implementation of JWT-Based Authentication using Spring Boot, MySQL, and Postman (Developed in Eclipse IDE)

<img width="1918" height="1023" alt="Screenshot 2026-04-01 122023" src="https://github.com/user-attachments/assets/810dd643-636e-4c38-8baf-cf689e154aa6" />

🎯 Aim
To build and verify a JWT (JSON Web Token) authentication system in a Spring Boot REST API using MySQL for user data storage and Postman for endpoint testing, with full development performed in Eclipse IDE.

🧰 Software/Tools Used
Eclipse IDE (development environment)
Java
Spring Boot
Spring Security
Spring Data JPA (Hibernate)
MySQL
Postman
Maven
📘 Theory
JWT (JSON Web Token) is a compact and secure token format used for stateless authentication in web applications.
Unlike session-based authentication, JWT does not require storing session data on the server for each user.

When a user logs in:

Credentials are sent to the server.
Server validates credentials against database records.
If valid, server generates a signed JWT and returns it.
Client stores this token and sends it in future requests.
Structure of JWT
A JWT has 3 parts separated by dots (.):

Header 🧩
Contains token type and algorithm (e.g., HS256).
Payload 📦
Contains claims such as username, issued time, and expiration.
Signature 🔐
Generated using a secret key and algorithm to ensure token integrity.
If token payload is modified, signature verification fails, so tampering is detected.

⚙️ What Was Implemented in This Experiment
1. Project Setup in Eclipse IDE
Created a Spring Boot project using Maven.
Organized the project into layers:
controller
service
repository
model
security
config
2. Database Configuration
Configured MySQL connection in application.properties.
Used database: jwt_demo.
Enabled Hibernate auto schema update (ddl-auto=update).
3. Entity and Repository Layer
Created User entity mapped to users table with:
id
username
password
Created UserRepository with method:
findByUsername(String username)
4. Service Layer Logic
Implemented AuthService:
fetch user by username from DB
compare password
generate token if credentials are valid
return "Invalid Credentials" if invalid
5. JWT Utility
Implemented JwtUtil class:
generates JWT token with:
subject = username
issued time
expiry = 1 hour
signs token with HS256 algorithm and secret key
includes method to extract username from token
6. Controller Endpoints
Implemented AuthController with:
POST /api/login → accepts username/password and returns JWT token on success
GET /api/hello → basic endpoint for response/testing
7. Security Configuration
Added SecurityConfig to define Spring Security behavior.
CSRF disabled for API testing flow.
Requests permitted in current setup for simplified experiment execution.
8. Application Execution
Ran project from Eclipse/Maven.
Application started on:
http://localhost:8080
Verified successful DB connection and Spring Boot startup logs.
9. Postman Testing
Connected API to Postman.
Sent login request to /api/login with valid credentials.
Successfully received JWT token in response ✅
This confirmed that authentication and token generation worked correctly.
✅ Result
JWT authentication flow was successfully implemented and tested.
MySQL-based user validation worked.
Token generation was successful on valid login.
Postman integration confirmed end-to-end operation.
🧾 Conclusion
This experiment successfully demonstrates a real-world stateless authentication mechanism using JWT in Spring Boot.
The system validates user credentials from MySQL and returns a signed token for authenticated use.
Development in Eclipse IDE and API testing in Postman validated complete practical understanding of JWT-based authentication architecture.

🌟 Additional Discussion Points (for report enrichment)
Passwords should be stored in hashed form (e.g., BCrypt) in production.
JWT should be validated via filter on protected endpoints.
Secret key and DB credentials should be externalized (environment variables).
Token refresh and role-based claims can be added for advanced security.

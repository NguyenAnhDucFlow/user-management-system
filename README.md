User Management System
Overview
This project is a User Management System built with Spring Boot for the backend and ReactJS with Vite for the frontend. The system includes features such as user registration, login, role-based access control (admin, regular user), personal information update, password recovery, two-factor authentication (2FA), and Google login.

Technologies
Backend: Spring Boot
Frontend: ReactJS with Vite
Database: H2 (for development), PostgreSQL (for production)
Authentication: JWT, Spring Security
2FA: Google Authenticator
OAuth2: Google
Features
User Registration: Allows new users to create an account.
User Login: Enables users to log in with their credentials.
Role-Based Access Control: Differentiates access between admin and regular users.
Personal Information Update: Allows users to update their personal information.
Password Recovery: Provides a way for users to reset their passwords.
Two-Factor Authentication (2FA): Enhances security with an additional authentication step.
Google Login: Allows users to log in using their Google accounts.
Installation
Prerequisites
Java 11 or higher
Node.js 14 or higher
PostgreSQL
Backend Setup
Clone the repository:

bash
Sao chép mã
git clone https://github.com/your-username/user-management-system.git
cd user-management-system/backend
Configure the database in application.properties:

properties
Sao chép mã
spring.datasource.url=jdbc:postgresql://localhost:5432/user_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Build and run the Spring Boot application:

bash
Sao chép mã
./mvnw clean install
./mvnw spring-boot:run
Frontend Setup
Navigate to the frontend directory:

bash
Sao chép mã
cd ../frontend
Install dependencies:

bash
Sao chép mã
npm install
Start the development server:

bash
Sao chép mã
npm run dev
Usage
User Registration
Endpoint: POST /api/auth/register
Request Body:
json
Sao chép mã
{
    "username": "exampleUser",
    "email": "user@example.com",
    "password": "password123"
}
User Login
Endpoint: POST /api/auth/login
Request Body:
json
Sao chép mã
{
    "username": "exampleUser",
    "password": "password123"
}
Personal Information Update
Endpoint: PUT /api/user/update
Request Body:
json
Sao chép mã
{
    "email": "newemail@example.com",
    "phoneNumber": "1234567890"
}
Password Recovery
Endpoint: POST /api/auth/recover
Request Body:
json
Sao chép mã
{
    "email": "user@example.com"
}
Two-Factor Authentication (2FA)
Enable 2FA: POST /api/auth/2fa/enable
Verify 2FA: POST /api/auth/2fa/verify
Google Login
Endpoint: GET /oauth2/authorization/google
Project Structure
Backend
css
Sao chép mã
src
└── main
    ├── java
    │   └── com.example.usermanagement
    │       ├── config
    │       ├── controller
    │       ├── model
    │       ├── repository
    │       ├── service
    │       └── UserManagementApplication.java
    └── resources
        ├── application.properties
        └── templates
Frontend
css
Sao chép mã
src
└── components
    ├── Auth
    ├── User
    ├── Admin
    └── App.js
Contributing
Contributions are welcome! Please create a pull request or open an issue to discuss what you would like to change.

License
This project is licensed under the MIT License.


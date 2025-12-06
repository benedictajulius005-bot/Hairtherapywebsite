# Hair Therapy Website  
### Modern Web Platform for Booking Hair Treatments & Managing Salon Operations

---

## 📌 Overview  
The **Hair Therapy Website** is a full-stack web application designed to help clients book hair treatment sessions and allow administrators to manage users, bookings, services, and website content.

This project was developed as part of the **Hair Therapy Team Project**, using Spring Boot, Thymeleaf, and a well-structured MVC architecture.

---

## 🚀 Features

### 👤 User Features
- User registration & login  
- User role selection (CLIENT / STYLIST / ADMIN)  
- Book hair treatment services  
- View available services  
- Access blog posts  
- Personal dashboard  

### 🛠️ Admin Features
- Manage users  
- Manage services  
- Approve or delete bookings  
- Publish blog posts  
- Overall dashboard management  

---

## 🏗️ System Architecture
Built using **Spring Boot MVC**:

- **Controller Layer** → Handles routes  
- **Service Layer** → Core business logic  
- **Repository Layer** → Database access via JPA  
- **Thymeleaf Templates** → Dynamic server-side rendering  
- **MySQL Database** → Persistent storage  

---


---

## 📦 Technologies Used

### 🖥️ Frontend
- HTML5  
- CSS3  
- Bootstrap  
- JavaScript  
- Thymeleaf  

### 🔧 Backend
- Java 17+  
- Spring Boot  
- Spring MVC  
- Spring Data JPA  
- Lombok  

### 🗄️ Database
- MySQL (or H2 for testing)

### 🔨 Build Tool
- Maven

---

## 🔧 How to Run the Project

###  Clone the repository  
```bash
git clone https://github.com/your-repo-url

###  Open:
src/main/resources/application.properties

###  Add your MySQL credentials:
spring.datasource.url=jdbc:mysql://localhost:3306/hairtherapy
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

###  Run the app:
mvn spring-boot:run

###  Open the app:
http://localhost:9191/

###  📄 User Documentation
The full user manual is available here:
/docs/HairTherapy_User_Documentation.pdf






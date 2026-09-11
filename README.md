

# Smart Campus Management System

## Overview

The Smart Campus Management System is a Java-based console application designed to manage common campus activities through a centralized system.

The application provides separate modules for student management, attendance management, event management, complaint management, and an administrative dashboard.

The project follows a modular structure using Java classes and packages to make the system organized, maintainable, and easy to extend.

## Features

### 1. Student Management

- Add new students
- View all students
- Search students using Student ID
- Delete student records
- Prevent duplicate Student IDs

### 2. Attendance Management

- Record student attendance
- Calculate attendance percentage
- View attendance records for a student
- Validate attendance values
- Display a warning when attendance is below 75%

### 3. Event Management

- Create campus events
- View available events
- Register students for events
- Prevent duplicate event registration
- Prevent registration when an event is full

### 4. Complaint Management

- Submit complaints
- View submitted complaints
- Update complaint status
- Manage complaint statuses:
  - PENDING
  - IN_PROGRESS
  - RESOLVED

### 5. Admin Dashboard

- Display total number of students
- Display total attendance records
- Display total events
- Display total complaints
- Display pending, in-progress, and resolved complaints
- Display system status

### 6. Input Validation and Error Handling

- Handles invalid numeric input
- Prevents duplicate student and event IDs
- Validates attendance values
- Validates event capacity
- Checks whether students and events exist before related operations
- Includes a custom `CampusException` class

## Technologies Used

- **Programming Language:** Java
- **Concepts:** Object-Oriented Programming, Abstraction, Inheritance, Method Overriding, Encapsulation
- **Collections:** ArrayList
- **Exception Handling:** Java Exception Handling and Custom Exception
- **IDE:** Visual Studio Code
- **Version Control:** Git
- **Repository:** GitHub

## Project Structure

```text
SmartCampusManagementSystem
│
├── src
│   ├── Main.java
│   │
│   ├── exception
│   │   └── CampusException.java
│   │
│   ├── model
│   │   ├── Person.java
│   │   ├── Student.java
│   │   ├── Attendance.java
│   │   ├── Event.java
│   │   └── Complaint.java
│   │
│   └── service
│       ├── StudentService.java
│       ├── AttendanceService.java
│       ├── EventService.java
│       └── ComplaintService.java
│
├── .gitignore
└── README.md
Requirements

Requirements to run this project :-

Java Development Kit (JDK)
Visual Studio Code or any Java-compatible IDE
Git (optional, for version control)

How to Run this project ?
1. Open the Project

Open the SmartCampusManagementSystem folder in Visual Studio Code.

2. Compile the Project

Open the terminal in the project folder and run:

javac -d out src\Main.java src\model\*.java src\service\*.java src\exception\*.java

3. Run the Application
java -cp out Main

The Smart Campus Management System main menu will appear in the terminal.

Testing :-

The major modules of the application were tested through console-based validation.

The following functionalities were tested:

-Student addition and viewing
-Student search
-Student deletion
-Attendance recording
-Attendance percentage calculation
-Attendance validation
-Event creation
-Student event registration
-Complaint submission
-Complaint status updates
-Admin dashboard
-Invalid input handling

Example Attendance Test
Student ID       : 101
Subject          : Programming in Java
Classes Held     : 40
Classes Attended : 32
Attendance       : 80.00%
Status           : Satisfactory

The application successfully calculated the attendance percentage and displayed the appropriate status.

Error Handling :-

The application handles several invalid situations, including:

Invalid integer or decimal input
Duplicate Student IDs
Duplicate Event IDs
Invalid attendance values
Invalid event capacity
Non-existent students
Non-existent events
Non-existent complaints
Invalid complaint status selection

Future Enhancements :-

The system can be further enhanced by:

Adding a graphical user interface
Adding database connectivity
Adding user authentication and login
Adding faculty and administrator accounts
Providing persistent data storage
Developing a web or mobile-based version

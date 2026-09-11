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

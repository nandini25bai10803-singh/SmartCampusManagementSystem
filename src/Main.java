 import java.util.Scanner;
import java.util.ArrayList;

import model.Student;
import model.Attendance;
import model.Event;
import model.Complaint;

import service.StudentService;
import service.AttendanceService;
import service.EventService;
import service.ComplaintService;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static StudentService studentService = new StudentService();
    static AttendanceService attendanceService = new AttendanceService();
    static EventService eventService = new EventService();
    static ComplaintService complaintService = new ComplaintService();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n==========================================");
            System.out.println("       SMART CAMPUS MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Student Management");
            System.out.println("2. Attendance Management");
            System.out.println("3. Event Management");
            System.out.println("4. Complaint Management");
            System.out.println("5. Admin Dashboard");
            System.out.println("0. Exit");
            System.out.println("==========================================");

            choice = getInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    studentMenu();
                    break;

                case 2:
                    attendanceMenu();
                    break;

                case 3:
                    eventMenu();
                    break;

                case 4:
                    complaintMenu();
                    break;

                case 5:
                    dashboard();
                    break;

                case 0:
                    System.out.println(
                            "\nThank you for using Smart Campus Management System!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }

    // =====================================================
    // STUDENT MANAGEMENT
    // =====================================================

    static void studentMenu() {

        int choice;

        do {
            System.out.println("\n----------- STUDENT MANAGEMENT -----------");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("0. Back");

            choice = getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    static void addStudent() {

        int id = getInt("Enter Student ID: ");

        if (studentService.findStudent(id) != null) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        int year = getInt("Enter Year: ");
        double cgpa = getDouble("Enter CGPA: ");

        Student student = new Student(
                id, name, email, course, branch, year, cgpa
        );

        if (studentService.addStudent(student)) {
            System.out.println("\nStudent added successfully!");
        }
    }

    static void viewStudents() {

        ArrayList<Student> students =
                studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n========== ALL STUDENTS ==========");

        for (Student student : students) {
            student.displayDetails();
        }
    }

    static void searchStudent() {

        int id = getInt("Enter Student ID: ");

        Student student = studentService.findStudent(id);

        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {

        int id = getInt("Enter Student ID: ");

        if (studentService.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // =====================================================
    // ATTENDANCE MANAGEMENT
    // =====================================================

    static void attendanceMenu() {

        int choice;

        do {
            System.out.println("\n----------- ATTENDANCE MANAGEMENT -----------");
            System.out.println("1. Record Attendance");
            System.out.println("2. View Student Attendance");
            System.out.println("0. Back");

            choice = getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    recordAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    static void recordAttendance() {

        int studentId = getInt("Enter Student ID: ");

        if (studentService.findStudent(studentId) == null) {
            System.out.println("Student does not exist.");
            return;
        }

        System.out.print("Enter Subject: ");
        String subject = sc.nextLine();

        int held = getInt("Enter Classes Held: ");
        int attended = getInt("Enter Classes Attended: ");

        if (held <= 0 || attended < 0 || attended > held) {
            System.out.println("Invalid attendance values.");
            return;
        }

        Attendance attendance = new Attendance(
                studentId,
                subject,
                held,
                attended
        );

        attendanceService.recordAttendance(attendance);

        double percentage = attendance.calculatePercentage();

        System.out.println("\nAttendance recorded successfully!");

        System.out.printf(
                "Attendance Percentage: %.2f%%\n",
                percentage
        );

        if (percentage < 75) {
            System.out.println(
                    "WARNING: Student has low attendance!"
            );
        } else {
            System.out.println("Status: Satisfactory");
        }
    }

    static void viewAttendance() {

        int studentId = getInt("Enter Student ID: ");

        ArrayList<Attendance> records =
                attendanceService.getStudentAttendance(studentId);

        if (records.isEmpty()) {
            System.out.println("No attendance record found.");
            return;
        }

        for (Attendance attendance : records) {
            attendance.displayAttendance();
        }
    }

    // =====================================================
    // EVENT MANAGEMENT
    // =====================================================

    static void eventMenu() {

        int choice;

        do {
            System.out.println("\n----------- EVENT MANAGEMENT -----------");
            System.out.println("1. Create Event");
            System.out.println("2. View Events");
            System.out.println("3. Register Student");
            System.out.println("0. Back");

            choice = getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    createEvent();
                    break;

                case 2:
                    viewEvents();
                    break;

                case 3:
                    registerStudent();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    static void createEvent() {

        int eventId = getInt("Enter Event ID: ");

        if (eventService.findEvent(eventId) != null) {
            System.out.println("Event ID already exists!");
            return;
        }

        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        System.out.print("Enter Venue: ");
        String venue = sc.nextLine();

        int capacity = getInt("Enter Capacity: ");

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than 0.");
            return;
        }

        Event event = new Event(
                eventId,
                name,
                description,
                date,
                venue,
                capacity
        );

        if (eventService.addEvent(event)) {
            System.out.println("\nEvent created successfully!");
        }
    }

    static void viewEvents() {

        ArrayList<Event> events =
                eventService.getAllEvents();

        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }

        System.out.println("\n========== CAMPUS EVENTS ==========");

        for (Event event : events) {
            event.displayEvent();
        }
    }

    static void registerStudent() {

        int eventId = getInt("Enter Event ID: ");
        int studentId = getInt("Enter Student ID: ");

        if (studentService.findStudent(studentId) == null) {
            System.out.println("Student does not exist.");
            return;
        }

        Event event = eventService.findEvent(eventId);

        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        if (event.registerStudent(studentId)) {
            System.out.println(
                    "Student registered successfully!"
            );
        } else {
            System.out.println(
                    "Registration failed. Event may be full "
                    + "or student is already registered."
            );
        }
    }

    // =====================================================
    // COMPLAINT MANAGEMENT
    // =====================================================

    static void complaintMenu() {

        int choice;

        do {
            System.out.println("\n----------- COMPLAINT MANAGEMENT -----------");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Complaint Status");
            System.out.println("0. Back");

            choice = getInt("Enter choice: ");

            switch (choice) {

                case 1:
                    submitComplaint();
                    break;

                case 2:
                    viewComplaints();
                    break;

                case 3:
                    updateComplaint();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    static void submitComplaint() {

        int complaintId =
                getInt("Enter Complaint ID: ");

        if (complaintService.findComplaint(complaintId) != null) {
            System.out.println("Complaint ID already exists!");
            return;
        }

        int studentId =
                getInt("Enter Student ID: ");

        if (studentService.findStudent(studentId) == null) {
            System.out.println("Student does not exist.");
            return;
        }

        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Description: ");
        String description = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        Complaint complaint = new Complaint(
                complaintId,
                studentId,
                category,
                description,
                date
        );

        if (complaintService.addComplaint(complaint)) {
            System.out.println(
                    "\nComplaint submitted successfully!"
            );
        }
    }

    static void viewComplaints() {

        ArrayList<Complaint> complaints =
                complaintService.getAllComplaints();

        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
            return;
        }

        System.out.println("\n========== COMPLAINTS ==========");

        for (Complaint complaint : complaints) {
            complaint.displayComplaint();
        }
    }

    static void updateComplaint() {

        int id = getInt("Enter Complaint ID: ");

        Complaint complaint =
                complaintService.findComplaint(id);

        if (complaint == null) {
            System.out.println("Complaint not found.");
            return;
        }

        System.out.println("\nSelect New Status:");
        System.out.println("1. PENDING");
        System.out.println("2. IN_PROGRESS");
        System.out.println("3. RESOLVED");

        int choice = getInt("Enter choice: ");

        String status;

        switch (choice) {

            case 1:
                status = "PENDING";
                break;

            case 2:
                status = "IN_PROGRESS";
                break;

            case 3:
                status = "RESOLVED";
                break;

            default:
                System.out.println("Invalid status.");
                return;
        }

        complaintService.updateStatus(id, status);

        System.out.println(
                "Complaint status updated successfully!"
        );
    }

    // =====================================================
    // ADMIN DASHBOARD
    // =====================================================

    static void dashboard() {

        System.out.println("\n==========================================");
        System.out.println("              ADMIN DASHBOARD");
        System.out.println("==========================================");

        System.out.println(
                "Total Students       : "
                + studentService.getStudentCount()
        );

        System.out.println(
                "Attendance Records   : "
                + attendanceService.getAttendanceCount()
        );

        System.out.println(
                "Total Events         : "
                + eventService.getEventCount()
        );

        System.out.println(
                "Total Complaints     : "
                + complaintService.getComplaintCount()
        );

        int pending = 0;
        int resolved = 0;
        int inProgress = 0;

        for (Complaint complaint :
                complaintService.getAllComplaints()) {

            if (complaint.getStatus().equals("PENDING")) {
                pending++;
            } else if (complaint.getStatus().equals("RESOLVED")) {
                resolved++;
            } else if (complaint.getStatus().equals("IN_PROGRESS")) {
                inProgress++;
            }
        }

        System.out.println(
                "Pending Complaints   : " + pending
        );

        System.out.println(
                "In-Progress Complaints: " + inProgress
        );

        System.out.println(
                "Resolved Complaints  : " + resolved
        );

        System.out.println(
                "System Status        : ONLINE"
        );

        System.out.println("==========================================");
    }

    // =====================================================
    // INPUT METHODS
    // =====================================================

    static int getInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        sc.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }

    static double getDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Double.parseDouble(
                        sc.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}
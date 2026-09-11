 package model;

public class Complaint {

    private int complaintId;
    private int studentId;
    private String category;
    private String description;
    private String date;
    private String status;

    public Complaint(int complaintId, int studentId,
                     String category, String description,
                     String date) {

        this.complaintId = complaintId;
        this.studentId = studentId;
        this.category = category;
        this.description = description;
        this.date = date;

        this.status = "PENDING";
    }

    public int getComplaintId() {
        return complaintId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayComplaint() {

        System.out.println("\n----- Complaint Details -----");

        System.out.println(
                "Complaint ID : " + complaintId
        );

        System.out.println(
                "Student ID   : " + studentId
        );

        System.out.println(
                "Category     : " + category
        );

        System.out.println(
                "Description  : " + description
        );

        System.out.println(
                "Date         : " + date
        );

        System.out.println(
                "Status       : " + status
        );
    }
}
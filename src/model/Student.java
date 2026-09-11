 package model;

public class Student extends Person {

    private String course;
    private String branch;
    private int year;
    private double cgpa;

    public Student(int id, String name, String email,
                   String course, String branch,
                   int year, double cgpa) {

        super(id, name, email);

        this.course = course;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

    public String getCourse() {
        return course;
    }

    public String getBranch() {
        return branch;
    }

    public int getYear() {
        return year;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public void displayDetails() {

        System.out.println("\n----- Student Details -----");
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Email    : " + email);
        System.out.println("Course   : " + course);
        System.out.println("Branch   : " + branch);
        System.out.println("Year     : " + year);
        System.out.println("CGPA     : " + cgpa);
    }
}
 package model;

public class Attendance {

    private int studentId;
    private String subject;
    private int classesHeld;
    private int classesAttended;

    public Attendance(int studentId, String subject,
                      int classesHeld, int classesAttended) {

        this.studentId = studentId;
        this.subject = subject;
        this.classesHeld = classesHeld;
        this.classesAttended = classesAttended;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public int getClassesHeld() {
        return classesHeld;
    }

    public int getClassesAttended() {
        return classesAttended;
    }

    public double calculatePercentage() {

        if (classesHeld == 0) {
            return 0;
        }

        return ((double) classesAttended / classesHeld) * 100;
    }

    public void displayAttendance() {

        double percentage = calculatePercentage();

        System.out.println("\n----- Attendance Details -----");
        System.out.println("Student ID       : " + studentId);
        System.out.println("Subject          : " + subject);
        System.out.println("Classes Held     : " + classesHeld);
        System.out.println("Classes Attended : " + classesAttended);

        System.out.printf(
                "Attendance       : %.2f%%\n",
                percentage
        );

        if (percentage < 75) {
            System.out.println("WARNING: Low Attendance!");
        } else {
            System.out.println("Status: Satisfactory");
        }
    }
}
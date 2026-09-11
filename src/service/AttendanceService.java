 package service;

import java.util.ArrayList;
import model.Attendance;

public class AttendanceService {

    private ArrayList<Attendance> attendanceList =
            new ArrayList<>();

    public void recordAttendance(Attendance attendance) {
        attendanceList.add(attendance);
    }

    public ArrayList<Attendance> getAllAttendance() {
        return attendanceList;
    }

    public ArrayList<Attendance> getStudentAttendance(int studentId) {

        ArrayList<Attendance> result =
                new ArrayList<>();

        for (Attendance attendance : attendanceList) {

            if (attendance.getStudentId() == studentId) {
                result.add(attendance);
            }
        }

        return result;
    }

    public int getAttendanceCount() {
        return attendanceList.size();
    }
}
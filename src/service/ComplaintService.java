 package service;

import java.util.ArrayList;
import model.Complaint;

public class ComplaintService {

    private ArrayList<Complaint> complaints =
            new ArrayList<>();

    public boolean addComplaint(Complaint complaint) {

        if (findComplaint(
                complaint.getComplaintId()) != null) {

            return false;
        }

        complaints.add(complaint);
        return true;
    }

    public ArrayList<Complaint> getAllComplaints() {
        return complaints;
    }

    public Complaint findComplaint(int complaintId) {

        for (Complaint complaint : complaints) {

            if (complaint.getComplaintId()
                    == complaintId) {

                return complaint;
            }
        }

        return null;
    }

    public boolean updateStatus(
            int complaintId,
            String status) {

        Complaint complaint =
                findComplaint(complaintId);

        if (complaint == null) {
            return false;
        }

        complaint.setStatus(status);
        return true;
    }

    public int getComplaintCount() {
        return complaints.size();
    }
}
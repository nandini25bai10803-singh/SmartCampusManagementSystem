 package model;

import java.util.ArrayList;

public class Event {

    private int eventId;
    private String eventName;
    private String description;
    private String date;
    private String venue;
    private int capacity;

    private ArrayList<Integer> registeredStudents =
            new ArrayList<>();

    public Event(int eventId, String eventName,
                 String description, String date,
                 String venue, int capacity) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
    }

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean registerStudent(int studentId) {

        if (registeredStudents.contains(studentId)) {
            return false;
        }

        if (registeredStudents.size() >= capacity) {
            return false;
        }

        registeredStudents.add(studentId);

        return true;
    }

    public void displayEvent() {

        System.out.println("\n----- Event Details -----");

        System.out.println("Event ID    : " + eventId);
        System.out.println("Name        : " + eventName);
        System.out.println("Description : " + description);
        System.out.println("Date        : " + date);
        System.out.println("Venue       : " + venue);
        System.out.println("Capacity    : " + capacity);

        System.out.println(
                "Registered  : " + registeredStudents.size()
        );

        System.out.println(
                "Seats Left  : "
                + (capacity - registeredStudents.size())
        );
    }
}
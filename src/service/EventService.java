 package service;

import java.util.ArrayList;
import model.Event;

public class EventService {

    private ArrayList<Event> events =
            new ArrayList<>();

    public boolean addEvent(Event event) {

        if (findEvent(event.getEventId()) != null) {
            return false;
        }

        events.add(event);
        return true;
    }

    public ArrayList<Event> getAllEvents() {
        return events;
    }

    public Event findEvent(int eventId) {

        for (Event event : events) {

            if (event.getEventId() == eventId) {
                return event;
            }
        }

        return null;
    }

    public int getEventCount() {
        return events.size();
    }
}
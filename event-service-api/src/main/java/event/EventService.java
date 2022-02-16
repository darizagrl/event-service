package event;

import java.util.List;

public interface EventService {
    Event createEvent();

    Event updateEvent(String id);

    Event getEvent(String id);

    void deleteEvent(String id);

    List<Event> getAllEvents();

    List<Event> getAllEventsByTitle(String title);
}

import java.time.LocalDateTime;
import java.util.*;

public class EventManager {
    private List<Event> events;
    private User currentUser;

    public EventManager(User user) {
        this.currentUser = user;
        this.events = FileManager.loadEvents();
    }

    public void addEvent(Event event) {
        events.add(event);
        FileManager.saveEvents(events);
    }

    public List<Event> getUpcomingEvents() {
        List<Event> result = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            if (event.getDateTime().isAfter(now)) result.add(event);
        }
        result.sort(Comparator.comparing(Event::getDateTime));
        return result;
    }

    public List<Event> getPastEvents() {
        List<Event> result = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            if (event.getDateTime().isBefore(now)) result.add(event);
        }
        return result;
    }

    public void confirmParticipation(Event event) {
        currentUser.confirmEvent(event);
    }

    public void cancelParticipation(Event event) {
        currentUser.cancelEvent(event);
    }

    public List<Event> getUserEvents() {
        return currentUser.getConfirmedEvents();
    }

    public List<Event> getAllEvents() {
        return events;
    }

    public void checkOngoingEvents() {
        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            if (event.getDateTime().isBefore(now.plusMinutes(1)) &&
                event.getDateTime().isAfter(now.minusMinutes(1))) {
                System.out.println("Evento ocorrendo agora: " + event.getName());
            }
        }
    }
}
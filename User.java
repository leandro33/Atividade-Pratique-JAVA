import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String city;
    private List<Event> confirmedEvents;

    public User(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.confirmedEvents = new ArrayList<>();
    }

    public void confirmEvent(Event event) {
        if (!confirmedEvents.contains(event)) {
            confirmedEvents.add(event);
        }
    }

    public void cancelEvent(Event event) {
        confirmedEvents.remove(event);
    }

    public List<Event> getConfirmedEvents() {
        return confirmedEvents;
    }

    public String getName() {
        return name;
    }
}
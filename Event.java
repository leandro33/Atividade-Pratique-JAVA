import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private String address;
    private String category;
    private LocalDateTime dateTime;
    private String description;

    public Event(String name, String address, String category, LocalDateTime dateTime, String description) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.dateTime = dateTime;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public String toFileString() {
        return name + ";" + address + ";" + category + ";" + dateTime + ";" + description;
    }

    public static Event fromFileString(String line) {
        String[] parts = line.split(";");
        return new Event(parts[0], parts[1], parts[2], LocalDateTime.parse(parts[3]), parts[4]);
    }

    @Override
    public String toString() {
        return name + " - " + category + " em " + address + " às " +
                dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
                "\nDescrição: " + description;
    }
}
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "events.data";

    public static void saveEvents(List<Event> events) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Event event : events) {
                writer.write(event.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os eventos: " + e.getMessage());
        }
    }

    public static List<Event> loadEvents() {
        List<Event> events = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return events;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(Event.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os eventos: " + e.getMessage());
        }

        return events;
    }
}
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Cadastro de Usuário ===");
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cidade: ");
        String city = scanner.nextLine();

        User user = new User(name, email, city);
        EventManager manager = new EventManager(user);

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Cadastrar novo evento");
            System.out.println("2. Listar eventos disponíveis");
            System.out.println("3. Participar de evento");
            System.out.println("4. Cancelar participação");
            System.out.println("5. Meus eventos");
            System.out.println("6. Eventos já ocorridos");
            System.out.println("7. Checar evento atual");
            System.out.println("0. Sair");

            System.out.print("Escolha: ");
            int opt = scanner.nextInt();
            scanner.nextLine(); // consumir newline

            switch (opt) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String ename = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String address = scanner.nextLine();
                    System.out.print("Categoria (Festa, Show, Esporte): ");
                    String category = scanner.nextLine();
                    System.out.print("Data e hora (dd/MM/yyyy HH:mm): ");
                    String dateTimeStr = scanner.nextLine();
                    LocalDateTime dt = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    manager.addEvent(new Event(ename, address, category, dt, desc));
                    break;
                case 2:
                    System.out.println("--- Eventos disponíveis ---");
                    for (Event e : manager.getUpcomingEvents()) System.out.println(e + "\n");
                    break;
                case 3:
                    System.out.print("Nome do evento para participar: ");
                    String eventToJoin = scanner.nextLine();
                    manager.getAllEvents().stream().filter(e -> e.getName().equalsIgnoreCase(eventToJoin)).findFirst()
                            .ifPresent(manager::confirmParticipation);
                    break;
                case 4:
                    System.out.print("Nome do evento para cancelar: ");
                    String eventToCancel = scanner.nextLine();
                    user.getConfirmedEvents().stream().filter(e -> e.getName().equalsIgnoreCase(eventToCancel)).findFirst()
                            .ifPresent(manager::cancelParticipation);
                    break;
                case 5:
                    System.out.println("--- Meus eventos ---");
                    for (Event e : user.getConfirmedEvents()) System.out.println(e + "\n");
                    break;
                case 6:
                    System.out.println("--- Eventos passados ---");
                    for (Event e : manager.getPastEvents()) System.out.println(e + "\n");
                    break;
                case 7:
                    manager.checkOngoingEvents();
                    break;
                case 0:
                    FileManager.saveEvents(manager.getAllEvents());
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
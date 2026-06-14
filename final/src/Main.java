import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void help_text() {
        System.out.println("\nFollowing commands are available:");
        System.out.println("\t\"add\"\tticket");
        System.out.println("\t\"solve\"\toldest ticket of a given priority");
        System.out.println("\t\"print\"\ttickets");
        System.out.println("\t\"help\"\ttext");
        System.out.println("\t\"exit\"\tprogram");
    }
    
    public static void main(String[] args) {
        Queue<Ticket> low_queue = new LinkedList<Ticket>();
        Queue<Ticket> medium_queue = new LinkedList<Ticket>();
        Queue<Ticket> high_queue = new LinkedList<Ticket>();
        Queue<Ticket> emergency_queue = new LinkedList<Ticket>();

        Scanner stdin = new Scanner(System.in);
        String command;

        help_text();

        loop:
        while (true) {
            System.out.print("\n\t$ ");
            try {
                command = stdin.nextLine();
            } catch (Exception e) {
                System.out.println();
                break;
            }
            

            if (emergency_queue.size() != 0) {
                System.out.println("\u001b[1;31mEMERGENCY TICKETS EXIST. SOLVE THEM NOW.\u001b[0m");
            }

            switch (command) {
                case "add":
                    System.out.println("What is the ticket message?");
                    String message = stdin.nextLine();
                    System.out.println("What is the priority? LOW, MEDIUM, HIGH, EMERGENCY");
                    String input_string;
                    Ticket.Priority priority;
                    inner:
                    while (true) {
                        input_string = stdin.nextLine().toLowerCase();
                        switch (input_string) {
                            case "low":
                                priority = Ticket.Priority.LOW;
                                break inner;
                            case "medium":
                                priority = Ticket.Priority.MEDIUM;
                                break inner;
                            case "high":
                                priority = Ticket.Priority.HIGH;
                                break inner;
                            case "emergency":
                                priority = Ticket.Priority.EMERGENCY;
                                break inner;
                            default:
                                break;
                        }
                    }
                    switch (priority) {
                        case Ticket.Priority.LOW:
                            low_queue.add(new Ticket(message, priority));
                            break;
                        case Ticket.Priority.MEDIUM:
                            medium_queue.add(new Ticket(message, priority));
                            break;
                        case Ticket.Priority.HIGH:
                            high_queue.add(new Ticket(message, priority));
                            break;
                        case Ticket.Priority.EMERGENCY:
                            emergency_queue.add(new Ticket(message, priority));
                            break;
                        default:
                            break;
                    }
                    break;
                case "solve":
                    System.out.println("What is the priority of the ticket? LOW, MEDIUM, HIGH, EMERGENCY");
                    String input_string1;
                    inner:
                    while (true) {
                        input_string1 = stdin.nextLine().toLowerCase();
                        switch (input_string1) {
                            case "low":
                                low_queue.poll();
                                break inner;
                            case "medium":
                                medium_queue.poll();
                                break inner;
                            case "high":
                                high_queue.poll();
                                break inner;
                            case "emergency":
                                emergency_queue.poll();
                                break inner;
                            default:
                                break;
                        }
                    }

                    break;
                case "print":
                    System.out.println("\nNext LOW priority ticket");
                    System.out.println(low_queue.size() != 0 ? low_queue.peek().get_message() : "no LOW priority tickets");
                    System.out.println("\nNext MEDIUM priority ticket");
                    System.out.println(medium_queue.size() != 0 ? medium_queue.peek().get_message() : "no MEDIUM priority tickets");
                    System.out.println("\nNext HIGH priority ticket");
                    System.out.println(high_queue.size() != 0 ? high_queue.peek().get_message() : "no HIGH priority tickets");
                    System.out.println("\nNext EMERGENCY priority ticket");
                    System.out.println(emergency_queue.size() != 0 ? emergency_queue.peek().get_message() : "no EMERGENCY priority tickets");
                    break;
                case "exit":
                    break loop;
                case "help":
                    help_text();
                    break;
                default:
                    System.out.println("Invalid command " + command);
            }
        }

        stdin.close();
    }
}

public class Ticket {
    private final String message;
    private final long id;
    private static long last_id = 0;

    private Priority priority;

    public Ticket(String message, Priority priority) {
        this.message = message;
        this.priority = priority;
        this.id = last_id++;
    }

    public enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        EMERGENCY
    }

    public String get_message() {return message; }

    public long get_id() {return id; }

    public Priority get_priority() {return priority; }

}

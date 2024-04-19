import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ChatServer server = new ChatServer();

        User malik = new User("malik", server);
        User yunis = new User("yunis", server);
        User hamzeh = new User("hamzeh", server);

        server.register(malik);
        server.register(yunis);
        server.register(hamzeh);

        ArrayList<String> hamzehAndYunis = new ArrayList<>();
        hamzehAndYunis.add("hamzeh");
        hamzehAndYunis.add("yunis");

        ArrayList<String> malikAndHamzeh = new ArrayList<>();
        malikAndHamzeh.add("hamzeh");
        malikAndHamzeh.add("malik");

        ArrayList<String> malikAndYunis = new ArrayList<>();
        malikAndYunis.add("malik");
        malikAndYunis.add("yunis");

        yunis.blockUser("malik");

        malik.sendMessage(hamzehAndYunis, "Hi");
        malik.sendMessage(hamzehAndYunis, "Hello");

        hamzeh.sendMessage(malikAndYunis, "Hi guys");

        malik.undo();

        System.out.println("Chat history for Malik:");
        for (Message message : malik.getHistory().getMessages()) {
            System.out.println("From " + message.getSender() + ": ");
            System.out.println(message.getMessageContent());
        }

        System.out.println("\nChat history for Yunis:");
        for (Message message : yunis.getHistory().getMessages()) {
            System.out.println("From " + message.getSender() + ": ");
            System.out.println(message.getMessageContent());
        }

        System.out.println("\nChat history for Hamzeh:");
        for (Message message : hamzeh.getHistory().getMessages()) {
            System.out.println("From " + message.getSender() + ": ");
            System.out.println(message.getMessageContent());
        }
    }
}

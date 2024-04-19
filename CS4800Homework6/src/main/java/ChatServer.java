import java.util.ArrayList;
import java.util.HashMap;

public class ChatServer {
    HashMap<String, User> users;
    HashMap<String, ArrayList<String>> blocked;

    public ChatServer(){
        users = new HashMap<>();
        blocked = new HashMap<>();
    }

    public void register(User user){
        users.put(user.getUser(), user);
    }

    public void unregister(User user){
        users.remove(user.getUser());
    }

    public void send(String sender, ArrayList<String> recipients, String messageContent){
        Message message = new Message(sender, recipients, messageContent);
        for (String recipient : recipients) {
            if (!isBlocked(sender, recipient))
            {
                User user = users.get(recipient);
                if (user != null) {
                    user.receiveMessage(message);
                }
            }
        }
    }

    public void blockUser(String blocker, String userToBlock) {
        if (!blocked.containsKey(blocker)) {
            blocked.put(blocker, new ArrayList<>());
        }
        blocked.get(blocker).add(userToBlock);
    }

    public boolean isBlocked(String sender, String recipient) {
        ArrayList<String> blocking = blocked.getOrDefault(recipient, new ArrayList<>());
        return blocking.contains(sender);
    }
}

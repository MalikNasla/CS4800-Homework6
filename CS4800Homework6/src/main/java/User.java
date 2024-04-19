import java.util.ArrayList;

public class User {
    String user;
    ChatServer server;
    ChatHistory history;

    public User(String user, ChatServer server){
        this.user = user;
        this.server = server;
        this.history = new ChatHistory();
    }

    public String getUser(){
        return user;
    }

    public ChatHistory getHistory() {
        return history;
    }

    public void blockUser(String userToBlock) {
        server.blockUser(user, userToBlock);
    }

    public void sendMessage(ArrayList<String> recipients, String messageContent){
        server.send(user, recipients, messageContent);
    }

    public void receiveMessage(Message message){
        history.add(message);
    }

    public void undo(){
        Message last = history.getLast();
        if (last != null && last.getSender().equals(user)){
            history.removeLast();
        }
    }
}

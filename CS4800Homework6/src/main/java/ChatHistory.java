import java.util.ArrayList;

public class ChatHistory {
    ArrayList<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public void add(Message messageContent){
        messages.add(messageContent);
    }

    public ArrayList<Message> getMessages(){
        return messages;
    }

    public Message getLast(){
        if(messages == null || messages.isEmpty()){
            return null;
        }
        else {
            return messages.get(messages.size() - 1);
        }
    }

    public void removeLast() {
        if (!messages.isEmpty()) {
            messages.remove(messages.size() - 1);
        }
    }
}

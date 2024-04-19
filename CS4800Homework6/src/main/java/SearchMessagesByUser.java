import java.util.ArrayList;
import java.util.Iterator;

class SearchMessagesByUser implements Iterator<Message> {
    ArrayList<Message> messages;
    int index = 0;

    public SearchMessagesByUser(ArrayList<Message> messages, User search){
        this.messages = new ArrayList<>();
        for (int i = 0; i < messages.size(); i++){
            Message message = messages.get(i);
            if (message.getSender().equals(search.getUser()) || message.getRecipients().contains(search.getUser())) {
                this.messages.add(message);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < messages.size();
    }

    @Override
    public Message next() {
        return messages.get(index++);
    }
}

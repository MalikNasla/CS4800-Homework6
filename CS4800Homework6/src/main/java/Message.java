import java.util.ArrayList;
import java.util.Date;

public class Message {
    String sender;
    ArrayList<String> recipients;
    Date time;
    String messageContent;

    public Message(String sender, ArrayList<String> recipients, String messageContent){
        this.sender = sender;
        this.recipients = recipients;
        this.time = new Date();
        this.messageContent = messageContent;
    }

    public String getSender() {
        return sender;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public Date getTime() {
        return time;
    }

    public String getMessageContent() {
        return messageContent;
    }

}

import java.util.Date;

public class MessageMemento {
    String messageContent;
    Date time;

    public MessageMemento(String messageContent, Date time){
        this.messageContent = messageContent;
        this.time = time;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public Date getTime() {
        return time;
    }
}

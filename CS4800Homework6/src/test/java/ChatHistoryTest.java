import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ChatHistoryTest {
    @Test
    public void testAdd() {
        ChatHistory chatHistory = new ChatHistory();

        Message message1 = new Message("user1", new ArrayList<>(), "Hello");
        Message message2 = new Message("user2", new ArrayList<>(), "Hi");

        chatHistory.add(message1);
        chatHistory.add(message2);

        ArrayList<Message> messages = chatHistory.getMessages();
        assertEquals(2, messages.size());
    }

    @Test
    public void testGetMessages() {
        ChatHistory chatHistory = new ChatHistory();

        Message message1 = new Message("user1", new ArrayList<>(), "Hello");
        Message message2 = new Message("user2", new ArrayList<>(), "Hi");

        chatHistory.add(message1);
        chatHistory.add(message2);

        ArrayList<Message> messages = chatHistory.getMessages();
        assertEquals(2, messages.size());
        assertEquals("Hello", messages.get(0).getMessageContent());
        assertEquals("Hi", messages.get(1).getMessageContent());
    }

    @Test
    public void testGetLast() {
        ChatHistory chatHistory = new ChatHistory();

        assertNull(chatHistory.getLast());

        Message message1 = new Message("user1", new ArrayList<>(), "Hello");
        chatHistory.add(message1);

        assertEquals("Hello", chatHistory.getLast().getMessageContent());
    }

    @Test
    public void testRemoveLast() {
        ChatHistory chatHistory = new ChatHistory();

        Message message1 = new Message("user1", new ArrayList<>(), "Hello");
        Message message2 = new Message("user2", new ArrayList<>(), "Hi");

        chatHistory.add(message1);
        chatHistory.add(message2);
        chatHistory.removeLast();

        ArrayList<Message> messages = chatHistory.getMessages();
        assertEquals(1, messages.size());
        assertEquals("Hello", messages.get(0).getMessageContent());
    }
}

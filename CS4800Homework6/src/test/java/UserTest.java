import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void testBlockUser() {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        user1.blockUser("user2");

        assertTrue(chatServer.isBlocked("user1", "user2"));
        assertFalse(chatServer.isBlocked("user2", "user1"));
    }

    @Test
    public void testSendMessage() {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        chatServer.register(user1);
        chatServer.register(user2);

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("user2");

        user1.sendMessage(recipients, "Hello");

        assertEquals(1, user2.history.getMessages().size());
        assertEquals("Hello", user2.history.getMessages().get(0).getMessageContent());
    }

    @Test
    public void testReceiveMessage() {
        User user1 = new User("user1", null);
        Message message = new Message("user1", new ArrayList<>(), "Hello");
        user1.receiveMessage(message);

        assertEquals(1, user1.history.getMessages().size());
        assertEquals("Hello", user1.history.getMessages().get(0).getMessageContent());
    }

    @Test
    public void testUndo() {
        User user1 = new User("user1", null);

        Message message1 = new Message("user1", new ArrayList<>(), "Hello");
        Message message2 = new Message("user2", new ArrayList<>(), "Hi");

        user1.receiveMessage(message1);
        user1.receiveMessage(message2);

        assertEquals(2, user1.history.getMessages().size());

        user1.undo();

        assertEquals(1, user1.history.getMessages().size());
        assertEquals("Hello", user1.history.getMessages().get(0).getMessageContent());
    }

}

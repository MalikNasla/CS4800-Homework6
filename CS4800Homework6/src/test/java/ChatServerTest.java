import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class ChatServerTest {
    @Test
    public void testRegister() {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        chatServer.register(user1);
        chatServer.register(user2);

        assertEquals(2, chatServer.users.size());
        assertTrue(chatServer.users.containsKey("user1"));
        assertTrue(chatServer.users.containsKey("user2"));
    }

    @Test
    public void testUnregister() {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        chatServer.register(user1);
        chatServer.register(user2);
        chatServer.unregister(user1);

        assertEquals(1, chatServer.users.size());
        assertNull(chatServer.users.get("user1"));
        assertTrue(chatServer.users.containsKey("user2"));
    }

    @Test
    public void testSend() {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        chatServer.register(user1);
        chatServer.register(user2);

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("user2");

        chatServer.send("user1", recipients, "Hello");

        assertEquals(1, user2.history.getMessages().size());
        assertEquals("Hello", user2.history.getMessages().get(0).getMessageContent());
    }

    @Test
    public void testBlockUser() {
        ChatServer chatServer = new ChatServer();

        User user1 = new User("user1", chatServer);
        User user2 = new User("user2", chatServer);

        chatServer.register(user1);
        chatServer.register(user2);

        chatServer.blockUser("user1", "user2");

        assertTrue(chatServer.isBlocked("user1", "user2"));
        assertTrue(chatServer.blocked.containsKey("user1"));
        ArrayList<String> blockedUsers = chatServer.blocked.get("user1");
        assertTrue(blockedUsers.contains("user2"));
    }

}

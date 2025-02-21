import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testLoadUsersFromExternalApi() {
        userService.loadUsersFromExternalApi();
        assertEquals(1, userService.getAllUsers().size());  // Adjust based on external API response
    }
}
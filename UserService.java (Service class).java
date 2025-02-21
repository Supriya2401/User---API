import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    // Fetching all users from the in-memory DB
    public List<User> getAllUsers() {
        logger.info("Fetching all users from the database");
        return userRepository.findAll();
    }

    // Fetching users by role
    public List<User> getUsersByRole(String role) {
        logger.info("Fetching users with role: {}", role);
        return userRepository.findByRole(role);
    }

    // Fetching users sorted by age
    public List<User> getUsersByAge(String sortOrder) {
        logger.info("Fetching users sorted by age in order: {}", sortOrder);
        if ("asc".equalsIgnoreCase(sortOrder)) {
            return userRepository.findAllByOrderByAgeAsc();
        } else {
            return userRepository.findAllByOrderByAgeDesc();
        }
    }

    // Fetching user by ID or SSN
    public Optional<User> getUserByIdOrSsn(Long id, String ssn) {
        logger.info("Fetching user with ID: {} or SSN: {}", id, ssn);
        return userRepository.findBySsnOrId(ssn, id).stream().findFirst();
    }

    // Load users from external API and store in the DB
    public void loadUsersFromExternalApi() {
        try {
            logger.info("Loading users from external API...");
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://dummyjson.com/users";
            User[] users = restTemplate.getForObject(url, User[].class);
            if (users != null) {
                for (User user : users) {
                    userRepository.save(user);
                }
                logger.info("Successfully loaded {} users", users.length);
            }
        } catch (Exception e) {
            logger.error("Error loading users from external API", e);
        }
    }
}

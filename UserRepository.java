import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRole(String role);
    List<User> findBySsnOrId(String ssn, Long id);
    List<User> findAllByOrderByAgeAsc();
    List<User> findAllByOrderByAgeDesc();
}
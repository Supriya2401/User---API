import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Api(value = "User Management", description = "Operations pertaining to users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Get all users", response = List.class)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get users by role", response = List.class)
    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable String role) {
        return userService.getUsersByRole(role);
    }

    @ApiOperation(value = "Get users sorted by age", response = List.class)
    @GetMapping("/age/{sortOrder}")
    public List<User> getUsersByAge(@PathVariable String sortOrder) {
        return userService.getUsersByAge(sortOrder);
    }

    @ApiOperation(value = "Get user by ID or SSN", response = User.class)
    @GetMapping("/id-or-ssn")
    public Optional<User> getUserByIdOrSsn(@RequestParam(required = false) Long id,
                                            @RequestParam(required = false) String ssn) {
        return userService.getUserByIdOrSsn(id, ssn);
    }

    @ApiOperation(value = "Load users from external API", response = String.class)
    @PostMapping("/load")
    public String loadUsers() {
        userService.loadUsersFromExternalApi();
        return "Users loaded successfully!";
    }
}

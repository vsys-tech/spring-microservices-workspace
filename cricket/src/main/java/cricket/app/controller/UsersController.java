package cricket.app.controller;


import cricket.app.services.UsersService;
import cricket.app.web.shared.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public ResponseEntity<Response> findAll() {
        return new ResponseEntity<>(
                new Response(this.usersService.find(), "OK"), HttpStatus.OK);
    }

}

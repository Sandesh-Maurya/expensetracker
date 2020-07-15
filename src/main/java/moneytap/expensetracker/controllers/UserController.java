package moneytap.expensetracker.controllers;

import moneytap.expensetracker.model.User;
import moneytap.expensetracker.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/home/user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @GetMapping("/userDetails")
    Collection<User> users(){return userRepository.findAll();}

    @GetMapping("/userDetails/{id}")
    ResponseEntity<?> getUserDteails(@PathVariable Integer id){
        Optional<User> user=userRepository.findById(id);
        return user.map(response->ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * with applying spring security here we can use this for sign-up
     * i.e just allowing this URL to be permmited to access by user
     * @param user
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/userDetails")
    ResponseEntity<User> addUser(@Valid @RequestBody User user)throws URISyntaxException {
        User input=userRepository.save(user);
        return ResponseEntity.created(new URI("/home/user/userDetails"+input.getId())).body(input);
    }


}


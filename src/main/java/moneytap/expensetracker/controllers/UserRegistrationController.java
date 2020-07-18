package moneytap.expensetracker.controllers;
import moneytap.expensetracker.model.User;
import moneytap.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Registration")
public class UserRegistrationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @PostMapping("/AddUser")
    public String addUser(@RequestBody User user){
        String pswd=user.getPassword();
        String encrypted_Password= bCryptPasswordEncoder.encode(pswd);
        user.setPassword(encrypted_Password) ;
        userRepository.save(user);
        return  "User Registration successful";
    }
}

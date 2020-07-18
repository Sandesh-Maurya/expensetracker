package moneytap.expensetracker.Config;
import moneytap.expensetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import moneytap.expensetracker.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByName(s);
        CustomUserDetails customUserDetails=null;
        if(user!=null){
            customUserDetails=new CustomUserDetails();
            customUserDetails.setUser(user);

        }
        else{
            throw new UsernameNotFoundException("User with this name doesn't exits in database, signup first "+s);
        }
        return customUserDetails;
    }
}

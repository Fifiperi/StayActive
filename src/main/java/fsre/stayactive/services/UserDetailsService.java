package fsre.stayactive.services;
import fsre.stayactive.models.User;
import fsre.stayactive.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public fsre.stayactive.models.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username);
        System.out.println(u.getEmail());
        return new fsre.stayactive.models.UserDetails(u);
    }
}
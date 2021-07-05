package opera.service;

import opera.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User add(User user);

    User get(Long id);

    User findByEmail(String email);
}

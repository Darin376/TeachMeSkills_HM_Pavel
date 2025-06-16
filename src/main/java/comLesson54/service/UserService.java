package comLesson54.service;

import comLesson54.dao.UserRepository;
import comLesson54.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public User save(User userEntity) {

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setRole("USER");

        return userRepository.save(userEntity);
    };


}

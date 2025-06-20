package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

        @Autowired
        private UserRepository userRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;

        public User save(User userEntity) {

            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity.setRole("ROLE_USER");

            return userRepository.save(userEntity);


        }
}

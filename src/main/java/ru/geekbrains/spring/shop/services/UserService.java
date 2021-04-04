package ru.geekbrains.spring.shop.services;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.entities.Role;
import ru.geekbrains.spring.shop.model.entities.User;
import ru.geekbrains.spring.shop.repository.RoleRepository;
import ru.geekbrains.spring.shop.repository.UserRepository;

@Service
@Log
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public User findByLoginAndPassword(String login, String password) {
        User currentUser = userRepository.findByLogin(login);
        if (currentUser != null) {
            if (passwordEncoder.matches(password, currentUser.getPassword())) {
                return userRepository.findByLogin(login);
            } else {
                log.info("Incorrect password for user " + login);
                return null;
            }
        }
        log.info("No match user " + login);
        return null;
    }

    public User findByLogin (String login){
        return userRepository.findByLogin(login);
    }

    public void saveUser(User user) {
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}

package ru.geekbrains.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.shop.model.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}
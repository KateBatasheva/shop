package ru.geekbrains.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.shop.model.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
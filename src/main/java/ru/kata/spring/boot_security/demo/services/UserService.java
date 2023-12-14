package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    User findOne(String userName);

    void save(User user);

    void update(User user);

    void delete(int id);

}

package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Init {
    private final RoleRepository roleRepository;
    private final UserService userService;

    @Autowired
    public Init(RoleRepository roleRepository, UserService userService) {
        this.roleRepository = roleRepository;
        this.userService = userService;
    }

    @PostConstruct
    public void initTestUsers() {
        Role userTest = new Role("ROLE_USER");
        Role adminTest = new Role("ROLE_ADMIN");
        roleRepository.save(userTest);
        roleRepository.save(adminTest);
        Set<Role> userTestSet = Stream.of(userTest).collect(Collectors.toSet());
        Set<Role> adminTestSet = Stream.of(adminTest).collect(Collectors.toSet());

        User user0 = new User("Admin", "Oleg", "Petrov", 1999, 650, "Oleg@mail.ru", "test", adminTestSet);
        User user1 = new User("User1", "Alex", "Lincoln", 1995, 1250, "Alex@yandex.ru", "test", userTestSet);
        User user2 = new User("User2", "Ivan", "Ivanov", 2012, 999999, "Ivan@gmail.com", "test", userTestSet);
        userService.save(user0);
        userService.save(user1);
        userService.save(user2);
    }
}

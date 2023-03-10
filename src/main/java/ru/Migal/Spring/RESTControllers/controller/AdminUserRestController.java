package ru.Migal.Spring.RESTControllers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Migal.Spring.RESTControllers.Handling.NoSuchUserException;
import ru.Migal.Spring.RESTControllers.model.User;
import ru.Migal.Spring.RESTControllers.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class AdminUserRestController {
    private final UserService userService;

    @Autowired
    public AdminUserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.listUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no employee with ID = " + id + " in database!");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (user.getPassword() == null) {
            user.setPassword((userService.getUserById(user.getId())).getPassword());
        }
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no employee with ID = " + id + " in database!");
        }
        userService.deleteUser(user);
    }
}
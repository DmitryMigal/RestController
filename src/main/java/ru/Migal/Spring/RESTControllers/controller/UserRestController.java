package ru.Migal.Spring.RESTControllers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Migal.Spring.RESTControllers.model.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @GetMapping("/current")
    public ResponseEntity<User> getUser(UsernamePasswordAuthenticationToken token) {
        return new ResponseEntity<>((User) token.getPrincipal(), HttpStatus.OK);
    }
}



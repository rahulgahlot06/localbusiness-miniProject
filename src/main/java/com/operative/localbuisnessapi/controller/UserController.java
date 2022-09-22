package com.operative.localbuisnessapi.controller;


import com.operative.localbuisnessapi.model.User;
import com.operative.localbuisnessapi.service.UserService;
import com.operative.localbuisnessapi.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        try {


            if (!userService.checkUser(user)) {
                User userTemp = userService.addUser(user);
                return new ResponseEntity<>(userTemp, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(user, HttpStatus.FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/users/signin")
    public boolean isUserValid(@RequestBody User user) {
        if (userService.userIsPresent(user)) {
            return true;
        }
        return false;
    }
}

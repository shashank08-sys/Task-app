package com.task.shashank.controller;

import com.task.shashank.dto.UserRequestDTO;
import com.task.shashank.model.Users;
import com.task.shashank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUserInDB(@RequestBody Users user){
        userService.addUser(user);
        return ResponseEntity.ok("User created successfully");
    }

    @GetMapping("/find")
    public List<Users> getAllusersFromDB(){
        return userService.getAllUsers();
    }

}

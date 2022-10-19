package com.example.demo.controller;


import com.example.demo.model.nodes.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/User")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/createUserToVMRelationship/{type}")
    public User createUserToVMRelationship(@RequestParam Long userId, @RequestParam Long virtualMachineId, @PathVariable String type) {
        return userService.createUserToVMRelationship(userId, virtualMachineId, type);
    }



}

package com.example.DatabaseNoSQLORM.controllers;

import com.example.DatabaseNoSQLORM.entities.User;
import com.example.DatabaseNoSQLORM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping(value = "")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PutMapping(value = "/{id}")
    public User editUser(@PathVariable String id, @RequestBody User user) throws Exception{
        if (!userRepository.existsById(id)) throw new Exception("User is not found");
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}


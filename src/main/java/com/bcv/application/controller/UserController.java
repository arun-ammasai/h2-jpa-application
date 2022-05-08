package com.bcv.application.controller;

import com.bcv.application.entity.User;
import com.bcv.application.repository.UserRepository;
import com.bcv.application.request.UserRequest;
import com.bcv.application.util.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Status;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;
    @Autowired
    Mapper mapper;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    @GetMapping("/getUser/{id}")
    public User getUsers(@PathVariable(name = "id") int id){
        return repository.findById(id).get();
    }

    @PostMapping("addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody UserRequest request){
        User user =  mapper.mapper().map(request,User.class);
        System.out.println("Mapper "+ user);
        return repository.save(user);
    }

}

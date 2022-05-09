package com.bcv.application.controller;

import com.bcv.application.entity.User;
import com.bcv.application.exception.UserException;
import com.bcv.application.repository.UserRepository;
import com.bcv.application.request.UserRequest;
import com.bcv.application.util.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Status;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("update/{id}/email/{email}")
    public User updateEmail(@PathVariable(name = "id") int id,@PathVariable(name = "email")String email) throws UserException {
        Optional<User> byId = repository.findById(id);
        User user = byId.orElseThrow(() -> new UserException("User Not  Found"));
        byId.orElseThrow(UserException::new);
        user.setEmail(email);
        return repository.save(user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity updateEmail(@PathVariable(name = "id") int id) throws UserException {
        Optional<User> byId = repository.findById(id);
        User user = byId.orElseThrow(UserException::new);
        repository.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }


}

package com.utn.TP_Final.controller;


import com.utn.TP_Final.exceptions.UserAlreadyExistsException;
import com.utn.TP_Final.exceptions.UserNotExistsException;
import com.utn.TP_Final.exceptions.ValidationException;
import com.utn.TP_Final.model.User;
import com.utn.TP_Final.projections.UserMostCalledDest;
import com.utn.TP_Final.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User newUser) throws UserAlreadyExistsException
    {
        return new ResponseEntity<>(userService.addUser(newUser), HttpStatus.OK);
    }

    @PostMapping("/delete/{dni}")
    public void removeUser(@RequestBody(required = true)String dni)
    {
        userService.deleteUser(dni);
    }


    @GetMapping("/")
    public List<User> getAll(@RequestParam(required = false) String name)
    {
        return userService.getAll(name);
    }

    @GetMapping("/getByDni/{dni}")
    public User getByDni(@RequestParam(required = true)String dni)
    {
        return userService.getByDni(dni);
    }

    @GetMapping("/getByLineNumber/{lineNumber}")
    public User getByLineNumber(@RequestParam(required = true)String lineNumber)
    {
        return userService.getByLineNumber(lineNumber);
    }

    @GetMapping("/getById/{id}")
    public Optional<User> getById(@RequestParam(required = true)Integer id)
    {
        return userService.getById(id);
    }

    @GetMapping("/getByUsername/{username}")
    public User getByUsername(@RequestParam(required = true)String username, @RequestParam(required = true)String password){
        return userService.getByUsername(username, password);
    }

    @PostMapping("/login")
    public User login(@RequestBody String username, @RequestBody String password) throws UserNotExistsException, ValidationException
    {
        if((username != null) && (password != null))
        {
            return userService.login(username, password);
        }else{
            throw new ValidationException("You must complete the fields.");
        }
    }

    @GetMapping("/mostCalledDest")
    public UserMostCalledDest getUserMostCalledDest(@RequestParam(required = true) Integer id){
       return userService.getUserMostCalledDest(id);
    }
}

package com.utn.TP_Final.service;

import com.utn.TP_Final.exceptions.UserNotExistsException;
import com.utn.TP_Final.model.User;
import com.utn.TP_Final.projections.UserMostCalledDest;
import com.utn.TP_Final.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User addUser(User newUser) { //esto vendria a ser como el registro de usuarios
        return userRepository.save(newUser);
    }

    public void deleteUser(String dni)
    {
        userRepository.delete(dni);
    } //esto es como el remove user

    public List<User> getAll(String name) {
        if(isNull(name))
        {
            return userRepository.findAll();
        }
        return userRepository.findByLastname(name);
    }

    public User getByDni(String dni)
    {
        return userRepository.findByDni(dni);
    }

    public User getByLineNumber(String lineNumber)
    {
        return userRepository.findByLineNumber(lineNumber);
    }

    public Optional<User> getById(Integer id)
    {
        return userRepository.findById(id);
    }

    public User getByUsername(String username, String password)
    {
        return userRepository.findByUsername(username, password);
    }

    public User login(String username, String password) throws UserNotExistsException {
        User user = userRepository.findByUsername(username, password);
        return Optional.ofNullable(user).orElseThrow(()-> new UserNotExistsException());
    }

    public UserMostCalledDest getUserMostCalledDest(Integer id){

         //lo hice para probar la logica del test
        /*ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        UserMostCalledDest userMostCalledDest = factory.createProjection(UserMostCalledDest.class);
        userMostCalledDest.setFirstName("Juan");
        userMostCalledDest.setLastName("Pilegi");
        userMostCalledDest.setDest("123456");

        return userMostCalledDest;


         */

        return userRepository.getUserMostCalledDest(id);
    }

    //ver como hacer el logout

}

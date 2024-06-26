package me.kiryakov.popeengooi.controller;


import me.kiryakov.popeengooi.dto.UserDTO;
import me.kiryakov.popeengooi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @GetMapping(path = "/{userId}")
    public UserDTO getUserById(Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
}

package me.kiryakov.popeengooi.controller;


import me.kiryakov.popeengooi.dto.UserDTO;
import me.kiryakov.popeengooi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    public UserDTO registerUser(@RequestBody UserDTO dto){
        return userService.createUser(dto);
    }
}

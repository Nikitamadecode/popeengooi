package me.kiryakov.popeengooi.service;

import me.kiryakov.popeengooi.domain.User;
import me.kiryakov.popeengooi.dto.UserDTO;
import me.kiryakov.popeengooi.exception.EntityNotFoundException;
import me.kiryakov.popeengooi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        modelMapper.map(userDTO, user);
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found"));
        return modelMapper.map(user, UserDTO.class);
    }
}

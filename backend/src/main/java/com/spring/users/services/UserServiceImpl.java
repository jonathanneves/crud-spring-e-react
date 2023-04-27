package com.spring.users.services;

import com.spring.users.dtos.UserDTO;
import com.spring.users.implementations.UserService;
import com.spring.users.models.User;
import com.spring.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    @Override
    public void update(Long id, UserDTO userDTO) {
        User user = findById(id);
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setBirthday(userDTO.getBirthday());
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        String message = String.format("User ID (%d) not Found!", id);
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(message));
    }
}

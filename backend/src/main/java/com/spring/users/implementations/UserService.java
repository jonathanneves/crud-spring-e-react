package com.spring.users.implementations;

import com.spring.users.dtos.UserDTO;
import com.spring.users.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    void deleteById(Long id);
    User create(UserDTO userDTO);
    void update(Long id, UserDTO userDTO);
    User findById(Long id);
}

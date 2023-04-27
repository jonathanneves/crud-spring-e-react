package com.spring.users.controllers;

import com.spring.users.dtos.UserDTO;
import com.spring.users.implementations.UserService;
import com.spring.users.models.User;
import com.spring.users.responses.SuccessResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @PostMapping()
    public ResponseEntity<User> create(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.create(userDTO);
        return new SuccessResponse<User>().handle(user, this.getClass(), request, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        userService.update(id, userDTO);
        return new SuccessResponse<String>().handle("Usuário atualizado com sucesso!", this.getClass(), request, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new SuccessResponse<String>().handle("Usuário deletado com sucesso!", this.getClass(), request, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new SuccessResponse<User>().handle(user, this.getClass(), request, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> UserList = userService.findAll();
        return new SuccessResponse<List<User>>().handle(UserList, this.getClass(), request, HttpStatus.OK);
    }
}

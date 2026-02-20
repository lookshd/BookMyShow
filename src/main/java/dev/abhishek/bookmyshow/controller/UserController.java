package dev.abhishek.bookmyshow.controller;

import dev.abhishek.bookmyshow.dto.CreateUserReqDTO;
import dev.abhishek.bookmyshow.dto.CreateUserRespDTO;
import dev.abhishek.bookmyshow.entity.User;
import dev.abhishek.bookmyshow.mapper.UserDTOMapper;
import dev.abhishek.bookmyshow.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/user")
    public ResponseEntity<CreateUserRespDTO> addUser(@RequestBody CreateUserReqDTO createUserReqDTO)
    {
        User reqUser = UserDTOMapper.getUser(createUserReqDTO);
        User savedUser = userService.createUser(reqUser);
        CreateUserRespDTO respUser = UserDTOMapper.getCreateUserRespDTO(savedUser);
        return ResponseEntity.ok(respUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

}

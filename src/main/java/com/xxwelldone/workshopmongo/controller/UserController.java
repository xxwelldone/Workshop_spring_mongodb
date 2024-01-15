package com.xxwelldone.workshopmongo.controller;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
    List<User> list = userService.findAll();
    List<UserDto> dtoList = list.stream().map(UserDto::new).toList();

        return ResponseEntity.ok().body(dtoList);
    }
    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user ){
        return ResponseEntity.ok().body(userService.save(user));
    }
}

package com.xxwelldone.workshopmongo.controller;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<Void> add(@RequestBody UserDto user ){
        User obj = userService.save(user);
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

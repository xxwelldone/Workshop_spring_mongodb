package com.xxwelldone.workshopmongo.controller;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.Post;
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
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDto ){
        User obj = userService.save(userDto);
        userDto.setId(obj.getId());
        URI  uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(userDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        User user = userService.findById(id);
        UserDto userDto = new UserDto(user);
        return ResponseEntity.ok().body(userDto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDto> put(@RequestBody UserDto userDto, @PathVariable String id){
       UserDto userDto1 = new UserDto(userService.put(id, userDto));
      return ResponseEntity.ok().body(userDto1);
    }
    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> getPosts (@PathVariable String id){
        User user = userService.findById(id);
    return ResponseEntity.ok().body(user.getPosts());

    }
}

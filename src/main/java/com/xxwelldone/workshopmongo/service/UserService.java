package com.xxwelldone.workshopmongo.service;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    public User save(UserDto user){
        return repo.save(new User(user.getId(), user.getName(), user.getEmail()));
    }
}

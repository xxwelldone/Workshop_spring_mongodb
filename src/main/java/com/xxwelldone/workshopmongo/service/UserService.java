package com.xxwelldone.workshopmongo.service;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.repository.UserRepository;
import com.xxwelldone.workshopmongo.service.exception.NotFoundException;
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
    public User findById(String id){

      return  repo.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
    public User save(UserDto user){
        return repo.save(new User(user.getId(), user.getName(), user.getEmail()));
    }
}

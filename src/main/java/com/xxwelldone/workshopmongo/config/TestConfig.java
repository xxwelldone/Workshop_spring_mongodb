package com.xxwelldone.workshopmongo.config;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.Post;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.service.PostService;
import com.xxwelldone.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {

        User x =new User(null, "Wesley", "wm@gmail.com");
        User y =  new User(null, "Fefucho", "fefu@gmail.com");

        userService.saveAll(Arrays.asList(x,y));
        Post p = new Post(null, Instant.now(), "Jão chato demais", "Gente??????? como aguentam?");
        postService.save(p);

    }
}
package com.xxwelldone.workshopmongo.config;

import com.xxwelldone.workshopmongo.dto.UserDto;
import com.xxwelldone.workshopmongo.model.Comment;
import com.xxwelldone.workshopmongo.model.Post;
import com.xxwelldone.workshopmongo.model.User;
import com.xxwelldone.workshopmongo.repository.CommentRepository;
import com.xxwelldone.workshopmongo.repository.PostRepository;
import com.xxwelldone.workshopmongo.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        commentRepository.deleteAll();

        User x =new User(null, "Wesley", "wm@gmail.com");
        User y =  new User(null, "Fefucho", "fefu@gmail.com");

        userService.saveAll(Arrays.asList(x,y));
        Post p = new Post(null, Instant.now(), "Jão chato demais", "Gente??????? como aguentam?", new UserDto(x));
        Post p2 = new Post(null, Instant.now(), "Vanessa Lopes doidona", "Gente??????? como aguentam?", new UserDto(x));
        Comment c1 = new Comment(null, "Saiu ne? kkk", Instant.now(), new UserDto(y) );
        commentRepository.save(c1);
        p2.getComments().add(c1);
        postService.save(p);
        postService.save(p2);
        x.getPosts().addAll(Arrays.asList(p,p2));
        userRepository.save(x);

    }
}
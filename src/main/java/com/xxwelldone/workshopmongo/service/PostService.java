package com.xxwelldone.workshopmongo.service;

import com.xxwelldone.workshopmongo.model.Post;
import com.xxwelldone.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post save(Post p){
        return postRepository.save(p);
    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}

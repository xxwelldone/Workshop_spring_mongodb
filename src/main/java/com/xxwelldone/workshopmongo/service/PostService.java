package com.xxwelldone.workshopmongo.service;

import com.xxwelldone.workshopmongo.model.Post;
import com.xxwelldone.workshopmongo.repository.PostRepository;
import com.xxwelldone.workshopmongo.service.exception.NotFoundException;
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

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
    public Post put(String id, Post p){
        Post obj = findById(id);
        obj.setAuthor(p.getAuthor());
        obj.setBody(p.getBody());
        obj.setTitle(p.getTitle());
       return postRepository.save(obj);
    }
}

package com.xxwelldone.workshopmongo.controller;

import com.xxwelldone.workshopmongo.controller.exception.URL;
import com.xxwelldone.workshopmongo.model.Post;
import com.xxwelldone.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok().body(postService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> put(@PathVariable String id, @RequestBody Post post){
      Post p=  postService.put(id, post);
      return ResponseEntity.ok().body(p);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> findAllByTitle
            (@RequestParam(value = "title", defaultValue = "") String title){

        return ResponseEntity.ok().body(postService.findAllByTitle( URL.decodeParam(title)));
    }
}

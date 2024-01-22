package com.xxwelldone.workshopmongo.controller;

import com.xxwelldone.workshopmongo.model.Comment;
import com.xxwelldone.workshopmongo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/comment" )
public class CommentController {
    @Autowired
    private CommentService commentService;

   @GetMapping("/{id}")
    public ResponseEntity<Comment> get(@PathVariable String id){
      return ResponseEntity.ok().body( commentService.findById(id));
   }
   @PostMapping
    public ResponseEntity<Comment> post(@RequestBody Comment comment){
       Comment obj = commentService.save(comment);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/comment").
               buildAndExpand(obj.getId()).toUri();
       return ResponseEntity.created(uri).body(obj);

   }
}

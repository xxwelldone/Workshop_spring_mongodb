package com.xxwelldone.workshopmongo.service;

import com.xxwelldone.workshopmongo.model.Comment;
import com.xxwelldone.workshopmongo.repository.CommentRepository;
import com.xxwelldone.workshopmongo.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment save(Comment c){
        return commentRepository.save(c);
    }
    public Comment findById(String id){
        return commentRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }
    public void delete(String id){
        findById(id);
        commentRepository.deleteById(id);
    }
    public Comment put(String id, Comment c){
        Comment obj = findById(id);
        obj.setText(c.getText());
      return  save(c);
    }
}

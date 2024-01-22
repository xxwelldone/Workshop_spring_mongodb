package com.xxwelldone.workshopmongo.repository;

import com.xxwelldone.workshopmongo.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

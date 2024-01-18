package com.xxwelldone.workshopmongo.repository;

import com.xxwelldone.workshopmongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

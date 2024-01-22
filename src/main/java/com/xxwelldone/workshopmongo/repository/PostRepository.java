package com.xxwelldone.workshopmongo.repository;

import com.xxwelldone.workshopmongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    public List<Post> findAllBytitleContainingIgnoreCase(String title);
}

package com.xxwelldone.workshopmongo.repository;

import com.xxwelldone.workshopmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

package com.task.shashank.repository;

import com.task.shashank.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users, String> {
    Users findByUsername(String name);
}

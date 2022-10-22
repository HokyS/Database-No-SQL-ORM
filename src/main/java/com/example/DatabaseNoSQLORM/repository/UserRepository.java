package com.example.DatabaseNoSQLORM.repository;

import com.example.DatabaseNoSQLORM.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}

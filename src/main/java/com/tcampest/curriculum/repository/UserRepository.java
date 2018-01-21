package com.tcampest.curriculum.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tcampest.curriculum.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByFirstName(String firstName);
    public User findByUsername(String username);
    public List<User> findByLastName(String lastName);

}

package com.poc.service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.poc.domain.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	List<User> findByAddress(String address);

}

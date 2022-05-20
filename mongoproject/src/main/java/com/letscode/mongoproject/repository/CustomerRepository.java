package com.letscode.mongoproject.repository;

import com.letscode.mongoproject.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    Optional<Customer> findByRegistrationNumber(String registrationNumber);
}

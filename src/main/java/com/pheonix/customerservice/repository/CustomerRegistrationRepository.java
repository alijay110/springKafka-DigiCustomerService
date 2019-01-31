package com.pheonix.customerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pheonix.customerservice.model.Registration;

public interface CustomerRegistrationRepository  extends MongoRepository<Registration, String> {


}

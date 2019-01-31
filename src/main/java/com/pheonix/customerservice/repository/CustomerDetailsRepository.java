package com.pheonix.customerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pheonix.customerservice.model.CustomerDetails;

public interface CustomerDetailsRepository  extends MongoRepository<CustomerDetails, String> {


}

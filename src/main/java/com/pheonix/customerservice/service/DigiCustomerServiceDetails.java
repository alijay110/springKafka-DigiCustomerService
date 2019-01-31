package com.pheonix.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import com.pheonix.customerservice.model.CustomerDetails;

@Service
public class DigiCustomerServiceDetails {
	
	@Autowired
	MongoOperations mongoOperations;

	/*@Autowired
	MongoTemplate mongoTemplate;*/

	public void createRegistrationEvent(CustomerDetails customerDetails) {
		
		mongoOperations.save(customerDetails);


		
	}

}

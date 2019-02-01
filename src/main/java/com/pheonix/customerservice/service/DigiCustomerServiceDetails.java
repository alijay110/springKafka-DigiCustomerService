package com.pheonix.customerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pheonix.customerservice.model.Addresses;
import com.pheonix.customerservice.model.CustomerDetails;

@Service
public class DigiCustomerServiceDetails {

	@Autowired
	MongoOperations mongoOperations;

	/*@Autowired
	MongoTemplate mongoTemplate;*/

	public void createParticulars(CustomerDetails customerDetails) {

		mongoOperations.save(customerDetails);



	}

	public CustomerDetails updateAddress(String id, Addresses addresses) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		
		CustomerDetails userTest1 = mongoOperations.findOne(query, CustomerDetails.class);

		System.out.println("CustomerDetails find - " + userTest1);

		Update update = new Update();		
		//addresses.getAddress().stream().forEach(address -> update.push("address", address));
		//update.pushAll("address", addresses);
		update.push("address", addresses.getAddress());

		CustomerDetails cgs =  mongoOperations.findAndModify(query, update, new FindAndModifyOptions().returnNew(true),CustomerDetails.class);
		//System.out.println("DigitalService find - " + dgs);
		if(cgs!=null) {
			//afterSaveListener.updateEvent(dgs);
			//afterSaveListener.updateEventInDiffPar(dgs);
		}		

		return cgs;

	}

}

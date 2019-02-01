package com.pheonix.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheonix.customerservice.model.Addresses;
import com.pheonix.customerservice.model.CustomerDetails;
import com.pheonix.customerservice.model.Registration;
import com.pheonix.customerservice.service.DigiCustomerService;
import com.pheonix.customerservice.service.DigiCustomerServiceDetails;

@RestController
@RequestMapping("/customers")
public class CustomerServiceController {


	@Autowired
	private DigiCustomerService customerService;
	
	@Autowired
	private DigiCustomerServiceDetails customerServiceDetails;
	

	@RequestMapping(path = "/registration", method = RequestMethod.POST)
	public ResponseEntity<String> sampleData(@RequestBody Registration registration) {		
		customerService.createRegistrations(registration);
		//load to event
		return new ResponseEntity("please check your email for the next steps.", HttpStatus.CREATED);
	}

	@RequestMapping(path = "/particulars", method = RequestMethod.POST)
	public ResponseEntity<String> createDGSApplication(@RequestBody CustomerDetails customerDetails) {
		customerServiceDetails.createParticulars(customerDetails);
		
		//load to event
		return new ResponseEntity("customer particulars created", HttpStatus.CREATED);
	}
	
	/*
	 * not working need to check this
	 */
	@RequestMapping(path = "/particulars/address/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<CustomerDetails> createDGSApplication(@PathVariable("id") String id,@RequestBody Addresses addresses) {
		
		
		CustomerDetails cds = customerServiceDetails.updateAddress(id, addresses);
		
		//load to event
		return new ResponseEntity(cds, HttpStatus.OK);
	}

	

}

package com.pheonix.customerservice.messageservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.pheonix.customerservice.model.RegistrationEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Sender {

	@Autowired
	private KafkaTemplate<String, RegistrationEvent> registrationCreatedkafkaTemplate;

	public void sendRegistrationCreatedTemplate(String topic,int partition,String key, RegistrationEvent payload) {

		log.info("sending payload='{}' to topic='{}'", payload, topic);
		registrationCreatedkafkaTemplate.send(topic,partition,key, payload);
	}

	
}

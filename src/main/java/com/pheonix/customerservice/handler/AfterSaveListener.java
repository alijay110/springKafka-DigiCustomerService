package com.pheonix.customerservice.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Controller;

import com.pheonix.customerservice.messageservice.Sender;
import com.pheonix.customerservice.model.Registration;
import com.pheonix.customerservice.model.RegistrationEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AfterSaveListener extends AbstractMongoEventListener<Registration> {

	@Value("${spring.kafka.topic.dgs-customerRegistration}")
	private String registrationCreatedTopic;
	

	private Sender sender;

	@Autowired
	public AfterSaveListener(Sender sender) {

		this.sender = sender;
	}	
	@Override
    public void onAfterSave(AfterSaveEvent<Registration> event) {

        log.info("onAfterSave event='{}'", event);
        Registration rgs = event.getSource();

        RegistrationEvent registrationEvent = new RegistrationEvent();
        registrationEvent.setId(rgs.getId());
        registrationEvent.setEmail(rgs.getEmail());
        registrationEvent.setUserId(rgs.getUserId());
        
       
        sender.sendRegistrationCreatedTemplate(registrationCreatedTopic,0,"app_reg",registrationEvent);
    }
	
	

}

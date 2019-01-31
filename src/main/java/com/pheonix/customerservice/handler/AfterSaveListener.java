package com.pheonix.customerservice.handler;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AfterSaveListener extends AbstractMongoEventListener<Object> {

	


}

package com.pheonix.customerservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class RegistrationEvent {

	@Id
	private String id;

	@NonNull
	private String email;

	@NonNull
	private String userId;


}

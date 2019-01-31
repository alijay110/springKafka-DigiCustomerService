package com.pheonix.customerservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document(collection = "customerDetails")
public class CustomerDetails {
	
	@Id
	private String id;

	@NonNull
	private String email;
	
	@NonNull
	private String userId;

    @NonNull
    private Date createdAt;
    
    
    private Date updatedAt;

	
    @NonNull
    private Particulars particulars;
    
    
    

}

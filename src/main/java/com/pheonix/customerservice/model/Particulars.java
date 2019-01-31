package com.pheonix.customerservice.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Particulars {
	
	@NonNull
    private Name name;
	
	
	private Identity identity;	
	
    @NonNull
    private Contact contact;

    @NonNull
    private List<Address> address;

}

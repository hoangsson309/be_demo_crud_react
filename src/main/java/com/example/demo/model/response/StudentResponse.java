package com.example.demo.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

public interface StudentResponse {
	
	@Value("#{target.id}")
	Integer getId();
	
	@Value("#{target.name}")
	String getName();
	
	@Value("#{target.age}")
	String getAge();
	
	@Value("#{target.gender}")
	String getGender();
	
	@Value("#{target.address}")
	String getAddress();
	
}

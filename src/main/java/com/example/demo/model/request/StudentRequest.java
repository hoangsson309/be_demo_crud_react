package com.example.demo.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class StudentRequest {
	@NotNull
	@Length(max = 100)
	@Nationalized
	private String name;
	
	@NotNull
	private Integer age;
	
	@NotNull
	@Length(max = 250)
	private String gender;
	
	@NotNull
	@Length(max = 250)
	private String address;
}

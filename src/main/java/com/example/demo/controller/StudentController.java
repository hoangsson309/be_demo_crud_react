package com.example.demo.controller;

import com.example.demo.model.request.StudentRequest;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@CrossOrigin({"*"})
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/{pageNo}")
	public ResponseEntity getAll(@PathVariable("pageNo") Integer pageNo, Pageable pageable){
		return new ResponseEntity(service.getAll(pageNo, 5, pageable), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity add(@RequestBody StudentRequest request){
		return new ResponseEntity(service.add(request), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Integer id,@RequestBody StudentRequest request){
		return new ResponseEntity(service.update(id ,request), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") Integer id){
		return new ResponseEntity(service.delete(id), HttpStatus.OK);
	}
	
	@GetMapping("/detail/{id}")
	public ResponseEntity detail(@PathVariable("id") Integer id){
		return new ResponseEntity(service.getOne(id), HttpStatus.OK);
	}
}

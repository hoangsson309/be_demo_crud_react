package com.example.demo.service.impl;

import com.example.demo.entity.Student;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.model.response.StudentResponse;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public Page<StudentResponse> getAll(Integer currentPage, Integer size, Pageable pageable) {
		pageable = PageRequest.of(currentPage, size);
		return repository.getAllCustom(pageable);
	}
	
	@Override
	public Student add(StudentRequest request) {
		Student student = Student.builder()
				.name(request.getName())
				.age(request.getAge())
				.gender(request.getGender())
				.address(request.getAddress())
				.build();
		return repository.save(student);
	}
	
	@Override
	public Student update(Integer id, StudentRequest request) {
		Student studentOld = repository.findById(id).get();
		studentOld.setName(request.getName());
		studentOld.setAge(request.getAge());
		studentOld.setGender(request.getGender());
		studentOld.setAddress(request.getAddress());
		return repository.save(studentOld);
	}
	
	@Override
	public Student delete(Integer id) {
		Student studentOld = repository.findById(id).get();
		repository.delete(studentOld);
		return studentOld;
	}
	
	@Override
	public Student getOne(Integer id) {
		Student studentOld = repository.findById(id).get();
		return studentOld;
	}
}

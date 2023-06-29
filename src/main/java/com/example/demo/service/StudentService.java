package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.model.request.StudentRequest;
import com.example.demo.model.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
	Page<StudentResponse> getAll(Integer currentPage, Integer size, Pageable pageable);
	Student add(StudentRequest request);
	Student update(Integer id, StudentRequest request);
	Student delete(Integer id);
	Student getOne(Integer id);
}

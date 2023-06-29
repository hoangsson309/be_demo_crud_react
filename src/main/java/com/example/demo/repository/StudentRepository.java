package com.example.demo.repository;

import com.example.demo.entity.Student;
import com.example.demo.model.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(value = """
			select s.id as 'id', s.name as 'name', s.age as 'age', s.gender as 'gender',
			s.address as 'address' from student s
						""", nativeQuery = true)
	Page<StudentResponse> getAllCustom(Pageable pageable);
}

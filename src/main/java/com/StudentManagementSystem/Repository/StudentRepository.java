package com.StudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
}

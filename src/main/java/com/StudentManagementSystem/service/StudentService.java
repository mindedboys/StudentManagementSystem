package com.StudentManagementSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;

@Service
public interface StudentService {
	
	public List<Student> getAllStudents(); //show or get all student
	
    public Student saveStudent(Student student); //create  
	
    public Student getById(int id); //update
    
    public void deleteByid(int id); //delete
}

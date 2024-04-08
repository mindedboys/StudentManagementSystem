package com.StudentManagementSystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;

@Service
public class ServiceImpl implements StudentService {

	@Autowired
	com.StudentManagementSystem.Repository.StudentRepository studentRepository;

	@Override // show or get all student
	public List<Student> getAllStudents() {

		List<Student> list = studentRepository.findAll();

		return list;
	}

	@Override  //create 
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	
	@Override // update
	public Student getById(int id) {

		return studentRepository.findById(id).get();
		
	}

	
	@Override //delete student
	public void deleteByid(int id) {
	
		studentRepository.deleteById(id);
	}

	
	
}

package com.captain.contentNegotiation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captain.contentNegotiation.dto.Student;

@RestController
public class StudentController {

	@GetMapping(value = "/student", produces = "text/plain")
	public String getStudentV1() {
		System.out.println("plain text method executed.");
		return new Student(1, "Axel", "axelb@inazuma.com").toString();
	}
	
	@GetMapping(value = "/student", produces = "application/json")
	public Student getStudentV2() {
		System.out.println("json method executed.");
		return new Student(1, "Axel", "axelb@inazuma.com");
	}
}

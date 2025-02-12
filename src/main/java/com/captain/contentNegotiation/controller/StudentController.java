package com.captain.contentNegotiation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.captain.contentNegotiation.dto.Student;

@RestController
public class StudentController {

	@GetMapping("/student")
	public String getStudentV1() {
		return new Student(1, "Axel", "axelb@inazuma.com").toString();
	}
}

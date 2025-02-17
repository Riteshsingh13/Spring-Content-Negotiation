package com.captain.contentNegotiation.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.captain.contentNegotiation.dto.Student;

@RestController
public class StudentController {

	@GetMapping(value = "/student", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getStudentV1() {
		System.out.println("plain text method executed.");
		return new Student(1, "Axel", "axelb@inazuma.com").toString();
	}
	
	@GetMapping(value = "/student", produces = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public Student getStudentV2() {
		System.out.println("json method executed.");
		return new Student(1, "Axel", "axelb@inazuma.com");
	}
	
	@GetMapping(value = "/student", produces = MediaType.APPLICATION_PDF_VALUE)
	public InputStreamResource getStudentV3() throws FileNotFoundException {
		System.out.println("pdf method executed.");
		InputStreamResource ret = null;
		FileInputStream fileInputStream = new FileInputStream("mystudent.pdf");
		ret = new InputStreamResource(fileInputStream);
		return ret;
	}
	
	@PostMapping(value = "/student", consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public void createStudent(@RequestBody Student student) {
		System.out.println(student);
	}
}

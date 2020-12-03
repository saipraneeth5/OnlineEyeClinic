package com.onlineeyeclinic.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyeclinic.model.Tests;
import com.onlineeyeclinic.service.ITestService;

@RestController
//@RequestMapping("/api/test")
@Validated
public class TestController {

	@Autowired
	private ITestService testService;

	@PostMapping("/add_test")
	public ResponseEntity<Tests> addTest(@Valid @RequestBody Tests tests) {
		tests = testService.addTest(tests);
		return new ResponseEntity<>(tests, HttpStatus.OK);
	}

	@PutMapping("/update_test")
	public ResponseEntity<Tests> updateTest(@Valid @RequestBody Tests tests) {
		tests = testService.updateTest(tests);
		return new ResponseEntity<>(tests, HttpStatus.OK);
	}

	@DeleteMapping("/delete_test_by_id/{testId}")
	public ResponseEntity<String> deleteTestById(@PathVariable("testId") Integer testId) {
		testService.removeTest(testId);
		return new ResponseEntity<>("Test Deleted Successfully", HttpStatus.OK);
	}

	@GetMapping("/view_test_by_id/{testId}")
	public ResponseEntity<Optional<Tests>> viewTestById(@PathVariable("testId") Integer testId) {
		Optional<Tests> test = testService.viewTest(testId);
		return new ResponseEntity<>(test, HttpStatus.OK);
	}

	@GetMapping("/view_all-tests")
	public ResponseEntity<List<Tests>> viewAllTests() {
		return new ResponseEntity<>(testService.viewTestsList(), HttpStatus.OK);
	}

}

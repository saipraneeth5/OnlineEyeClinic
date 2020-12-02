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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.model.Doctor;
import com.onlineeyeclinic.service.IDoctorService;
/**
 * 
 * @author Kondraju Praneeth
 *
 */

/*
 * Rest Controller is combination of Annotations: Controller + ResponseBody
 */
@RestController
@RequestMapping("/api/Doctor")
@Validated
public class DoctorController {
	
	@Autowired
	IDoctorService service;
	
	/*
	 * To insert Doctor record to DB
	 */
	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor){
		doctor = service.addDoctor(doctor);
		return new ResponseEntity<>(doctor, HttpStatus.OK);
	}
	
	/*
	 * To update Doctor Record in DB if exists.
	 */
	@PutMapping("/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@Valid @RequestBody Doctor doctor) {
		doctor = service.updateDoctor(doctor);
		return new ResponseEntity<>(doctor, HttpStatus.OK); 
	}
	
	/*
	 * To Delete Doctor Record from DB if exists.
	 */
	@DeleteMapping("/deleteDoctorById/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("id") Long id) {
		service.deleteDoctor(id);
		return new ResponseEntity<>("Doctor Deleted Successfully", HttpStatus.OK);
	}
	
	/*
	 * To view Doctor Record from DB if exists
	 */
	@GetMapping("/viewDoctorById/{id}")
	public ResponseEntity<Optional<Doctor>> viewDoctorById(@PathVariable("id") Long id) throws DoctorIdNotFoundException{
		Optional<Doctor> doc = service.viewDoctor(id);
		return new ResponseEntity<>(doc, HttpStatus.OK);
	}
	
	/*
	 * To view All Records of Doctor from Doctor DB
	 */
	@GetMapping("/viewDoctorsList")
	public ResponseEntity<List<Doctor>> viewAllDoctors(){
		return new ResponseEntity<>(service.viewDoctorsList(), HttpStatus.OK);
	}
	
	/*
	 * To view all records form Appointment DB
	 */
//	@GetMapping("/viewAppointments")
//	public ResponseEntity<List<Appointment>> viewAllAppointments(){
//		return new ResponseEntity<List<Appointment>>(service.viewAppointments(), HttpStatus.OK);
//	}
//	
	/*
	 * To add test to Test DB
	 */
//	@PostMapping("/viewAddTest")
//	public ResponseEntity<Tests> addTest(@RequestBody Tests test){
//		test = 
//	}

}

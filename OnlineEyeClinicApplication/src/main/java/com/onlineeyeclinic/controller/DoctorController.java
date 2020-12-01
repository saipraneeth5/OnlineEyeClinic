package com.onlineeyeclinic.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/api/Doctor")
public class DoctorController {
	
	@Autowired
	IDoctorService service;
	
	@PostMapping("/addDoctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		doctor = service.addDoctor(doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	
	@PutMapping("/updateDoctor")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor){
		doctor = service.updateDoctor(doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK); 
	}
	
	@DeleteMapping("/deleteDoctorById/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable("id") Integer id) throws DoctorIdNotFoundException{
		Optional<Doctor> doc = service.viewDoctor(id);
		if(doc.isEmpty())
			throw new DoctorIdNotFoundException("Doctor ID Not Found :(");
		service.deleteDoctor(id);
		return new ResponseEntity<String>("Doctor Deleted Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/viewDoctorById/{id}")
	public ResponseEntity<Optional<Doctor>> viewDoctorById(@PathVariable("id") Integer id) throws DoctorIdNotFoundException{
		Optional<Doctor> doc = service.viewDoctor(id);
		if(doc.isEmpty())
			throw new DoctorIdNotFoundException("Doctor ID Not Found :(");
		return new ResponseEntity<Optional<Doctor>>(doc, HttpStatus.OK);
	}
	
	@GetMapping("/viewDoctorsList")
	public ResponseEntity<List<Doctor>> viewAllDoctors(){
		return new ResponseEntity<List<Doctor>>(service.viewDoctorsList(), HttpStatus.OK);
	}
	
//	@GetMapping("/viewAppointments")
//	public ResponseEntity<List<Appointment>> viewAllAppointments(){
//		return new ResponseEntity<List<Appointment>>(service.viewAppointments(), HttpStatus.OK);
//	}
	
//	@PostMapping("/viewAddTest")
//	public ResponseEntity<Tests> addTest(@RequestBody Tests test){
//		test = 
//	}

}

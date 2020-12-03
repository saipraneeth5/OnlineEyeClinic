package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyeclinic.model.Appointment;
import com.onlineeyeclinic.model.Patient;
import com.onlineeyeclinic.model.Report;
import com.onlineeyeclinic.model.Tests;

/** IPatientService interface provides abstract methods to perform CRUD operations on Patient entity, Book appointment, View report and tests
 * 
 * @author Prudhvi Mypati
 * 
 */


public interface IPatientService {
	
	Patient addPatient(Patient patient);
	
	Patient updatePatient(Patient patient);
	
	Patient deletePatient(Long patientId);
	
	Optional<Patient> findPatientById(Long patientId);
	
	List<Patient> viewPatientList();
	
	Appointment bookAppointment(Appointment appointment);
	
	Optional<Appointment> findAppointmentById(Integer appointmentId);
	
	Optional<Report> findReportByPatientId(Long patientId);
	
	List<Tests> viewAllTests();
}

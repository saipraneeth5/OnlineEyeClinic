package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyeclinic.model.Appointment;
import com.onlineeyeclinic.model.Doctor;
import com.onlineeyeclinic.model.Tests;

public interface IDoctorService {
	
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	Doctor deleteDoctor(Long doctorId);
	Optional<Doctor> viewDoctor(Long doctorId);
	List<Doctor> viewDoctorsList();
	List<Appointment> viewAppointments();
	Tests createTest(Tests test);

}

package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.model.Doctor;

public interface IDoctorService {
	
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(Long doctorId) throws DoctorIdNotFoundException;
	Optional<Doctor> viewDoctor(Long doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
//	List<Appointment> viewAppointments();
//	Tests createTest(Tests test);

}

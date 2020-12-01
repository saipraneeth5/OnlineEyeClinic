package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.model.Doctor;

public interface IDoctorService {
	
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException ;
	Optional<Doctor> viewDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList();
//	List<Appointment> viewAppointments();
//	Tests createTest(Tests test);

}

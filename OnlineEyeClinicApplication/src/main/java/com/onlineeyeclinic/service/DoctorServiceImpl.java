package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.model.Doctor;
import com.onlineeyeclinic.repository.IDoctorRepository;

@Service("name = DoctorService")
@Transactional
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	IDoctorRepository repository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		doctor = repository.save(doctor);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		doctor = repository.save(doctor);
		return doctor;
	}

	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> doc = repository.findById(doctorId);
		
		if(doc == null)
			throw new DoctorIdNotFoundException("Doctor ID Not Found");
		else
			repository.deleteById(doctorId);
		
		return null;
	}

	@Override
	public Optional<Doctor> viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> doc = repository.findById(doctorId);
		if(doc == null)
			throw new DoctorIdNotFoundException("Doctor ID Not Found");
		return doc;

	}

	@Override
	public List<Doctor> viewDoctorsList() {
		List<Doctor> allDoctors = repository.viewDoctorsList();
		return allDoctors;
	}

//	@Override
//	public List<Appointment> viewAppointments() {
//		List<Appointment> allAppointments = repository.viewAppointments();
//		return allAppointments;
//	}
//
//	@Override
//	public Tests createTest(Tests test) {
//		
//		return null;
//	}

}

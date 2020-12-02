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
	
	private static final String ERROR_MESSAGE = "Doctor ID Not Found";
	
	@Autowired
	private IDoctorRepository repository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		doctor = repository.save(doctor);
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException {
		Long doctorId = doctor.getDoctorId();
		Optional<Doctor> doc = repository.findById(doctorId);
		if(doc.isEmpty())
			throw new DoctorIdNotFoundException(ERROR_MESSAGE);
		doctor = repository.save(doctor);
		return doctor;
	}

	@Override
	public Doctor deleteDoctor(Long doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> doc = repository.findById(doctorId);
		if(doc.isEmpty())
			throw new DoctorIdNotFoundException(ERROR_MESSAGE);
		repository.deleteById(doctorId);
		return null;
		
	}

	@Override
	public Optional<Doctor> viewDoctor(Long doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> doc = repository.findById(doctorId);
		if(doc.isEmpty())
			throw new DoctorIdNotFoundException(ERROR_MESSAGE);
		return doc;

	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return repository.findAll();
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

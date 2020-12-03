package com.onlineeyeclinic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.exception.AppointmentIdNotFoundException;
import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.exception.InvalidAppointmentException;
import com.onlineeyeclinic.model.Appointment;
import com.onlineeyeclinic.model.Doctor;
import com.onlineeyeclinic.repository.IAppointmentRepository;

@Service(value = "appointmentService")
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {

	private static final String ERROR_MESSAGE = "Appointment ID Not Found";

	@Autowired
	private IAppointmentRepository appointmentRepository;

	@Autowired
	private IDoctorService doctorService;

	@Override
	public Appointment bookAppointment(Appointment appointment) {
		Optional<Doctor> doctor = doctorService.viewDoctor(appointment.getDoctorId());
		if (doctor.isEmpty()) {
			throw new DoctorIdNotFoundException("Doctor Id does not exist");
		}
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		Integer appointmentId = appointment.getAppointmentId();
		Optional<Appointment> appointments = appointmentRepository.findById(appointmentId);
		if (appointments.isEmpty()) {
			throw new InvalidAppointmentException(ERROR_MESSAGE);
		}
		Optional<Doctor> doctor = doctorService.viewDoctor(appointment.getDoctorId());
		if (doctor.isEmpty()) {
			throw new DoctorIdNotFoundException("Doctor Id does not exist");
		}
		appointment = appointmentRepository.save(appointment);
		return appointment;
	}

	@Override
	public Appointment cancelAppointment(Integer appointmentId) {
		Optional<Appointment> appointments = appointmentRepository.findById(appointmentId);
		if (appointments.isEmpty()) {
			throw new AppointmentIdNotFoundException(ERROR_MESSAGE);
		}

		appointmentRepository.deleteById(appointmentId);

		return null;

	}

	@Override
	public Optional<Appointment> findAppointmentById(Integer appointmentId) {
		Optional<Appointment> appointments = appointmentRepository.findById(appointmentId);
		if (appointments.isEmpty()) {
			throw new AppointmentIdNotFoundException(ERROR_MESSAGE);
		}
		return appointments;
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> viewAppointments(LocalDate date) {
		return appointmentRepository.viewAppointments(date);
	}

}

package com.onlineeyeclinic.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.model.Appointment;

@Repository(value =  "appointmentRepository")
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{
	@Query("select d from Appointment d where d.dateOfAppointment like ?1")
	List<Appointment> viewAppointments(LocalDate date);
	
}

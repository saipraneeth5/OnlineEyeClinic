package com.onlineeyeclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
	
	@Query("select doc from Doctor doc")
	List<Doctor> viewDoctorsList();
	
//	@Query("select a from Appointment a")
//	List<Appointment> viewAppointments();

}

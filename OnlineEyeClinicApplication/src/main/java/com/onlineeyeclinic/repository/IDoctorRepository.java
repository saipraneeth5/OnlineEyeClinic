package com.onlineeyeclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.model.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long>{

//	@Query("select a from Appointment a")
//	List<Appointment> viewAppointments();
}

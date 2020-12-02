package com.cg.onlineeyeclinic.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.onlineeyeclinic.exception.DoctorIdNotFoundException;
import com.onlineeyeclinic.model.Doctor;
import com.onlineeyeclinic.repository.IDoctorRepository;
import com.onlineeyeclinic.service.DoctorServiceImpl;


@TestInstance(Lifecycle.PER_CLASS)
 class DoctorServiceTest {
	
	@InjectMocks
	private DoctorServiceImpl doctorService;
	
	@Mock
	private IDoctorRepository doctorRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	 void addDoctorTest() {
		Doctor doc = new Doctor("sai", "10:30", "9876543210", "sai.global@doctor.com", "saiglobal", "Sai&%6412", "Hyderabad");
		
		when(doctorRepository.save(doc)).thenReturn(doc);
		
		doc = doctorService.addDoctor(doc);
		
		assertEquals("sai", doc.getDoctorName());
		verify(doctorRepository, times(1)).save(doc);
	}
	
	@Test
	void updateDoctorTest() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30", "9876543210", "sai.global@doctor.com", "saiglobal", "Sai&%6412", "Hyderabad");
		
		Long doctorId = doc.getDoctorId();
		Optional<Doctor> doctor = doctorRepository.findById(doctorId);
		
		when(doctorRepository.findById(doctorId)).thenReturn(doctor);
		when(doctorRepository.save(doc)).thenReturn(doc);
		
		doc.setAddress("chennai");
		
		doc = doctorService.updateDoctor(doc);
		
		assertEquals("chennai", doc.getAddress());
		verify(doctorRepository, times(1)).save(doc);
	}
	
	@Test
	 void deleteDoctorTest() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30", "9876543210", "sai.global@doctor.com", "saiglobal", "Sai&%6412", "Hyderabad");
		
		Long doctorId = doc.getDoctorId();
		Optional<Doctor> doctor = Optional.of(doc);
		when(doctorRepository.findById(doctorId)).thenReturn(doctor);
		
		doc = doctorService.deleteDoctor(doctorId);
		
		assertNull(doc);
		verify(doctorRepository, times(1)).deleteById(doctorId);
	}
	
	@Test
	 void viewDoctorTest() throws DoctorIdNotFoundException {
		Doctor doc = new Doctor("sai", "10:30", "9876543210", "sai.global@doctor.com", "saiglobal", "Sai&%6412", "Hyderabad");
		Long doctorId = doc.getDoctorId();
		Optional<Doctor> doctor = Optional.of(doc);
		when(doctorRepository.findById(doctorId)).thenReturn(doctor);
		
		Optional<Doctor> viewDoctor = doctorService.viewDoctor(doctorId);
		
		assertEquals("sai", viewDoctor.get().getDoctorName());;
		verify(doctorRepository, times(2)).findById(doctorId);
	}
	
	@Test
	 void viewDoctorsListTest() {
		List<Doctor> doctorsList = new ArrayList<Doctor>();
		doctorsList.add(new Doctor("sai", "10:30 AM", "9876543210", "sai.global@doctor.com", "saiGlobal", "Sai@Global123", "Chennai"));
		doctorsList.add(new Doctor("shiva", "11:30 AM", "9874563210", "shiva.global@doctor.com", "shivaGlobal", "shiva@Global123", "Hyderabad"));
		doctorsList.add(new Doctor("ram", "12:30 AM", "9876541230", "ram.global@doctor.com", "ramGlobal", "ram@Global123", "Nellore"));
	
		when(doctorRepository.findAll()).thenReturn(doctorsList);
		
		List<Doctor> docList = doctorService.viewDoctorsList();
		
		assertEquals(3, docList.size());
		verify(doctorRepository, times(1)).findAll();
	}


}

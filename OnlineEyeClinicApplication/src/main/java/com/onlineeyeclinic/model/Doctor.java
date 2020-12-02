package com.onlineeyeclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** This is entity class for patients with default constructor, parameterized constructor along with getters and setters
 * 
 * @author Kondraju Praneeth
 * @version 1.0
 */

@Entity
@Table(name = "DoctorModel")
public class Doctor {
	
	/**
	 * Data Fields
	 */
	/**
	 * @Id annotation is used to set a particular data field as primary key.
	 * @Column annotation is used to set column properties such as name, length.,etc.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 5)
	private Integer doctorId;
	@Column(length = 20)
	private String doctorName;
	@Column(length = 20)
	private String doctorConsultationTime;
	@Column(length = 10)
	private Long doctorMobile;
	@Column(length = 20)
	private String doctorEmail;
	@Column(length = 10)
	private String userName;
	@Column(length = 11)
	private String password;
	@Column(length = 20)
	private String address;
	//@Autowired
	//private Tests test;
	
	/**
	 * Default Constructor
	 */
	
	public Doctor() {

	}
	
	/**
	 * Parameterized Constructor
	 */
	
	

	public Doctor(String doctorName, String doctorConsultationTime, Long doctorMobile, String doctorEmail,
			String userName, String password, String address) {
		super();
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	/**
	 * Getters and setters for All data fields
	 * 
	 */
	
//
	public Integer getDoctorId() {
		return doctorId;
	}

	

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}

	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}

	public long getDoctorMobile() {
		return doctorMobile;
	}

	public void setDoctorMobile(Long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	public Tests getTest() {
//		return test;
//	}
//
//	public void setTest(Tests test) {
//		this.test = test;
//	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorConsultationTime="
				+ doctorConsultationTime + ", doctorMobile=" + doctorMobile + ", doctorEmail=" + doctorEmail
				+ ", userName=" + userName + ", password=" + password + ", address=" + address + "]";
	}
	
	
	

}

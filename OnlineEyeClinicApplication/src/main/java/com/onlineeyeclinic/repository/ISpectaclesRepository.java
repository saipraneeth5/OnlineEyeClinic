package com.onlineeyeclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyeclinic.model.Spectacles;

@Repository(value =  "spectaclesRepository")
public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer>{	
	
}
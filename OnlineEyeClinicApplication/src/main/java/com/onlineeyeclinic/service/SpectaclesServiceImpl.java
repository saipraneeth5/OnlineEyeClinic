package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyeclinic.exception.SpectaclesIdNotFoundException;
import com.onlineeyeclinic.model.Spectacles;
import com.onlineeyeclinic.repository.ISpectaclesRepository;

@Service("name= SpectaclesService")

@Transactional
public class SpectaclesServiceImpl implements ISpectaclesService {

	private static final String ERROR_MESSAGE = "Spectacles ID Not Found";

	@Autowired
	private ISpectaclesRepository spectaclesRepository;

	@Override
	public Spectacles addSpectacles(Spectacles spectacles) {
		return spectaclesRepository.save(spectacles);
	}

	@Override
	public Spectacles updateSpectacles(Spectacles spectacles) {
		Integer spectaclesId = spectacles.getSpectaclesId();
		Optional<Spectacles> specs = spectaclesRepository.findById(spectaclesId);
		if (specs.isEmpty())
			throw new SpectaclesIdNotFoundException(ERROR_MESSAGE);
		return spectaclesRepository.save(spectacles);
	}

	@Override
	public Spectacles deleteSpectacles(Integer spectaclesId) {
		Optional<Spectacles> specs = spectaclesRepository.findById(spectaclesId);
		if (specs.isEmpty())
			throw new SpectaclesIdNotFoundException(ERROR_MESSAGE);
		spectaclesRepository.deleteById(spectaclesId);
		return null;
	}

	@Override
	public Optional<Spectacles> viewSpectacles(Integer spectaclesId) {
		Optional<Spectacles> specs = spectaclesRepository.findById(spectaclesId);
		if (specs.isEmpty())
			throw new SpectaclesIdNotFoundException(ERROR_MESSAGE);
		return specs;

	}

	@Override
	public List<Spectacles> viewSpectaclesList() {
		return spectaclesRepository.findAll();
	}

}
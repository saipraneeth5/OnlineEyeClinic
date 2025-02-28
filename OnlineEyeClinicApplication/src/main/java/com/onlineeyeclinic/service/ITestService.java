package com.onlineeyeclinic.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyeclinic.model.Tests;

	public interface ITestService {
		Tests addTest(Tests tests);
		Tests updateTest(Tests tests);
		Tests removeTest(Integer testId);
		Optional<Tests> viewTest(Integer testId);
		List<Tests> viewTestsList();
	}


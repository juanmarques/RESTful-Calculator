package com.jm.calculator.service;

import java.util.List;
import java.util.Optional;

import com.jm.calculator.model.CalculationResult;
import com.jm.calculator.model.ValuesDtO;

public interface CalculatorService {

	CalculationResult add(Optional<ValuesDtO> values);

	default CalculationResult divide(Optional<ValuesDtO> values) {
		return null;
	}

	CalculationResult multiply(Optional<ValuesDtO> values);

	CalculationResult subtract(Optional<ValuesDtO> values);

	List<Integer> fibonacci(Optional<String> series);

}

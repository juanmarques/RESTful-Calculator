package com.jm.calculator.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.jm.calculator.exception.BadRequestException;
import com.jm.calculator.model.CalculationResult;
import com.jm.calculator.model.ValuesDtO;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public CalculationResult add(Optional<ValuesDtO> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(ValuesDtO::getFirstValue),
				values.flatMap(ValuesDtO::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationResult(BigDecimal.valueOf(firstValue).add(BigDecimal.valueOf(secondValue)));
	}

	@Override
	public CalculationResult divide(Optional<ValuesDtO> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(ValuesDtO::getFirstValue), values.flatMap(ValuesDtO::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationResult(
				BigDecimal.valueOf(firstValue).divide(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));

	}

	@Override
	public CalculationResult multiply(Optional<ValuesDtO> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(ValuesDtO::getFirstValue), values.flatMap(ValuesDtO::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationResult(
				BigDecimal.valueOf(firstValue).multiply(BigDecimal.valueOf(secondValue), MathContext.DECIMAL32));
	}

	@Override
	public CalculationResult subtract(Optional<ValuesDtO> values) {

		ValuesDtO checkValues = new ValuesDtO(values.flatMap(ValuesDtO::getFirstValue), values.flatMap(ValuesDtO::getSecondValue));

		float firstValue = checkValues.getFirstValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);
		float secondValue = checkValues.getSecondValue().map(Float::parseFloat)
				.orElseThrow(BadRequestException::new);

		return new CalculationResult(BigDecimal.valueOf(firstValue).subtract(BigDecimal.valueOf(secondValue)));
	}

	@Override
	public List<Integer> fibonacci(Optional<String> series) {
		int fibonacciSeries = series.filter(str -> str.matches("(^\\d*\\.?\\d*[1-9]+\\d*$)|(^[1-9]+\\.?\\d*$)"))
				.map(Integer::parseInt).orElseThrow(BadRequestException::new);

		return Stream
				.iterate(new int[] { 1, 1 },i -> new int[] { i[1], i[0] + i[1] })
				.limit(fibonacciSeries)
				.map(i -> i[0])
				.collect(Collectors.toList());
	}
}
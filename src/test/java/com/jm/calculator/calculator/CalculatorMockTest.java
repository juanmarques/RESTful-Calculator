package com.jm.calculator.calculator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.jm.calculator.model.CalculationResult;
import com.jm.calculator.model.ValuesDtO;
import com.jm.calculator.service.CalculatorService;
import com.jm.calculator.service.CalculatorServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockTest {

	@InjectMocks
	@Spy
	CalculatorService calculatorService = new CalculatorServiceImpl();

	Optional<ValuesDtO> values = Optional.of(new ValuesDtO(Optional.of("300"), Optional.of("2")));

	@Before
	public void setUp() {

		when(this.calculatorService.add(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(302)));
		when(this.calculatorService.divide(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(150)));
		when(this.calculatorService.multiply(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(600)));
		when(this.calculatorService.subtract(this.values)).thenReturn(new CalculationResult(BigDecimal.valueOf(298)));

	}

	@Test
	public void testAdd() {
		assertEquals(BigDecimal.valueOf(302), this.calculatorService.add(this.values).getResult());
	}

	@Test
	public void testDivide() {
		assertEquals(BigDecimal.valueOf(150), this.calculatorService.divide(this.values).getResult());
	}

	@Test
	public void testMultiply() {
		assertEquals(BigDecimal.valueOf(600), this.calculatorService.multiply(this.values).getResult());
	}

	@Test
	public void testSubtract() {
		assertEquals(BigDecimal.valueOf(298), this.calculatorService.subtract(this.values).getResult());
	}
}
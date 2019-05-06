package com.jm.calculator.model;

import java.util.Optional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValuesDtO {

	private Optional<String> firstValue;
	private Optional<String> secondValue;
	
	public ValuesDtO(Optional<String> firstValue, Optional<String> secondValue) {
		this.firstValue = firstValue.filter(str -> str.matches("(^\\d*\\.?\\d*[1-9]+\\d*$)|(^[1-9]+\\.?\\d*$)"));
		this.secondValue = secondValue.filter(str -> str.matches("(^\\d*\\.?\\d*[1-9]+\\d*$)|(^[1-9]+\\.?\\d*$)"));
	}

}
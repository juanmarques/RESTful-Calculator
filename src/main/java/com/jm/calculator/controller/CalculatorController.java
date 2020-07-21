package com.jm.calculator.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jm.calculator.model.CalculationResult;
import com.jm.calculator.model.ValuesDtO;
import com.jm.calculator.service.CalculatorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	private final CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {

		this.calculatorService = calculatorService;

	}

	@Operation(summary = "add", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "add")
	@GetMapping(value = "/add")
	public ResponseEntity<CalculationResult> add(ValuesDtO values) {

		return ResponseEntity.ok().body(this.calculatorService.add(Optional.ofNullable(values)));
	}

	@Operation(summary = "divide", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "divide")
	@GetMapping(value = "/divide")
	public ResponseEntity<CalculationResult> divide(ValuesDtO values) {

		return ResponseEntity.ok().body(this.calculatorService.divide(Optional.ofNullable(values)));

	}

	@Operation(summary = "multiply", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "multiply")
	@GetMapping(value = "/multiply")
	public ResponseEntity<CalculationResult> multiply(ValuesDtO values) {

		return ResponseEntity.ok().body(this.calculatorService.multiply(Optional.ofNullable(values)));

	}

	@Operation(summary = "subtract", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "subtract")
	@GetMapping(value = "/subtract")
	public ResponseEntity<CalculationResult> subtract(ValuesDtO values) {

		return ResponseEntity.ok().body(this.calculatorService.subtract(Optional.ofNullable(values)));
	}

	@Operation(summary = "fibonacci", tags = {
			"Calculator" }, description = "Returns a Fibonacci sequence up to the number entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The fibonacci series", content = @Content(schema = @Schema(implementation = Integer.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "fibonacci")
	@GetMapping(value = "/fibonacci/{series}")
	public ResponseEntity<List<Integer>> fibonacci(@PathVariable String series) {
		return ResponseEntity.ok().body(this.calculatorService.fibonacci(Optional.ofNullable(series)));
	}

}
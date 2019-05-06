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

	private CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {

		this.calculatorService = calculatorService;

	}

	@Operation(summary = "add", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "add")
	@GetMapping(value = "/add")
	public ResponseEntity<CalculationResult> add(Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorService.add(values));
	}

	@Operation(summary = "divide", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "divide")
	@GetMapping(value = "/divide")
	public ResponseEntity<CalculationResult> divide(Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorService.divide(values));

	}

	@Operation(summary = "multiply", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "multiply")
	@GetMapping(value = "/multiply")
	public ResponseEntity<CalculationResult> multiply(Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorService.multiply(values));

	}

	@Operation(summary = "substract", tags = {
			"Calculator" }, description = "Returns a result, based on the values entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The Calculator", content = @Content(schema = @Schema(implementation = ValuesDtO.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "subtract")
	@GetMapping(value = "/subtract")
	public ResponseEntity<CalculationResult> subtract(Optional<ValuesDtO> values) {

		return ResponseEntity.ok().body(this.calculatorService.subtract(values));
	}

	@Operation(summary = "fibbonachi", tags = {
			"Calculator" }, description = "Returns a Fibonacci sequence up to the number entered. or non numeric , negative numbers will simulate API error conditions", responses = {
					@ApiResponse(description = "The fibbonachi's serie", content = @Content(schema = @Schema(implementation = Integer.class))),
					@ApiResponse(responseCode = "400", description = "Please enter a valid input") }, operationId = "fibbonachi")
	@GetMapping(value = "/fibbonachi/{series}")
	public ResponseEntity<List<Integer>> fibbonachi(@PathVariable Optional<String> series) {
		return ResponseEntity.ok().body(this.calculatorService.fibbonachi(series));
	}

}
package com.jm.calculator.calculator;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.jm.calculator.CalculatorApplication;
import com.jm.calculator.model.CalculationResult;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorIntegrationTest {

	private RestTemplate rt;

	@LocalServerPort
	private int port;

	private String baseUrl = "";

	@Before
	public void init() {
		this.baseUrl = "http://localhost:" + this.port + "/api/calculator/";
		this.rt = new RestTemplate();
	}

	@Test
	public void add() throws Exception {
		CalculationResult result = this.rt.getForObject(this.baseUrl + "add?firstValue=150&secondValue=300",CalculationResult.class);
		assertEquals(BigDecimal.valueOf(450.0), result.getResult());
	}

	@Test
	public void divide() throws Exception {
		CalculationResult result = this.rt.getForObject(this.baseUrl + "divide?firstValue=150&secondValue=300",CalculationResult.class);
		assertEquals(BigDecimal.valueOf(0.5), result.getResult());
	}

	@Test
	public void multiply() throws Exception {
		CalculationResult result = this.rt.getForObject(this.baseUrl + "multiply?firstValue=150.93&secondValue=99.92",CalculationResult.class);
		assertEquals(BigDecimal.valueOf(15080.92), result.getResult());
	}

	@Test
	public void subtract() throws Exception {
		CalculationResult result = this.rt.getForObject(this.baseUrl + "subtract?firstValue=150.93&secondValue=99.92",CalculationResult.class);
		assertEquals(BigDecimal.valueOf(51.00999450683594), result.getResult());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void fibbonachi() throws Exception {
		List<Integer> result = this.rt.getForObject(this.baseUrl + "fibbonachi/8",List.class);
		assertEquals(Arrays.asList(1,1,2,3,5,8,13,21),result);
	}

	@Test
	public void validateAddStatusCodeWithZero() {
		given()
		.queryParam("firstValue", 1)
		.queryParam("secondValue", 0)
		.when().get(this.baseUrl + "add")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateAddStatusCodeWithString() {
		given()
		.queryParam("firstValue", "testeeeeeee@43!")
		.queryParam("secondValue", 0)
		.when().get(this.baseUrl + "add")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateAddStatusCodeWithNegative() {
		given().queryParam("firstValue", -2)
		.queryParam("secondValue", 32)
		.when().get(this.baseUrl + "add")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateAddStatusCodeWithEmpty() {
		given()
		.queryParam("firstValue", "")
		.queryParam("secondValue", 4343.243)
		.when().get(this.baseUrl + "add")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateDivideStatusCodeWithZero() {
		given()
		.queryParam("firstValue", 1)
		.queryParam("secondValue", 0)
		.when().get(this.baseUrl + "divide")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateDivideStatusCodeWithString() {
		given()
		.queryParam("firstValue", "testeeeeeee@Divide!")
		.queryParam("secondValue", 0)
		.when()
		.get(this.baseUrl + "divide")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateDivideStatusCodeWithNegative() {
		given()
		.queryParam("firstValue", -2)
		.queryParam("secondValue", 43432)
		.when().get(this.baseUrl + "divide")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateDivideStatusCodeWithEmpty() {
		given()
		.queryParam("firstValue", "")
		.queryParam("secondValue", 4343.243)
		.when().get(this.baseUrl + "divide")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateMultiplyStatusCodeWithZero() {
		given()
		.queryParam("firstValue", 1)
		.queryParam("secondValue", 0)
		.when().get(this.baseUrl + "multiply")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateMultiplyStatusCodeWithString() {
		given()
		.queryParam("firstValue", "testeeeeeee@43!")
		.queryParam("secondValue", 0)
		.when()
		.get(this.baseUrl + "multiply")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateMultiplyStatusCodeWithNegative() {
		given()
		.queryParam("firstValue", -2)
		.queryParam("secondValue", 3034)
		.when().get(this.baseUrl + "multiply")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateMultiplyStatusCodeWithEmpty() {
		given()
		.queryParam("firstValue", "")
		.queryParam("secondValue", 4343.243)
		.when().get(this.baseUrl + "multiply")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateSubtractStatusCodeWithZero() {
		given()
		.queryParam("firstValue", 1)
		.queryParam("secondValue", 0)
		.when().get(this.baseUrl + "subtract")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateSubtractStatusCodeWithString() {
		given()
		.queryParam("firstValue", "testeeeeeee@43!")
		.queryParam("secondValue", 0)
		.when()
		.get(this.baseUrl + "subtract")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateSubtractStatusCodeWithNegative() {
		given()
		.queryParam("firstValue", -2)
		.queryParam("secondValue", 4543)
		.when().get(this.baseUrl + "subtract")
		.then()
		.assertThat()
		.statusCode(400);
	}

	@Test
	public void validateSubtractStatusCodeWithEmpty() {
		given()
		.queryParam("firstValue", "")
		.queryParam("secondValue", 4343.243)
		.when().get(this.baseUrl + "subtract")
		.then()
		.assertThat()
		.statusCode(400);
	}
}
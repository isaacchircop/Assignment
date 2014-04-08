package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculator {

	Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test
	public void testAddPositiveNumbers() {
		assertEquals(5, calc.add(2, 3));
	}
	
	@Test
	public void testAddNegativeNumbers() {
		assertEquals(-6, calc.add(-3, -3));
	}
	
	@Test
	public void testDivision() {
		assertEquals(5, calc.divide(25, 5));
	}
	
	@Test
	public void testSubtraction() {
		assertEquals(3, calc.sub(6,3));
	}

	@Test
	public void testMultiplication() {
		assertEquals(15, calc.multiply(5,3));
	}
	
	@Test
	public void testSubtractionNegative() {
		assertEquals(0, calc.sub(-3,-3));
	}
}

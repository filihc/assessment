package com.filihc.assessment.test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.filihc.assessment.MultipleAndPalindromeWord;

public class MultipleAndPalindromeWordTest {
	
	private Logger logger = LoggerFactory.getLogger(MultipleAndPalindromeWordTest.class);
	
	private MultipleAndPalindromeWord multipleAndPalindromeWord;

	@Before
	public void setUp(){
		multipleAndPalindromeWord = new MultipleAndPalindromeWord();
	}
	
	@Test
	public void testSuccess() {
		
		String strExpected = "[2012, 20, 108, ANNA, NOON, ABA]";
		String strInput = "ANNA BAKES 2012 CAKES IN THE NOON, 201, 1089 ABA";
		Integer numInput = 2;
		
		String result = multipleAndPalindromeWord.getMultipleAndPalindromeWord(numInput, strInput);
		logger.info("expected: {} --> result: {}", strExpected, result);
		
		assertTrue("Bad implementation", strExpected.equals(result));
	}
	
	@Test
	public void testNoOutput() {
		
		String strExpected = "";
		String strInput = "CANADA";
		Integer numInput = 2;
		
		String result = multipleAndPalindromeWord.getMultipleAndPalindromeWord(numInput, strInput);
		logger.info("expected: {} --> result: {}", strExpected, result);
		
		assertTrue("Bad implementation", strExpected.equals(result));
	}

	@Test
	public void testInvalidNumber() {
		
		String strExpected = "[ANNA, NOON, ABA]";
		String strInput = "ANNA BAKES 2012 CAKES IN THE NOON, 201, 1089 ABA";
		Integer numInput = 11;
		
		String result = multipleAndPalindromeWord.getMultipleAndPalindromeWord(numInput, strInput);
		logger.info("expected: {} --> result: {}", strExpected, result);
		
		assertTrue("Bad implementation", strExpected.equals(result));
	}
}

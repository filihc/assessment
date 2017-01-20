package com.filihc.assessment.test;

import static org.junit.Assert.*;

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
	public void doTest() {
		
		String strExpected = "[80, 9892160, 16, ANNA, NOON, ABA]";
		String strInput = "ANNA BAKES 80 CAKES IN THE NOON, 989216011, 16 ABA";
		Integer numInput = 8;
		
		String result = multipleAndPalindromeWord.getMultipleAndPalindromeWord(numInput, strInput);
		logger.info("expected: {} --> result: {}", strExpected, result);
		
		assertTrue("Bad implementation", strExpected.equals(result));
	}

}

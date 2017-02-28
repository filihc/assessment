package com.filihc.assessment.test;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.filihc.assessment.NumberEnglishString;

public class NumberEnglishStringTest {
	
	private Logger logger = LoggerFactory.getLogger(NumberEnglishStringTest.class);
	private NumberEnglishString numberEnglishString;
	private DecimalFormat df;
	@Before
	public void setUp(){
		numberEnglishString = new NumberEnglishString();
		df = new DecimalFormat("###,###,###,###");
	}
	
	@Test
	public void testSuccess() {
		Integer number = 1111111111;
		String strExpected = "one thousand one hundred eleven million, one hundred eleven thousand, one hundred eleven";
		String result = numberEnglishString.numberToEnglishString(number);
		logger.info("expected {} --> {}", df.format(number), result);
		assertTrue("bad convertion: " + number + " -> " + result, result.equals(strExpected));
	}
	
	@Test
	public void testLoop(){
		Integer i = 0;
		for(i=0; i<20; i++){
			String result = numberEnglishString.numberToEnglishString(i);
			logger.info("{} --> {}", df.format(i), result);
		}
	}
	
	@Test
	public void testHundredsAndTens(){
		Integer i = 10;
		do{
			String result = numberEnglishString.numberToEnglishString(i);
			logger.info("{} --> {}", df.format(i), result);
			i += (i<100)?10:100;
		}while(i<1000);
	}
	
	@Test
	public void testThousandAndMillion(){
		Integer i = 1000;
		do{
			String result = numberEnglishString.numberToEnglishString(i);
			logger.info("{} --> {}", df.format(i), result);
			i += (i<10000)?1000:1000000;
		}while(i<10000000);
	}

}

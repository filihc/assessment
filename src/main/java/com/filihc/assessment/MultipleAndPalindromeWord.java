package com.filihc.assessment;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultipleAndPalindromeWord {
	
	private Logger logger = LoggerFactory.getLogger(MultipleAndPalindromeWord.class);
	
	private List<String> lstMultiple;
	private List<String> lstPalindrome;
	
	public String getMultipleAndPalindromeWord(Integer numInput, String strInput){
		String strOutput = new String();
		strInput = strInput.toUpperCase();
		lstMultiple = new ArrayList<String>();
		lstPalindrome = new ArrayList<String>();
		
		String []strArray = strInput.split(" |,");
		logger.info("input: {}", strInput);
		for(String word: strArray){
			logger.debug("{}", word);
			if(!isMultipleNumber(numInput, word)){
				isPalindrome(word);
			}
		}
		
		for(String word: lstMultiple){
			strOutput += word + ", ";
		}
		
		for(String word: lstPalindrome){
			strOutput += word + ", ";
		}
		
		if(strOutput.length() > 0){
			strOutput = "[" + strOutput.substring(0, strOutput.length()-2) + "]";
		}
		
		return strOutput;
	}
	
	private boolean isMultipleNumber(Integer numInput, String word){
		boolean flag = true;
		Integer number = null;
		try{
			do{
				number = Integer.valueOf(word);
				if((numInput > 0 && numInput < 10) && number%numInput == 0){
						lstMultiple.add(number.toString());
						logger.debug("multiple: {}", number);
						return true;
				}
				else{
					word = word.substring(0, word.length()-1);
					logger.debug("New number: {}", word);
				}
			}while(word.length() > 0);
			
		} catch(Exception e){
			flag = false;
		}
		return flag;
	}
	
	private boolean isPalindrome(String word){
		boolean flag = true;
		int lengthWord = word.length();
		int i=lengthWord-1;
		char []array = word.toCharArray();
		
		if(lengthWord > 0){
			for(char c: array){
				logger.debug("c: {} --> i: {}", c, array[i]);
				if(c != array[i--]){
					return false;
				}
			}
			lstPalindrome.add(word);
		}
		return flag;
	}
	

}

package com.filihc.assessment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberEnglishString {
	
	private Logger logger = LoggerFactory.getLogger(NumberEnglishString.class);
	
	public String numberToEnglishString(Integer number){
		String strEnglish = new String();
		String strNumber = number.toString();
		String strBlock = new String();
		int lengthNumber = strNumber.length();
		int blocks = (lengthNumber/3) + ( (lengthNumber<3 || lengthNumber%3 > 0 ? 1 : 0));
		logger.debug("blocks: {}", blocks);
		for(int i=blocks-1; i>=0; i--){
			int end = lengthNumber - (i*3);
			int init = lengthNumber - (3 + (i*3));
			init = init < 0 ? 0 : init;
			logger.debug("init {}, end {}", init, end);
			strBlock = strNumber.substring(init, end);
			logger.debug("Bloque {}: {}", i, strBlock);
			int lengthBlock = strBlock.length();
			int unit = 0; 
			int ten = 0;
			int hundred = 0;
			
			if(lengthBlock == 3){
				hundred = Integer.valueOf(strBlock.substring(0,1));
				ten = Integer.valueOf(strBlock.substring(1,2));
				unit = Integer.valueOf(strBlock.substring(2));
			} 
			else if(lengthBlock == 2){
				ten = Integer.valueOf(strBlock.substring(0,1));
				unit = Integer.valueOf(strBlock.substring(1));
			}
			else
				unit = Integer.valueOf(strBlock);
			
			if(hundred > 0)
				strEnglish += " " + getUnities(hundred) + " hundred";
			
			if(ten > 0 ){
				if(ten == 1 && unit > 0 ){
					strEnglish += " " + getTensInclusive(10+unit);
				}
				else{
					strEnglish += " " + getTens(ten);
				}
			}
			if((hundred == 0 && ten == 0) || (unit > 0 && ten != 1) )
				if(unit == 0 && strEnglish.length() == 0)
					strEnglish += " zero";
				else
					strEnglish += " " + getUnities(unit);
			
			switch(i){
				case 1:
					strEnglish += " thousand,";
					break;
				case 3:
					strEnglish += " thousand";
					break;
				case 2:
					strEnglish += " million,";
					break;
			}
			
		}
		
		strEnglish = strEnglish.trim();
		
		logger.debug("index: {} length: {}", strEnglish.lastIndexOf(","), strEnglish.length()-1);
		if(strEnglish.length() > 0 && strEnglish.lastIndexOf(",") >= strEnglish.length()-1)
			strEnglish = strEnglish.substring(0,strEnglish.length()-1);
		return strEnglish;
	}
	
	private String getUnities(Integer number){
		String strEnglish = new String();
		
		switch(number){
			case 1:
				strEnglish = "one";
				break;
			case 2:
				strEnglish = "two";
				break;
			case 3:
				strEnglish = "three";
				break;
			case 4:
				strEnglish = "four";
				break;
			case 5:
				strEnglish = "five";
				break;
			case 6:
				strEnglish = "six";
				break;
			case 7:
				strEnglish = "seven";
				break;
			case 8:
				strEnglish = "eight";
				break;
			case 9:
				strEnglish = "nine";
				break;
		}
		return strEnglish;
	}
	
	private String getTensInclusive(Integer number){
		String strEnglish = new String();
		
		switch(number){
			case 11:
				strEnglish = "eleven";
				break;
			case 12:
				strEnglish = "twelve";
				break;
			case 13:
				strEnglish = "therteen";
				break;
			case 14:
				strEnglish = "fourteen";
				break;
			case 15:
				strEnglish = "fifteen";
				break;
			case 16:
				strEnglish = "sixteen";
				break;
			case 17:
				strEnglish = "seventeen";
				break;
			case 18:
				strEnglish = "eighteen";
				break;
			case 19:
				strEnglish = "nineteen";
				break;
		}
		return strEnglish;
	}
	
	private String getTens(Integer number){
		String strEnglish = new String();
		
		switch(number){
			case 1:
				strEnglish = "ten";
				break;
			case 2:
				strEnglish = "twenty";
				break;
			case 3:
				strEnglish = "thirty";
				break;
			case 4:
				strEnglish = "forty";
				break;
			case 5:
				strEnglish = "fifty";
				break;
			case 6:
				strEnglish = "sixty";
				break;
			case 7:
				strEnglish = "seventy";
				break;
			case 8:
				strEnglish = "eighty";
				break;
			case 9:
				strEnglish = "ninety";
				break;
		}
		return strEnglish;
	}

}

package com.watsonas.jb;

public class Solution {

	public static int solution( String inputData ) {
		// 26 35 should return 5362...
		if ( inputData.isEmpty() ) {
			return 0;
		}
		
		int indexOfNewLineDelimiter = 0;
		String delimiter = ",";
		boolean customDelimiter = false;
		
		if ( inputData.startsWith("//") ) {
			indexOfNewLineDelimiter = inputData.indexOf("\n");
			delimiter = inputData.substring(2,indexOfNewLineDelimiter);
			customDelimiter = true;
		}
		
		System.out.println("Input data is "  + inputData );
		System.out.println("Delimiter is "  + delimiter );


		String inputDataWithoutDelimiter;
		if ( customDelimiter ) {
			inputDataWithoutDelimiter = inputData.substring(indexOfNewLineDelimiter+1);
		}
		else {
			inputDataWithoutDelimiter = inputData;
		}
		
		String[]splitData = inputDataWithoutDelimiter.split(delimiter);
		
		// need to check  overflow condition
		// Build result as a string
		StringBuilder result = new StringBuilder();
		// reverse through array
		for ( int i = splitData.length-1; i >= 0; i-- ) {
			Integer number;
			try {
				number = Integer.valueOf(splitData[i]);
			}
			catch( Exception e ) {
				throw new RuntimeException("Invalid input data");
			}
			
			System.out.println("Number is "  + number );
				
			if ( number < 0 ) {
				throw new RuntimeException("Invalid input data");
			}
			
			if ( number > 1000 ) {
				// silently skip numbers larger than 1000
			}
				
			result.append(new StringBuilder(number.toString()).reverse().toString());
			
		}
		
		try {
			Integer intResult = Integer.valueOf(result.toString());
			System.out.println("Result is "  + intResult );
			return intResult;
		}
		catch( Exception e ) {
			throw new RuntimeException("Invalid input data ");
		}
		
		
	}
}

package com.watsonas.codility;

public class Nesting {

	public static int solution( String S ) {

		int bracketCount = 0;
		for( int i = 0; i < S.length(); i++ ) {
			char data = S.charAt(i);
			switch( data ) {
			case '(':
				bracketCount++;
				break;
			case ')':
				if (bracketCount == 0 ) return 0;
				bracketCount--;
				break;
				default:
			// no action
			}
		}
		return bracketCount == 0 ? 1 : 0;
	
	}

	
		
}

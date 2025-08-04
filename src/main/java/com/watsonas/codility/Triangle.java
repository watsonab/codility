package com.watsonas.codility;

import java.util.Arrays;

public class Triangle {

	public static int solution( int[] A ) {
		if ( A.length < 3 ) return 0;
		Arrays.sort( A );
		for ( int first = 2; first < A.length; first ++ ) {
			if ( checkTriangle( A[first], A[first -1 ], A[first - 2]  ) ) {
				return 1;
			}
		}
		return 0;
	}


	static boolean checkTriangle( int first, int second, int third ) {
		try {
			if ( Math.addExact(first, second) <= third ) return false;
			if ( Math.addExact(third, second) <= first ) return false;
			if ( Math.addExact(first, third)  <= second) return false;
			System.out.println( first + " " + second + " " + third + " is a triangle " );
			return true;
		}
		catch( Exception e ) { 
			return true; 
		}
	}
		
}

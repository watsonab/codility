package com.watsonas.codility;

import java.util.HashSet;
import java.util.Set;

public class LowestIntegerNotInArray {

	public static int solution( int[] A ) {
		System.out.println("Lowest integer not in an array");
		
		Set<Integer> uniqueResults = new HashSet<>();
		for ( int i = 0; i < A.length; i++ ) {
			uniqueResults.add( A[i] );
		}
		
		for ( int n = 1; n < 1000000; n++ ) {
			if ( !uniqueResults.contains(n)) {
				return n;
			}
		}
		
		return 1;
	}
}

package com.watsonas.codility;

import java.util.Arrays;

public class MissingNumber {

	
	public static int solution( int[] A ) {
		// from array of N numbers, one number is missing 
		// eg 5,1,2,4 - 3 is missing
		Arrays.sort( Arrays.copyOf(A, A.length) );
		for( int i = 0; i < A.length -1; i++ ) {
			if ( A[i] + 1 != A[i+1] ) {
				return A[i] + 1;
			}
		}
		return -1;
	}
}

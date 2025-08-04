package com.watsonas.codility;

public class CyclicRotation {

	public static int[] solution( int[] A, int K ) {
		if ( A.length < 2 ) return A;
		int[] result = new int[A.length];
		int target = K % A.length;
		for ( int i = 0; i < A.length; i++ ) {
			result[target] = A[i];
			target += 1;
			if ( target >= A.length ) {
				target = 0;
			}
		}
		
		return result;
	}
		
}

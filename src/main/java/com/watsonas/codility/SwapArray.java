package com.watsonas.codility;

import java.util.stream.IntStream;

public class SwapArray {

	public static boolean slowSolution( int[]a, int[]b, int m ) {
		// swap elements
		if ( a.length != b.length ) throw new RuntimeException( "Arrays of unequal length");
		int n = a.length;
		int sum_a = IntStream.of(a).sum();
		int sum_b = IntStream.of(a).sum();
		for ( int i=0; i < n; i++ ) {
			for ( int j=0; j < n; j++ ) {
				int change = b[j] - a[i];
				sum_a += change;
				sum_b -= change;
				if ( sum_a == sum_b ) {
					return true;
				}
				sum_a -= change;
				sum_b += change;
			}
		}
	
		return false;
	}

/*
	public static boolean fastSolution( int[]a, int[]b, int m ) {
		// swap elements
		if ( a.length != b.length ) throw new RuntimeException( "Arrays of unequal length");
		int n = a.length;
		int sum_a = IntStream.of(a).sum();
		int sum_b = IntStream.of(a).sum();
		int d = sum_b - sum_a; // diff in totals
		if ( d % 2 == 1 ) {
			return false; // odd sums
		}
	
		d = d / 2;
		int count = counting( A, m ); // ?

		for ( int i=0; i < n; i++ ) {
			if ( 0 <= ( B[i] - d ) && ( B[i] - d <= m ) && ( count[B[i] - d] > 0 ) {
				return true;
			}
		}
		return false;
	}
*/

}

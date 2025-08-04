package com.watsonas.codility;

// you can also use imports, for example:
import java.util.HashMap;
import java.util.Map;

public class CountNonDivisible {


	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");
	public static int[] solution( int[] A ) {
			int[] result = new int[A.length];
			
			// TODO
			// Create map of unique numbers from data, including the count of each numbers
			// From this unique set, determine the number of non-divisors for each number.
			
			Map<Integer,Integer> results = new HashMap<>();
			
			for( int i = 0; i < A.length; i++ ) {
				int target = A[i];
				int divisors = 0;
				
				// use cached result if poss
				if ( results.get(target) != null ) {
					result[i] = results.get(target);
				}
				else {
					for( int j = 0; j < A.length; j++ ) {
						if ( A[j] == 1 || A[j] == target ) {
							divisors++;
						} else {
							if ( ( target % A[j] ) == 0 ) {
								divisors++;
							}
						}
					}
					result[i] = A.length - divisors;
					results.put(target, result[i]);
				}
			}
			
			return result;
		
		}

	}


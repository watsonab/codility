package com.watsonas.codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class MinAbsSumLogical {
	
	
	public static int solution( int[] A ) {
		
		// Sort numbers largest first.
		// Running total - if total +ve, subtract next number... if total -ve, add next number
		

		Comparator<Integer> comparator = new Comparator<Integer>() {
	        @Override
	        public int compare(Integer o1, Integer o2) {
	        	Integer first = Math.abs(o1);
	        	Integer second = Math.abs(o2);
	            return second.compareTo(first);
	        }
	    };
	    
		List<Integer> dataAsList = Arrays.stream(A).boxed().collect(Collectors.toList());
		
		Collections.sort(dataAsList,comparator);
		
		System.out.println( dataAsList );
		int runningSum = 0;
		for( Integer dataPoint : dataAsList ) {
			if ( runningSum > 0 && dataPoint > 0 ) {
				runningSum -= dataPoint;
			}
			else {
				runningSum += dataPoint;
			}
			System.out.println("Running sum is " + runningSum );

		}
		
		return Math.abs(runningSum);
	}
	
	
    

}

package com.watsonas.codility;

public class PassingCars {

	
	public static int solution( int[] A ) {
	
		// key is the index of the east travelling car
		// value is the count of west travelling cars it has passed
		int countOfEastCars = 0;
		int countOfCarPairs = 0;
		
		for ( int i = 0; i < A.length; i++ ) {
			if ( A[i] == 0 ) {
				countOfEastCars++; // log the east travelling car we came across
			}
			else {
				// this car is travelling west.. therefore it will pass all previous east travelling cars
				countOfCarPairs += countOfEastCars;
				if ( countOfCarPairs > 1000000000 ) {
					return -1;
				}

			}
		}

		return countOfCarPairs;
	}
	
	
	/*
	public static int solution( int[] A ) {
	
		// key is the index of the east travelling car
		// value is the count of west travelling cars it has passed
		Set<Integer> eastCars = new HashSet<>();
		int countOfCarPairs = 0;
		
		for ( int i = 0; i < A.length; i++ ) {
			if ( A[i] == 0 ) {
				eastCars.add( i ); // log the east travelling car we came across
				if ( eastCars.size() > 1000000 ) {
					return -1;
				}
			}
			else {
				// this car is travelling west.. therefore it will pass all previous east travelling cars
				for ( Integer key : eastCars ) {
					System.out.println( key + " is passing " + i );
					countOfCarPairs++;
				}
			}
		}

		return countOfCarPairs;
	}
	*/
		
}

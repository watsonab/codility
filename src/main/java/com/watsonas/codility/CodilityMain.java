package com.watsonas.codility;

public class CodilityMain {

	static int[] triangleData = new int[] { 10,2,5,1,8,12  };
	static int[] triangleDataMaxInt = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
	static int[] testData = new int[] { 8,1,3,4,5,24, 17,1041  };
	static int[] bigTestData = new int[] { 8,3,3,4,5,66,42,12,11,20,10,10,7,8,3,3,4,5,66,42,12,11,20,10,10,7,8,3,3,4,5,66,42,12,11,20,10,10,7 };
	static int[] codilitytestData = new int[] { 5,4,1,-2 };
	static int[] codilitytestData2 = new int[] { 5, 4, 3,3,3 };
	static int[] codilitytestData3 = new int[] { 5, 4 };
	static int[] codilitytestData4 = new int[] { 5, 4, 3,3,3,8,7,6,5,4,3,2,20,10,10,7,8,3,3,4,5,66,42 };

	static String goodBrackets = "(()(())())";
	static String badBrackets = "(()(())()";
	static int[] frogJump = new int[] { 10, 85, 30 };
	static int[] dominator = new int[] { 3,4,3,2,3,-1,3,3 };
	static int[] minLargeSum = new int[] { 2,1,5,1,2,2,2 };
	static int[] nonDivisors = new int[] { 3,1,2,3,6 };
	static int[] swapArray = new int[] { 3,1,2,3,7 };
	static int[] passingCars = new int[] { 0,1,0,1,1 };
	

	static int[] missingNumber = new int[] { 5,1,2,4 };
	
	static int[] nonOverlappingLeft = new int[] { 1,3,7,9,9,9 };
	static int[] nonOverlappingRight = new int[] { 5,6,8,9,9,10};
	
	static int[] tieRopes = new int[] {1,2,3,4,1,1,3};
	
	public static void main( String[] args ) {

//		System.out.println( "Tie ropes count is " + TieRopes.solution(tieRopes, 4) );
		
//		System.out.println( "Non overlapping count is " + MaxNonOverlapping.solution(nonOverlappingLeft, nonOverlappingRight) );

		
//		System.out.println( MissingNumber.solution(missingNumber) + " is missing from " + Arrays.toString( missingNumber ) );
//		System.out.println( Arrays.stream(triangleData).boxed().collect(Collectors.toList()).toString() + " has " + CountTriangles.solution(triangleData) +  " triangles " );
		
//		System.out.println( Arrays.stream(triangleData).boxed().collect(Collectors.toList()).toString() + " has " + ( Triangle.solution(triangleData)  == 0 ? " no triangle " : " a triangle " ));
		
		/*
		long startTime = System.currentTimeMillis();
		int minSum = MinAbsSumTree.solution( bigTestData );
		long endTime = System.currentTimeMillis();
		System.out.println("Tree min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );

		long startTime = System.currentTimeMillis();
		int minSum = MinAbsSumArrayEfficient.solution( bigTestData );
		long endTime = System.currentTimeMillis();
		System.out.println("Fork min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );

		*/
//		System.out.println("Passing cars in " +  Arrays.toString(passingCars) + " is " + PassingCars.solution(passingCars) );

//		System.out.println("Fibonnaci is " + Fibonnaci.solution(12) );

//		System.out.println("Swap is " + ( SwapArray.slowSolution( nonDivisors, swapArray, 10 ) ? "ok" : " not ok" ) );

//		System.out.println("Total is " + Total.solution(7) );

//		System.out.println("CountNonDivisble of " + Arrays.toString(nonDivisors) + " is " + Arrays.toString( CountNonDivisibleExternal.solution(nonDivisors) ));

		// System.out.println("CyclicRotation of " + Arrays.toString(testData) + " is " + Arrays.toString( CyclicRotation.solution(testData, 3) ));
		// System.out.println("MinMaxDivision is " + MinMaxDivision.solution( 3, 5, minLargeSum ) );

		// System.out.println("Dominator is " + Dominator.solution( dominator) );

		// System.out.println("Frog jumps " + FrogJmp.solution( 10, 85, 30 ) );
		
		//System.out.println( goodBrackets + " is " + ( Nesting.solution(goodBrackets) == 1 ? "ok" : "not ok" ));
		//System.out.println( badBrackets + " is " + ( Nesting.solution(badBrackets) == 1 ? "ok" : "not ok" ));
		
		// System.out.println("Lowest integer is " + LowestIntegerNotInArray.solution( testData ) );

		
		/*
		long startTime = System.currentTimeMillis();
		int minSum = MinAbsSumArrayEfficient.solution( codilitytestData );
		long endTime = System.currentTimeMillis();
		System.out.println("Logical min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );

		
		startTime = System.currentTimeMillis();
		minSum = MinAbsSumArray.solution( codilitytestData );
		endTime = System.currentTimeMillis();
		System.out.println("Min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
		

		startTime = System.currentTimeMillis();
		minSum = MinAbsSumForkJoin.solution( codilitytestData );
		endTime = System.currentTimeMillis();
		System.out.println("Fork min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );

		LinkedListAw<Integer> testList = new LinkedListAw();
		testList.push(6).push(3);
		while ( !testList.isEmpty() ) {
			System.out.println( testList.pop() );
		}
		*/
	}

}


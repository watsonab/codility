package com.watsonas.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test; 

public class MinAbsSumTest {
	static final int[] codilitytestData1 = new int[] { 5,4,1,-2 };
	static final int[] codilitytestData2 = new int[] { 5, 4, 3,3,3 };
	static final int[] codilitytestData3 = new int[] { 5, 4 };
	static final int[] codilitytestData4 = new int[] { 5, 4, 3,3,3,8,7,6,5,4,3,2,20,10,10,7,8,3,3,4,5,66,42 };

	static int[][] testSet = new int[][]{ codilitytestData1, codilitytestData2, codilitytestData3 };
	static int[] testResult = new int[]{ 0,0,1,1 };
	
	@Test
	public void testMinAbsSumArrayEfficient( ) {
		for ( int i = 0; i < testSet.length; i++ ) {
			long startTime = System.currentTimeMillis();
			int minSum = MinAbsSumArrayEfficient.solution(testSet[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("MinAbsSumArrayEfficient min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
			assertEquals( testResult[i], minSum );
		}
	}

	
	@Test
	public void testMinAbsSumArray( ) {
		for ( int i = 0; i < testSet.length; i++ ) {
			long startTime = System.currentTimeMillis();
			int minSum = MinAbsSumArray.solution(testSet[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("MinAbsSumArray min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
			assertEquals( testResult[i], minSum );
		}
	}

	
	@Test
	public void testMinAbsSumFork( ) {
		for ( int i = 0; i < testSet.length; i++ ) {
			long startTime = System.currentTimeMillis();
			int minSum = MinAbsSumFork.solution(testSet[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("MinAbsSumFork min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
			assertEquals( testResult[i], minSum );
		}
	}

	
	@Test
	public void testMinAbsSumForkJoin( ) {
		for ( int i = 0; i < testSet.length; i++ ) {
			long startTime = System.currentTimeMillis();
			int minSum = MinAbsSumForkJoin.solution(testSet[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("MinAbsSumForkJoin min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
			assertEquals( testResult[i], minSum );
		}
	}
	
	@Test
	public void testMinAbsSumTree( ) {
		for ( int i = 0; i < testSet.length; i++ ) {
			long startTime = System.currentTimeMillis();
			int minSum = MinAbsSumTree.solution(testSet[i]);
			long endTime = System.currentTimeMillis();
			System.out.println("MinAbsSumTree min sum is " + minSum + " timeTaken " + ( endTime - startTime ) + " ms" );
			assertEquals( testResult[i], minSum );
		}
	}
}

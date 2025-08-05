package com.watsonas.jb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test; 


public class JbTest {

	@Test
	public void standardTest() {
		int reversed = Solution.solution("26,35");
		assertEquals( 5362, reversed );
	}

	
	@Test
	public void testWithNegatives() {
		
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	    	Solution.solution("1,-1,3,-2,4");
	    });

	    String expectedMessage = "Invalid input data";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testCustomDelimiter() {
		int reversed = Solution.solution(("//;\n26;35;223"));
		assertEquals( 3225362, reversed );
	}

	@Test
	public void testEmptyString() {
		int reversed = Solution.solution((""));
		assertEquals( 0, reversed );
	}

	@Test
	public void testBadData() {
	    Exception exception = assertThrows(RuntimeException.class, () -> {
	    	Solution.solution("xx");
	    });

	    String expectedMessage = "Invalid input data";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

}

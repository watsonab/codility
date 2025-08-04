package com.watsonas.averageTemps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Map;

import org.junit.jupiter.api.Test; 

public class AverageTempsTest {

	@Test
	public void testAverageTemps() {
		try {
			Map<String,String> result = AverageTempsFromFileWithStreams.processFile("src/test/resources/measurements.txt");
			assertEquals(5,result.size() );
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	
}
